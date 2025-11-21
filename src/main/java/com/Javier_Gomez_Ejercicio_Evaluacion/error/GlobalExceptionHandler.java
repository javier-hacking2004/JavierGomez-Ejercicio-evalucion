package com.Javier_Gomez_Ejercicio_Evaluacion.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.URI;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MuseumNotFoundException.class)
    public ProblemDetail handleMuseumNotFoundException(MuseumNotFoundException ex){
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());

        problem.setTitle("Recurso no encontrado");
        problem.setType(URI.create("https://api.museum.com/errors/not-found"));
        return problem;
    }

    @ExceptionHandler(InvalidMuseumDataException.class)
    public ProblemDetail handleMuseumInvalidDataException(InvalidMuseumDataException ex){
        ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());

        problem.setTitle("Datos inválidos");
        problem.setType(URI.create("https://api.museum.com/errors/invalid-data"));
        return problem;
    }
}
