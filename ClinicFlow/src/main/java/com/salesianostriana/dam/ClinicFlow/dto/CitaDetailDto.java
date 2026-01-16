package com.salesianostriana.dam.ClinicFlow.dto;

import com.salesianostriana.dam.ClinicFlow.model.Estado;

import java.time.LocalDateTime;

public record CitaDetailDto(
        Long id,
        LocalDateTime fechaHora,
        Estado estado,
        PacienteSimpleDto pacienteDto,
        ProfesionalSimpleDto profesionalDto
) {
}
