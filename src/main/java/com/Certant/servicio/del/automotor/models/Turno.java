package com.Certant.servicio.del.automotor.models;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.regex.Pattern;

@Entity
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name = "native",strategy = "native")
    public long id;
    private double precio;//ingresado por el cliente
    @OneToOne
    private Client cliente;
    @OneToOne
    private Servicio servicio;
    private LocalDateTime fecha;
    private String patente;

    //constructor
    public Turno(){}
    public Turno(Client nCliente,Servicio nServicio,LocalDateTime nfecha, String npatente,double precio){
        this.cliente = nCliente;
        this.servicio = nServicio;
        this.fecha = nfecha;
        if(validarPatente(npatente)){
            this.patente = npatente;
        }else this.patente = null;
        this.precio = precio;
    }

    //geters y seters

    public long getId() {
        return id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

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

    private boolean validarPatente(String patente) {
        String pattern = "^[A-Z]{3}\\d{3}$|^[A-Z]{2}\\d{3}[A-Z]{2}$";
        return Pattern.matches(pattern, patente);
    }

    @Override
    public String toString() {
        return "Turno{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", servicio=" + servicio +
                ", fecha=" + fecha +
                ", patente='" + patente + '\'' +
                '}';
    }
}
