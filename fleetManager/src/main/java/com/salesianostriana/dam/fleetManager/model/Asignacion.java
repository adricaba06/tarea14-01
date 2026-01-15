package com.salesianostriana.dam.fleetManager.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Asignacion {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDate fechaInicio;
    private LocalDate fechaFin;


    @ManyToOne
    @JoinColumn(name = "vehiculo_id")
    private Vehiculo vehiculo;

    @ManyToOne
    @JoinColumn(name = "conductor_id")
    private Conductor conductor;

}