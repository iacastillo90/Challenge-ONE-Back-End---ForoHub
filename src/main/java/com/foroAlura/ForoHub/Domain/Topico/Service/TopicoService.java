package com.foroAlura.ForoHub.Domain.Topico.Service;

import com.foroAlura.ForoHub.Domain.Topico.DTO.ActualizarTopicoDTO;
import com.foroAlura.ForoHub.Domain.Topico.DTO.ListarTopicosDTO;
import com.foroAlura.ForoHub.Domain.Topico.DTO.RegistrarTopicoDTO;
import com.foroAlura.ForoHub.Domain.Topico.Model.Topico;
import jakarta.validation.Valid;

import java.util.List;

public interface TopicoService {

    List<ListarTopicosDTO> listarTopicos();

    Topico crearTopico(@Valid RegistrarTopicoDTO topico);

    Topico actualizarTopico(Long id, @Valid ActualizarTopicoDTO acutalizarTopicoDTO);

    void desactivarTopico(Long id, String usuario);

    void eliminarTopico(Long id, String usuario);
}
