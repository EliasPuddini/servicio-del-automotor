package com.Certant.servicio.del.automotor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestServicioDelAutomotorApplication {

	public static void main(String[] args) {
		SpringApplication.from(ServicioDelAutomotorApplication::main).with(TestServicioDelAutomotorApplication.class).run(args);
	}

}
