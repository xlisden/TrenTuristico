package com.example.demo.Service;

import com.example.demo.Entity.Helpers.EstacionDto;
import org.springframework.stereotype.Component;

import java.util.List;

public interface IEstacionService {

    public abstract List<EstacionDto> getInfoEstaciones();

}
