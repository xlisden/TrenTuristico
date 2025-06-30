package com.example.demo.Controller;

import com.example.demo.Entity.HorarioTren;
import com.example.demo.Service.HorTrenService;
import com.example.demo.Service.IEstacionService;
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


	private final ListableBeanFactory listableBeanFactory;

	static class Tren {
		public int posicionInicial;
		public int direccion;

		public Tren(int posicionInicial, int direccion) {
			this.posicionInicial = posicionInicial;
			this.direccion = direccion;
		}
	}


	private final IEstacionService estacionService;
	private	 final HorTrenService horTrenService;
	private Integer estacionActiva = null;
	//private final IReporteClimaService reporteClimaService;

	@GetMapping({"/", ""})
    public ModelAndView a1() {
		ModelAndView mav = new ModelAndView("tren_temp");
		
		mav.addObject("esta",estacionService.getInfoEstaciones());
		mav.addObject("horas",horTrenService.findAllHorarioTren());
		a();
		return mav;
	}


	public void a(){

		List< HorarioTren> lista = horTrenService.findAllHorarioTren();

		//System.err.println("aaaaa  :"+lista.size());
		for (int i = 1; i < lista.size() ; i++) {
			LocalTime t1 = LocalTime.parse(lista.get(i).getHora());
			LocalTime t2 = LocalTime.now();
			//System.err.println(t1);
			if(LocalTime.parse(lista.get(i-1).getHora()).isBefore(t2) && t1.isAfter(t2)){
				System.err.println(lista.get(i-1).getDireccion());
				System.err.println(lista.get(i-1).getEstacionUbi());
				System.err.println(lista.get(i-1).getHora());
			}
		}
	}
}
