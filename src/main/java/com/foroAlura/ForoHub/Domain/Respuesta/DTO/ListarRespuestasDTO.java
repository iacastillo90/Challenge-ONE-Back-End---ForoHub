package com.foroAlura.ForoHub.Domain.Respuesta.DTO;

import com.foroAlura.ForoHub.Domain.Respuesta.Model.Respuesta;

import java.time.LocalDateTime;
import java.util.List;

public record ListarRespuestasDTO(

        Long id,

        String mensaje,

        LocalDateTime fechaCreacion,

        Long autor,

        String solucion
) {
    public ListarRespuestasDTO (Respuesta respuesta) {
        this(
                respuesta.getId(),
                respuesta.getMensaje(),
                respuesta.getFechaCreacion(),
                respuesta.getAutor().getId(),
                respuesta.getSolucion()
        );
    }

    public static List<ListarRespuestasDTO> converter(List<Respuesta> respuestas) {
        return respuestas.stream().map(ListarRespuestasDTO::new).toList();
    }
}
