-- Tabla de usuarios
CREATE TABLE usuarios (
    id BIGINT NOT NULL AUTO_INCREMENT,    -- ID principal de la tabla
    nombre VARCHAR(100) NOT NULL,         -- Nombre del usuario
    email VARCHAR(100) NOT NULL UNIQUE,   -- Email único del usuario
    contrasena VARCHAR(255) NOT NULL,     -- Contraseña (puede ser más larga para almacenamiento cifrado)
    rol VARCHAR(20) NOT NULL,             -- Rol del usuario, puede ser 'ADMIN', 'USER', etc.

    PRIMARY KEY (id)                      -- Clave primaria
);

-- Tabla intermedia para la relación muchos a muchos con Perfil
CREATE TABLE usuario_perfil (
    usuario_id BIGINT NOT NULL,           -- ID del usuario
    perfil_id BIGINT NOT NULL,            -- ID del perfil
    PRIMARY KEY (usuario_id, perfil_id),  -- Combinación de ambos IDs como clave primaria
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE CASCADE,
    FOREIGN KEY (perfil_id) REFERENCES perfiles(id) ON DELETE CASCADE
);