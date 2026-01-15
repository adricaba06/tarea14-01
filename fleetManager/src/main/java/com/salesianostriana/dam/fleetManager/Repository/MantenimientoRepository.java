package com.salesianostriana.dam.fleetManager.Repository;

import com.salesianostriana.dam.fleetManager.model.Mantenimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MantenimientoRepository extends JpaRepository<Mantenimiento, Long> {
}
