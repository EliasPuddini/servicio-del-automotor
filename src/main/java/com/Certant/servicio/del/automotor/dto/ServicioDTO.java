package com.Certant.servicio.del.automotor.dto;

import com.Certant.servicio.del.automotor.models.Servicio;
public class ServicioDTO{

    private Long id;
    private String alineacionybalanceo;
    private double precio;
    private String aceiteyfiltro;
    private String lavado;


    public ServicioDTO(Servicio servicio){
        this.id = servicio.getId();
        this.precio = servicio.getPrecio();
        this.alineacionybalanceo = servicio.getAlineacionybalanceo();
        this.aceiteyfiltro = servicio.getAceiteyfiltro();
        this.lavado = servicio.getLavado();
    }

    public Long getId() {
        return id;
    }

    public double getPrecio() {
        return precio;
    }

    public String getAlineacionybalanceo() {
        return alineacionybalanceo;
    }

    public String getAceiteyfiltro() {
        return aceiteyfiltro;
    }

    public String getLavado() {
        return lavado;
    }
}
