-- Tabla de perfiles
CREATE TABLE perfiles (
    id BIGINT NOT NULL AUTO_INCREMENT,    -- ID principal del perfil
    nombre VARCHAR(100) NOT NULL,         -- Nombre del perfil
    PRIMARY KEY (id)                      -- Clave primaria
);