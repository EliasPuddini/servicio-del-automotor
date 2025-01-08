package com.Certant.servicio.del.automotor.models.entities;

import com.Certant.servicio.del.automotor.models.enums.DocumentType;
import jakarta.persistence.*;
import lombok.Setter;

@Setter
@Entity
public class Document {
    @Id
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "documentType")
    private DocumentType documentType;
    private String value;

}
