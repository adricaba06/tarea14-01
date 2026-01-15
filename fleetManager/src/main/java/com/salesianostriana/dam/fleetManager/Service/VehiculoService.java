package com.salesianostriana.dam.fleetManager.Service;

import com.salesianostriana.dam.fleetManager.Repository.VehiculoRepository;
import com.salesianostriana.dam.fleetManager.exceptions.MatriculaAlreadyExists;
import com.salesianostriana.dam.fleetManager.model.Estado;
import com.salesianostriana.dam.fleetManager.model.Vehiculo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VehiculoService {

    private final VehiculoRepository vehiculoRepository;

    private void comprobarMatricula(String matricula) {
        if(this.vehiculoRepository.findAll().stream().anyMatch(v-> v.getMatricula().equalsIgnoreCase(matricula)))
            throw new MatriculaAlreadyExists();
    }




}
