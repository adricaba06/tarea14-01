package com.salesianostriana.dam.fleetManager.services;

import com.salesianostriana.dam.fleetManager.dto.MantenimientoRequestDTO;
import com.salesianostriana.dam.fleetManager.exceptions.ThisVehiculoAlreadyHasAnAsignaccion;
import com.salesianostriana.dam.fleetManager.model.Estado;
import com.salesianostriana.dam.fleetManager.model.Mantenimiento;
import com.salesianostriana.dam.fleetManager.model.Vehiculo;
import com.salesianostriana.dam.fleetManager.repository.MantenimientoRepository;
import com.salesianostriana.dam.fleetManager.repository.VehiculoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MantenimietoService {

    private final MantenimientoRepository mantenimientoRepository;
    private final VehiculoRepository vehiculoRepository;

    public void mapToEntity(MantenimientoRequestDTO requestDTO){
        return Mantenimiento.builder()
                .tipo(requestDTO.tipo())
                .fecha(requestDTO.fecha())
                .kmEnRevision(requestDTO.kmEnRevision())
                .build()
    }

    public void registrarMantenimiento(MantenimientoRequestDTO requestDTO, Vehiculo vehiculo){
        if(vehiculo.getEstado().equals(Estado.ASIGNADO)){
            throw new ThisVehiculoAlreadyHasAnAsignaccion();
        }



    }


}
