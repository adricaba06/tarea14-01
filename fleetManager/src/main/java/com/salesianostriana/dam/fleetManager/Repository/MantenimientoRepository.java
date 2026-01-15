package com.salesianostriana.dam.fleetManager.Repository;

import com.salesianostriana.dam.fleetManager.model.Mantenimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MantenimientoRepository extends JpaRepository<Mantenimiento, Long> {


    List<Mantenimiento> findByVehiculo_Id(Long id);

    @Query("select m from Mantenimiento m where m.vehiculo.id = ?1 and m.fecha = ?2")
    Mantenimiento findByVehiculo_IdAndFecha(Long id, @NonNull LocalDate fecha);

}
