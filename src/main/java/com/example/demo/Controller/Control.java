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

import java.time.Duration;
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
		t();
		return mav;
	}


	public  void t(){
		List<HorarioTren> h = horTrenService.findAllHorarioTren();
		int Des = 10;// estacion donde quiero ir
		int ori = 3; // estacion donde estoy
		int direc = 2 ;
		LocalTime now = LocalTime.now();
		LocalTime abor = null;
		LocalTime tf = null;
		System.out.println(now);

		for (HorarioTren ht : h) {
			LocalTime hora = LocalTime.parse(ht.getHora());
			int ubi = ht.getEstacionUbi();
			int dic = ht.getDireccion();
			int est = ht.getEstado();
			if(Des>ori)     direc=1;

			if(hora.isAfter(now) && ori == ubi  && dic == direc && est == 2) {

				abor = hora;
			}
			if(abor != null && ubi == Des && est == 2){
				tf = hora;
				Duration dur = Duration.between(now, abor);
				System.out.println(" tiempo hasta el abordaje :  "+dur.getSeconds()+"  - id: "+ht.getId());
				dur = Duration.between(abor, tf);
				System.out.println("tiempo estimado entre estaciones :   "+dur.getSeconds()+" -  id: "+ht.getId());
				return;
			}
		}
	}




	@GetMapping({"/g"})
	public ModelAndView a3() {
		return new ModelAndView("h2");
	}
}
