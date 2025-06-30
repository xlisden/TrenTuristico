package com.example.demo.Service.ServiceImpl;

import com.example.demo.Entity.HorarioTren;
import com.example.demo.Repository.HorTrenRepository;
import com.example.demo.Service.HorTrenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HorTrenServiceImpl implements HorTrenService {

    private final HorTrenRepository horTrenService;

    @Override
    public List<HorarioTren> findAllHorarioTren() {
        return horTrenService.findAll();
    }
}
