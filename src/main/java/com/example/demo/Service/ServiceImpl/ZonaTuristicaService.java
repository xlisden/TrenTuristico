package com.example.demo.Service.ServiceImpl;

import com.example.demo.Entity.ZonaTuristica;
import com.example.demo.Entity.dto.PronosticoClimaDto;
import com.example.demo.Entity.dto.ZonaDto;
import com.example.demo.Entity.extras.ZonaTuristicaQuery;
import com.example.demo.Repository.ZonaTuristicaRepository;
import com.example.demo.Service.IZonaTuristicaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ZonaTuristicaService implements IZonaTuristicaService {

    private final ZonaTuristicaRepository zonaRepository;
    private final UtilsServcice utilsServcice;

    @Override
    public ZonaTuristicaQuery getAllByEstacion(int estacion) {
        int hora = utilsServcice.getHora();
        return zonaRepository.getAllByEstacion(estacion, hora);
    }

    @Override
    public PronosticoClimaDto getPronosticoClima() {
        return null;
    }

    @Override
    public List<ZonaDto> findAllZonaTuristica() {
        List<ZonaTuristica> zonaTuristicas = zonaRepository.findAll();
        List<ZonaDto> list = new ArrayList<>();
        for (ZonaTuristica z : zonaTuristicas) {
            list.add(new ZonaDto(z.getId(),z.getNombre(),z.getEstacion().getId(),z.getTiempoRecorrido()));
        }

        return list;
    }

}
