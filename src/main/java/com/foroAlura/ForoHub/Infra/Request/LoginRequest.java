package com.foroAlura.ForoHub.Infra.Request;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class LoginRequest {
    private String email;
    private String contrasena;
}
