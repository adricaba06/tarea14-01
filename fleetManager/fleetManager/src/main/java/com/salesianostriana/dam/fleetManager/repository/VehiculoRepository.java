package com.salesianostriana.dam.fleetManager.repository;

import com.salesianostriana.dam.fleetManager.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
}
