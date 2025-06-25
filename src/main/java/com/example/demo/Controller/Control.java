package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Service.ActividadService;

@Controller
@RequestMapping("/sis")
public class Control {
	@Autowired
	@Qualifier("actiservice")
	private ActividadService actiser;
	
	@GetMapping({"/", ""})
    public ModelAndView a1() {
		ModelAndView mav = new ModelAndView("h");
		
		mav.addObject("acti",actiser.findAllActi());
		return mav;
	}
}
