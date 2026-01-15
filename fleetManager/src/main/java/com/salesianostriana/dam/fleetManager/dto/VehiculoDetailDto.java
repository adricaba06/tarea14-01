package com.salesianostriana.dam.fleetManager.dto;

import com.salesianostriana.dam.fleetManager.model.Estado;

public record VehiculoDetailDto(
        Long id,
        String matricula,
        String modelo,
        int kmActuales,
        Estado estado

) {

}
