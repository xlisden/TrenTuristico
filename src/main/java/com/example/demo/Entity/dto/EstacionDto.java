package com.example.demo.Entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link com.example.demo.Entity.Estacion}
 */

@Data
@AllArgsConstructor
public class EstacionDto implements Serializable {

    private int idEstacion;
    private String nombre;
    private double temperatura;
    private int nroZonasTuristicas;
    private String icono;
    private String mensaje;
    private double intensidad;

    public String getMensaje() {
        return (nroZonasTuristicas <= 0) ? "Esta estación no cuenta con zonas turísticas." : null;
    }

    public EstacionDto(int idEstacion, String nombre, double temperatura, long nroZonasTuristicas, String icono,double intensidad) {
        this.idEstacion = idEstacion;
        this.nombre = nombre;
        this.temperatura = temperatura;
        this.nroZonasTuristicas = (int) nroZonasTuristicas;
        this.icono = icono;
        this.intensidad = intensidad;
    }

}
