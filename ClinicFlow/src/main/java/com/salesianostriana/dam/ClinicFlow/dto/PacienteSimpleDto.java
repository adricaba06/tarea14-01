package com.salesianostriana.dam.ClinicFlow.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jdk.jfr.Name;

public record PacienteSimpleDto(
        Long id,

        @NotBlank
        String nombre,

        @Email
        String email) {}
