package com.salesianostriana.dam.ClinicFlow.exceptions;

public class SameFechaHoraException extends RuntimeException {
    public SameFechaHoraException(String message) {
        super(message);
    }

    public SameFechaHoraException() {
        super("Error: same fechaHora");
    }
}
