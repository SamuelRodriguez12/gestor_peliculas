package com.metaphorce.gestorpeliculas.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "peliculas")
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pelicula;
    private String nombre;
    private boolean disponible;

    public Pelicula() {
    }

    public Pelicula(Integer idPelicula, String nombre, boolean disponible) {
        this.id_pelicula = idPelicula;
        this.nombre = nombre;
        this.disponible = disponible;
    }

    public Integer getId_pelicula() {
        return id_pelicula;
    }

    public void setId_pelicula(Integer id_pelicula) {
        this.id_pelicula = id_pelicula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
