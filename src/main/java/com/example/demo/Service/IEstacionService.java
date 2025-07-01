package com.example.demo.Service;

import com.example.demo.Entity.Estacion;
import com.example.demo.Entity.dto.EstacionDto;

import java.util.List;

public interface IEstacionService {

    public abstract List<EstacionDto> getInfoEstaciones();
    public abstract List<Estacion> listar();
}
