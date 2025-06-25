package com.example.demo.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Actividad;

@Repository("actirepository")
public interface ActividadRepository  extends JpaRepository<Actividad, Serializable>{

}
