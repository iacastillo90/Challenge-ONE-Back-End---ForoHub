package com.foroAlura.ForoHub.Controller;

import com.foroAlura.ForoHub.Domain.Curso.Repository.CursoRepository;
import com.foroAlura.ForoHub.Domain.Curso.Service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @Autowired
    private CursoRepository cursoRepository;
}
