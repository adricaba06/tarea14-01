package com.salesianostriana.dam.ClinicFlow.exceptions;

public class PacienteNotFoundException extends RuntimeException {
    public PacienteNotFoundException(String message) {
        super(message);
    }

    public PacienteNotFoundException() {
        super();
    }

    //tendria quehaber uno con id
}
