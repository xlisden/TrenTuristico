package com.example.demo.Service.ServiceImpl;

import com.example.demo.Entity.dto.PronosticoClimaDto;
import com.example.demo.Entity.extras.ZonaTuristicaQuery;
import com.example.demo.Repository.ZonaTuristicaRepository;
import com.example.demo.Service.IZonaTuristicaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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

}
