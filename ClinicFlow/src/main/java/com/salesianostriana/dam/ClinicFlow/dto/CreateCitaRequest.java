package com.salesianostriana.dam.ClinicFlow.dto;

import com.salesianostriana.dam.ClinicFlow.model.Estado;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDateTime;

public record CreateCitaRequest(
    LocalDateTime fechaHora,
    Estado estado
) {
}
