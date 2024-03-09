package com.Certant.servicio.del.automotor.models;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Clientes")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name = "native",strategy = "native")
    private Long id;
    @Column(name = "DNI",unique = true)
    private double dni;
    private String nombre;
    private String tipoCliente;
    private int serviciosPrevios;


    //constructors
    public Client(){}
    public Client(String nNombre, int serviciosPrevios, double dni){
        this.nombre = nNombre;
        this.dni = dni;
        this.serviciosPrevios = serviciosPrevios;

        if(serviciosPrevios>5){
            this.tipoCliente = "Premium";
        }else{
            this.tipoCliente = "Normal";
        }
    }

    //Geters and Seters

    public Long getId() {
        return id;
    }

    public double getDni() {
        return dni;
    }

    public void setDni(double dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }


    public int getServicios() {
        return serviciosPrevios;
    }

    public void setServicios(int servicios) {
        this.serviciosPrevios = servicios;
    }

    public void updateServicecounter(){
        this.serviciosPrevios ++;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tipoCliente=" + tipoCliente +
                ", serviciosPrevios=" + serviciosPrevios +
                '}';
    }
}

