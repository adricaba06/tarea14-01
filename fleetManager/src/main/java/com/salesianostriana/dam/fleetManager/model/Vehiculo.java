package com.salesianostriana.dam.fleetManager.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Vehiculo {

    @Id
    @GeneratedValue
    private Long id;

    private String matricula;
    private String modelo;
    private double kmActuales;
    private Estado estado;

    @OneToMany(mappedBy = "vehiculo", fetch = FetchType.LAZY)
    private List<Asignacion> asignaciones = new ArrayList<>();

    @OneToMany(mappedBy = "vehiculo", fetch = FetchType.LAZY)
    private List<Mantenimiento> mantenimientos = new ArrayList<>();

    //helper asignacion

    public void addAsigancion(Asignacion a){
        this.asignaciones.add(a);
        a.setVehiculo(this);
    }

    public void removeAsignacion(Asignacion a){
        this.asignaciones.remove(a);
        a.setVehiculo(null);
    }

    //helper mantenimiento

    public void addMantenimiento(Mantenimiento m){
        this.mantenimientos.add(m);
        m.setVehiculo(this);
    }


}