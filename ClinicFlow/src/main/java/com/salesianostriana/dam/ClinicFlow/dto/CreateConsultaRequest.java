package com.salesianostriana.dam.ClinicFlow.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record CreateConsultaRequest(
        String observaciones,
        String diagnostico,
        LocalDate fecha
) {
}
