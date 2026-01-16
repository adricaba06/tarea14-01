package com.salesianostriana.dam.ClinicFlow.exceptions;

public class CitaAtendidaException extends RuntimeException {
    public CitaAtendidaException(String message) {
        super(message);
    }

    public CitaAtendidaException() {
        super("cita atendida");
    }
}
