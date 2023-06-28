package com.IntegradorFinal.exceptions;

import com.IntegradorFinal.controllers.impl.OdontologoController;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptions {

    private static final org.apache.log4j.Logger logger = Logger.getLogger(OdontologoController.class);

    @ExceptionHandler({ResourceNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,String> procesarNotFound(ResourceNotFoundException ex) {
        Map<String, String> exceptionMessage = new HashMap<>();
        exceptionMessage.put("message","Recurso no encontrado: "+ ex.getMessage());
    return exceptionMessage;
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> procesarValidationException(MethodArgumentNotValidException ex) {
     Map<String,String> exceptionMessage = new HashMap<>();
       ex.getBindingResult().getAllErrors().forEach((error)->{
           String fieldName = ((FieldError) error).getField();
           String errorMessage = error.getDefaultMessage();
           exceptionMessage.put(fieldName, errorMessage);
       });
       return exceptionMessage;
    }

}
