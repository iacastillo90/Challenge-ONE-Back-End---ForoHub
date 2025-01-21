package com.foroAlura.ForoHub.Controller;

import com.foroAlura.ForoHub.Domain.Perfil.Repository.PerfilRepository;
import com.foroAlura.ForoHub.Domain.Perfil.Service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @Autowired
    private PerfilRepository perfilRepository;
}
