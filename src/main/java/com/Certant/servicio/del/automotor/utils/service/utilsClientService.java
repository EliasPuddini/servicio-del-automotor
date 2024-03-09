package com.Certant.servicio.del.automotor.utils.service;

import com.Certant.servicio.del.automotor.dto.ClientDTO;
import com.Certant.servicio.del.automotor.models.Client;
import com.Certant.servicio.del.automotor.repositories.ClientRepository;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class utilsClientService {

    public static void ingresarClientes(ClientRepository clientRepository){

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
                    System.out.println("Cliente ingresado. Quiere ingresar un cliente nuevo?");
                    opcionString = lectura.next();
                }

                if (opcionString.equals("no")){
                    flag++;
                }

            }while(flag == 0);
    }



    public static void buscarCliente(ClientRepository clientRepository){

        double dni;
        ClientDTO cliente;
        Scanner lectura = new Scanner(System.in);

        System.out.println("Introduzca el dni del cliente.");
        dni = lectura.nextDouble();

        cliente = clientRepository.findAll().stream().filter(client -> client.getDni()==dni).map(client -> new ClientDTO(client)).findFirst().orElse(null);

        System.out.println(cliente);
    }


    public static boolean clienteExistente(ClientRepository clientRepository,double dni){
        return clientRepository.findAll().stream().filter(client -> client.getDni()==dni).count() != 0;
    };
}
