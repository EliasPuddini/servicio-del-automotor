package com.Certant.servicio.del.automotor.models.dto;

import com.Certant.servicio.del.automotor.models.entities.Document;
import com.Certant.servicio.del.automotor.models.enums.DocumentType;

public class DocumentDTO {
    private DocumentType documentType;
    private String value;

    public DocumentDTO(Document document){
        this.value = document.getValue();
        this.documentType = document.getDocumentType();
    }
}
