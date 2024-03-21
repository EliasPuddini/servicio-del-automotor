package com.Certant.servicio.del.automotor.utils.service;

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

        int dia,mes,año,hora,minuto;
        double opcionDouble, opcionDouble2;
        String patente;
        Scanner lectura = new Scanner(System.in);
        Client cliente;
        Servicio servicio;
        Turno turno;
        LocalDate fecha;
        LocalTime horaDelDia;
        LocalDateTime fechaYHora, fechaActual = LocalDateTime.now();

        System.out.println("Primero se ingresara el cliente del turno.");
        System.out.println("Ingresar el dni del cliente.");
        opcionDouble = lectura.nextDouble();

        if(utilsClientService.clienteExistente(clientRepository,opcionDouble)){

            cliente = clientRepository.findAll().stream().filter(client -> client.getDni() == opcionDouble).findFirst().orElse(null);
        }else{
            utilsClientService.ingresarClientes(clientRepository,opcionDouble);
            cliente = clientRepository.findAll().stream().filter(client -> client.getDni() == opcionDouble).findFirst().orElse(null);
        }

        System.out.println("Segundo se ingresara el servicio del turno.");
        servicio = utilsServicioService.ingresarServicio(servicioRepository);

        System.out.println("ingresar el precio");
        opcionDouble2 = lectura.nextDouble();

        System.out.println("Ahora se ingresaran los datos del turno.");
        do{
            System.out.println("ingresar la patente.");
            patente = lectura.next().toUpperCase();

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




        turno = new Turno(cliente,servicio,fechaYHora,patente,opcionDouble2);

        turnoRepository.save(turno);
        System.out.println("Turno guardado correctamente.");

        if(fechaYHora.isBefore(fechaActual)){
            utilsClientService.incrementarServiciosPrecios(cliente,clientRepository);
        }


    }

    public static List<Turno> buscarTurnosPorCliente(double dni, TurnoRepository turnoRepository){

        List<Turno> turnos = turnoRepository.findAll().stream().filter(turno -> turno.getCliente().getDni() == dni).collect(Collectors.toList());;

        System.out.println(turnos);
        return turnos;
    }

    public static void buscarTurnosPorID(Long id, TurnoRepository turnoRepository){

        System.out.println(turnoRepository.findById(id).orElse(null));
    }

    public static void buscarTurnosAntiguos(TurnoRepository turnoRepository, LocalDateTime fecha){

        List<Turno> turnos = turnoRepository.findAll().stream().filter(turno -> turno.getFecha().isBefore(fecha)).collect(Collectors.toList());
        for (Turno turno : turnos) {
            System.out.println(turno);
        }
    }

    public static void buscarTurnosFuturos(TurnoRepository turnoRepository, LocalDateTime fecha){

        List<Turno> turnos = turnoRepository.findAll().stream().filter(turno -> turno.getFecha().isAfter(fecha)).collect(Collectors.toList());
        for (Turno turno : turnos) {
            System.out.println(turno);
        }
    }

    public static boolean validarPatente(String patente) {
        String pattern = "^[A-Z]{3}\\d{3}$|^[A-Z]{2}\\d{3}[A-Z]{2}$";
        return Pattern.matches(pattern, patente);
    }

    public static void ActualizarServiciosPrevios(ClientRepository clientRepository, TurnoRepository turnoRepository, LocalDateTime fechaActual){ //actualizar la base de datos en base a la fecha de ejecución.

        List <Turno> turnos = turnoRepository.findAll().stream().collect(Collectors.toList());

        for (Turno turno : turnos) {

            Client client = turno.getCliente();
            Long turnosPrevios = turnoRepository.findAll().stream().filter(turno1 -> turno1.getCliente().getDni() == client.getDni() && turno1.getFecha().isBefore(fechaActual)).count();

            if(client.getServicios() != turnosPrevios) client.setServicios(turnosPrevios.intValue());
            clientRepository.save(client);
        }
    }



}
