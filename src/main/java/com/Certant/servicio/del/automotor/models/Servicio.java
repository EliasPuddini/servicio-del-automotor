package com.Certant.servicio.del.automotor.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private ABTYPE alineacionybalanceo;
    private CAFTYPE aceiteyfiltro;
    private LavadoType lavado;


    //constructors
    public Servicio(){}
    public Servicio(ABTYPE ab,CAFTYPE caf,LavadoType lav){
        this.alineacionybalanceo = ab;
        this.aceiteyfiltro = caf;
        this.lavado = lav;
    }

    //geters and seters
    public ABTYPE getAlineacionybalanceo() {
        return alineacionybalanceo;
    }

    public void setAlineacionybalanceo(ABTYPE alineacionybalanceo) {
        this.alineacionybalanceo = alineacionybalanceo;
    }

    public CAFTYPE getAceiteyfiltro() {
        return aceiteyfiltro;
    }

    public void setAceiteyfiltro(CAFTYPE aceiteyfiltro) {
        this.aceiteyfiltro = aceiteyfiltro;
    }

    public LavadoType getLavado() {
        return lavado;
    }

    public void setLavado(LavadoType lavado) {
        this.lavado = lavado;
    }
}
