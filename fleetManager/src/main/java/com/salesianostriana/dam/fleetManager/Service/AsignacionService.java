package com.salesianostriana.dam.fleetManager.Service;

import com.salesianostriana.dam.fleetManager.Repository.AsignacionRepository;
import com.salesianostriana.dam.fleetManager.Repository.ConductorRepository;
import com.salesianostriana.dam.fleetManager.Repository.VehiculoRepository;
import com.salesianostriana.dam.fleetManager.dto.CreateAsignacionRequest;
import com.salesianostriana.dam.fleetManager.exceptions.*;
import com.salesianostriana.dam.fleetManager.model.Asignacion;
import com.salesianostriana.dam.fleetManager.model.Conductor;
import com.salesianostriana.dam.fleetManager.model.Estado;
import com.salesianostriana.dam.fleetManager.model.Vehiculo;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class AsignacionService {

    private final AsignacionRepository asignacionRepository;

    private final VehiculoRepository vehiculoRepository;
    private final ConductorRepository conductorRepository;


    public Asignacion mapToEntity(CreateAsignacionRequest requestDTO){
        return Asignacion.builder()
                .fechaInicio(requestDTO.fechaInicio())
                .fechaFin(requestDTO.fechaFin())
                .build();
    }

    public void verifyAsigancionDate(CreateAsignacionRequest requestDTO){
        if(requestDTO.fechaInicio().isAfter(requestDTO.fechaFin()))
            throw new ImposibleDateException();

    }

    public void addAsignacionToVehiculo(CreateAsignacionRequest requestDTO, Long vehiculo_id, Long conductor_id){
        verifyAsigancionDate(requestDTO);
        Vehiculo v = vehiculoRepository
                .findById(vehiculo_id)
                .orElseThrow(()-> new VehiculoNotFoundException(vehiculo_id));

        Conductor c = conductorRepository.findById(conductor_id)
                .orElseThrow(()-> new ConductorNotFoundException(conductor_id));

        if(v.getEstado().equals(Estado.ASIGNADO)){
            throw new VehiculoAlreadyAsignadoException(vehiculo_id);
        }

        if(c.getAsignaciones().stream().anyMatch(a -> a.getFechaFin() == null)){ //preguntar a luismi
            throw new ConductorAlreadyAsignadoExceotion(conductor_id);
        }

        Asignacion a =  mapToEntity(requestDTO);
        c.addAsignacion(a);
        v.addAsigancion(a);
        asignacionRepository.save(a);

    } //yo lo entendi así. No se si es exactamente lo que pide? deberian de ser metodos separados?


    @Transactional //aqui se podria usar??
    public void cerrarAsignacion(Long asignacionId) {

        Asignacion a = asignacionRepository.findById(asignacionId)
                .orElseThrow(() -> new AsignacionNotFoundException(asignacionId));

        a.setFechaFin(LocalDate.now());

        Vehiculo v = a.getVehiculo();
        v.setEstado(Estado.DISPONIBLE);

        asignacionRepository.save(a);
        vehiculoRepository.save(v);
    }

}
