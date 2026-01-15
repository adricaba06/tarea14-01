package com.salesianostriana.dam.fleetManager.dto;

import com.salesianostriana.dam.fleetManager.model.Estado;

public record VehiculoSummaryDto(
        Long id,
        String matricula,
        String modelo,
        Estado estado
) {}
