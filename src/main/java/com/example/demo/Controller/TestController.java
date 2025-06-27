package com.example.demo.Controller;

import com.example.demo.Entity.Helpers.Filtros;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/test")
@Slf4j
public class TestController {

    @GetMapping("")
    public ModelAndView test() {
        ModelAndView mav = new ModelAndView("test");
        Filtros filtros = new Filtros();
        filtros.setAventura(true);

        mav.addObject("filtros", filtros);
        return mav;
    }


    @PostMapping("/procesar")
    public String procesarFiltros(@ModelAttribute Filtros filtros) {
        if (filtros.isSenderismo())
            log.debug("vamo de senderismo");
        if (filtros.isSoleado())
            log.debug("solecito");

         return "h";
    }

}
