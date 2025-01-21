package com.foroAlura.ForoHub.Controller;

import com.foroAlura.ForoHub.Domain.Topico.Repository.TopicoRepository;
import com.foroAlura.ForoHub.Domain.Topico.Service.TopicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @Autowired
    private TopicoRepository topicoRepository;
}
