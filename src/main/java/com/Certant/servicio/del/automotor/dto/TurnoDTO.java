package com.Certant.servicio.del.automotor.dto;

import com.Certant.servicio.del.automotor.models.Client;
import com.Certant.servicio.del.automotor.models.Servicio;
import com.Certant.servicio.del.automotor.models.Turno;

import java.time.LocalDateTime;

public class TurnoDTO {
    private Long id;
    private Client cliente;
    private Servicio servicio;
    private LocalDateTime fecha;
    private String patente;
    private double precio;

    public TurnoDTO(Turno turno){
        this.id = turno.getId();
        this.cliente = turno.getCliente();
        this.servicio = turno.getServicio();
        this.fecha = turno.getFecha();
        this.patente = turno.getPatente();
        this.precio = turno.getPrecio();
    }

    public Long getId(){
        return id;
    }

    public ClientDTO getCliente() {
        return new ClientDTO(cliente);
    }

    public ServicioDTO getServicio() {
        return new ServicioDTO(servicio);
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public String getPatente() {
        return patente;
    }

    public double getPrecio() {
        return precio;
    }
}
