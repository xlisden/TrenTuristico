package com.example.demo.Entity;

import jakarta.persistence.*;

@Entity
@Table
public class Estacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EstId")
    private int EstId;

    @Column(name = "EstNom", length = 100)
    private String EstNom;

    public Estacion() {
        super();
    }

    public Estacion(int estId, String estNom) {
        super();
        EstId = estId;
        EstNom = estNom;
    }

    public int getEstId() {
        return EstId;
    }

    public void setEstId(int estId) {
        EstId = estId;
    }

    public String getEstNom() {
        return EstNom;
    }

    public void setEstNom(String estNom) {
        EstNom = estNom;
    }

}
