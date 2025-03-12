package com.Certant.servicio.del.automotor.models.dto;

import com.Certant.servicio.del.automotor.models.entities.Document;
import com.Certant.servicio.del.automotor.models.entities.DocumentType;
import lombok.Getter;

@Getter
public class DocumentDTO {
    private Long id;
    private DocumentType documentType;
    private String value;

    public DocumentDTO(Document document){
        this.id = document.getId();
        this.value = document.getValue();
        this.documentType = document.getDocumentType();
    }
}
