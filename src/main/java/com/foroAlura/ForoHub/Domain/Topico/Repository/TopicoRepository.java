package com.foroAlura.ForoHub.Domain.Topico.Repository;

import com.foroAlura.ForoHub.Domain.Topico.Model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TopicoRepository extends JpaRepository<Topico, Long> {

}
