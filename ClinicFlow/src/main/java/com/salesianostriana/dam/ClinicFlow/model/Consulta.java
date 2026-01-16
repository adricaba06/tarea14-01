package com.salesianostriana.dam.ClinicFlow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Consulta {

    @Id
    @GeneratedValue
    private Long id;

    private String observaciones, diagnostico;
    private LocalDate fecha;

    @OneToOne(mappedBy = "consulta")
    private Cita cita;


}
