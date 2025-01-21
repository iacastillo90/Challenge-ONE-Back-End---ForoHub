package com.foroAlura.ForoHub.Domain.Topico.DTO;

import com.foroAlura.ForoHub.Domain.Topico.Model.Topico;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegistrarTopicoDTO(

        @NotBlank(message = "El titulo del topico no puede estar vacío.")
        String Titulo,
        @NotBlank(message = "El mensaje del topico no puede estar vacío.")
        String Mensaje,
        @NotNull(message = "El autor del topico no puede ser nulo.")
        Long autor,
        @NotNull(message = "El curso del topico no puede ser nulo.")
        Long curso

) {
        public RegistrarTopicoDTO(Topico topico) {
                this(topico.getTitulo(), topico.getMensaje(), topico.getAutor().getId(), topico.getCurso().getId());
        }
}
