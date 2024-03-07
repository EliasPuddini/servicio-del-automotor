package com.Certant.servicio.del.automotor.dto;

import com.Certant.servicio.del.automotor.models.Client;
import com.Certant.servicio.del.automotor.models.ClientType;

public class ClientDTO {

    private String nombre;
    private ClientType tipoCliente;
    private int serviciosPrevios;

    public ClientDTO(Client cliente){
        this.nombre = cliente.getNombre();
        this.tipoCliente = cliente.getTipoCliente();
        this.serviciosPrevios = cliente.getServicios();
    }


    public String getNombre() {
        return nombre;
    }

    public ClientType getTipoCliente() {
        return tipoCliente;
    }

    public int getServiciosPrevios() {
        return serviciosPrevios;
    }
}
