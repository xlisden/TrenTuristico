package com.example.demo.Repository;

import com.example.demo.Entity.ZonaTuristica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface ZonaTuristicaRepository extends JpaRepository<ZonaTuristica, Serializable> {
}