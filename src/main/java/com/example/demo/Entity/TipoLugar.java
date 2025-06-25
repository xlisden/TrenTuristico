package com.example.demo.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "tipolugar")
public class TipoLugar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TLugarId", nullable = false)
    private int id;

    @Size(max = 30)
    @NotNull
    @Column(name = "TLugarNombre", nullable = false, length = 30)
    private String nombre;

}