package com.metaphorce.gestorpeliculas.repositories;

import com.metaphorce.gestorpeliculas.entidades.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Integer> {
    List<Pelicula> findByDisponible(boolean disponible);
}
