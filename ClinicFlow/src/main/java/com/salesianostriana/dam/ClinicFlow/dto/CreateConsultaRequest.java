package com.salesianostriana.dam.ClinicFlow.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record CreateConsultaRequest(
        @NotBlank(message = "{createConsultaRequest.observaciones.notblank}")
        String observaciones,
        @NotBlank
        String diagnostico,
        LocalDate fecha
) {
}
