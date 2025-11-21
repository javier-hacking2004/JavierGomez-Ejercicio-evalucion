package com.Javier_Gomez_Ejercicio_Evaluacion.error;

public class InvalidMuseumDataException extends RuntimeException {
    public InvalidMuseumDataException(String message) {
        super(message);
    }

    public InvalidMuseumDataException(){
        super("Los datos proporcionados no son válidos");
    }
}
