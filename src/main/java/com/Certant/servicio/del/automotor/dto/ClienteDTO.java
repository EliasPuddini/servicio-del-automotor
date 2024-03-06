package com.Certant.servicio.del.automotor.dto;

import com.Certant.servicio.del.automotor.models.ClientType;
import com.Certant.servicio.del.automotor.models.Cliente;

public class ClienteDTO {

    private String nombre;
    private ClientType tipoCliente;
    private int serviciosPrevios;

    public ClienteDTO(Cliente cliente){
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
