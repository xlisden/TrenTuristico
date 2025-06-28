package com.example.demo.Entity.extras;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ReporteClimaQuery {

    public int idEstacion;
    public int hora;
    public double temperatura;
    public int probabilidad;
    public double intensidad;
    public String fecha;

}
