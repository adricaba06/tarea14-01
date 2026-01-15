package com.salesianostriana.dam.fleetManager.exceptions;

public class VehiculoAlreadyAsignadoException extends RuntimeException {
    public VehiculoAlreadyAsignadoException(String message) {
        super(message);
    }

    public VehiculoAlreadyAsignadoException(Long id) {
        super("Vehiculo con id: " + id + "ya tiene una asignación");
    }

    public VehiculoAlreadyAsignadoException() {
        super("Vehiculo ya tiene una asignación");
    }
}
