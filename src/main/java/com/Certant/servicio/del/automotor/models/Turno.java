package com.Certant.servicio.del.automotor.models;

import jakarta.persistence.Entity;

import java.time.LocalDateTime;

@Entity
public class Turno {

    private Cliente cliente;
    private Servicio servicio;
    private LocalDateTime fecha;
    private String Patente;

    //constructor
    public Turno(Cliente nCliente,Servicio nServicio,LocalDateTime nfecha){
        this.cliente = nCliente;
        this.servicio = nServicio;
        this.fecha = nfecha;
    }

    //geters y seters
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getPatente() {
        return Patente;
    }

    public void setPatente(String patente) {
        Patente = patente;
    }
}
