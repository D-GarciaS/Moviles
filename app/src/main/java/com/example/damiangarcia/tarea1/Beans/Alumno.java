package com.example.damiangarcia.tarea1.Beans;

/**
 * Created by Damian Garcia on 9/2/2017.
 */

public class Alumno {
    String nombre;
    String telefono;
    String escolaridad;
    String genero;

    String libroFavorito;
    boolean practicaDeporte;

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEscolaridad() {
        return escolaridad;
    }

    public String getGenero() {
        return genero;
    }

    public String getLibroFavorito() {
        return libroFavorito;
    }

    public boolean isPracticaDeporte() {
        return practicaDeporte;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEscolaridad(String escolaridad) {
        this.escolaridad = escolaridad;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setLibroFavorito(String libroFavorito) {
        this.libroFavorito = libroFavorito;
    }

    public void setPracticaDeporte(boolean practicaDeporte) {
        this.practicaDeporte = practicaDeporte;
    }

    @Override
    public String toString() {
        return "Nombre: " + this.nombre + " Apellido: " + this.telefono
                + " Escolaridad " + this.escolaridad + " Genero: " + this.genero
                + "Libro Favorito: " + this.libroFavorito + " Practica deporte: "
                + ((this.practicaDeporte)? "Si" : "No") ;
    }
}
