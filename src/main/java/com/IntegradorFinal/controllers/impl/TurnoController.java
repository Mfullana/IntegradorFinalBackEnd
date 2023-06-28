package com.IntegradorFinal.controllers.impl;

import com.IntegradorFinal.controllers.ControllerInterface;
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
public class TurnoController implements ControllerInterface<TurnoDTO> {

    @Autowired(required = true)
    TurnoService service;

    @Override
    @PostMapping("/crear")
    public ResponseEntity<?> crearEnBDD(@Valid @RequestBody TurnoDTO turnoDTO) throws BadRequestException, ResourceNotFoundException {
        return ResponseEntity.ok(service.insertar(turnoDTO));
    }

    @Override
    @GetMapping("/todos")
    public ResponseEntity<?> consultarTodos() throws ResourceNotFoundException {
        return ResponseEntity.ok(service.obtenerTodos());
    }

    @Override
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarDeBDD(@PathVariable Integer id) throws ResourceNotFoundException {
        return ResponseEntity.ok(service.eliminar(id));
    }

    @Override
    @PutMapping("/actualizar")
    public ResponseEntity<?> actualizarEnBDD(@Valid @RequestBody TurnoDTO turnoDTO) throws ResourceNotFoundException, BadRequestException{
        return ResponseEntity.ok(service.actualizar(turnoDTO));
    }

    @GetMapping("/proximaSemana")
    public ResponseEntity<?> turnosProximaSemana() throws ResourceNotFoundException {
        return ResponseEntity.ok(service.turnosProxSemana());
    }
}
