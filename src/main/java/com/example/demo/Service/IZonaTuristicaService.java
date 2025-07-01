package com.example.demo.Service;

import com.example.demo.Entity.dto.PronosticoClimaDto;
import com.example.demo.Entity.extras.ZonaTuristicaQuery;

public interface IZonaTuristicaService {

    public abstract ZonaTuristicaQuery getAllByEstacion(int estacion);

}
