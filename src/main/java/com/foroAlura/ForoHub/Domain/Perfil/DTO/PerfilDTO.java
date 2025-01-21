package com.foroAlura.ForoHub.Domain.Perfil.DTO;

import com.foroAlura.ForoHub.Domain.Usuario.DTO.DetalleUsuarioDTO;
import jakarta.validation.constraints.NotBlank;

public record PerfilDTO(

        @NotBlank(message = "El nombre del perfil no puede estar vacío")
        String nombre,

        DetalleUsuarioDTO usuarios
) {
}
