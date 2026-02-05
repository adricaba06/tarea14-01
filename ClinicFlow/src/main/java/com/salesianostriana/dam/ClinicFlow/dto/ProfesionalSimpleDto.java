package com.salesianostriana.dam.ClinicFlow.dto;

import jakarta.validation.constraints.NotBlank;

public record ProfesionalSimpleDto(
        Long id,

        @NotBlank
        String nombre
) {
}
