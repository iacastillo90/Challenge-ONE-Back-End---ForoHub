package com.foroAlura.ForoHub.Domain.Respuesta;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.foroAlura.ForoHub.Domain.Topico.Topico;
import com.foroAlura.ForoHub.Domain.Usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Respuesta")
@Table(name = "Respuestas")
@Getter
@Setter
@NoArgsConstructor
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    @JsonBackReference("Usuario-Respuesta")
    private Usuario autor;
}
