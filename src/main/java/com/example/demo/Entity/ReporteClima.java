package com.example.demo.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "reporteclima")
public class ReporteClima {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RepClimaId", nullable = false)
    private int id;

    @NotNull
    @Column(name = "RepClimaFecha", nullable = false)
    private LocalDateTime fecha;

    @NotNull
    @Column(name = "RepClimaHora", nullable = false)
    private int fora;

    @NotNull
    @Column(name = "RepClimaTemp", nullable = false)
    private double temperatura;

    @NotNull
    @Column(name = "RepClimaProbabilidadLluvia", nullable = false)
    private int probabilidadLluvia;

    @NotNull
    @Column(name = "RepClimaIntensidadLluvia", nullable = false)
    private double intensidadLluvia;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "RepClimaEstacion", nullable = false)
    private Estacion estacion;

}