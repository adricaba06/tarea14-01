package com.salesianostriana.dam.fleetManager.exceptions;

public class MatriculaAlreadyExists extends RuntimeException {
    public MatriculaAlreadyExists(String message) {
        super(message);
    }

    public MatriculaAlreadyExists() {
        super("La matricula ya existe");
    }
}
