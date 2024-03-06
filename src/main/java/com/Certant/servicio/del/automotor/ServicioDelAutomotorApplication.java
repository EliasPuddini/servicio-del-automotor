package com.Certant.servicio.del.automotor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Certant.servicio.del.automotor.models.*;

import java.time.LocalDateTime;

import static com.Certant.servicio.del.automotor.models.ClientType.PREMIUM;

@SpringBootApplication
public class ServicioDelAutomotorApplication {



	public static void main(String[] args) {
		SpringApplication.run(ServicioDelAutomotorApplication.class, args);

		Cliente cliente1 = new Cliente("AA123AA","Elias Puddini",ClientType.PREMIUM,8);
		Servicio servicio1 = new Servicio(ABTYPE.ABCONCAMBIODECUBIERTAS,CAFTYPE.BASICODIESEL,LavadoType.LavadoCompleto);
		Turno turno1 = new Turno(cliente1,servicio1,LocalDateTime.of(2024,03,06,12,1));

	}


}
