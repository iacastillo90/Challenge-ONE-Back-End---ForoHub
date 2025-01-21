-- Creación de la tabla cursos
CREATE TABLE cursos (
    id BIGINT NOT NULL AUTO_INCREMENT,  -- ID principal de la tabla
    nombre VARCHAR(100) NOT NULL,       -- Nombre del curso
    categoria VARCHAR(100) NOT NULL,    -- Categoría del curso

    PRIMARY KEY (id)                    -- Clave primaria
);
