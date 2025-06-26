package com.example.demo.Controller;

import com.example.demo.Entity.Helpers.Filtros;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")
public class TestController {

    @GetMapping("")
    public ModelAndView test() {
        ModelAndView mav = new ModelAndView("test");
        Filtros filtros = new Filtros();
        filtros.setAventura(true);

        mav.addObject("filtros", filtros);
        return mav;
    }

}
