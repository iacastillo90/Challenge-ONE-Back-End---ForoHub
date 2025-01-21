package com.foroAlura.ForoHub.Domain.Usuario.DTO;

import com.foroAlura.ForoHub.Domain.Usuario.Model.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DetalleUsuarioDTO(

        @NotNull(message = "El id del usuario no puede ser nulo.")
        Long id,

        @NotBlank(message = "El nombre del usuario no puede estar vacío.")
        String nombre,

        @NotBlank(message = "El email del usuario no puede estar vacío.")
        @Email
        String email

) {
        public DetalleUsuarioDTO(Usuario usuario){
                this(usuario.getId(),usuario.getNombre(),usuario.getEmail());
        }
}
