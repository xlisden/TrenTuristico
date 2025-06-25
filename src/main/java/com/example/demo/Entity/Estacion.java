package com.example.demo.Entity;

import jakarta.persistence.*;

@Entity
@Table
public class Estacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EstId")
    private int id;

    @Column(name = "EstNom", length = 100)
    private String nombre;

    public Estacion() {
        super();
    }

    public Estacion(int id, String nombre) {
        super();
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
