package com.foroAlura.ForoHub.Infra.Request;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class AuthResquest {
    private String token;
    private String role;

    public AuthResquest(String token, String role) {
        this.token = token;
        this.role = role;
    }
}
