package com.foroAlura.ForoHub.Controller;

import com.foroAlura.ForoHub.Domain.Respuesta.Repository.RespuestaRepository;
import com.foroAlura.ForoHub.Domain.Respuesta.Service.RespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RespuestaController {

    @Autowired
    private RespuestaService respuestaService;

    @Autowired
    private RespuestaRepository respuestaRepository;
}
