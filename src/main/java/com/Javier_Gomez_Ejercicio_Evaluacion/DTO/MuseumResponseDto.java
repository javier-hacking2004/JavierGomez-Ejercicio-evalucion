package com.Javier_Gomez_Ejercicio_Evaluacion.DTO;

import com.Javier_Gomez_Ejercicio_Evaluacion.model.Museum;

public record MuseumResponseDto(
        Long id,
        String nombreMuseo,
        String ciudad,
        int anioAperturta,
        int nSalas,
        String descripcion,
        String url
) {
    public static MuseumResponseDto of(Museum m){
        return new MuseumResponseDto(
                m.getId(),
                m.getNombreMuseo(),
                m.getCiudad(),
                m.getAnioAperturta(),
                m.getNSalas(),
                m.getDescripcion(),
                m.getUrl()
        );
    }
}
