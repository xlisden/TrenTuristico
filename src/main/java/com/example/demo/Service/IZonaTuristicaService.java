package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.dto.PronosticoClimaDto;
import com.example.demo.Entity.dto.ZonaDto;
import com.example.demo.Entity.extras.ZonaTuristicaQuery;

public interface IZonaTuristicaService {

    public abstract PronosticoClimaDto getPronosticoClima();

    public abstract List<ZonaDto> findAllZonaTuristica();

    public abstract ZonaTuristicaQuery getAllByEstacion(int estacion);

}
