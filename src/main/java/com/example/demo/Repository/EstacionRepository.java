package com.example.demo.Repository;

import com.example.demo.Entity.Estacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface EstacionRepository extends JpaRepository<Estacion, Serializable> {
}