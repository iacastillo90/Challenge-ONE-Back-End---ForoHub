package com.foroAlura.ForoHub.Controller;

import com.foroAlura.ForoHub.Domain.Usuario.DTO.AutenticarUsuarioDTO;
import com.foroAlura.ForoHub.Domain.Usuario.Model.Usuario;
import com.foroAlura.ForoHub.Domain.Usuario.Repository.UsuarioRepository;
import com.foroAlura.ForoHub.Domain.Usuario.Service.UsuarioService;
import com.foroAlura.ForoHub.Infra.AuthService;
import com.foroAlura.ForoHub.Infra.Request.AuthResquest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AuthService authService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/login")
    public ResponseEntity<AuthResquest> login(@RequestBody AutenticarUsuarioDTO request) {

        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/registro")
    public ResponseEntity<Usuario> registro(@RequestBody Usuario usuario) {

        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            return ResponseEntity.badRequest().build();
        }
        usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena()));
        return ResponseEntity.ok(usuarioService.save(usuario));
    }
}
