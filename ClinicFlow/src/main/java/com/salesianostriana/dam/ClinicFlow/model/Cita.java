package com.salesianostriana.dam.ClinicFlow.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Cita{

    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime fechaHora;
    @Enumerated(EnumType.STRING)
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "profesional_id")
    private Profesional profesional;

    @OneToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "consulta_id")
    private Consulta consulta;



}
