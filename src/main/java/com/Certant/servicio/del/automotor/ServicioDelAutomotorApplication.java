package com.Certant.servicio.del.automotor;

import com.Certant.servicio.del.automotor.repositories.ClientRepository;
import com.Certant.servicio.del.automotor.repositories.ServicioRepository;
import com.Certant.servicio.del.automotor.repositories.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class ServicioDelAutomotorApplication {

	public static void main(String[] args){
		SpringApplication.run(ServicioDelAutomotorApplication.class, args);

	}

}
