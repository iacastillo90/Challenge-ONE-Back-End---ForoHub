package com.foroAlura.ForoHub.Domain.Respuesta.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.foroAlura.ForoHub.Domain.Topico.Model.Topico;
import com.foroAlura.ForoHub.Domain.Usuario.Model.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "Respuesta")
@Table(name = "Respuestas")
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensaje;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topico_id")
    @JsonBackReference("Topico-Respuesta")
    private Topico topico;

    private LocalDateTime fechaCreacion = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    @JsonBackReference("Usuario-Respuesta")
    private Usuario autor;

    private String solucion;

    public Respuesta() {
    }

    public Respuesta(String mensaje, Topico topico, LocalDateTime fechaCreacion, Usuario autor, String solucion) {
        this.mensaje = mensaje;
        this.topico = topico;
        this.fechaCreacion = fechaCreacion;
        this.autor = autor;
        this.solucion = solucion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Topico getTopico() {
        return topico;
    }

    public void setTopico(Topico topico) {
        this.topico = topico;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public String getSolucion() {
        return solucion;
    }

    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }
}
