package com.foroAlura.ForoHub.Domain.Topico.DTO;

import com.foroAlura.ForoHub.Domain.Respuesta.DTO.ListarRespuestasDTO;
import com.foroAlura.ForoHub.Domain.Topico.Model.Topico;

import java.time.LocalDateTime;
import java.util.List;

public record ListarTopicosDTO(
        Long id,

        String titulo,

        String mensaje,

        LocalDateTime fechaCreacion,

        Boolean status,

        Long usuario,

        Long curso,

        List<ListarRespuestasDTO> respuestas
) {
    public ListarTopicosDTO(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getAutor().getId(),
                topico.getCurso().getId(),
                ListarRespuestasDTO.converter(topico.getRespuestas())
        );
    }
}
