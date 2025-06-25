package com.example.demo.Service.ServiceImpl;

import com.example.demo.Entity.Helpers.EstacionDto;
import com.example.demo.Repository.EstacionRepository;
import com.example.demo.Service.IEstacionService;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EstacionService implements IEstacionService {

    private final EstacionRepository estacionRepository;

    @Override
    public List<EstacionDto> getInfoEstaciones() {
        System.err.println("hora = " + getHora());
        return estacionRepository.getInfoEstaciones(getHora());
    }

    public int getHora() {
        int horaInicial = LocalDateTime.now().getHour();
        if (horaInicial < 10)
            return 7;
        else if (horaInicial >= 10 && horaInicial < 13)
            return 10;
        else if (horaInicial >= 13 && horaInicial < 16)
            return 13;
        else if (horaInicial >= 16 && horaInicial < 19)
            return 16;
        else if (horaInicial >= 19)
            return 19;
        return 0;
    }
}
