package com.IntegradorFinal.service.impl;

import com.IntegradorFinal.config.SpringConfig;
import com.IntegradorFinal.dto.DomicilioDTO;
import com.IntegradorFinal.exceptions.BadRequestException;
import com.IntegradorFinal.exceptions.ResourceNotFoundException;
import com.IntegradorFinal.service.interfaces.PacienteServiceInterface;
import com.IntegradorFinal.dto.PacienteDTO;
import com.IntegradorFinal.persistence.entities.Domicilio;
import com.IntegradorFinal.persistence.entities.Paciente;
import com.IntegradorFinal.persistence.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService implements PacienteServiceInterface {
    @Autowired
    PacienteRepository repository;

    @Autowired
    SpringConfig mapper;

    @Autowired
    DomicilioService domicilioService;

    @Override
    public PacienteDTO insertar(PacienteDTO entidad){
        Paciente paciente = mapper.getModelMapper().map(entidad, Paciente.class);
        repository.save(paciente);
        return mapper.getModelMapper().map(paciente, PacienteDTO.class);
    }


    @Override
    public List<PacienteDTO> obtenerTodos() throws BadRequestException {
        List<Paciente> lista = repository.findAll();
        if (lista.size() == 0){
            throw new BadRequestException("No hay pacientes aún cargados en la base de datos");
        }
        return mapper.getModelMapper().map(lista, List.class);
    }

    @Override
    public String actualizar(PacienteDTO entidad) throws ResourceNotFoundException {
        String respuesta;
        Optional<Paciente> pacienteAModificar = repository.findById(entidad.getId());
        if(pacienteAModificar.isPresent()){
            repository.save(this.actualizarEnBDD(pacienteAModificar.get(), entidad));
            respuesta = "Actualización con éxito del paciente con id: " + entidad.getId();
        } else {
            throw new ResourceNotFoundException("No se logró actualizar el paciente. El paciente con id " + entidad.getId() +" no fue encontrado en la base de datos");
        }
        return respuesta;
    }

    private Paciente actualizarEnBDD(Paciente paciente, PacienteDTO pacienteDto) throws ResourceNotFoundException{
        if (pacienteDto.getNombre() != null) {
            paciente.setNombre(pacienteDto.getNombre());
        }
        if (pacienteDto.getApellido() != null) {
            paciente.setApellido(pacienteDto.getApellido());
        }
        if (pacienteDto.getDni() != null) {
            paciente.setDni(pacienteDto.getDni());
        }
        if (pacienteDto.getDomicilio() != null) {
            DomicilioDTO domicilioActualizado = domicilioService.actualizar(pacienteDto.getDomicilio());
            paciente.setDomicilio(mapper.getModelMapper().map(domicilioActualizado, Domicilio.class));
        }
        return paciente;
    }

    @Override
    public String eliminar(Integer id) throws ResourceNotFoundException{
        String respuesta;
        if(repository.findById(id).isPresent()){
            repository.deleteById(id);
            respuesta = "Eliminado con éxito";
        } else {
            throw new ResourceNotFoundException("No se logró eliminar el paciente. El id " + id +" no fue encontrado en la base de datos.");
        }
        return respuesta;
    }

    public PacienteDTO buscarPorId(Integer id) throws ResourceNotFoundException {
        Paciente pacienteRespuesta = repository.findById(id).orElse(null);
        if (pacienteRespuesta != null){
            return mapper.getModelMapper().map(pacienteRespuesta, PacienteDTO.class);
        } else {
            throw new ResourceNotFoundException ("No fue encontrado el paciente con id " + id);
        }
    }


}
