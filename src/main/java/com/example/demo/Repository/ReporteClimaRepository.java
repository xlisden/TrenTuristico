package com.example.demo.Repository;

import com.example.demo.Entity.ReporteClima;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface ReporteClimaRepository extends JpaRepository<ReporteClima, Serializable> {
}