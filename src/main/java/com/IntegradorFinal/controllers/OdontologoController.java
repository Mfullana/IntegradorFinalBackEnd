package com.IntegradorFinal.controllers;

import com.IntegradorFinal.exceptions.BadRequestException;
import com.IntegradorFinal.exceptions.ResourceNotFoundException;
import com.IntegradorFinal.dto.OdontologoDTO;
import com.IntegradorFinal.service.impl.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired(required = true)
    OdontologoService service;

    @PostMapping("/crear")
    public ResponseEntity<OdontologoDTO> crearEnBDD(@RequestBody OdontologoDTO odontologo) {
        ResponseEntity<OdontologoDTO> respuesta = ResponseEntity.badRequest().body(odontologo);
        OdontologoDTO odontologoInsertado = service.insertar(odontologo);
        if (odontologoInsertado != null){
            respuesta = ResponseEntity.ok(odontologoInsertado);
        }
        return respuesta;

    }

    @GetMapping("/todos")
    public ResponseEntity<List<OdontologoDTO>> consultarTodos() throws ResourceNotFoundException
    {
        return ResponseEntity.ok(service.obtenerTodos());
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarDeBDD(@PathVariable Integer id) throws ResourceNotFoundException {
        return ResponseEntity.ok(service.eliminar(id));
    }

    @PutMapping("/actualizar")
    public ResponseEntity<String> actualizarEnBDD(@Valid @RequestBody OdontologoDTO odontologo) throws BadRequestException, ResourceNotFoundException {
        ResponseEntity<String> respuesta;
        if (odontologo.getId() != null){
            respuesta = ResponseEntity.ok(service.actualizar(odontologo));
        } else{
            throw new BadRequestException("Falta el id del odontólogo");
        }
        return respuesta;
    }

    @GetMapping("/apellidos/{apellido}")
    public ResponseEntity<?> obtenerOdontologosPorApellidoEnElPathLike(@PathVariable String apellido){
        return ResponseEntity.ok(service.obtenerOdontologosPorSuApellidoLike(apellido));
    }

    // Lo hacemos con request param para tener otra forma de listarlos
    @GetMapping("/apellidos")
    public ResponseEntity<?> obtenerOdontologosPorApellidoLike(@RequestParam String apellido){
        return ResponseEntity.ok(service.obtenerOdontologosPorSuApellidoLike(apellido));
    }


}
