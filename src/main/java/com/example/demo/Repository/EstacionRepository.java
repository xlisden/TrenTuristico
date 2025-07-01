package com.example.demo.Repository;

import com.example.demo.Entity.Estacion;
import com.example.demo.Entity.dto.EstacionDto;
import java.util.List;

import com.example.demo.Entity.extras.AyudaEstacion;
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
            "where r.RepClimaHora = :hora and DATE(r.RepClimaFecha) = '2025-07-02'\n" +
            ";", nativeQuery = true)
    public List<EstacionDto> getInfoEstaciones(int hora);

    @Query(value = "select e.EstId, e.EstNombre from estacion e;", nativeQuery = true)
    public List<AyudaEstacion> getAll();

}