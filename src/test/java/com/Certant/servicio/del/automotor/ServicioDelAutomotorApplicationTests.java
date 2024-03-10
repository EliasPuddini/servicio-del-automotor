package com.Certant.servicio.del.automotor;

import com.Certant.servicio.del.automotor.models.Client;
import com.Certant.servicio.del.automotor.models.Turno;
import com.Certant.servicio.del.automotor.repositories.TurnoRepository;
import com.Certant.servicio.del.automotor.utils.service.utilsClientService;
import com.Certant.servicio.del.automotor.utils.service.utilsTurnosService;
import com.Certant.servicio.del.automotor.repositories.ClientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
public class ServicioDelAutomotorApplicationTests {

	@Autowired
	ClientRepository clientRepository;
	@Autowired
	TurnoRepository turnoRepository;

	@Test
	public void existeEnLaBase(){

		Client client1 = clientRepository.findAll().stream().toList().get(4);//cliente en la base de datos

		Assertions.assertTrue(utilsClientService.clienteExistente(clientRepository,client1.getDni()));
	}

	@Test
	public void noExisteEnLaBase(){

		Client client = new Client("Esteban Quito", 0,35485678); //cliente no ingresado en la base de datos

		Assertions.assertFalse(utilsClientService.clienteExistente(clientRepository,client.getDni()));
	}

	@Test
	public void validarPatentes1(){

		String a = "AA123VV", c = "SD405AD";

		Assertions.assertTrue(utilsTurnosService.validarPatente(a) && utilsTurnosService.validarPatente(c));
	}

	@Test
	public void validarPatentes2(){

		String b = "A1C1V1";

		Assertions.assertFalse(utilsTurnosService.validarPatente(b));
	}

	@Test
	public void buscarTurnosPorCliente(){

		Client client = clientRepository.findAll().stream().toList().get(5);

		List<Turno> turnos = utilsTurnosService.buscarTurnosPorCliente(client.getDni(),turnoRepository);

        Assertions.assertFalse(turnos.isEmpty());
	}

}
