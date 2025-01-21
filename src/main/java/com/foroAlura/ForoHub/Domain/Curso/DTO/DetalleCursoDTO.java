package com.foroAlura.ForoHub.Domain.Curso.DTO;

import com.foroAlura.ForoHub.Domain.Curso.Model.Curso;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DetalleCursoDTO(
        @NotNull(message = "El id del curso no puede ser nulo.")
        Long id,
        @NotBlank(message = "El nombre del curso no puede estar vacío.")
        String nombre,
        @NotBlank(message = "La categoría del curso no puede estar vacía.")
        String categoria
) {
        public DetalleCursoDTO (Curso curso) {
                this(curso.getId(), curso.getNombre(), curso.getCategoria());
        }
}
