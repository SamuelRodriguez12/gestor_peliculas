package com.metaphorce.gestorpeliculas.excepciones;

import org.springframework.validation.BindingResult;

public class DatosNoEncontradosExcepciones extends RuntimeException{
    private BindingResult   bindingResult;

    public DatosNoEncontradosExcepciones(String mensaje, BindingResult bindingResult){
        super(mensaje);
        this.bindingResult=bindingResult;
    }

    public BindingResult getBindingResult() {
        return bindingResult;
    }

    public void setBindingResult(BindingResult bindingResult) {
        this.bindingResult = bindingResult;
    }
}
