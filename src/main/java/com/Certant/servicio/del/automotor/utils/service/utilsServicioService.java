package com.Certant.servicio.del.automotor.utils.service;

import com.Certant.servicio.del.automotor.dto.ClientDTO;
import com.Certant.servicio.del.automotor.models.Client;
import com.Certant.servicio.del.automotor.models.Servicio;
import com.Certant.servicio.del.automotor.repositories.ClientRepository;
import com.Certant.servicio.del.automotor.repositories.ServicioRepository;

import java.util.Optional;
import java.util.Scanner;

public class utilsServicioService {

    public static Servicio ingresarServicio(ServicioRepository servicioRepository){

        int flag = 0;
        double opcionDouble;
        String opcionString1,opcionString2,opcionString3;
        Scanner lectura = new Scanner(System.in);


        System.out.println("Se hara la alineación y balanceo?");
        opcionString1 = lectura.next();

        if (opcionString1.equals("si")) {

            opcionString1 = gestionarAYB(opcionString1, lectura);

        } else {
            opcionString1 = "no";
        }

        System.out.println("Se cambiara el aceite?");
        opcionString2 = lectura.next();

        if (opcionString2.equals("si")) {
            gestionarCAF(opcionString2, lectura);
        } else {
            opcionString2 = opcionString2 = "no";
        }


        System.out.println("Se lavara el vehiculo?");
        opcionString3 = lectura.next();

        if (opcionString2.equals("si")) {
            opcionString3 = gestionarLavado(opcionString3, lectura);
        } else {
            opcionString3 = "no";
        }

        System.out.println("ingresar el precio");
        opcionDouble = lectura.nextDouble();


        Servicio servicio = new Servicio(opcionString1, opcionString2, opcionString3, opcionDouble);
        servicioRepository.save(servicio);


        System.out.println("Servicio ingresado.");

        return servicio;
    }

    public static String gestionarAYB(String opcionString1,Scanner lectura){

        System.out.println("La alineación y balance incluye cambio de cubiertas?");
        opcionString1 = lectura.next();;

        if(opcionString1.equals("si")){
            opcionString1 = "Con cambio de cubiertas.";
        }else{
            opcionString1 = "Sin cambio de cubiertas.";
        }

        return opcionString1;
    }
    public static String gestionarCAF(String opcionString2,Scanner lectura){

        System.out.println("el motor es diesel?");
        opcionString2 = lectura.next();

        if(opcionString2.equals("si")){

            System.out.println("el aceite es de alto rendimiento?");
            opcionString2 = lectura.next();

            if(opcionString2.equals("si")){
                opcionString2 = "alto rendimiento para motor diesel";
            }else opcionString2 = "bajo rendimiento para motor diesel";

        }else{

            System.out.println("el aceite es de alto rendimiento?");
            opcionString2 = lectura.next();

            if(opcionString2.equals("si")){
                opcionString2 = "alto rendimiento para motor naftero";
            }else opcionString2 = "bajo rendimiento para motor naftero";
        }


        return opcionString2;
    }

    public static String gestionarLavado(String opcionString2,Scanner lectura){

        int opcionLavado;

        System.out.println("que tipo de lavado sera?:");
        System.out.println("1.Lavado basico.");
        System.out.println("2.Lavado Completo");
        System.out.println("3.Lavado Premium");
        opcionLavado = lectura.nextInt();

        if(opcionLavado == 1){
            opcionString2 = "Lavado Basico";
        }if(opcionLavado == 2){
            opcionString2 = "Lavado Completo";
        }if(opcionLavado == 3){
            opcionString2 = "Lavado Premium";
        }

        return opcionString2;
    }
}
