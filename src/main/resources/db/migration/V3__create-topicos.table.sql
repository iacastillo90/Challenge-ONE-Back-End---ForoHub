-- Relación uno a muchos con Topico
CREATE TABLE topicos (
    id BIGINT NOT NULL AUTO_INCREMENT,    -- ID del tópico
    titulo VARCHAR(255) NOT NULL,         -- Título del tópico
    mensaje TEXT NOT NULL,                -- Mensaje del tópico
    autor_id BIGINT NOT NULL,             -- ID del autor (referencia a Usuario)
    PRIMARY KEY (id),
    FOREIGN KEY (autor_id) REFERENCES usuarios(id) ON DELETE CASCADE
);