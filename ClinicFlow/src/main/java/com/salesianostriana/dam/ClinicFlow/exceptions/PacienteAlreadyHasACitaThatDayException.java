package com.salesianostriana.dam.ClinicFlow.exceptions;

public class PacienteAlreadyHasACitaThatDayException extends RuntimeException {
    public PacienteAlreadyHasACitaThatDayException(String message) {
        super(message);
    }

    public PacienteAlreadyHasACitaThatDayException() {
        super("Already has a cita");
    }
}
