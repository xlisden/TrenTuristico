package com.example.demo.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "zonaturistica")
public class ZonaTuristica {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ZonaId", nullable = false)
    private int id;

    @Size(max = 100)
    @NotNull
    @Column(name = "ZonaNombre", nullable = false, length = 100)
    private String nombre;

    @NotNull
    @Column(name = "ZonaTiempoLlegada", nullable = false)
    private int tiempoLlegada;

    @NotNull
    @Column(name = "ZonaTiempoRecorrido", nullable = false)
    private int tiempoRecorrido;

    @NotNull
    @Column(name = "ZonaActivo", nullable = false)
    private boolean activo = false;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ZonaEstacion", nullable = false)
    private Estacion estacion;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ZonaActividad", nullable = false)
    private Actividad actividad;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ZonaTipoLugar", nullable = false)
    private TipoLugar tipoLugar;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ZonaCreadoPor", nullable = false)
    private Usuario creadoPor;

}