-- Relación uno a muchos con Permisos
CREATE TABLE permisos (
    id BIGINT NOT NULL AUTO_INCREMENT,    -- ID del permiso
    permiso VARCHAR(100) NOT NULL,        -- Descripción del permiso
    usuario_id BIGINT NOT NULL,           -- ID del usuario (referencia a Usuario)
    PRIMARY KEY (id),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE CASCADE
);