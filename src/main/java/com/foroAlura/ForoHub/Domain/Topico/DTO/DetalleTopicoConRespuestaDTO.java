package com.foroAlura.ForoHub.Domain.Topico.DTO;

import com.foroAlura.ForoHub.Domain.Curso.DTO.DetalleCursoDTO;
import com.foroAlura.ForoHub.Domain.Respuesta.DTO.DetalleRespuestaDTO;
import com.foroAlura.ForoHub.Domain.Topico.Model.Topico;
import com.foroAlura.ForoHub.Domain.Usuario.DTO.DetalleUsuarioDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record DetalleTopicoConRespuestaDTO(

        @NotNull(message = "El id no puede ser nulo.")
        Long id,
        @NotBlank(message = "El título no puede estar vacío.")
        String titulo,
        @NotBlank(message = "El mensaje no puede estar vacío.")
        String mensaje,
        @AssertTrue(message = "El estado debe ser verdadero o falso.")
        boolean estado,
        @FutureOrPresent(message = "La fecha de creación debe ser en el presente o futuro.")
        LocalDateTime fechaCreacion,
        @NotBlank(message = "El autor no puede estar vacío.")
        @Valid
        DetalleUsuarioDTO autor,
        @NotBlank(message = "El curso no puede estar vacío.")
        @Valid
        DetalleCursoDTO curso,
        List<DetalleRespuestaDTO> respuestas
) {
    public DetalleTopicoConRespuestaDTO(Topico topico, List<DetalleRespuestaDTO> respuestas) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(),
                topico.getStatus(), topico.getFechaCreacion(),
                new DetalleUsuarioDTO(topico.getAutor()),
                new DetalleCursoDTO(topico.getCurso()),
                respuestas);
    }
}
