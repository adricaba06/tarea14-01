package com.salesianostriana.dam.ClinicFlow.Repository;

import com.salesianostriana.dam.ClinicFlow.model.Cita;
import com.salesianostriana.dam.ClinicFlow.model.Estado;
import com.salesianostriana.dam.ClinicFlow.model.Profesional;
import jakarta.annotation.Nullable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {


    boolean existsByFechaHoraAndPaciente_Id(LocalDateTime fechaHora, Long id);

    @Nullable
    @EntityGraph(attributePaths = {"paciente", "profesional"})
    Page<Cita> findAll(Pageable pageable);

    List<Cita> findByPaciente_Id(Long id);

    List<Cita> findByEstado(Estado estado);

    List<Cita> findByFechaHoraBetween(LocalDateTime start, LocalDateTime end);

    @Query("select c from Cita c join fetch c.paciente where c.profesional = ?1 and c.fechaHora > ?2 order by c.fechaHora")
    List<Cita> findByProfesionalAndFechaHoraAfterOrderByFechaHoraAsc(Profesional profesional, LocalDateTime fechaHora);


}
