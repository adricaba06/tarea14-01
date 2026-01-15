package com.salesianostriana.dam.fleetManager.dto;

import java.time.LocalDate;

public record CreateMantenimientoRequest(
        String tipo,
        LocalDate fecha,
        double kmEnRevision

) {
}
