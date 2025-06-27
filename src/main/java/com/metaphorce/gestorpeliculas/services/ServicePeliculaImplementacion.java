package com.metaphorce.gestorpeliculas.services;

import com.metaphorce.gestorpeliculas.entidades.Pelicula;
import com.metaphorce.gestorpeliculas.repositories.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicePeliculaImplementacion implements ServicePelicula{
    @Autowired
    PeliculaRepository repository;

    @Override
    public List<Pelicula> getPelicula(){
        return repository.findAll();
    }

    @Override
    public Pelicula sendPelicula(Pelicula pelicula){
        return repository.save(pelicula);
    }

    @Override
    public List<Pelicula> getPeliculaDisponible(boolean disponible){
        return repository.findByDisponible(disponible);
    }

    @Override
    public Pelicula updatePeliculaDisponible(int id, boolean disponible){
        Pelicula peli = repository.findById(id).get();
        peli.setDisponible(disponible);
        return repository.save(peli);
    }

    @Override
    public Boolean deletePelicula(int id){
        repository.deleteById(id);
        return true;
    }
}
