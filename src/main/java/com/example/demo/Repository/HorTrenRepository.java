package com.example.demo.Repository;


import com.example.demo.Entity.HorarioTren;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface HorTrenRepository extends JpaRepository<HorarioTren, Serializable> {


}
