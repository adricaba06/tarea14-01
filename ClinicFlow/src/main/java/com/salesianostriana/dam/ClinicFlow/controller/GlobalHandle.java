package com.salesianostriana.dam.ClinicFlow.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import org.springframework.http.*;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@RestControllerAdvice
public class GlobalHandle extends ResponseEntityExceptionHandler {

    @Override //MIRAR EN CASA !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ProblemDetail result = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, "Error de validacion");

        List<ApiValidationSubError> subErrors = ex.getAllErrors().stream().map(ApiValidationSubError::from).toList();

        result.setProperty("invalid-params", subErrors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }


    @Builder
    record ApiValidationSubError(
            String object,
            String message,
            @JsonInclude(JsonInclude.Include.NON_NULL)
            String field,
            @JsonInclude(JsonInclude.Include.NON_NULL)
            Object rejectedValue
    ) {


        public static ApiValidationSubError from(ObjectError objectError) {
            if (objectError instanceof FieldError fieldError) {
                return ApiValidationSubError.builder()
                        .object(fieldError.getObjectName())
                        .field(fieldError.getField())
                        .rejectedValue(fieldError.getRejectedValue())
                        .message(fieldError.getDefaultMessage())
                        .build();
            }
            return null;
        }
    }
}



