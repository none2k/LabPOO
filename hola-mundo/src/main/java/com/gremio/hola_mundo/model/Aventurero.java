package com.gremio.hola_mundo.model;

public class Aventurero {
    private final String nombre;
    private final String clase;  // "Guerrero", "Druida", etc.
    private final int nivel;

    public Aventurero(String nombre, String clase, int nivel) {
        this.nombre = nombre;
        this.clase = clase;
        this.nivel = nivel;
    }

    public String getNombre() { return nombre; }
    public String getClase() { return clase; }
    public int getNivel() { return nivel; }
}