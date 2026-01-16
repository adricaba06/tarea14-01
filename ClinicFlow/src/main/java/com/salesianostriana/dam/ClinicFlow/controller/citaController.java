package com.salesianostriana.dam.ClinicFlow.controller;

import com.salesianostriana.dam.ClinicFlow.Services.CitaService;
import com.salesianostriana.dam.ClinicFlow.dto.CitaDetailDto;
import com.salesianostriana.dam.ClinicFlow.dto.CitaListDto;
import com.salesianostriana.dam.ClinicFlow.model.Cita;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/citas")
@RequiredArgsConstructor
public class citaController {

    private final CitaService citaService;

    @GetMapping
    public Page<CitaListDto> listarCita(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int numOfElements){
        Page<Cita> citas = citaService.findAll(page, numOfElements);

        return citas.map(CitaListDto::of);

    }

   

}
