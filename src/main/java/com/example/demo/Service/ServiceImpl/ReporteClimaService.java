package com.example.demo.Service.ServiceImpl;

import com.example.demo.Entity.dto.PronosticoClimaDto;
import com.example.demo.Entity.dto.PronosticoDia;
import com.example.demo.Entity.dto.PronosticoEstacion;
import com.example.demo.Entity.dto.PronosticoHora;
import com.example.demo.Entity.extras.AyudaEstacion;
import com.example.demo.Entity.extras.ReporteClimaQuery;
import com.example.demo.Entity.extras.Utils;
import com.example.demo.Repository.EstacionRepository;
import com.example.demo.Repository.ReporteClimaRepository;
import com.example.demo.Service.IReporteClimaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ReporteClimaService implements IReporteClimaService {

    private final UtilsServcice utilsServcice;
    private final EstacionRepository estacionRepository;
    private final ReporteClimaRepository reporteClimaRepository;

    public PronosticoClimaDto getPronosticoClima() {
        PronosticoClimaDto pronosticoClima = new PronosticoClimaDto();
        List<AyudaEstacion> estaciones = estacionRepository.getAll();
        List<String> semanaFechas = reporteClimaRepository.getSemana();
        List<PronosticoDia> semana = new ArrayList<>();

        pronosticoClima.semana = new ArrayList<>();

        for (int i = 0; i < semanaFechas.size(); i++) {
            PronosticoDia pronosticoDia = new PronosticoDia();
            List<PronosticoEstacion> pronosticoEstaciones = new ArrayList<>();

            pronosticoDia.dia = Utils.climaFrontDias.get(i);
            pronosticoDia.fecha = semanaFechas.get(i);

            for (AyudaEstacion estacion : estaciones) {
                PronosticoEstacion pronosticoEstacion = new PronosticoEstacion();
                List<PronosticoHora> pronosticoHoras = new ArrayList<>();
                List<ReporteClimaQuery> reportes = reporteClimaRepository.getClimaPorEstacion(estacion.id);

                pronosticoEstacion.estacion = estacion.nombre;

                for (ReporteClimaQuery reporte : reportes) {
                    if (reporte.getFecha().equals(semanaFechas.get(i))) {
                        PronosticoHora hora = new PronosticoHora();

                        hora.url = getUrl(reporte.hora, reporte.temperatura, reporte.intensidad, reporte.probabilidad);
                        hora.hora = String.format("%02d:%02d", reporte.hora, 0);
                        hora.temperatura = reporte.temperatura;

                        pronosticoHoras.add(hora);
                    }
                }
                pronosticoEstacion.horario = pronosticoHoras;
                pronosticoEstaciones.add(pronosticoEstacion);
            }
            pronosticoDia.estaciones = pronosticoEstaciones;
            semana.add(pronosticoDia);
        }
        pronosticoClima.semana = semana;

        return pronosticoClima;
    }

    public String getUrl(int hora, double temperatura, double intensidad, int probabilidad) {
        boolean esDeDia = hora < 19;

        return utilsServcice.getUrl(esDeDia, temperatura, (int) intensidad, probabilidad);
    }

}
