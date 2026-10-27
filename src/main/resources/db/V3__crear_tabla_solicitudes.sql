-- Módulo de solicitudes y evaluación para MySQL 8.
-- Requiere que las tablas usuarios y beneficiarios ya existan.
-- No elimina ni modifica datos existentes.
CREATE TABLE IF NOT EXISTS solicitudes (
    id BIGINT NOT NULL AUTO_INCREMENT,
    codigo_seguimiento VARCHAR(20) NOT NULL,
    beneficiario_id BIGINT NOT NULL,
    usuario_registro_id BIGINT NULL,
    fecha_solicitud DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    estado VARCHAR(20) NOT NULL DEFAULT 'RECIBIDA',
    nivel_hemoglobina DECIMAL(4,1) NULL,
    fecha_medicion DATE NULL,
    establecimiento_salud VARCHAR(150) NULL,
    condicion_anemia VARCHAR(30) NULL,
    observaciones_solicitud VARCHAR(1000) NULL,
    consentimiento_datos BOOLEAN NOT NULL DEFAULT FALSE,
    documento_respaldo VARCHAR(100) NULL,
    tipo_documento_respaldo VARCHAR(50) NULL,
    evaluador_id BIGINT NULL,
    fecha_evaluacion DATETIME NULL,
    motivo_evaluacion VARCHAR(1000) NULL,
    PRIMARY KEY (id),
    CONSTRAINT uk_solicitudes_codigo UNIQUE (codigo_seguimiento),
    CONSTRAINT fk_solicitudes_beneficiario FOREIGN KEY (beneficiario_id) REFERENCES beneficiarios(id),
    CONSTRAINT fk_solicitudes_usuario_registro FOREIGN KEY (usuario_registro_id) REFERENCES usuarios(id),
    CONSTRAINT fk_solicitudes_evaluador FOREIGN KEY (evaluador_id) REFERENCES usuarios(id),
    INDEX idx_solicitudes_estado_fecha (estado, fecha_solicitud),
    INDEX idx_solicitudes_beneficiario (beneficiario_id)
);
