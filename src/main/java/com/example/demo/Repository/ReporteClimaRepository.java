package com.example.demo.Repository;

import com.example.demo.Entity.Helpers.AyudaClima;
import com.example.demo.Entity.ReporteClima;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;

public interface ReporteClimaRepository extends JpaRepository<ReporteClima, Serializable> {

    @Query(value = "select r.RepClimaEstacion as estacion, r.RepClimaTemp as temperatura, r.RepClimaProbabilidadLluvia as probabilidad, r.RepClimaIntensidadLluvia as intensidad\n" +
            "from reporteclima r \n" +
            "where r.RepClimaHora = :hora and DATE(r.RepClimaFecha) = CURRENT_DATE() and r.RepClimaEstacion = :estacion\n" +
            ";", nativeQuery = true)
    public AyudaClima getClima(int estacion, int hora);

}