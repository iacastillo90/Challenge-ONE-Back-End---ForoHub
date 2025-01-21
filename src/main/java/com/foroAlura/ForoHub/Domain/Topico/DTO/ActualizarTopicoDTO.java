package com.foroAlura.ForoHub.Domain.Topico.DTO;

import jakarta.validation.constraints.NotBlank;

public record ActualizarTopicoDTO(
        @NotBlank(message = "El título del tópico no puede estar vacío.")
        String Titulo,
        @NotBlank(message = "El mensaje del tópico no puede estar vacío.")
        String Mensaje
) {}
