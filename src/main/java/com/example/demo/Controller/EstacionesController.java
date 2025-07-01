package com.example.demo.Controller;

import com.example.demo.Entity.extras.Filtros;
import com.example.demo.Service.IEstacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/estaciones")
@RequiredArgsConstructor
public class EstacionesController {

    private final IEstacionService estacionService;

    // odio github
    @GetMapping("")
    public ModelAndView getEstaciones(){
        ModelAndView mav = new ModelAndView("estaciones/estaciones");
        try {
            Filtros filtros = new Filtros();
            filtros.setCataVinos(true);
            mav.addObject("filtros", filtros);
            mav.addObject("estaciones", estacionService.getInfoEstaciones());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }

    @PostMapping("/filtrar")
    public ModelAndView filtrarEstaciones(@ModelAttribute Filtros filtros){
        ModelAndView mav = new ModelAndView("estaciones/estaciones");
        try {
            mav.addObject("filtros", filtros);
            mav.addObject("estaciones", estacionService.getInfoEstaciones());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }

}
