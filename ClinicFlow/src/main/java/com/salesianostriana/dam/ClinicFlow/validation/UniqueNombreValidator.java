package com.salesianostriana.dam.ClinicFlow.validation;

import com.salesianostriana.dam.ClinicFlow.Repository.PacienteRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

public class UniqueNombreValidator implements ConstraintValidator<UniqueNombre, String> {

    @Autowired
    private PacienteRepository repo;


    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.hasText(s) && !repo.existsByNombre(s);
    }
}
