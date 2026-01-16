package com.salesianostriana.dam.ClinicFlow.dto;

import com.salesianostriana.dam.ClinicFlow.model.Cita;
import com.salesianostriana.dam.ClinicFlow.model.Paciente;

import java.time.LocalDateTime;

public record CitaListDto(
        Long id,
        LocalDateTime fechaHora,
        PacienteSimpleDto pacienteDto
        ) {

    public static CitaListDto of(Cita cita){
        return new CitaListDto(
                cita.getId(),
                cita.getFechaHora(),
                new PacienteSimpleDto( cita.getId(), cita.getPaciente().getNombre(), cita.getPaciente().getEmail())
        );
    }
}
