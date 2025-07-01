package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.ZonaTuristica;
import com.example.demo.Entity.dto.PronosticoClimaDto;
import com.example.demo.Entity.dto.ZonaDto;
import com.example.demo.Entity.extras.ZonaTuristicaQuery;

public interface IZonaTuristicaService {

    public abstract PronosticoClimaDto getPronosticoClima();

    public abstract List<ZonaDto> findAllZonaTuristica();

    public abstract ZonaTuristicaQuery getAllByEstacion(int estacion);

    public abstract List<ZonaTuristica> listarZonas();
    public abstract ZonaTuristica obtenerZonaPorId(int id);
    public abstract void guardarZona(ZonaTuristica zona);
    public abstract void actualizarZona(ZonaTuristica zona);
    public abstract void desactivarZona(int id);
}
