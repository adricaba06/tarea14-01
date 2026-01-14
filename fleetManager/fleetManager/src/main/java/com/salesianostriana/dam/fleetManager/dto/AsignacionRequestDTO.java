package com.salesianostriana.dam.fleetManager.dto;

import java.time.LocalDate;

public record AsignacionRequestDTO(
        LocalDate fechaInicio,
        LocalDate fechaFin
) {
}
