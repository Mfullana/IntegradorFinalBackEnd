package com.IntegradorFinal.controllers;

import com.IntegradorFinal.exceptions.BadRequestException;
import com.IntegradorFinal.exceptions.ResourceNotFoundException;
import com.IntegradorFinal.dto.TurnoDTO;
import com.IntegradorFinal.service.impl.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@CrossOrigin
@RequestMapping("/turnos")
public class TurnoController   {

    @Autowired(required = true)
    TurnoService service;

    @PostMapping("/crear")
    public ResponseEntity<?> crearEnBDD(@Valid @RequestBody TurnoDTO turnoDTO) throws BadRequestException, ResourceNotFoundException {
        return ResponseEntity.ok(service.insertar(turnoDTO));
    }

    @GetMapping("/todos")
    public ResponseEntity<?> consultarTodos() throws ResourceNotFoundException {
        return ResponseEntity.ok(service.obtenerTodos());
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarDeBDD(@PathVariable Integer id) throws ResourceNotFoundException {
        return ResponseEntity.ok(service.eliminar(id));
    }

    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizarEnBDD(@Valid @RequestBody TurnoDTO turnoDTO) throws ResourceNotFoundException, BadRequestException{
        return ResponseEntity.ok(service.actualizar(turnoDTO));
    }

    @GetMapping("/proximaSemana")
    public ResponseEntity<?> turnosProximaSemana() throws ResourceNotFoundException {
        return ResponseEntity.ok(service.turnosProxSemana());
    }
}
