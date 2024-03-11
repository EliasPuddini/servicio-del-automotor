package com.Certant.servicio.del.automotor;

import com.Certant.servicio.del.automotor.models.Client;
import com.Certant.servicio.del.automotor.models.Servicio;
import com.Certant.servicio.del.automotor.models.Turno;
import com.Certant.servicio.del.automotor.repositories.TurnoRepository;
import com.Certant.servicio.del.automotor.service.implementations.ClientServiceImplementations;
import com.Certant.servicio.del.automotor.service.implementations.TurnosServiceImplementations;
import com.Certant.servicio.del.automotor.service.implementations.ServicioServiceImplementations;
import com.Certant.servicio.del.automotor.utils.service.utilsClientService;
import com.Certant.servicio.del.automotor.utils.service.utilsTurnosService;
import com.Certant.servicio.del.automotor.repositories.ClientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
public class ServicioDelAutomotorApplicationTests {//comentar el @Bean en la funcion init de ServicioDelAutomotorApplication si quieren ejecutar los test

	@Autowired
	ClientRepository clientRepository;
	@Autowired
	TurnoRepository turnoRepository;
	@Autowired
	ClientServiceImplementations clientServiceImplementations;
	@Autowired
	TurnosServiceImplementations turnosServiceImplementations;
	@Autowired
	ServicioServiceImplementations servicioServiceImplementations;


	//test de los servicios del menu
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

	//test de los servicios de la api
	@Test
	public void crearBuscarEliminarUsuario(){

		Client cliente = new Client("Jose Luis",0,3154698);
		boolean operacion1,operacion2;

		clientServiceImplementations.saveClient(cliente);
		operacion1 = clientServiceImplementations.getClient(cliente.getId()).isPresent();

		clientServiceImplementations.deleteClient(cliente.getId());
		operacion2 = clientServiceImplementations.getClient(cliente.getId()).isEmpty();

		Assertions.assertTrue(operacion1&&operacion2);
	}
	@Test
	public void crearBuscarEliminarServicio(){

		Servicio servicio = new Servicio("alto rendimiento para motor diesel","Con cambio de cubiertas","Lavado Premium",100000);
		boolean operacion1, operacion2;

		servicioServiceImplementations.saveServicio(servicio);
		operacion1 = servicioServiceImplementations.getServicio(servicio.getId()).isPresent();

		servicioServiceImplementations.deleteServicio(servicio.getId());
		operacion2 = servicioServiceImplementations.getServicio(servicio.getId()).isEmpty();

		Assertions.assertTrue(operacion1&&operacion2);
	}
	@Test
	public void crearBuscarEliminarTurno(){

		Client cliente = new Client("Jose Luis",0,3154698);
		Servicio servicio = new Servicio("alto rendimiento para motor diesel","Con cambio de cubiertas","Lavado Premium",100000);
		Turno turno = new Turno(cliente,servicio, LocalDateTime.of(2024,05,15,9,30),"CS963SQ");
		boolean operacion1, operacion2;

		turnosServiceImplementations.saveTurno(turno);
		operacion1 = turnosServiceImplementations.getTurnoDTO(turno.getId()).isPresent();

		turnosServiceImplementations.deleteTurno(turno.getId());
		operacion2 = turnosServiceImplementations.getTurnoDTO(turno.getId()).isEmpty();

		clientServiceImplementations.deleteClient(turno.getCliente().getId());
		servicioServiceImplementations.deleteServicio(turno.getCliente().getId());

		Assertions.assertTrue(operacion1&&operacion2);
	}
}
