package com.Certant.servicio.del.automotor.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
    @GenericGenerator(name = "native",strategy = "native")
    private Long id;
    private double precio;//ingresado por el cliente
    private String alineacionybalanceo;//con o sin cambio de cubiertas
    private String aceiteyfiltro;//básico o de alto rendimiento, para motores diesel o nafteros
    private String lavado;//básico, completo o premium


    //constructors
    public Servicio(){}
    public Servicio(String ab,String caf,String lav, double precio){
        this.alineacionybalanceo = ab;
        this.aceiteyfiltro = caf;
        this.lavado = lav;
        this.precio = precio;
    }

    //geters and seters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getAlineacionybalanceo() {
        return alineacionybalanceo;
    }

    public void setAlineacionybalanceo(String alineacionybalanceo) {
        this.alineacionybalanceo = alineacionybalanceo;
    }

    public String getAceiteyfiltro() {
        return aceiteyfiltro;
    }

    public void setAceiteyfiltro(String aceiteyfiltro) {
        this.aceiteyfiltro = aceiteyfiltro;
    }

    public String getLavado() {
        return lavado;
    }

    public void setLavado(String lavado) {
        this.lavado = lavado;
    }
}
