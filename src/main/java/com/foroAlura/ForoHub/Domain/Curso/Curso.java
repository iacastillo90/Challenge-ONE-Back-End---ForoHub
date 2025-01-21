package com.foroAlura.ForoHub.Domain.Curso;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.foroAlura.ForoHub.Domain.Topico.Topico;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "Curso")
@Table(name = "Cursos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String categoria;

    @OneToMany(mappedBy = "Curso", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference("Curso-Topico")
    private List<Topico> topicos;

}
