package com.salesianostriana.dam.fleetManager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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

    @OneToMany(mappedBy = "conductor")
    private List<Asignacion> asignacionList = new ArrayList<>();


    //helpers

    public void addAsignacion(Asignacion a){
        this.asignacionList.add(a);
        a.setConductor(this);
    }

    public void deleteAsigancion(Asignacion a){
        this.asignacionList.remove(a);
        a.setConductor(null);
    }
}
