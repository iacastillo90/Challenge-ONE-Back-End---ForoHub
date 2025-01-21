package com.foroAlura.ForoHub.Domain.Usuario.Repository;

import com.foroAlura.ForoHub.Domain.Usuario.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String username);

    boolean existsByEmail(String email);
}
