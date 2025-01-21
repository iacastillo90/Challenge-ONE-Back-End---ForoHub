package com.foroAlura.ForoHub.Domain.Curso.DTO;

import jakarta.validation.constraints.NotBlank;

public record RegistrarCursoDTO(
        @NotBlank(message = "El nombre del curso no puede estar vacío.")
        String nombre,
        @NotBlank(message = "La categoria del curso no puede estar vacía.")
        String categoria) {
}