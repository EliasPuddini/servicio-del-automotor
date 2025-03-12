package com.Certant.servicio.del.automotor.models.dto;

import com.Certant.servicio.del.automotor.models.entities.ClientType;
import lombok.Getter;

@Getter
public class ClientTypeDTO {
    private Long id;
    private String name;

    public ClientTypeDTO(ClientType clientType){
        this.id = clientType.getId();
        this.name = clientType.getName();
    }
}
