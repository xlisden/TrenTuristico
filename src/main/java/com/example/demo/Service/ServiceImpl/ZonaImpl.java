package com.example.demo.Service.ServiceImpl;

import com.example.demo.Entity.ZonaTuristica;
import com.example.demo.Entity.dto.PronosticoClimaDto;
import com.example.demo.Entity.dto.ZonaDto;
import com.example.demo.Repository.ZonaTuristicaRepository;
import com.example.demo.Service.ZonaTuristicaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class ZonaImpl implements IZonaTuristicaService {


    private ZonaTuristicaRepository zonarepo;

    @Override
    public PronosticoClimaDto getPronosticoClima() {
        return null;
    }

    @Override
    public List<ZonaDto> findAllZonaTuristica() {
        List<ZonaTuristica> zonaTuristicas = zonarepo.findAll();
        List<ZonaDto> list = new ArrayList<>();
        for (ZonaTuristica z : zonaTuristicas) {
            list.add(new ZonaDto(z.getId(),z.getNombre(),z.getEstacion().getId(),z.getTiempoRecorrido()));
        }

        return list;
    }
}
