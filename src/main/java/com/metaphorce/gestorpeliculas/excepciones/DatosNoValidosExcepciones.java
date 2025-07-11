package com.metaphorce.gestorpeliculas.excepciones;

import org.springframework.validation.BindingResult;

public class DatosNoValidosExcepciones extends RuntimeException{

    BindingResult bindingResult;

    public DatosNoValidosExcepciones(String mensaje, BindingResult bindingResult) {
        super(mensaje);
        this.bindingResult = bindingResult;
    }

    public BindingResult getBindingResult() {
        return bindingResult;
    }

    public void setBindingResult(BindingResult bindingResult) {
        this.bindingResult = bindingResult;
    }
}
