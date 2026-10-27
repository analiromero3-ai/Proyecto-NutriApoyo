-- Módulo de Beneficiarios para MySQL 8.
-- Ejecute este script una sola vez en la base de datos nutriapoyo.
-- No elimina tablas ni datos existentes.
CREATE TABLE IF NOT EXISTS beneficiarios (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nombres VARCHAR(80) NOT NULL,
    apellidos VARCHAR(80) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    sexo VARCHAR(20) NULL,
    tipo_documento VARCHAR(25) NULL,
    numero_documento VARCHAR(20) NULL,
    direccion VARCHAR(180) NOT NULL,
    distrito VARCHAR(80) NOT NULL,
    tutor_nombres VARCHAR(160) NOT NULL,
    tutor_documento VARCHAR(20) NULL,
    tutor_telefono VARCHAR(20) NOT NULL,
    tutor_correo VARCHAR(120) NULL,
    relacion_tutor VARCHAR(60) NOT NULL,
    estado VARCHAR(15) NOT NULL DEFAULT 'ACTIVO',
    fecha_registro DATE NOT NULL,
    usuario_responsable VARCHAR(120) NULL,
    observaciones VARCHAR(500) NULL,
    PRIMARY KEY (id),
    CONSTRAINT uk_beneficiarios_numero_documento UNIQUE (numero_documento),
    INDEX idx_beneficiarios_distrito (distrito),
    INDEX idx_beneficiarios_estado (estado)
);
