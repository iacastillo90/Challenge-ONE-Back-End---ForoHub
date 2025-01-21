package com.foroAlura.ForoHub.Domain.Topico.Service.ImplementService;

import com.foroAlura.ForoHub.Domain.Curso.Model.Curso;
import com.foroAlura.ForoHub.Domain.Curso.Repository.CursoRepository;
import com.foroAlura.ForoHub.Domain.Topico.DTO.ActualizarTopicoDTO;
import com.foroAlura.ForoHub.Domain.Topico.DTO.ListarTopicosDTO;
import com.foroAlura.ForoHub.Domain.Topico.DTO.RegistrarTopicoDTO;
import com.foroAlura.ForoHub.Domain.Topico.Model.Topico;
import com.foroAlura.ForoHub.Domain.Topico.Repository.TopicoRepository;
import com.foroAlura.ForoHub.Domain.Topico.Service.TopicoService;
import com.foroAlura.ForoHub.Domain.Usuario.Model.Rol;
import com.foroAlura.ForoHub.Domain.Usuario.Model.Usuario;
import com.foroAlura.ForoHub.Domain.Usuario.Repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TopicoServiceImplement implements TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;


    @Override
    public List<ListarTopicosDTO> listarTopicos() {
        List<ListarTopicosDTO> topicos = topicoRepository.findAll()
                .stream()
                .map(ListarTopicosDTO::new)
                .collect(Collectors.toList());

        if (topicos.isEmpty()) {
            return (List<ListarTopicosDTO>) ResponseEntity.noContent().build();
        }
        return topicos;
    }

    @Override
    public Topico crearTopico(@Valid RegistrarTopicoDTO topico) {
        Usuario autor = usuarioRepository.findById(topico.autor())
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));

        Curso curso = cursoRepository.findById(topico.curso())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        Topico nuevoTopico = new Topico();
        nuevoTopico.setTitulo(topico.Titulo());
        nuevoTopico.setMensaje(topico.Mensaje());
        nuevoTopico.setAutor(autor);
        nuevoTopico.setCurso(curso);

        Topico topicoGuardado = topicoRepository.save(nuevoTopico);
        return topicoGuardado;
    }

    @Override
    public Topico actualizarTopico(Long id, ActualizarTopicoDTO acutalizarTopicoDTO) {
        Topico topicoExistente = topicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tópico no encontrado"));

        topicoExistente.setTitulo(acutalizarTopicoDTO.Titulo());
        topicoExistente.setMensaje(acutalizarTopicoDTO.Mensaje());

        Topico topicoActualizado = topicoRepository.save(topicoExistente);
        return topicoActualizado;
    }

    @Override
    public void desactivarTopico(Long id, String usuario) {

        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tópico no encontrado"));

        Usuario usuarioAutenticado = usuarioRepository.findByEmail(usuario)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));

        if (!topico.getAutor().getId().equals(usuarioAutenticado.getId())
                && !usuarioAutenticado.getRol().equals(Rol.ADMIN)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "No tienes permiso para desactivar este tópico");
        }

        topico.setStatus(false);
        topicoRepository.save(topico);
    }

    @Override
    public void eliminarTopico(Long id, String usuario) {
        Topico topico = topicoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tópico no encontrado"));

        Usuario usuarioAutenticado = usuarioRepository.findByEmail(usuario)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));

        if (!usuarioAutenticado.getRol().equals(Rol.ADMIN)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "No tienes permiso para eliminar este tópico");
        }

        topicoRepository.delete(topico);
    }
}
