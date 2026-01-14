package com.salesianostriana.dam.fleetManager.repository;

import com.salesianostriana.dam.fleetManager.model.Asignacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsignacionRepository extends JpaRepository<Asignacion, Long> {
}
