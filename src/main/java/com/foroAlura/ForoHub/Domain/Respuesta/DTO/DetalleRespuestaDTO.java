package com.foroAlura.ForoHub.Domain.Respuesta.DTO;

import com.foroAlura.ForoHub.Domain.Respuesta.Model.Respuesta;

import java.time.LocalDateTime;
import java.util.List;

public record DetalleRespuestaDTO(
        Long id,
        String mensaje,
        String topico,
        String autor,
        LocalDateTime fechaCreacion,
        List <String> solucion

) {
    public DetalleRespuestaDTO(Respuesta respuesta) {
        this(
                respuesta.getId(),
                respuesta.getMensaje(),
                respuesta.getTopico().getTitulo(),
                respuesta.getAutor().getNombre(),
                respuesta.getFechaCreacion(),
                respuesta.getSolucion().lines().toList()
        );
    }
}
