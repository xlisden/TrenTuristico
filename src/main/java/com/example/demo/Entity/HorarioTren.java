package com.example.demo.Entity;


import jakarta.persistence.*;

@Entity
@Table(name="horariotren")
public class HorarioTren {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="hortrenid")
    private int id;

    @Column(name = "hortrenhora", length = 8)
    private String hora;
    @Column(name = "hortrenubi")
    private int estacionUbi;
    @Column(name= "hortrenestado")
    private int estado;
    @Column(name = "hortrendireccion")
    private int direccion;

    public HorarioTren() {
        super();
    }

    public HorarioTren(int direccion, int estado, int estacionUbi, String hora, int id) {
        super();
        this.direccion = direccion;
        this.estado = estado;
        this.estacionUbi = estacionUbi;
        this.hora = hora;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getEstacionUbi() {
        return estacionUbi;
    }

    public void setEstacionUbi(int estacionUbi) {
        this.estacionUbi = estacionUbi;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }
}
