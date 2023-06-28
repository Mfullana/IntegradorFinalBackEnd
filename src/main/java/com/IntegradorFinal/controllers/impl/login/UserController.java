package com.IntegradorFinal.controllers.impl.login;

import com.IntegradorFinal.persistence.entities.login.AppUser;
import com.IntegradorFinal.service.impl.login.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    AppUserService service;

    @GetMapping("/")
    public String home(){
        return "<h1> Bienvenidos a la Clinica Odontologica </h1>" ;
    }

    @PostMapping("/usuarios/crear")
    public ResponseEntity<?> crearEnBDD(@RequestBody AppUser user) {
        ResponseEntity<?> respuesta = ResponseEntity.badRequest().body(user);
        AppUser usuario = service.crearUsuario(user);
        if (usuario != null){
            respuesta = org.springframework.http.ResponseEntity.ok(usuario);
        }
        return respuesta;
    }
}
