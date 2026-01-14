package com.salesianostriana.dam.fleetManager.dto;

import java.time.LocalDate;

public record MantenimientoRequestDTO(
        String tipo,
        LocalDate fecha,
        double kmEnRevision
) {


}
