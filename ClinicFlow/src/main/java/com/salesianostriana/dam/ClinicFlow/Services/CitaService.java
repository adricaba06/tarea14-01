package com.salesianostriana.dam.ClinicFlow.Services;

import com.salesianostriana.dam.ClinicFlow.Repository.CitaRepository;
import com.salesianostriana.dam.ClinicFlow.Repository.PacienteRepository;
import com.salesianostriana.dam.ClinicFlow.Repository.ProfesionalRepository;
import com.salesianostriana.dam.ClinicFlow.dto.CreateCitaRequest;
import com.salesianostriana.dam.ClinicFlow.exceptions.*;
import com.salesianostriana.dam.ClinicFlow.model.Cita;
import com.salesianostriana.dam.ClinicFlow.model.Estado;
import com.salesianostriana.dam.ClinicFlow.model.Paciente;
import com.salesianostriana.dam.ClinicFlow.model.Profesional;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class CitaService {

    private final CitaRepository citaRepository;

    private final PacienteRepository pacienteRepository;
    private final ProfesionalRepository profesionalRepository;

    public Cita mapToEntity(CreateCitaRequest citaRequest) {
        return Cita.builder()
                .fechaHora(citaRequest.fechaHora())
                .estado(citaRequest.estado())
                .build();
    }

    @Transactional
    public Cita createCita(CreateCitaRequest citaRequest, Long paciente_id, Long profesional_id) {
        //variables

        //buscar
        Paciente pa = pacienteRepository
                .findById(paciente_id)
                .orElseThrow(() -> new PacienteNotFoundException());


        Profesional pro = profesionalRepository
                .findById(profesional_id)
                .orElseThrow(() -> new ProfesionalNotFound());

        //condiciones

        boolean dateOnThePast = citaRequest.fechaHora().isBefore(LocalDateTime.now());
        boolean paAlreadyHasCita = pa.getCitaList()
                .stream().anyMatch(c -> c.getFechaHora().
                        toLocalDate().equals(citaRequest.fechaHora().toLocalDate()));

        //Un profesional no puede tener dos citas a la misma fecha y hora.
        if (citaRepository.existsByFechaHoraAndPaciente_Id(citaRequest.fechaHora(), profesional_id))
            throw new SameFechaHoraException();

        //
        if ((paAlreadyHasCita))
            throw new PacienteAlreadyHasACitaThatDayException();

        if (dateOnThePast)
            throw new DateIsOnThePastException();

        Cita c = mapToEntity(citaRequest);

        pa.addCita(c);
        pro.addCita(c);

       return citaRepository.save(c);

    }

    @Transactional
    public void deleteCita(Long cita_id) {
        //1. buscamos

        Cita cita = citaRepository.findById(cita_id)
                .orElseThrow(() -> new EntityNotFoundException("cita con id %d not found"
                        .formatted(cita_id)));

        if (cita.getEstado() == Estado.ATENDIDA || cita.getEstado() == Estado.CANCELADA) {
            throw new IllegalStateException("No se puede cancelar una cita atendida o cancelada");
        }

        Paciente pa = cita.getPaciente();
        Profesional pro = cita.getProfesional();

        pa.removeCita(cita);
        pro.removeCita(cita);
        citaRepository.delete(cita);

    }

    public Page<Cita> findAll(int numPag, int numElementos){
        Pageable pageable = PageRequest.of(numPag, numElementos);
        return this.citaRepository.findAll(pageable);
    }


}
