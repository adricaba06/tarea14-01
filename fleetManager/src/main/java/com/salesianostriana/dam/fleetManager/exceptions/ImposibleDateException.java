package com.salesianostriana.dam.fleetManager.exceptions;

public class ImposibleDateException extends RuntimeException {
    public ImposibleDateException(String message) {
        super(message);
    }

    public ImposibleDateException() {
        super("Date doesn't make sense");
    }
}
