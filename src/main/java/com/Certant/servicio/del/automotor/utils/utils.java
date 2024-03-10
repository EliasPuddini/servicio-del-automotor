package com.Certant.servicio.del.automotor.utils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import com.Certant.servicio.del.automotor.dto.ClientDTO;
import com.Certant.servicio.del.automotor.dto.TurnoDTO;
import com.Certant.servicio.del.automotor.models.Client;
import com.Certant.servicio.del.automotor.repositories.ClientRepository;
import com.Certant.servicio.del.automotor.repositories.ServicioRepository;
import com.Certant.servicio.del.automotor.repositories.TurnoRepository;
import com.Certant.servicio.del.automotor.utils.service.utilsClientService;
import com.Certant.servicio.del.automotor.utils.service.utilsTurnosService;

import static java.util.stream.Collectors.toList;

public class utils {

    public static void menu(ClientRepository clientRepository, TurnoRepository turnoRepository,ServicioRepository servicioRepository){

        int flag = 0, flagClients = 0,flagTurnos = 0, opcionMenu;
        Long opcionLong;
        double opcionDouble;
        Scanner lectura1 = new Scanner(System.in);
        LocalDateTime fechaActual = LocalDateTime.now();

        utilsTurnosService.ActualizarServiciosPrevios(clientRepository,turnoRepository,fechaActual);//actualizar la base de datos en base a la fecha actual.


        do{
            System.out.println("Bienvenido al menu. Introducir el numero en consola.");
            System.out.println("1.Ver,buscar, e introducir clientes.");
            System.out.println("2.ver,buscar, e introducir turnos.");
            System.out.println("3.Salir.");
            opcionMenu = lectura1.nextInt();



            switch(opcionMenu){
                case 1:
                    do{
                        System.out.println("Clientes.");
                        System.out.println("1.Ingresar un cliente.");
                        System.out.println("2.Buscar un cliente.");
                        System.out.println("3.Ver todos los clientes.");
                        System.out.println("4.Salir de clientes.");
                        opcionMenu = lectura1.nextInt();

                        switch (opcionMenu){
                            case 1:

                                utilsClientService.ingresarClientes(clientRepository,0);
                                break;
                            case 2:

                                utilsClientService.buscarCliente(clientRepository);
                                break;
                            case 3:

                                utilsClientService.buscarClientes(clientRepository);
                                break;
                            case 4:

                                System.out.println("Volviendo al menu principal. ");
                                flagClients ++;
                            default:

                                System.out.println("Numero erroneo. se vuelve al menu principal. ");
                                flagClients ++;
                        }
                    }while(flagClients == 0);

                        break;

                case 2:

                    do{
                        System.out.println("Turnos.");
                        System.out.println("1.Ingresar un turno.");
                        System.out.println("2.Buscar turnos por cliente.");
                        System.out.println("3.Buscar turnos por id.");
                        System.out.println("4.Ver todos los turnos antiguos.");
                        System.out.println("5.Ver todos los turnos futuros.");
                        System.out.println("6.Salir de turnos.");
                        opcionMenu = lectura1.nextInt();

                        switch (opcionMenu){
                            case 1:

                                utilsTurnosService.ingresarTurnos(clientRepository,turnoRepository,servicioRepository);
                                break;
                            case 2:

                                System.out.println("Ingresar el dni del cliente.");
                                opcionDouble = lectura1.nextDouble();
                                utilsTurnosService.buscarTurnosPorCliente(opcionDouble,turnoRepository);
                                break;
                            case 3:

                                System.out.println("Ingresar el id del turno.");
                                opcionLong = lectura1.nextLong();
                                utilsTurnosService.buscarTurnosPorID(opcionLong,turnoRepository);
                                break;
                            case 4:

                                utilsTurnosService.buscarTurnosAntiguos(turnoRepository,fechaActual);
                                break;
                            case 5:

                                utilsTurnosService.buscarTurnosFuturos(turnoRepository,fechaActual);
                                break;
                            case 6:

                                System.out.println("Volviendo al menu principal. ");
                                flagTurnos ++;
                                break;
                            default:

                                System.out.println("Numero erroneo. se vuelve al menu principal. ");
                                flagTurnos ++;
                        }

                    }while(flagTurnos == 0);

                    break;

                default:
                    System.out.println("Se salio del menu. el servidor servidor sigue funcionando.");
                    flag ++;
            }
        }while(flag == 0);

    }



}
