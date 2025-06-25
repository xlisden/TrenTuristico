package com.example.demo.Service.ServiceImpl;

import com.example.demo.Entity.Helpers.EstacionDto;
import com.example.demo.Repository.EstacionRepository;
import com.example.demo.Service.IEstacionService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EstacionService implements IEstacionService {

    private final EstacionRepository estacionRepository;

    @Override
    public List<EstacionDto> getInfoEstaciones() {
        return estacionRepository.getInfoEstaciones();
    }
}
