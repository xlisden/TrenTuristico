package com.example.demo.Controller;

import com.example.demo.Entity.dto.PronosticoClimaDto;
import com.example.demo.Service.IReporteClimaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clima")
@RequiredArgsConstructor
public class ReporteClimaController {

    private final IReporteClimaService reporteClimaService;

    @GetMapping("")
    public PronosticoClimaDto getReporteClima(){
        try {
            return reporteClimaService.getPronosticoClima();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
