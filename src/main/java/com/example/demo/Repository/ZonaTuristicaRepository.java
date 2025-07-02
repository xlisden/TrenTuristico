package com.example.demo.Repository;

import com.example.demo.Entity.ZonaTuristica;
import com.example.demo.Entity.extras.ZonaTuristicaQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;
import java.util.List;

@Repository
public interface ZonaTuristicaRepository extends JpaRepository<ZonaTuristica, Serializable> {

    @Query(value = "select distinct z.ZonaEstacion as estacion, z.ZonaId as idZona, z.ZonaNombre as zona, z.ZonaTipoLugar as lugar, z.ZonaTiempoRecorrido as recorrido, z.ZonaTiempoLlegada as llegada,\n" +
                        "r.RepClimaHora as hora, r.RepClimaTemp as temperatura, r.RepClimaIntensidadLluvia  as intensidad, r.RepClimaProbabilidadLluvia as prob,\n" +
                        "z.ZonaActividad as actividad\n" +
                    "from zonaturistica z\n" +
                    "inner join reporteclima r \n" +
                        "on r.RepClimaEstacion = z.ZonaEstacion\n" +
                    "where r.RepClimaHora = :hora and r.RepClimaEstacion = :estacion and DATE(r.RepClimaFecha) = CURRENT_DATE()\n" +
                    "order by z.ZonaId asc\n" +
                    ";", nativeQuery = true)
    public List<ZonaTuristicaQuery> getAllByEstacion(int estacion, int hora);

}