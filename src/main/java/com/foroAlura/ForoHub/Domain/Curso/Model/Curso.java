package com.foroAlura.ForoHub.Domain.Curso.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.foroAlura.ForoHub.Domain.Topico.Model.Topico;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "Curso")
@Table(name = "Cursos")
@EqualsAndHashCode(of = "id")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String categoria;

    @OneToMany(mappedBy = "curso", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference("Curso-Topico")
    private List<Topico> topicos;

    public Curso() {
    }

    public Curso(String nombre, String categoria, List<Topico> topicos) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.topicos = topicos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<Topico> getTopicos() {
        return topicos;
    }

    public void setTopicos(List<Topico> topicos) {
        this.topicos = topicos;
    }
}
