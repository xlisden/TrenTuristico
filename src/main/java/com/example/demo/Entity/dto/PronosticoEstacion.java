package com.example.demo.Entity.dto;

import lombok.Data;

import java.util.List;

@Data
public class PronosticoEstacion {

    public String estacion;
    public List<PronosticoHora> horario;

}
