package com.example.demo.Repository;

import com.example.demo.Entity.extras.AyudaClima;
import com.example.demo.Entity.ReporteClima;
import com.example.demo.Entity.extras.ReporteClimaQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;
import java.util.List;

public interface ReporteClimaRepository extends JpaRepository<ReporteClima, Serializable> {

    @Query(value = "select r.RepClimaEstacion as estacion, r.RepClimaTemp as temperatura, r.RepClimaProbabilidadLluvia as probabilidad, r.RepClimaIntensidadLluvia as intensidad\n" +
            "from reporteclima r \n" +
            "where r.RepClimaHora = :hora and DATE(r.RepClimaFecha) = CURRENT_DATE() and r.RepClimaEstacion = :estacion\n" +
            ";", nativeQuery = true)
    public AyudaClima getClimaPorEstacionHora(int estacion, int hora);

    @Query(value = "select distinct  DATE_FORMAT(r.RepClimaFecha, \"%m/%d/%Y\") as dia\n" +
            "from reporteclima r \n" +
            ";", nativeQuery = true)
    public List<String> getSemana();

    @Query(value = "select e.EstId, r.RepClimaHora, r.RepClimaTemp, r.RepClimaProbabilidadLluvia, r.RepClimaIntensidadLluvia, DATE_FORMAT(r.RepClimaFecha, \"%m/%d/%Y\")\n" +
            "from estacion e \n" +
            "inner join reporteclima r \n" +
                "on r.RepClimaEstacion = e.EstId\n" +
            "where r.RepClimaEstacion = :estacion\n" +
            ";", nativeQuery = true)
    public List<ReporteClimaQuery> getClimaPorEstacion(int estacion);

}