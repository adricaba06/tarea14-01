package com.salesianostriana.dam.ClinicFlow.exceptions;

public class ProfesionalNotFound extends RuntimeException {
    public ProfesionalNotFound(String message) {
        super(message);
    }

    public ProfesionalNotFound() {
        super("professional not found");
    }
}
