package com.salesianostriana.dam.ClinicFlow.Repository;

import com.salesianostriana.dam.ClinicFlow.model.Profesional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ProfesionalRepository extends JpaRepository<Profesional, Long> {

}
