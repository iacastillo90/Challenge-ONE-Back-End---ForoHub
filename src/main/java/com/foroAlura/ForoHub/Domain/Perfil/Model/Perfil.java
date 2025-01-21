package com.foroAlura.ForoHub.Domain.Perfil.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.foroAlura.ForoHub.Domain.Usuario.Model.Permisos;
import com.foroAlura.ForoHub.Domain.Usuario.Model.Usuario;
import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import lombok.*;

import java.util.List;

@Entity(name = "Perfil")
@Table(name = "Perfiles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "perfil_usuario",
            joinColumns = @JoinColumn(name = "perfil_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )
    private List<Usuario> usuarios;

}
