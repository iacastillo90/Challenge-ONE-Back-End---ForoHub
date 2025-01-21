package com.foroAlura.ForoHub.Domain.Curso.Repository;

import com.foroAlura.ForoHub.Domain.Curso.Model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CursoRepository extends JpaRepository<Curso, Long> {

}
