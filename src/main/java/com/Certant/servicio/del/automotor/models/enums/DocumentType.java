package com.Certant.servicio.del.automotor.models.enums;

public enum DocumentType {
    DNI,
    CUIT,
    CUIL;

    public static DocumentType fromString(String documentTypeString) {
        try {
            return DocumentType.valueOf(documentTypeString);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
