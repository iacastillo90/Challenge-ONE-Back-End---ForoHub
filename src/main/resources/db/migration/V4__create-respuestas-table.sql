-- Relación uno a muchos con Respuesta
CREATE TABLE respuestas (
    id BIGINT NOT NULL AUTO_INCREMENT,    -- ID de la respuesta
    mensaje TEXT NOT NULL,                -- Mensaje de la respuesta
    autor_id BIGINT NOT NULL,             -- ID del autor (referencia a Usuario)
    PRIMARY KEY (id),
    FOREIGN KEY (autor_id) REFERENCES usuarios(id) ON DELETE CASCADE
);