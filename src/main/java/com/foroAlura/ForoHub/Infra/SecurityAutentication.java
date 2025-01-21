package com.foroAlura.ForoHub.Infra;

import com.foroAlura.ForoHub.Domain.Usuario.Model.Usuario;
import com.foroAlura.ForoHub.Domain.Usuario.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class SecurityAutentication {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return this::loadUserByUsername;
    }



    public UserDetails loadUserByUsername(String username) {
        Usuario usuario = usuarioRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        String roleName = usuario.getRol().toString();

        // Crear una lista de autoridades (permisos)
        List<SimpleGrantedAuthority> authorities = usuario.getPermisos().stream()
                .map(permisoId -> new SimpleGrantedAuthority("PERMISO_" + permisoId))
                .collect(Collectors.toList());

        // Añadir el rol a las autoridades
        authorities.add(new SimpleGrantedAuthority("ROLE_" + roleName));

        return new User(usuario.getEmail(), usuario.getContrasena(), authorities);
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}