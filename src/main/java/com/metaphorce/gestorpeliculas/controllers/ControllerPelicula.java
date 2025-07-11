package com.metaphorce.gestorpeliculas.controllers;

import com.metaphorce.gestorpeliculas.entidades.Pelicula;
import com.metaphorce.gestorpeliculas.excepciones.DatosNoEncontradosExcepciones;
import com.metaphorce.gestorpeliculas.excepciones.DatosNoValidosExcepciones;
import com.metaphorce.gestorpeliculas.services.ServicePelicula;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/gestor_peliculas")
public class ControllerPelicula {

    @Autowired
    ServicePelicula servicePelicula;

    @GetMapping("/peliculas")
    public ResponseEntity<List<Pelicula>> obtenerPelicula(BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new DatosNoEncontradosExcepciones("Error al encontrar los datos de la pelicula", bindingResult);
        }
        List<Pelicula> pelicula = servicePelicula.getPelicula();
        return ResponseEntity.status(HttpStatus.CREATED).body(pelicula);
    }

    @PostMapping("/peliculas")
    public ResponseEntity<?> sendPelicula(@Valid @RequestBody Pelicula pelicula, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new DatosNoValidosExcepciones("Error de validacion de datos", bindingResult);
        }
            return ResponseEntity.ok(this.servicePelicula.sendPelicula(pelicula));
    }

    @GetMapping("/peliculas/{disponible}")
    public ResponseEntity<List<Pelicula>> obtenerPeliculaDisponible(@PathVariable("disponible") boolean disponible, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new DatosNoEncontradosExcepciones("Error al encontrar los datos de de la pelicula", bindingResult);
        }
        List<Pelicula> pelicula = servicePelicula.getPeliculaDisponible(disponible);
        return ResponseEntity.status(HttpStatus.CREATED).body(pelicula);
    }

    @PutMapping("/peliculas/{id_pelicula}/disponible/{disponible}")
    public ResponseEntity<Pelicula> updatePeliculaDisponible(@PathVariable("id_pelicula") int id_pelicula, @PathVariable("disponible") boolean disponible, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new DatosNoEncontradosExcepciones("Error al encontrar los datos de de la pelicula con id: "+id_pelicula, bindingResult);
        }
        Pelicula actualizada = servicePelicula.updatePeliculaDisponible(id_pelicula, disponible);
        return ResponseEntity.ok(actualizada);
    }

    @DeleteMapping("/peliculas/{id_pelicula}")
    public String deletePelicula(@PathVariable("id_pelicula") int id_pelicula, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new DatosNoEncontradosExcepciones("Error al encontrar los datos de de la pelicula con id: "+id_pelicula, bindingResult);
        }
        boolean estado = this.servicePelicula.deletePelicula(id_pelicula);
        return "Se elimino con exito";
    }
}
