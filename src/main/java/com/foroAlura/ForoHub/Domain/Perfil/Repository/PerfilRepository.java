package com.foroAlura.ForoHub.Domain.Perfil.Repository;

import com.foroAlura.ForoHub.Domain.Perfil.Model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PerfilRepository extends JpaRepository<Perfil, Long> {

}
