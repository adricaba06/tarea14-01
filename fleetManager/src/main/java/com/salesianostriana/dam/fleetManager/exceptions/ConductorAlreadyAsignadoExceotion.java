package com.salesianostriana.dam.fleetManager.exceptions;

public class ConductorAlreadyAsignadoExceotion extends RuntimeException {
    public ConductorAlreadyAsignadoExceotion(String message) {
        super(message);
    }

    public ConductorAlreadyAsignadoExceotion(Long id) {
        super("Conductor con id :" + id + "ya asignado");
    }

}
