package com.salesianostriana.dam.fleetManager.Service;

import com.salesianostriana.dam.fleetManager.Repository.MantenimientoRepository;
import com.salesianostriana.dam.fleetManager.Repository.VehiculoRepository;
import com.salesianostriana.dam.fleetManager.dto.CreateMantenimientoRequest;
import com.salesianostriana.dam.fleetManager.exceptions.VehiculoAlreadyAsignadoException;
import com.salesianostriana.dam.fleetManager.exceptions.VehiculoNotFoundException;
import com.salesianostriana.dam.fleetManager.exceptions.KilometrajeInvalidoException;
import com.salesianostriana.dam.fleetManager.model.Estado;
import com.salesianostriana.dam.fleetManager.model.Mantenimiento;
import com.salesianostriana.dam.fleetManager.model.Vehiculo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MantenimientoService {

    private final MantenimientoRepository mantenimientoRepository;

    private final VehiculoRepository vehiculoRepository;

    public Mantenimiento mapToEntity(CreateMantenimientoRequest cmr){
        return Mantenimiento.builder()
                .tipo(cmr.tipo())
                .fecha(cmr.fecha())
                .kmEnRevision(cmr.kmEnRevision())
                .build();
    }

    public void registerMantenimiento(CreateMantenimientoRequest cmr, Long vehiculo_id){
        Vehiculo v = vehiculoRepository
                .findById(vehiculo_id)
                .orElseThrow(()-> new VehiculoNotFoundException(vehiculo_id));

        if(v.getEstado().equals(Estado.ASIGNADO))
            throw new VehiculoAlreadyAsignadoException(v.getId());

        if(cmr.kmEnRevision() < v.getKmActuales())
            throw new KilometrajeInvalidoException();

        v.setKmActuales(cmr.kmEnRevision());
        Mantenimiento m = mapToEntity(cmr);
        v.addMantenimiento(m);
        this.mantenimientoRepository.save(m);

    }




}
