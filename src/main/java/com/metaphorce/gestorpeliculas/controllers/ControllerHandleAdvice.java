package com.metaphorce.gestorpeliculas.controllers;

import com.metaphorce.gestorpeliculas.excepciones.DatosNoEncontradosExcepciones;
import com.metaphorce.gestorpeliculas.excepciones.DatosNoValidosExcepciones;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerHandleAdvice {

    @ExceptionHandler(DatosNoValidosExcepciones.class)
    public ResponseEntity<?> validacionEntradaDatos(DatosNoValidosExcepciones datosNoValidosExcepciones){
            Map<String, String> errores = new HashMap<>();
            datosNoValidosExcepciones.getBindingResult().getFieldErrors().forEach(fieldError -> errores.put(fieldError.getField(),fieldError.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errores);
    }

    @ExceptionHandler(DatosNoEncontradosExcepciones.class)
    public ResponseEntity<?> datosEncontrados(DatosNoEncontradosExcepciones datosNoEncontradosExcepciones){
        Map<String, String> errores = new HashMap<>();
       errores.put("Mensaje:", datosNoEncontradosExcepciones.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errores);
    }
}
