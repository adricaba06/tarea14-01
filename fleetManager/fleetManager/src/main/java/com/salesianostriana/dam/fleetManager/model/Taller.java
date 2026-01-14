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
public class Taller {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String ciudad;

    @OneToMany(mappedBy = "taller")
    private List<Mantenimiento> mantenimientoList = new ArrayList<>();

    //helper

    public void addMantenimiento(Mantenimiento m){
        this.mantenimientoList.add(m);
        m.setTaller(this);
    }

    public void removeTaller(Mantenimiento m){
        this.mantenimientoList.add(m);
        m.setTaller(null);
    }
}
