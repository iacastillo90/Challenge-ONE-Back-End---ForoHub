package com.foroAlura.ForoHub.Domain.Usuario.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.foroAlura.ForoHub.Domain.Perfil.Model.Perfil;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Permisos")
@Table(name = "Permisos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Permisos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String descripcion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    @JsonBackReference("Usuario-Permisos")
    private Usuario usuario;
}
