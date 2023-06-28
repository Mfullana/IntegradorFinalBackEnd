package com.IntegradorFinal.controllers;

import com.IntegradorFinal.exceptions.BadRequestException;
import com.IntegradorFinal.exceptions.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


public interface ControllerInterface <E>{
    @PostMapping("/crear") ResponseEntity<?> crearEnBDD(@RequestBody E e) throws BadRequestException, ResourceNotFoundException;
    @GetMapping("/todos") ResponseEntity<?> consultarTodos() throws ResourceNotFoundException, BadRequestException;
    @DeleteMapping("/eliminar/{id}") ResponseEntity<?> eliminarDeBDD(@PathVariable Integer id) throws Exception;
    @PutMapping ResponseEntity<?> actualizarEnBDD(@RequestBody E e) throws BadRequestException, ResourceNotFoundException;
}
