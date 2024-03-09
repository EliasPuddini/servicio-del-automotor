package com.Certant.servicio.del.automotor.utils.service;

import com.Certant.servicio.del.automotor.dto.ClientDTO;
import com.Certant.servicio.del.automotor.dto.TurnoDTO;
import com.Certant.servicio.del.automotor.models.Client;
import com.Certant.servicio.del.automotor.models.Servicio;
import com.Certant.servicio.del.automotor.models.Turno;
import com.Certant.servicio.del.automotor.repositories.ClientRepository;
import com.Certant.servicio.del.automotor.repositories.ServicioRepository;
import com.Certant.servicio.del.automotor.repositories.TurnoRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class utilsTurnosService {

    public static void ingresarTurnos(ClientRepository clientRepository, TurnoRepository turnoRepository, ServicioRepository servicioRepository){

        int flag = 0, dia,mes,año,hora,minuto;
        double opcionDouble;
        String patente;
        Scanner lectura = new Scanner(System.in);
        Client cliente;
        Servicio servicio;
        Turno turno;
        LocalDate fecha;
        LocalTime horaDelDia;
        LocalDateTime fechaYHora;

        System.out.println("Primero se ingresara el cliente del turno.");
        System.out.println("Ingresar el dni del cliente.");
        opcionDouble = lectura.nextDouble();

        if(utilsClientService.clienteExistente(clientRepository,opcionDouble)){

            cliente = clientRepository.findAll().stream().filter(client -> client.getDni() == opcionDouble).findFirst().orElse(null);
        }else{
            utilsClientService.ingresarClientes(clientRepository);
            cliente = clientRepository.findAll().stream().filter(client -> client.getDni() == opcionDouble).findFirst().orElse(null);
        }

        System.out.println("Segundo se ingresara el servicio del turno.");
        servicio = utilsServicioService.ingresarServicio(servicioRepository);

        System.out.println("Ahora se ingresaran los datos del turno.");
        do{
            System.out.println("ingresar la patente.");
            patente = lectura.next();

            if(!validarPatente(patente)){
                System.out.println("Formato de patente erroneo.");
            }

        }while(!validarPatente(patente));



        System.out.println("Tercero, ingresar la fecha. siguiendo el formato (año mes dia)");
        año = lectura.nextInt();
        mes = lectura.nextInt();
        dia = lectura.nextInt();
        fecha = LocalDate.of(año, mes, dia);

        System.out.println("Tercero, ingresar la hora. siguiendo el formato (hora minuto)");
        hora = lectura.nextInt();
        minuto = lectura.nextInt();
        horaDelDia = LocalTime.of(hora,minuto);

        fechaYHora = LocalDateTime.of(fecha, horaDelDia);

        turno = new Turno(cliente,servicio,fechaYHora,patente);

        turnoRepository.save(turno);
        System.out.println("Turno guardado correctamente.");

    }

    public static void buscarTurnosPorCliente(double dni, TurnoRepository turnoRepository){

        List<TurnoDTO> turnos = turnoRepository.findAll().stream().filter(turno -> turno.getCliente().getDni() == dni).map(turno -> new TurnoDTO(turno)).collect(Collectors.toList());;

        System.out.println(turnos);
    }

    public static void buscarTurnosPorID(Long id, TurnoRepository turnoRepository){

        System.out.println(turnoRepository.findById(id).orElse(null));
    }

    public static boolean validarPatente(String patente) {
        String pattern = "^[A-Z]{3}\\d{3}$|^[A-Z]{2}\\d{3}[A-Z]{2}$";
        return Pattern.matches(pattern, patente);
    }

}
