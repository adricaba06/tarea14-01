package com.salesianostriana.dam.fleetManager.exceptions;

public class ConductorNotFoundException extends RuntimeException {
    public ConductorNotFoundException(String message) {
        super(message);
    }

    public ConductorNotFoundException(Long id) {
        super("Conductor con id: " + id + "no encontrado");
    }
}
