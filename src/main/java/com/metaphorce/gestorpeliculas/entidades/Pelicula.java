package com.metaphorce.gestorpeliculas.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "peliculas")
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pelicula;
    @NotNull(message = "El titulo es obligatorio, no se puede saltar su valor, estar vacio o tener solo")
    @NotBlank(message = "El titulo es obligatorio, no puede estar vacio o tener solo espacios")
    private String nombre;
    @NotNull(message = "El estado de la pelicula es obligatorio, no se puede saltar su valor, no puede ser null")
    private Boolean disponible;

    public Pelicula() {
    }

    public Pelicula(Integer idPelicula, String nombre, Boolean disponible) {
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

    public Boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

}
