package com.example.demo.Service;

import com.example.demo.Entity.ZonaTuristica;
import com.example.demo.Entity.dto.PronosticoClimaDto;
import com.example.demo.Entity.dto.ZonaDto;

import java.util.List;

public interface ZonaTuristicaService {

    public abstract PronosticoClimaDto getPronosticoClima();
    public abstract List<ZonaDto> findAllZonaTuristica();

}
