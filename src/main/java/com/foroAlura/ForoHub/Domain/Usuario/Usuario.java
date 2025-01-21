package com.foroAlura.ForoHub.Domain.Usuario;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.foroAlura.ForoHub.Domain.Perfil.Perfil;
import com.foroAlura.ForoHub.Domain.Respuesta.Respuesta;
import com.foroAlura.ForoHub.Domain.Topico.Topico;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "Usuario")
@Table(name = "Usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String email;

    private String contrasena;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "usuario_perfil",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "perfil_id")
    )
    private List<Perfil> perfiles;


    @OneToMany(mappedBy = "Usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference("Usuario-Topico")
    private List<Topico> topicos;

    @OneToMany(mappedBy = "Usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference("Usuario-Respuesta")
    private List<Respuesta> respuestas;

}
