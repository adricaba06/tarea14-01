package com.salesianostriana.dam.ClinicFlow.exceptions;

public class DateIsOnThePastException extends RuntimeException {
    public DateIsOnThePastException(String message) {
        super(message);
    }

    public DateIsOnThePastException() {
        super("Date is on the past");
    }
}
