package com.Certant.servicio.del.automotor.dto;

import com.Certant.servicio.del.automotor.models.Client;
import com.Certant.servicio.del.automotor.models.Servicio;
import com.Certant.servicio.del.automotor.models.Turno;

import java.time.LocalDateTime;

public class TurnoDTO {
    private Client cliente;
    private Servicio servicio;
    private LocalDateTime fecha;
    private String Patente;

    public TurnoDTO(Turno turno){
        this.cliente = turno.getCliente();
        this.servicio = turno.getServicio();
        this.fecha = turno.getFecha();
    }

    public Client getCliente() {
        return cliente;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public String getPatente() {
        return Patente;
    }
}
