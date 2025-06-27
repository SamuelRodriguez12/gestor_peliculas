package com.metaphorce.gestorpeliculas.services;

import com.metaphorce.gestorpeliculas.entidades.Pelicula;

import java.util.List;

public interface ServicePelicula {

    List<Pelicula> getPelicula();

    Pelicula sendPelicula(Pelicula pelicula);

    List<Pelicula> getPeliculaDisponible(boolean disponible);

    Pelicula updatePeliculaDisponible(int id, boolean disponible);

    Boolean deletePelicula(int id);
}
