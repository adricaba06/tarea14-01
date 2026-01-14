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
public class Mantenimiento {

    @Id
    @GeneratedValue
    private Long id;

    private String tipo;
    private LocalDate fecha;
    private double kmEnRevision;

    @ManyToOne
    @JoinColumn(name = "vehiculo_id")
    private Vehiculo vehiculo;

    @ManyToOne
    @JoinColumn(name = "taller_id")
    private Taller taller;

}
