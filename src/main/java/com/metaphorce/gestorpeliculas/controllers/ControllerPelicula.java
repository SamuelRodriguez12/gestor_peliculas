package com.metaphorce.gestorpeliculas.controllers;

import com.metaphorce.gestorpeliculas.entidades.Pelicula;
import com.metaphorce.gestorpeliculas.services.ServicePelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gestor_peliculas")
public class ControllerPelicula {

    @Autowired
    ServicePelicula servicePelicula;

    @GetMapping("/peliculas")
    public ResponseEntity<List<Pelicula>> obtenerPelicula(){
        List<Pelicula> pelicula = servicePelicula.getPelicula();
        return ResponseEntity.status(HttpStatus.CREATED).body(pelicula);
    }

    @PostMapping("/peliculas")
    public ResponseEntity<Pelicula> sendPelicula(@RequestBody Pelicula pelicula){
        return ResponseEntity.status(HttpStatus.CREATED).body(pelicula);
    }

    @GetMapping("/peliculas/{disponible}")
    public ResponseEntity<List<Pelicula>> obtenerPeliculaDisponible(@PathVariable("disponible") boolean disponible){
        List<Pelicula> pelicula = servicePelicula.getPeliculaDisponible(disponible);
        return ResponseEntity.status(HttpStatus.CREATED).body(pelicula);
    }

    @PutMapping("/peliculas/{id_pelicula}/disponible/{disponible}")
    public ResponseEntity<Pelicula> updatePeliculaDisponible(@PathVariable("id_pelicula") int id_pelicula, @PathVariable("disponible") boolean disponible){
        Pelicula actualizada = servicePelicula.updatePeliculaDisponible(id_pelicula, disponible);
        return ResponseEntity.ok(actualizada);
    }

    @DeleteMapping("/peliculas/{id_pelicula}")
    public String deletePelicula(@PathVariable("id_pelicula") int id_pelicula){
        boolean estado = this.servicePelicula.deletePelicula(id_pelicula);
        return "Se elimino con exito";
    }
}
