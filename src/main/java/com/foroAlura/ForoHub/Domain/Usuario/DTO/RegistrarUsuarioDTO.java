package com.foroAlura.ForoHub.Domain.Usuario.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegistrarUsuarioDTO(

        @NotBlank(message = "El nombre del usuario no puede estar vacío.")
        String nombre,
        @NotBlank(message = "El email del usuario no puede estar vacío.")
        @Email
        String email,
        @NotBlank(message = "La contraseña del usuario no puede estar vacía.")
        String contrasenia
) {
}
