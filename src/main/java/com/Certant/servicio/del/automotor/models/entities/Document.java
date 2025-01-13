package com.Certant.servicio.del.automotor.models.entities;

import com.Certant.servicio.del.automotor.models.enums.DocumentType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;

@Data
@Entity
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "documentType")
    private DocumentType documentType;
    private String value;

}
