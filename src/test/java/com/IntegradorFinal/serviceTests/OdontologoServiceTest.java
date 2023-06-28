package com.IntegradorFinal.serviceTests;

import com.IntegradorFinal.dto.OdontologoDTO;
import com.IntegradorFinal.exceptions.ResourceNotFoundException;
import com.IntegradorFinal.service.impl.OdontologoService;
import com.IntegradorFinal.persistence.repository.OdontologoRepository;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
public class OdontologoServiceTest {

    @Autowired
    private OdontologoService serviceOdontologoDto;

    @Autowired
    private OdontologoRepository repository;

    private OdontologoDTO o;

    public void cargarDataSet () {
        o.setNombre("Marcelo");
        o.setApellido("Fullana");
        o.setMatricula(1234);
        serviceOdontologoDto.insertar(o);
    }

    @BeforeEach public void setUp(){
        o = new OdontologoDTO();
    }
    @Test

    public void crearUnOdontologo() throws ResourceNotFoundException {
        //Dado
        Integer totalOdontologosAntesCreacion = repository.findAll().size();
        Integer totalOdontologosEsperado = totalOdontologosAntesCreacion+1;


        //Cuando
        cargarDataSet();
        Integer totalOdontologosDespuesCreacion = repository.findAll().size();


        //Entonces
        Assert.assertEquals(totalOdontologosEsperado, totalOdontologosDespuesCreacion);
    }
    @Test

    public void actualizarUnOdontologo() throws ResourceNotFoundException {
        //Dado
        cargarDataSet();
        OdontologoDTO original = serviceOdontologoDto.buscarPorId(1);

        //Cuando
        OdontologoDTO o = new OdontologoDTO();
        o.setId(1);
        o.setMatricula(0000);
        serviceOdontologoDto.actualizar(o);
        OdontologoDTO trucho = serviceOdontologoDto.buscarPorId(1);

        //Entonces
        Assert.assertFalse(original.equals(trucho));
    }
    @Test

    public void traerTodos() throws ResourceNotFoundException {
        //Dado
        cargarDataSet();
        cargarDataSet();
        cargarDataSet();
        int respuestaEsperada = 3;

        //Cuando
        List<OdontologoDTO> odontologoDTOS = serviceOdontologoDto.obtenerTodos();

        //Entonces
        Assert.assertEquals(respuestaEsperada, odontologoDTOS.size());
    }
    @Test

    public void borraUnOdontologo() throws Exception {
        cargarDataSet();
        String respuestaEsperada = "Se ha eliminado el odontologo con el id: {}1";
        String respuesta = serviceOdontologoDto.eliminar(1);
        Assert.assertEquals(respuestaEsperada, respuesta);
    }
}
