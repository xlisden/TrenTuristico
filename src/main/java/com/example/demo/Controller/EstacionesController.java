
package com.example.demo.Controller;

import com.example.demo.Entity.dto.EstacionDto;
import com.example.demo.Entity.dto.ZonaTuristicaDto;
import com.example.demo.Entity.extras.Filtros;
import com.example.demo.Service.HorTrenService;
import com.example.demo.Service.IEstacionService;
import com.example.demo.Service.IZonaTuristicaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/estaciones")
@RequiredArgsConstructor
public class EstacionesController {

    private final IEstacionService estacionService;
    private final IZonaTuristicaService zonaService;
    private final HorTrenService horTrenService;

    @GetMapping("")
    public ModelAndView getEstaciones() {
        ModelAndView mav = new ModelAndView("estaciones/estaciones");
        Filtros filtros = new Filtros();
        List<EstacionDto> estaciones = new ArrayList<>();
        try {
            estaciones = estacionService.getInfoEstaciones();
            mav.addObject("filtros", filtros);
            mav.addObject("estaciones", estaciones);

            mav.addObject("esta",estacionService.getInfoEstaciones());
            mav.addObject("horas",horTrenService.findAllHorarioTren());
            mav.addObject("zonas",zonaService.findAllZonaTuristica());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }

    @GetMapping("/{id}")
    public ModelAndView getZonasPorEstacion(@PathVariable int id) {
        ModelAndView mav = new ModelAndView("estaciones/zonasturisticas");
        Filtros filtros = new Filtros();
        List<EstacionDto> estaciones = new ArrayList<>();
        List<ZonaTuristicaDto> zonas = new ArrayList<>();
        try {
            estaciones = estacionService.getInfoEstaciones();
            zonas = zonaService.filtrarByEstacion(id, null);
            mav.addObject("zonasDaye", zonas);
            mav.addObject("idEstacion", id);
            mav.addObject("filtros", filtros);
            mav.addObject("estaciones", estaciones);

            mav.addObject("esta",estacionService.getInfoEstaciones());
            mav.addObject("horas",horTrenService.findAllHorarioTren());
            mav.addObject("zonas",zonaService.findAllZonaTuristica());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }

    @GetMapping("/filtrar-zonas/{id}")
    public ModelAndView getFiltrarEstaciones(@ModelAttribute Filtros filtros, @PathVariable int id) {
        ModelAndView mav = new ModelAndView("estaciones/zonasturisticas");
        List<EstacionDto> estaciones = new ArrayList<>();
        List<ZonaTuristicaDto> zonas = new ArrayList<>();
        try {
            estaciones = estacionService.getInfoEstaciones();
            zonas = zonaService.filtrarByEstacion(id, filtros);
            mav.addObject("zonasDaye", zonas);
            mav.addObject("idEstacion", id);
            mav.addObject("filtros", filtros);
            mav.addObject("estaciones", estaciones);

            mav.addObject("esta",estacionService.getInfoEstaciones());
            mav.addObject("horas",horTrenService.findAllHorarioTren());
            mav.addObject("zonas",zonaService.findAllZonaTuristica());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }

    @PostMapping("/filtrar-zonas/{id}")
    public ModelAndView filtrarEstaciones(@ModelAttribute Filtros filtros, @PathVariable int id) {
        ModelAndView mav = new ModelAndView("estaciones/zonasturisticas");
        List<EstacionDto> estaciones = new ArrayList<>();
        List<ZonaTuristicaDto> zonas = new ArrayList<>();
        try {
            estaciones = estacionService.getInfoEstaciones();
            zonas = zonaService.filtrarByEstacion(id, filtros);
            mav.addObject("zonasDaye", zonas);
            mav.addObject("idEstacion", id);
            mav.addObject("filtros", filtros);
            mav.addObject("estaciones", estaciones);

            mav.addObject("esta",estacionService.getInfoEstaciones());
            mav.addObject("horas",horTrenService.findAllHorarioTren());
            mav.addObject("zonas",zonaService.findAllZonaTuristica());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mav;
    }

}