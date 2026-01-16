package com.salesianostriana.dam.ClinicFlow.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Profesional {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre, especialidad;

    @OneToMany(mappedBy = "profesional", fetch = FetchType.LAZY)
    private List<Cita> citaList = new ArrayList<>();


    //helpers

    public void addCita(Cita cita){
        this.citaList.add(cita);
        cita.setProfesional(this);
    }

    public void removeCita(Cita cita){
        this.citaList.remove(cita);
        cita.setProfesional(null);
    }
}
