package com.example.demo.Repository;

import com.example.demo.Entity.Estacion;
import com.example.demo.Entity.Helpers.EstacionDto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface EstacionRepository extends JpaRepository<Estacion, Serializable> {
    @Query(value = "select e.EstId , e.EstNombre, r.RepClimaTemp, (select count(*)\n" +
                                                                    "from zonaturistica z \n" +
                                                                    "where z.ZonaEstacion = e.EstId ) as Zonas, 'url'\n" +
            "from estacion e \n" +
            "inner join reporteclima r \n" +
                "on r.RepClimaEstacion = e.EstId\n" +
            "where r.RepClimaHora = 16 and DATE(r.RepClimaFecha) = CURRENT_DATE()\n" +
            ";", nativeQuery = true)
    public List<EstacionDto> getInfoEstaciones();

}