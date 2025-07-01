package com.example.demo.Controller;

import com.example.demo.Entity.HorarioTren;
import com.example.demo.Entity.dto.EstacionDto;
import com.example.demo.Service.HorTrenService;
import com.example.demo.Service.IEstacionService;
import com.example.demo.Service.IZonaTuristicaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalTime;
import java.util.List;

@Controller
@RequestMapping("/sis")
@RequiredArgsConstructor
public class Control {

	private final IEstacionService estacionService;
	private	 final HorTrenService horTrenService;
	private	 final IZonaTuristicaService sonaService;

	@GetMapping({"/", ""})
    public ModelAndView a1() {
		ModelAndView mav = new ModelAndView("tren_temp");
		
		mav.addObject("esta",estacionService.getInfoEstaciones());
		mav.addObject("horas",horTrenService.findAllHorarioTren());
		mav.addObject("zonas",sonaService.findAllZonaTuristica());

		return mav;
	}





	@GetMapping({"/g"})
	public ModelAndView a3() {
		return new ModelAndView("h2");
	}
}
