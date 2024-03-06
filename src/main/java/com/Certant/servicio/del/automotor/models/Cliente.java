package com.Certant.servicio.del.automotor.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cliente {
    @Id
    public long id;

    private String nombre;
    private ClientType tipoCliente;
    private int serviciosPrevios;


    //constructor
    public Cliente(String nPatente, String nNombre, ClientType tipo, int serviciosPrevios){
        this.nombre = nNombre;
        this.tipoCliente = tipo;
        this.serviciosPrevios = serviciosPrevios;
    }

    //Geters and Seters
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
}
