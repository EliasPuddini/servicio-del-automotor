package com.Certant.servicio.del.automotor.dto;

import com.Certant.servicio.del.automotor.models.ABTYPE;
import com.Certant.servicio.del.automotor.models.CAFTYPE;
import com.Certant.servicio.del.automotor.models.LavadoType;
import com.Certant.servicio.del.automotor.models.Servicio;
public class ServicioDTO {
    private ABTYPE alineacionybalanceo;
    private CAFTYPE aceiteyfiltro;
    private LavadoType lavado;


    public ServicioDTO(Servicio servicio){
        this.alineacionybalanceo = servicio.getAlineacionybalanceo();
        this.aceiteyfiltro = servicio.getAceiteyfiltro();
        this.lavado = servicio.getLavado();
    }

    public ABTYPE getAlineacionybalanceo() {
        return alineacionybalanceo;
    }

    public CAFTYPE getAceiteyfiltro() {
        return aceiteyfiltro;
    }

    public LavadoType getLavado() {
        return lavado;
    }
}
