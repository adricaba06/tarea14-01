package com.salesianostriana.dam.fleetManager.services;

import com.salesianostriana.dam.fleetManager.dto.AsignacionRequestDTO;
import com.salesianostriana.dam.fleetManager.exceptions.ThisVehiculoAlreadyHasAnAsignaccion;
import com.salesianostriana.dam.fleetManager.exceptions.VehiculoNotFoundException;
import com.salesianostriana.dam.fleetManager.model.Asignacion;
import com.salesianostriana.dam.fleetManager.model.Vehiculo;
import com.salesianostriana.dam.fleetManager.repository.AsignacionRepository;
import com.salesianostriana.dam.fleetManager.repository.VehiculoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AsignacionService {

    private final AsignacionRepository asignacionRepository;
    private final VehiculoRepository vehiculoRepository;


    public Asignacion maptoEntity(AsignacionRequestDTO requestDTO){
        return Asignacion.builder()
                .fechaInicio(requestDTO.fechaInicio())
                .fechaFin(requestDTO.fechaFin())
                .build();
    }

    public void asignarVehiculo(Long vehiculo_id, AsignacionRequestDTO asignacionRequestDTO){
        Vehiculo v = vehiculoRepository.findById(vehiculo_id).orElseThrow(()-> new VehiculoNotFoundException(vehiculo_id))
        if(v.getAsignacionList().contains(maptoEntity(asignacionRequestDTO)))
            throw new ThisVehiculoAlreadyHasAnAsignaccion(vehiculo_id);

        v.addAsignacion(maptoEntity(asignacionRequestDTO));


    }



}
