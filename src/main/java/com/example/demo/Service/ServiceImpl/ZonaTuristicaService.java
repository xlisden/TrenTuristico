package com.example.demo.Service.ServiceImpl;

import com.example.demo.Entity.ZonaTuristica;
import com.example.demo.Entity.dto.PronosticoClimaDto;
import com.example.demo.Entity.dto.ZonaDto;
import com.example.demo.Entity.dto.ZonaTuristicaDto;
import com.example.demo.Entity.enums.TipoLugarEnum;
import com.example.demo.Entity.extras.Filtros;
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
    public List<ZonaTuristicaDto> filtrarByEstacion(int estacion, Filtros filtros) {
        int hora = utilsServcice.getHora();
        List<ZonaTuristicaQuery> zonasQuery = zonaRepository.getAllByEstacion(estacion, hora);

        if (filtros != null) {
            zonasQuery = filtrar(zonasQuery, filtros);
        }

        List<ZonaTuristicaDto> zonas = mapQueryToDto(zonasQuery);

        return zonas;
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

    @Override
    public List<ZonaTuristica> listarZonas() {
        return zonaRepository.findAll();
    }

    @Override
    public ZonaTuristica obtenerZonaPorId(int id) {
        return zonaRepository.findById(id).orElse(null);
    }

    @Override
    public void guardarZona(ZonaTuristica zona) {
        zonaRepository.save(zona);
    }

    @Override
    public void actualizarZona(ZonaTuristica zona) {
        zonaRepository.save(zona);
    }

    @Override
    public void desactivarZona(int id) {
        ZonaTuristica zona = zonaRepository.findById(id).orElse(null);
        if (zona != null) {
            zona.setActivo(false);
            zonaRepository.save(zona);
        }
    }
  
    private String getUrl(int hora, double temperatura, int intensidad, int probabilidad) {
        boolean esDia = hora < 16;
        return utilsServcice.getUrl(esDia, temperatura, intensidad, probabilidad);
    }

    private List<ZonaTuristicaDto> mapQueryToDto(List<ZonaTuristicaQuery> zonasQuery) {
        List<ZonaTuristicaDto> zonas = new ArrayList<>();
        for(ZonaTuristicaQuery query : zonasQuery) {
            ZonaTuristicaDto dto = new ZonaTuristicaDto();
            String url = getUrl(query.hora, query.temperatura, (int)query.intensidad, query.probabilidad);

            dto.setEstacion(query.estacion);
            dto.setIdZona(query.idZona);
            dto.setZona(query.zona);
            dto.setTipoLugar(TipoLugarEnum.getTipoLugar(query.tipoLugar));
            dto.setRecorrido(query.recorrido);
            dto.setLlegada(query.llegada);
            dto.setTemperatura((int) query.temperatura);
            dto.setActividad(query.actividad);
            dto.setUrl(url);

            zonas.add(dto);
        }
        return zonas;
    }

    private List<ZonaTuristicaQuery> filtrar(List<ZonaTuristicaQuery> zonasQuery, Filtros filtros) {
        List<ZonaTuristicaQuery> zonas = new ArrayList<>();
        boolean nofiltros = isFiltrosFasle(filtros);
        for (ZonaTuristicaQuery zona : zonasQuery) {
            if (nofiltros) {
                return zonasQuery;
            }

            boolean climaOk = true;
            if (filtros.isLluviaLigera()) {
                climaOk = esLluviaLigera(zona) || esNublado(zona) || esSoleado(zona);
            } else if (filtros.isNublado()) {
                climaOk = esNublado(zona) || esSoleado(zona);
            } else if (filtros.isSoleado()) {
                climaOk = esSoleado(zona);
            }     
            
            if (
                    (filtros.isCaminata()   && zona.getActividad() == 1) ||
                    (filtros.isSenderismo() && zona.getActividad() == 2) ||
                    (filtros.isEscalar()    && zona.getActividad() == 3) ||
                    (filtros.isAventura()   && zona.getActividad() == 4) ||
                    (filtros.isCultural()   && zona.getActividad() == 5) ||
                    (filtros.isSurfear()    && zona.getActividad() == 6) ||
                    (filtros.isCataVinos()  && zona.getActividad() == 7) ||
                    (filtros.isRecreativo() && zona.getActividad() == 8) &&
                    climaOk
            ) {
                zonas.add(zona);
            }
        }
        return zonas;
    }

    private boolean isFiltrosFasle(Filtros filtros) {
        boolean actividades =
                !filtros.isCaminata() && !filtros.isSenderismo() && !filtros.isEscalar() && !filtros.isAventura() && !filtros.isCultural() && !filtros.isSurfear() && !filtros.isCataVinos() && !filtros.isRecreativo();
        boolean clima = !filtros.isSoleado() && !filtros.isNublado() && !filtros.isLluviaLigera();
        return actividades && clima;
    }

    private boolean esLluviaLigera(ZonaTuristicaQuery zona) {
        return utilsServcice.isLluviaLigera(zona.temperatura, (int) zona.intensidad, zona.probabilidad);
    }
    private boolean esNublado(ZonaTuristicaQuery zona) {
        return utilsServcice.isNublado(zona.temperatura, (int) zona.intensidad, zona.probabilidad);
    }
    private boolean esSoleado(ZonaTuristicaQuery zona) {
        return utilsServcice.isSoleado(zona.temperatura, (int) zona.intensidad, zona.probabilidad);
    }

}
