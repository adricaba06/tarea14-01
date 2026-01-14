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

    @OneToMany(mappedBy = "vehiculo")
    private List<Asignacion> asignacionList = new ArrayList<>();

    @OneToMany(mappedBy = "vehiculo")
    private List<Mantenimiento> mantenimientos = new ArrayList<>();


    public void addAsignacion(Asignacion a){
        this.asignacionList.add(a);
        a.setVehiculo(this);
    }

    public void removeAsignacion(Asignacion a){
        this.asignacionList.remove(a);
        a.setVehiculo(null);
    }

    // - - - - -

    public void addMantenimiento(Mantenimiento m){
        this.mantenimientos.add(m);
        m.setVehiculo(this);
    }

    public void removeMantenimiento(Mantenimiento m){
        this.mantenimientos.remove(m);
        m.setVehiculo(null);
    }



}
