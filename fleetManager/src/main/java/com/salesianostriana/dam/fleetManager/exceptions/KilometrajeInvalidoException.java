package com.salesianostriana.dam.fleetManager.exceptions;

public class KilometrajeInvalidoException extends RuntimeException {
    public KilometrajeInvalidoException(String message) {
        super(message);
    }

    public KilometrajeInvalidoException() {
        super("Kilometraje invalido");
    }
}
