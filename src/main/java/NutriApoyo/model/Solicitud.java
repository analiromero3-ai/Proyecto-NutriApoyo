package NutriApoyo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "solicitudes")
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo_seguimiento", nullable = false, unique = true, length = 20)
    private String codigoSeguimiento;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "beneficiario_id", nullable = false)
    private Beneficiario beneficiario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_registro_id")
    private Usuario usuarioRegistro;

    @Column(name = "fecha_solicitud", nullable = false)
    private LocalDateTime fechaSolicitud;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private EstadoSolicitud estado = EstadoSolicitud.RECIBIDA;

    @DecimalMin(value = "0.0", message = "La hemoglobina declarada no puede ser negativa.")
    @Digits(integer = 3, fraction = 1, message = "Ingrese la hemoglobina con un decimal como máximo.")
    @Column(name = "nivel_hemoglobina", precision = 4, scale = 1)
    private BigDecimal nivelHemoglobina;

    @PastOrPresent(message = "La fecha de medición no puede estar en el futuro.")
    @Column(name = "fecha_medicion")
    private LocalDate fechaMedicion;

    @Size(max = 150)
    @Column(name = "establecimiento_salud", length = 150)
    private String establecimientoSalud;

    @Enumerated(EnumType.STRING)
    @Column(name = "condicion_anemia", length = 30)
    private CondicionAnemiaDeclarada condicionAnemia;

    @Size(max = 1000)
    @Column(name = "observaciones_solicitud", length = 1000)
    private String observacionesSolicitud;

    @AssertTrue(message = "Debe aceptar el consentimiento para el tratamiento de datos.")
    @Column(name = "consentimiento_datos", nullable = false)
    private boolean consentimientoDatos;

    @Column(name = "documento_respaldo", length = 100)
    private String documentoRespaldo;

    @Column(name = "tipo_documento_respaldo", length = 50)
    private String tipoDocumentoRespaldo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "evaluador_id")
    private Usuario evaluador;

    @Column(name = "fecha_evaluacion")
    private LocalDateTime fechaEvaluacion;

    @Size(max = 1000)
    @Column(name = "motivo_evaluacion", length = 1000)
    private String motivoEvaluacion;

    @PrePersist
    private void asignarFechaSolicitud() {
        if (fechaSolicitud == null) {
            fechaSolicitud = LocalDateTime.now();
        }
    }

    public Long getId() { return id; }
    public String getCodigoSeguimiento() { return codigoSeguimiento; }
    public void setCodigoSeguimiento(String codigoSeguimiento) { this.codigoSeguimiento = codigoSeguimiento; }
    public Beneficiario getBeneficiario() { return beneficiario; }
    public void setBeneficiario(Beneficiario beneficiario) { this.beneficiario = beneficiario; }
    public Usuario getUsuarioRegistro() { return usuarioRegistro; }
    public void setUsuarioRegistro(Usuario usuarioRegistro) { this.usuarioRegistro = usuarioRegistro; }
    public LocalDateTime getFechaSolicitud() { return fechaSolicitud; }
    public EstadoSolicitud getEstado() { return estado; }
    public void setEstado(EstadoSolicitud estado) { this.estado = estado; }
    public BigDecimal getNivelHemoglobina() { return nivelHemoglobina; }
    public void setNivelHemoglobina(BigDecimal nivelHemoglobina) { this.nivelHemoglobina = nivelHemoglobina; }
    public LocalDate getFechaMedicion() { return fechaMedicion; }
    public void setFechaMedicion(LocalDate fechaMedicion) { this.fechaMedicion = fechaMedicion; }
    public String getEstablecimientoSalud() { return establecimientoSalud; }
    public void setEstablecimientoSalud(String establecimientoSalud) { this.establecimientoSalud = establecimientoSalud; }
    public CondicionAnemiaDeclarada getCondicionAnemia() { return condicionAnemia; }
    public void setCondicionAnemia(CondicionAnemiaDeclarada condicionAnemia) { this.condicionAnemia = condicionAnemia; }
    public String getObservacionesSolicitud() { return observacionesSolicitud; }
    public void setObservacionesSolicitud(String observacionesSolicitud) { this.observacionesSolicitud = observacionesSolicitud; }
    public boolean isConsentimientoDatos() { return consentimientoDatos; }
    public void setConsentimientoDatos(boolean consentimientoDatos) { this.consentimientoDatos = consentimientoDatos; }
    public String getDocumentoRespaldo() { return documentoRespaldo; }
    public void setDocumentoRespaldo(String documentoRespaldo) { this.documentoRespaldo = documentoRespaldo; }
    public String getTipoDocumentoRespaldo() { return tipoDocumentoRespaldo; }
    public void setTipoDocumentoRespaldo(String tipoDocumentoRespaldo) { this.tipoDocumentoRespaldo = tipoDocumentoRespaldo; }
    public Usuario getEvaluador() { return evaluador; }
    public void setEvaluador(Usuario evaluador) { this.evaluador = evaluador; }
    public LocalDateTime getFechaEvaluacion() { return fechaEvaluacion; }
    public void setFechaEvaluacion(LocalDateTime fechaEvaluacion) { this.fechaEvaluacion = fechaEvaluacion; }
    public String getMotivoEvaluacion() { return motivoEvaluacion; }
    public void setMotivoEvaluacion(String motivoEvaluacion) { this.motivoEvaluacion = motivoEvaluacion; }
}
