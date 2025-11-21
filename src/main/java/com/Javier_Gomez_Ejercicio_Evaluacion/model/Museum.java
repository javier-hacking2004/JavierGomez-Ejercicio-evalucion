package com.Javier_Gomez_Ejercicio_Evaluacion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Museum {
    @Id
    @GeneratedValue
    private Long id;
    
    private String nombreMuseo;
    private String ciudad;
    private String descripcion;
    private int anioAperturta;
    private int nSalas;
    private String url;
}
