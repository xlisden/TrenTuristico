package com.example.demo.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserId", nullable = false)
    private int id;

    @Size(max = 8)
    @NotNull
    @Column(name = "UserDni", nullable = false, length = 8)
    private String dni;

    @Size(max = 50)
    @NotNull
    @Column(name = "UserNombre", nullable = false, length = 50)
    private String nombre;

    @Size(max = 50)
    @NotNull
    @Column(name = "UserApPaterno", nullable = false, length = 50)
    private String apPaterno;

    @Size(max = 50)
    @NotNull
    @Column(name = "UserApMaterno", nullable = false, length = 50)
    private String apMaterno;

    @Size(max = 100)
    @NotNull
    @Column(name = "UserUsername", nullable = false, length = 100)
    private String username;

    @Size(max = 300)
    @NotNull
    @Column(name = "UserPassword", nullable = false, length = 300)
    private String password;

    @NotNull
    @Column(name = "UserActivo", nullable = false)
    private boolean activo = false;

}