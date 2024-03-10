package com.Certant.servicio.del.automotor.utils.service;

import com.Certant.servicio.del.automotor.dto.ClientDTO;
import com.Certant.servicio.del.automotor.models.Client;
import com.Certant.servicio.del.automotor.repositories.ClientRepository;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class utilsClientService {

    public static void ingresarClientes(ClientRepository clientRepository,int contexto){

        int flag = 0;
        double opcionDouble;
        String opcionString;
        Scanner lectura = new Scanner(System.in);

            do{
                System.out.println("ingresar el nombre");
                opcionString = lectura.next();
                System.out.println("ingresar el DNI");
                opcionDouble = lectura.nextDouble();

                if(clienteExistente(clientRepository,opcionDouble)){
                    System.out.println("DNI existente en la base de datos.Quiere ingresar otro cliente nuevo?");
                    opcionString = lectura.next();
                }else{
                    Client client = new Client(opcionString,0,opcionDouble);
                    clientRepository.save(client);

                    if(contexto == 0){
                        System.out.println("Cliente ingresado. Quiere ingresar un cliente nuevo?");
                        opcionString = lectura.next();
                    }else{
                        System.out.println("Cliente ingresado.");
                        flag++;
                    }
                }

                if (opcionString.equals("no")){
                    flag++;
                }

            }while(flag == 0);
    }



    public static void buscarClientes(ClientRepository clientRepository){
        System.out.println(clientRepository.findAll().stream().collect(Collectors.toList()));
    }

    public static Client buscarCliente(ClientRepository clientRepository,double dni){

        Client cliente;

        cliente = clientRepository.findAll().stream().filter(client -> client.getDni()==dni).findFirst().orElse(null);

        System.out.println(cliente);
        return cliente;
    }


    public static boolean clienteExistente(ClientRepository clientRepository,double dni){
        return clientRepository.findAll().stream().filter(client -> client.getDni()==dni).count() != 0;
    };

    public static void incrementarServiciosPrecios(Client client,ClientRepository clientRepository){

        client.updateServicecounter();
        clientRepository.save(client);
    }
}
