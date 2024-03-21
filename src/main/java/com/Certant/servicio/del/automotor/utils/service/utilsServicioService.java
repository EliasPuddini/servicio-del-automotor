package com.Certant.servicio.del.automotor.utils.service;

import com.Certant.servicio.del.automotor.dto.ClientDTO;
import com.Certant.servicio.del.automotor.models.Client;
import com.Certant.servicio.del.automotor.models.Servicio;
import com.Certant.servicio.del.automotor.models.Turno;
import com.Certant.servicio.del.automotor.repositories.ClientRepository;
import com.Certant.servicio.del.automotor.repositories.ServicioRepository;
import com.Certant.servicio.del.automotor.repositories.TurnoRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class utilsServicioService {

    public static Servicio ingresarServicio(ServicioRepository servicioRepository){

        String opcionString1,opcionString2,opcionString3;
        Scanner lectura = new Scanner(System.in);


        System.out.println("Se hara la alineación y balanceo?");
        opcionString1 = lectura.next();

        if (opcionString1.equals("si")) {

            opcionString1 = gestionarAYB();

        } else {
            opcionString1 = "no";
        }

        System.out.println("Se cambiara el aceite?");
        opcionString2 = lectura.next();

        if (opcionString2.equals("si")) {
            opcionString2 = gestionarCAF();
        } else {
            opcionString2 = opcionString2 = "no";
        }


        System.out.println("Se lavara el vehiculo?");
        opcionString3 = lectura.next();

        if (opcionString3.equals("si")) {
            opcionString3 = gestionarLavado();
        } else {
            opcionString3 = "no";
        }




        Servicio servicio = new Servicio(opcionString1, opcionString2, opcionString3);

        if(existe(servicioRepository,servicio)){
            System.out.println("Servicio existente seleccionado.");
            servicio = encontrar(servicioRepository,servicio);
        }else{
            servicioRepository.save(servicio);
            System.out.println("Servicio nuevo ingresado.");
        }



        return servicio;
    }

    public static String gestionarAYB(){

        Scanner lectura = new Scanner(System.in);
        String opcionString1;
        System.out.println("La alineación y balance incluye cambio de cubiertas?");
        opcionString1 = lectura.next();;

        if(opcionString1.equals("si")){
            opcionString1 = "Con cambio de cubiertas.";
        }else{
            opcionString1 = "Sin cambio de cubiertas.";
        }

        return opcionString1;
    }
    public static String gestionarCAF(){

        Scanner lectura = new Scanner(System.in);
        String opcionString2;

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

    public static String gestionarLavado(){

        String opcionString = null;
        Scanner lectura = new Scanner(System.in);
        int opcionLavado;

        System.out.println("que tipo de lavado sera?:");
        System.out.println("1.Lavado basico.");
        System.out.println("2.Lavado Completo");
        System.out.println("3.Lavado Premium");
        opcionLavado = lectura.nextInt();

        if(opcionLavado == 1){
            opcionString = "Lavado Basico";
        }if(opcionLavado == 2){
            opcionString = "Lavado Completo";
        }if(opcionLavado == 3){
            opcionString = "Lavado Premium";
        }

        return opcionString;
    }
    public static boolean existe(ServicioRepository servicioRepository, Servicio servicio1){

        Long cantidad = servicioRepository.findAll().stream().filter(servicio ->

                servicio.getAceiteyfiltro() == servicio1.getAceiteyfiltro() &&
                        servicio.getAlineacionybalanceo() == servicio1.getAlineacionybalanceo() &&
                        servicio.getLavado() == servicio1.getLavado()
        ).count();
        return  cantidad != 0;
    }

    public static Servicio encontrar(ServicioRepository servicioRepository, Servicio servicio1){

        return servicioRepository.findAll().stream().filter(servicio ->

                servicio.getAceiteyfiltro() == servicio1.getAceiteyfiltro() &&
                        servicio.getAlineacionybalanceo() == servicio1.getAlineacionybalanceo() &&
                        servicio.getLavado() == servicio1.getLavado()
        ).findFirst().orElse(null);
    }

    public static void getServices(ServicioRepository servicioRepository){

        List<Servicio> servicios = servicioRepository.findAll().stream().collect(Collectors.toList());
        for (Servicio servicio : servicios) {
            System.out.println(servicio);
        }
    }
}
