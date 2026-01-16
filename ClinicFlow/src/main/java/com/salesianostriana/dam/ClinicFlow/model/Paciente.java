package com.salesianostriana.dam.ClinicFlow.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Paciente {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre, email;
    private LocalDate fechaNacimiento;

    @OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY)
    private List<Cita> citaList = new ArrayList<>();


    //helpers

    public void addCita(Cita cita){
        this.citaList.add(cita);
        cita.setPaciente(this);
    }

    public void removeCita(Cita cita){
        this.citaList.remove(cita);
        cita.setPaciente(null);
    }

}
