package com.foroAlura.ForoHub.Domain.Usuario.DTO;

import com.foroAlura.ForoHub.Domain.Usuario.Model.Usuario;
import jakarta.validation.constraints.NotBlank;

public record AutenticarUsuarioDTO(
        @NotBlank(message = "El email no puede estar vacío")
        String email,
        @NotBlank(message = "La contraseña no puede estar vacía")
        String contrasena
) {
}
