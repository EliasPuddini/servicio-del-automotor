package com.Certant.servicio.del.automotor.models;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Entity
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    @OneToOne
    private Client cliente;
    @OneToOne
    private Servicio servicio;
    private LocalDateTime fecha;
    private String patente;

    //constructor
    public Turno(){}
    public Turno(Client nCliente,Servicio nServicio,LocalDateTime nfecha, String npatente){
        this.cliente = nCliente;
        this.servicio = nServicio;
        this.fecha = nfecha;
        this.patente = npatente;
    }

    //geters y seters
    public Client getCliente() {
        return cliente;
    }

    public void setCliente(Client cliente) {
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
        return patente;
    }

    public void setPatente(String patente) {
        patente = patente;
    }
}
