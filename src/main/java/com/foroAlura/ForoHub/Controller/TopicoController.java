package com.foroAlura.ForoHub.Controller;

import com.foroAlura.ForoHub.Domain.Topico.DTO.ActualizarTopicoDTO;
import com.foroAlura.ForoHub.Domain.Topico.DTO.ListarTopicosDTO;
import com.foroAlura.ForoHub.Domain.Topico.DTO.RegistrarTopicoDTO;
import com.foroAlura.ForoHub.Domain.Topico.Model.Topico;
import com.foroAlura.ForoHub.Domain.Topico.Service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @GetMapping("/topicos")
    public ResponseEntity<List<ListarTopicosDTO>> getTopicos() {
        return ResponseEntity.ok(topicoService.listarTopicos());
    }

    @PostMapping("/topicos")
    public ResponseEntity<Topico> registrarTopico(@RequestBody @Valid RegistrarTopicoDTO topico) {
        return ResponseEntity.status(HttpStatus.CREATED).body(topicoService.crearTopico(topico));
    }

    @PutMapping("/topicos/{id}")
    public ResponseEntity<Topico> actualizarTopicoParcial(
            @PathVariable Long id,
            @RequestBody @Valid ActualizarTopicoDTO acutalizarTopicoDTO) {
        return ResponseEntity.ok(topicoService.actualizarTopico(id,acutalizarTopicoDTO));
    }

    @DeleteMapping("/topicos/{id}")
    public ResponseEntity<Void> eliminarTopico(
            @PathVariable Long id,
            Authentication authentication
    ) {
        topicoService.eliminarTopico(id, authentication.getName());
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/desactivar")
    public ResponseEntity<Void> desactivarTopico(
            @PathVariable Long id,
            Authentication authentication
    ) {
        topicoService.desactivarTopico(id, authentication.getName());
        return ResponseEntity.noContent().build();
    }

}
