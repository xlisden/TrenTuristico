package com.example.demo.Controller;

import com.example.demo.Entity.Helpers.EstacionDto;
import com.example.demo.Service.IEstacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/estaciones")
@RequiredArgsConstructor
public class EstacionesController {

    private final IEstacionService estacionService;

    @GetMapping("")
    public List<EstacionDto> getEstaciones(){
        return estacionService.getInfoEstaciones();
    }

}
