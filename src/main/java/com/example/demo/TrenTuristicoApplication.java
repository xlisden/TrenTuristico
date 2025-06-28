package com.example.demo;

import com.example.demo.Service.ServiceImpl.ReporteClimaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class TrenTuristicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrenTuristicoApplication.class, args);
		System.err.println("READY!");
	}

}
