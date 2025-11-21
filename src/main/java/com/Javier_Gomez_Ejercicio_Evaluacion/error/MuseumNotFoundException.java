package com.Javier_Gomez_Ejercicio_Evaluacion.error;

public class MuseumNotFoundException extends RuntimeException {
    public MuseumNotFoundException(String message) {
        super(message);
    }

    public MuseumNotFoundException(){
        super("No se encontraron museos en la base de datos");
    }

    public MuseumNotFoundException(Long id){
        super("El museo con identificador %d no existe".formatted(id));
    }
}
