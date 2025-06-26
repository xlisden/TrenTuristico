package com.example.demo.Service.ServiceImpl;

import com.example.demo.Entity.Helpers.AyudaClima;
import com.example.demo.Entity.Helpers.EstacionDto;
import com.example.demo.Repository.EstacionRepository;
import com.example.demo.Repository.ReporteClimaRepository;
import com.example.demo.Service.IEstacionService;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EstacionService implements IEstacionService {

    private final EstacionRepository estacionRepository;
    private final ReporteClimaRepository reporteClimaRepository;

    @Override
    public List<EstacionDto> getInfoEstaciones() {
        int hora = getHora();
        List<EstacionDto> estaciones = estacionRepository.getInfoEstaciones(hora);

        for(EstacionDto estacion : estaciones){
            estacion.setIcono(getUrl(estacion.getIdEstacion(), hora));
        }

        return estaciones;
    }

    public String getUrl(int idEstacion, int hora) {
        AyudaClima clima = reporteClimaRepository.getClima(idEstacion, hora);
        boolean esDeDia = hora < 16;
        double temp = clima.getTemperatura();
        int intensidad = (int) clima.getIntensidad();
        int probabilidad = clima.getProbabilidad();

        if (intensidad == 0) {
            if (temp < 16)
                return esDeDia ? "/icons/static/nublado.svg" : "/icons/static/noche-nublada.svg";
            else
                return esDeDia ? "/icons/static/day.svg" : "/icons/static/night.svg";
        }

        if (intensidad >= 1 && intensidad <= 3) {
            if (esDeDia) {
                if (temp < 20) {
                    if (probabilidad < 30) {
                        switch (intensidad) {
                            case 1: return "/icons/static/sol-nubladosuave.svg";
                            case 2: return "/icons/static/sol-nublado.svg";
                            case 3: return "/icons/static/sol-nubladofuerte.svg";
                        }
                    } else {
                        switch (intensidad) {
                            case 1: return "/icons/static/garua.svg";
                            case 2: return "/icons/static/lluviasuave-2.svg";
                            case 3: return "/icons/static/lluvia-3.svg";
                        }
                    }
                } else {
                    switch (intensidad) {
                        case 1: return "/icons/static/sol-lluviasuave-1.svg";
                        case 2: return "/icons/static/massol-lluviasuave-2.svg";
                        case 3: return "/icons/static/sol-lluviasuave-2.svg";
                    }
                }
            } else {
                if (probabilidad < 30) {
                    switch (intensidad) {
                        case 1: return "/icons/static/noche-nubladasuave.svg";
                        case 2: return "/icons/static/noche-nublada.svg";
                        case 3: return "/icons/static/noche-nubladafuerte.svg";
                    }
                } else {
                    switch (intensidad) {
                        case 1: return "/icons/static/garua.svg";
                        case 2: return "/icons/static/lluviasuave-2.svg";
                        case 3: return "/icons/static/lluvia-3.svg";
                    }
                }
            }
        }

        if (intensidad > 3)
            return "/icons/static/tormentas.svg";

        return "/icons/static/weather.svg";
    }

    public int getHora() {
        int horaInicial = LocalDateTime.now().getHour();
        if (horaInicial < 10)
            return 7;
        else if (horaInicial >= 10 && horaInicial < 13)
            return 10;
        else if (horaInicial >= 13 && horaInicial < 16)
            return 13;
        else if (horaInicial >= 16 && horaInicial < 19)
            return 16;
        else if (horaInicial >= 19)
            return 19;
        return 0;
    }
}
