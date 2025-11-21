package com.Javier_Gomez_Ejercicio_Evaluacion.DTO;

import com.Javier_Gomez_Ejercicio_Evaluacion.model.Museum;

public record MuseumRequestDto(
        String nombreMuseo,
        String ciudad,
        int anioAperturta,
        int nSalas,
        String descripcion,
        String url
) {
    public Museum toEntity(){
        return Museum.builder()
                .nombreMuseo(this.nombreMuseo)
                .ciudad(this.ciudad)
                .anioAperturta(this.anioAperturta)
                .nSalas(this.nSalas)
                .descripcion(this.descripcion)
                .url(this.url)
                .build();
    }
}
