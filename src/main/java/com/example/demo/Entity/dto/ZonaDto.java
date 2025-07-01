package com.example.demo.Entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class ZonaDto implements Serializable {
    private int id;
    private String nombre;
    private int estacion;
    private int dura;
}
