package com.example.demo.Entity.extras;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AyudaClima {

    private int estacion;
    private double temperatura;
    private int probabilidad;
    private double intensidad;

}
