package com.example.demo.Repository;

import com.example.demo.Entity.ZonaTuristica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface ZonaTuristicaRepository extends JpaRepository<ZonaTuristica, Serializable> {
}