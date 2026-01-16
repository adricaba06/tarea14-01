package com.salesianostriana.dam.ClinicFlow.Services;

import com.salesianostriana.dam.ClinicFlow.Repository.CitaRepository;
import com.salesianostriana.dam.ClinicFlow.Repository.ConsultaRepository;
import com.salesianostriana.dam.ClinicFlow.dto.CreateConsultaRequest;
import com.salesianostriana.dam.ClinicFlow.model.Cita;
import com.salesianostriana.dam.ClinicFlow.model.Consulta;
import com.salesianostriana.dam.ClinicFlow.model.Estado;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConsultaService {

    private final ConsultaRepository consultaRepository;

    private final CitaRepository citaRepository;

    public Consulta mapToEntity(CreateConsultaRequest consultaRequest){
        return Consulta.builder()
                .fecha(consultaRequest.fecha())
                .diagnostico(consultaRequest.diagnostico())
                .observaciones(consultaRequest.observaciones())
                .build();

    }

    @Transactional
    public Consulta registrarConsulta(CreateConsultaRequest consultaRequest, Long cita_id){
        Cita cita = citaRepository.findById(cita_id)
                .orElseThrow(() -> new EntityNotFoundException("no se encontro"));

        if(cita.getEstado() == Estado.ATENDIDA){
           throw new RuntimeException("cita atendida");

        }
        Consulta consulta = mapToEntity(consultaRequest);
        cita.setConsulta(consulta);
        cita.setEstado(Estado.ATENDIDA);
        citaRepository.save(cita);

        return cita.getConsulta();

    }





}
