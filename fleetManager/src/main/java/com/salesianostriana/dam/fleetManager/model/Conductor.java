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
public class Conductor {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private String email;

    @OneToMany(mappedBy = "conductor", fetch = FetchType.LAZY)
    private List<Asignacion> asignaciones = new ArrayList<>();

    //helper

    public void addAsignacion(Asignacion a){
        this.asignaciones.add(a);
        a.setConductor(this);
    }

    public void removeAsignacion(Asignacion a){
        this.asignaciones.remove(a);
        a.setConductor(null);
    }

}
