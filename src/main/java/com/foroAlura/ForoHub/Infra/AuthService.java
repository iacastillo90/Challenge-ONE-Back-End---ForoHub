package com.foroAlura.ForoHub.Infra;

import com.foroAlura.ForoHub.Domain.Usuario.DTO.AutenticarUsuarioDTO;
import com.foroAlura.ForoHub.Domain.Usuario.Model.Usuario;
import com.foroAlura.ForoHub.Domain.Usuario.Repository.UsuarioRepository;
import com.foroAlura.ForoHub.Infra.Jwt.JwtService;
import com.foroAlura.ForoHub.Infra.Request.AuthResquest;
import com.foroAlura.ForoHub.Infra.Request.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    public AuthResquest login(AutenticarUsuarioDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email(), request.contrasena()));

        Usuario usuario = usuarioRepository.findByEmail(request.email())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Obtener el nombre del rol desde la entidad Role
        String roleName = usuario.getRol().toString();

        // Crear una lista de permisos desde la entidad Role
        List<SimpleGrantedAuthority> authorities = usuario.getPermisos().stream()
                .map(permisoId -> new SimpleGrantedAuthority("PERMISO_" + permisoId))
                .collect(Collectors.toList());

        // Crear el token JWT
        String token = jwtService.getToken(new org.springframework.security.core.userdetails.User(
                usuario.getEmail(),
                usuario.getContrasena(),
                authorities));

        return new AuthResquest( token, roleName);
    }

}
