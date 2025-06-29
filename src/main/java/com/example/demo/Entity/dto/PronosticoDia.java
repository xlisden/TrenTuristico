package com.example.demo.Entity.dto;

import lombok.Data;

import java.util.List;

@Data
public class PronosticoDia {

    public String dia;
    public String fecha;
    public List<PronosticoEstacion> estaciones;

}
