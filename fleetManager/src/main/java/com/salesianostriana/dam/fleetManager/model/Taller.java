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
public class Taller {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "taller", fetch = FetchType.LAZY)
    private List<Mantenimiento> mantenimientos = new ArrayList<>();


    //helpers

    public void addMantenimiento(Mantenimiento m){
        this.mantenimientos.add(m);
        m.setTaller(this);

    }

    public void removeMantenimiento(Mantenimiento m){
        this.mantenimientos.remove(m);
        m.setTaller(null);
    }
}