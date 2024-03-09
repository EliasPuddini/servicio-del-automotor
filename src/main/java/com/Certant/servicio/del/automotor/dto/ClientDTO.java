package com.Certant.servicio.del.automotor.dto;

import com.Certant.servicio.del.automotor.models.Client;

public class ClientDTO {

    private Long id;
    private double dni;
    private String nombre;
    private String tipoCliente;
    private int serviciosPrevios;

    public ClientDTO(Client cliente){
        this.id = cliente.getId();
        this.dni = cliente.getDni();
        this.nombre = cliente.getNombre();
        this.tipoCliente = cliente.getTipoCliente();
        this.serviciosPrevios = cliente.getServicios();
    }


    public String getNombre() {
        return nombre;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public int getServiciosPrevios() {
        return serviciosPrevios;
    }

    public Long getId() {
        return id;
    }

    public double getDni() {
        return dni;
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
