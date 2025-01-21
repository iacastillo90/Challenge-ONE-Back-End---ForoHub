package com.foroAlura.ForoHub.Domain.Usuario.Service.ImplementService;

import com.foroAlura.ForoHub.Domain.Usuario.Model.Usuario;
import com.foroAlura.ForoHub.Domain.Usuario.Repository.UsuarioRepository;
import com.foroAlura.ForoHub.Domain.Usuario.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImplement implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}
