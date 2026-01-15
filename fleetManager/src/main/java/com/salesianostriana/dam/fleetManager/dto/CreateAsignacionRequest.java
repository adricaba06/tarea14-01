package com.salesianostriana.dam.fleetManager.dto;

import java.time.LocalDate;

public record CreateAsignacionRequest(
        LocalDate fechaInicio,
        LocalDate fechaFin
) {

}
