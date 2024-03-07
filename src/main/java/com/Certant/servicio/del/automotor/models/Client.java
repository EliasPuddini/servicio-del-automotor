package com.Certant.servicio.del.automotor.models;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Clientes")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private ClientType tipoCliente;
    private int serviciosPrevios;


    //constructors
    public Client(){}
    public Client(String nNombre, ClientType tipo, int serviciosPrevios){
        this.nombre = nNombre;
        this.tipoCliente = tipo;
        this.serviciosPrevios = serviciosPrevios;
    }

    //Geters and Seters

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ClientType getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(ClientType tipoCliente) {
        this.tipoCliente = tipoCliente;
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

