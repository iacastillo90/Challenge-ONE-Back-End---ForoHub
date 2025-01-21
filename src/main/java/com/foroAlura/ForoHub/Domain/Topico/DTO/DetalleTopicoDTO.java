package com.foroAlura.ForoHub.Domain.Topico.DTO;

import com.foroAlura.ForoHub.Domain.Curso.DTO.DetalleCursoDTO;
import com.foroAlura.ForoHub.Domain.Topico.Model.Topico;
import com.foroAlura.ForoHub.Domain.Usuario.DTO.DetalleUsuarioDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DetalleTopicoDTO(

        @NotNull(message = "El id del topico no puede ser nulo.")
        Long id,
        @NotBlank(message = "El titulo del topico no puede estar vacío.")
        String titulo,
        @NotBlank(message = "El mensaje del topico no puede estar vacío.")
        String mensaje,
        @AssertTrue(message = "El estado del topico no puede ser nulo.")
        boolean estado,
        @FutureOrPresent(message = "La fecha de creación no puede ser nula.")
        LocalDateTime fechaCreacion,
        @NotBlank(message = "El autor del topico no puede estar vacío.")
        @Valid
        DetalleUsuarioDTO autor,
        @NotBlank(message = "El curso del topico no puede estar vacío.")
        @Valid
        DetalleCursoDTO curso
) {
    public DetalleTopicoDTO(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(),
                topico.getStatus(), topico.getFechaCreacion(),
                new DetalleUsuarioDTO(topico.getAutor()),
                new DetalleCursoDTO(topico.getCurso()));
    }
}
