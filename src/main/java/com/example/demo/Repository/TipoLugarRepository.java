package com.example.demo.Repository;

import com.example.demo.Entity.TipoLugar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("tipolugarrepository")
public interface TipoLugarRepository extends JpaRepository<TipoLugar, Serializable>{
    @Query("SELECT tp FROM TipoLugar tp WHERE tp.id = :id")
    public TipoLugar obtenerTipoLugar(@Param("id") int id);

    List<TipoLugar> findByNombreContainingIgnoreCase(String nombre);
}
