package com.example.demo.Controller;

import com.example.demo.Entity.dto.PronosticoClimaDto;
import com.example.demo.Service.IReporteClimaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/clima")
@RequiredArgsConstructor
public class ReporteClimaController {

    private final IReporteClimaService climaService;

    @GetMapping("")
    public ModelAndView getReporteClima(){
        ModelAndView mav = new ModelAndView("clima/clima");
        PronosticoClimaDto pronosticoClimaDto = new PronosticoClimaDto();

        try {
            pronosticoClimaDto = climaService.getPronosticoClima();
            mav.addObject("clima", pronosticoClimaDto);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mav;
    }

}
