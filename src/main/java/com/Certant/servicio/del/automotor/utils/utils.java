package com.Certant.servicio.del.automotor.utils;

import java.util.List;
import java.util.Scanner;

import com.Certant.servicio.del.automotor.dto.ClientDTO;
import com.Certant.servicio.del.automotor.models.Client;
import com.Certant.servicio.del.automotor.repositories.ClientRepository;
import com.Certant.servicio.del.automotor.repositories.ServicioRepository;
import com.Certant.servicio.del.automotor.repositories.TurnoRepository;
import com.Certant.servicio.del.automotor.utils.service.utilsClientService;

import static java.util.stream.Collectors.toList;

public class utils {

    public static void menu(ClientRepository clientRepository, TurnoRepository turnoRepository,ServicioRepository servicioRepository){

        int flag = 0, flagClients = 0,flagTurnos = 0,flagServices = 0, opcionMenu;
        Scanner lectura1 = new Scanner(System.in);

        do{
            System.out.println("Bienvenido al menu. Introducir el numero en consola.");
            System.out.println("1.Ver,buscar, e introducir clientes.");
            System.out.println("2.ver,buscar, e introducir turnos.");
            System.out.println("3.ver,buscar, e introducir servicios.");
            System.out.println("4.Salir.");
            opcionMenu = lectura1.nextInt();
            List<ClientDTO> clientes = clientRepository.findAll().stream().map(client ->new ClientDTO(client)).collect(toList());


            switch(opcionMenu){
                case 1:
                    do{
                        System.out.println("Clientes.");

                        if(!clientes.isEmpty()){//si no hay clientes en la base de datos

                            System.out.println("clientes registrados en la base de datos:");
                            System.out.println(clientes);
                        }else{
                            System.out.println("sin clientes registrados en la base de datos.");
                        }


                        System.out.println("1.Ingresar un cliente.");
                        System.out.println("2.Buscar un cliente.");
                        System.out.println("3.Salir de clientes.");
                        opcionMenu = lectura1.nextInt();

                        switch (opcionMenu){
                            case 1:

                                utilsClientService.ingresarClientes(clientRepository);

                                break;
                            case 2:


                                utilsClientService.buscarCliente(clientRepository);

                                break;
                            case 3:
                                flagClients ++;

                            default:
                                System.out.println("Numero erroneo. se vuelve al menu principal. ");
                        }
                    }while(flagClients == 0);

                        break;

                case 2:
                    /*
                    System.out.println("Turnos.");
                    if(turnosService.getTurnosDTO().isEmpty()){//si no hay turnos en la base de datos

                        System.out.println("Turnos registrados en la base de datos:");
                        System.out.println(turnosService.getTurnosDTO());
                    }else{
                        System.out.println("sin turnos registrados en la base de datos.");
                    }

                    System.out.println("Desea ingresar un turno? Ingresar si o no");
                    opcion1 = lectura1.next();

                    if(opcion1 == "si"){

                        System.out.println("Es nuevo el turno? Ingresar si o no");
                        opcion1 = lectura1.next();

                        if(opcion1 == "si"){


                        }if(opcion1 == "no"){

                        }else{
                            System.out.println("error, se vuelve al menu principal.");
                        }

                    }
                    */
                    break;
                case 3:
                    /*
                    System.out.println("Servicios.");
                    if(servicioService.getServiciosDTO().isEmpty()){//si no hay Servicios en la base de datos

                        System.out.println("Servicios registrados en la base de datos:");
                        System.out.println(clientService.getClientsDTO());
                    }

                    System.out.println("Desea ingresar un servicio? Ingresar si o no");
                    opcion1 = lectura1.next();
                    if(opcion1 == "si"){

                        System.out.println("Es nuevo el servicio? Ingresar si o no");
                        opcion1 = lectura1.next();

                        if(opcion1 == "si"){


                        }if(opcion1 == "no"){

                        }else{
                            System.out.println("error, se vuelve al menu principal.");
                        }

                    }
                    */


                    break;

                default:
                    System.out.println("Se salio del menu. el servidor servidor sigue funcionando.");
                    flag ++;
            }
        }while(flag == 0);

    }



}
