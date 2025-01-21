package com.foroAlura.ForoHub.Domain.Respuesta.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegistroRespuestaDTO(
        @NotBlank(message = "El mensaje no puede estar vacío.")
        String mensaje,
        @NotBlank(message = "La solución no puede estar vacía.")
        String solucion,
        @NotNull(message = "El autor no puede ser nulo.")
        long autor,
        @NotNull(message = "El topico no puede ser nulo.")
        long topico
) {
}
