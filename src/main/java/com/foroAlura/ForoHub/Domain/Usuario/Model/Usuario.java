package com.foroAlura.ForoHub.Domain.Usuario.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.foroAlura.ForoHub.Domain.Perfil.Model.Perfil;
import com.foroAlura.ForoHub.Domain.Respuesta.Model.Respuesta;
import com.foroAlura.ForoHub.Domain.Topico.Model.Topico;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Usuarios")
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


    @OneToMany(mappedBy = "autor", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference("Usuario-Topico")
    private List<Topico> topicos;

    @OneToMany(mappedBy = "autor", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference("Usuario-Respuesta")
    private List<Respuesta> respuestas;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference("Usuario-Permisos")
    private List<Permisos> permisos;

    public Usuario() {
    }

    public Usuario(String nombre, String email, String contrasena, List<Perfil> perfiles, List<Topico> topicos, List<Respuesta> respuestas, Rol rol) {
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
        this.perfiles = perfiles;
        this.topicos = topicos;
        this.respuestas = respuestas;
        this.rol = rol;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public List<Perfil> getPerfiles() {
        return perfiles;
    }

    public void setPerfiles(List<Perfil> perfiles) {
        this.perfiles = perfiles;
    }

    public List<Topico> getTopicos() {
        return topicos;
    }

    public void setTopicos(List<Topico> topicos) {
        this.topicos = topicos;
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public List<Permisos> getPermisos() {
        return permisos;
    }

    public void setPermisos(List<Permisos> permisos) {
        this.permisos = permisos;
    }
}
