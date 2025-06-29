package com.example.demo.Controller;

import com.example.demo.Entity.dto.PronosticoClimaDto;
import com.example.demo.Entity.extras.Filtros;
import com.example.demo.Service.IReporteClimaService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/test")
@RequiredArgsConstructor
@Slf4j
public class TestController {

    private final IReporteClimaService climaService;

    @GetMapping("/2")
    public ModelAndView test2() {
        ModelAndView mav = new ModelAndView("test2");
        PronosticoClimaDto pronosticoClimaDto = new PronosticoClimaDto();
        try {
            pronosticoClimaDto = climaService.getPronosticoClima();
            mav.addObject("clima", pronosticoClimaDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }

    @PostMapping("/procesar")
    public String procesarFiltros(@ModelAttribute Filtros filtros) {
        if (filtros.isSenderismo())
            log.debug("vamo de senderismo");
        if (filtros.isSoleado())
            log.debug("solecito");
        if (filtros.isCataVinos())
            log.debug("toca vinito");

         return "h";
    }

}
