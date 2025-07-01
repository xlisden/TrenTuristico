package com.example.demo.Service.ServiceImpl;

import com.example.demo.Entity.Estacion;
import com.example.demo.Entity.extras.AyudaClima;
import com.example.demo.Entity.dto.EstacionDto;
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
    private final UtilsServcice utilsServcice;
    private final ReporteClimaRepository reporteClimaRepository;

    @Override
    public List<EstacionDto> getInfoEstaciones() {
        int hora = utilsServcice.getHora();
        List<EstacionDto> estaciones = estacionRepository.getInfoEstaciones(hora);

        for(EstacionDto estacion : estaciones){
            estacion.setIcono(getUrl(estacion.getIdEstacion(), hora));
        }

        return estaciones;
    }

    @Override
    public List<Estacion> listar() {
        return estacionRepository.findAll();  // ya con esto todo estará bien en el controlador
    }
    
    public String getUrl(int idEstacion, int hora) {
        AyudaClima clima = reporteClimaRepository.getClimaPorEstacionHora(idEstacion, hora);
        boolean esDeDia = hora < 16;
        double temperatura = clima.getTemperatura();
        int intensidad = (int) clima.getIntensidad();
        int probabilidad = clima.getProbabilidad();

        return utilsServcice.getUrl(esDeDia, temperatura, intensidad, probabilidad);
    }


}
