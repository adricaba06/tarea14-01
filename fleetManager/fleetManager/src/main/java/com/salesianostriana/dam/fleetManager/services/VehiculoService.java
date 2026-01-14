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
public class VehiculoService {

    private final VehiculoRepository vehiculoRepository;
    private final AsignacionRepository asignacionRepository;



    public Vehiculo getVehicleById(Long vehiculo_id){
        return vehiculoRepository.findById(vehiculo_id)
                .orElseThrow(()-> new VehiculoNotFoundException(vehiculo_id));
    }




    public void registrarMantenimiento(){

    }

    public void cerrarAsignacion(){

    }
}
