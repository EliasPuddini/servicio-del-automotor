package com.Certant.servicio.del.automotor;

import com.Certant.servicio.del.automotor.models.*;
import com.Certant.servicio.del.automotor.repositories.ClientRepository;
import com.Certant.servicio.del.automotor.repositories.ServicioRepository;
import com.Certant.servicio.del.automotor.repositories.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class ServicioDelAutomotorApplication {
	@Autowired
	ClientRepository clientRepository;
	@Autowired
	TurnoRepository turnoRepository;
	@Autowired
	ServicioRepository servicioRepository;

	public static void main(String[] args) {
		SpringApplication.run(ServicioDelAutomotorApplication.class, args);
	}
	@Bean
	public CommandLineRunner init(){
		return args -> {
			/*
			Client cliente1 = new Client("Elias Puddini", ClientType.PREMIUM,8);
			Servicio servicio1 = new Servicio(ABTYPE.ABCONCAMBIODECUBIERTAS, CAFTYPE.BASICODIESEL, LavadoType.LavadoCompleto);
			Turno turno1 = new Turno(cliente1,servicio1, LocalDateTime.of(2024,03,06,12,1),"AA124VS");

			clientRepository.save(cliente1);
			servicioRepository.save(servicio1);
			turnoRepository.save(turno1);*/


		};
	}
}
