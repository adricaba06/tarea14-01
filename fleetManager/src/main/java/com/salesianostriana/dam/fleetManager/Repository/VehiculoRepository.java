package com.salesianostriana.dam.fleetManager.Repository;

import com.salesianostriana.dam.fleetManager.model.Estado;
import com.salesianostriana.dam.fleetManager.model.Mantenimiento;
import com.salesianostriana.dam.fleetManager.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {


    List<Vehiculo> findByEstado(Estado estado);

}
