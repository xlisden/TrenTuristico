package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.ZonaTuristica;
import com.example.demo.Entity.dto.PronosticoClimaDto;
import com.example.demo.Entity.dto.ZonaDto;
import com.example.demo.Entity.dto.ZonaTuristicaDto;
import com.example.demo.Entity.extras.Filtros;
import com.example.demo.Entity.extras.ZonaTuristicaQuery;
import org.springframework.web.multipart.MultipartFile;

public interface IZonaTuristicaService {

    public abstract PronosticoClimaDto getPronosticoClima();

    public abstract List<ZonaDto> findAllZonaTuristica();

    public abstract List<ZonaTuristicaDto> filtrarByEstacion(int estacion, Filtros filtros);

    public abstract List<ZonaTuristica> listarZonas();
    public abstract ZonaTuristica obtenerZonaPorId(int id);
    public abstract ZonaTuristica guardarZona(ZonaTuristica zona, MultipartFile foto);
    public abstract void actualizarZona(ZonaTuristica zona,MultipartFile foto);
    public abstract void desactivarZona(int id);
}
