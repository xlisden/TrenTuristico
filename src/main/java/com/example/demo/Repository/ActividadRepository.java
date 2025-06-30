package com.example.demo.Repository;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.Entity.Actividad;

@Repository("actirepository")
public interface ActividadRepository  extends JpaRepository<Actividad, Serializable>{

    @Query("SELECT a FROM Actividad a WHERE a.id = :id")
    public Actividad obtenerActividad(@Param("id") int id);

    List<Actividad> findByNombreContainingIgnoreCase(String nombre);
}
