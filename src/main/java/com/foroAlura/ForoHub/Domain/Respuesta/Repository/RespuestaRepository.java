package com.foroAlura.ForoHub.Domain.Respuesta.Repository;

import com.foroAlura.ForoHub.Domain.Respuesta.Model.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {

}
