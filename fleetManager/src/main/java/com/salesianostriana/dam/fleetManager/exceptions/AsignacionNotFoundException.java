package com.salesianostriana.dam.fleetManager.exceptions;

public class AsignacionNotFoundException extends RuntimeException {

    public AsignacionNotFoundException(String message) {
        super(message);
    }

    public AsignacionNotFoundException(Long id) {
        super("Asignacion no encontrada " + id);
    }
}
