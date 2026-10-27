package NutriApoyo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "beneficiarios")
public class Beneficiario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Los nombres son obligatorios.")
    @Size(max = 80)
    @Column(nullable = false, length = 80)
    private String nombres;

    @NotBlank(message = "Los apellidos son obligatorios.")
    @Size(max = 80)
    @Column(nullable = false, length = 80)
    private String apellidos;

    @NotNull(message = "La fecha de nacimiento es obligatoria.")
    @PastOrPresent(message = "La fecha de nacimiento no puede estar en el futuro.")
    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Sexo sexo;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_documento", length = 25)
    private TipoDocumento tipoDocumento;

    @Size(max = 20)
    @Column(name = "numero_documento", unique = true, length = 20)
    private String numeroDocumento;

    @NotBlank(message = "La dirección es obligatoria.")
    @Size(max = 180)
    @Column(nullable = false, length = 180)
    private String direccion;

    @NotBlank(message = "El distrito es obligatorio.")
    @Size(max = 80)
    @Column(nullable = false, length = 80)
    private String distrito;

    @NotBlank(message = "Los nombres del tutor son obligatorios.")
    @Size(max = 160)
    @Column(name = "tutor_nombres", nullable = false, length = 160)
    private String tutorNombres;

    @Size(max = 20)
    @Column(name = "tutor_documento", length = 20)
    private String tutorDocumento;

    @NotBlank(message = "El teléfono del tutor es obligatorio.")
    @Pattern(regexp = "^[0-9+() -]{7,20}$", message = "Ingrese un teléfono válido.")
    @Column(name = "tutor_telefono", nullable = false, length = 20)
    private String tutorTelefono;

    @Email(message = "Ingrese un correo electrónico válido.")
    @Size(max = 120)
    @Column(name = "tutor_correo", length = 120)
    private String tutorCorreo;

    @NotBlank(message = "La relación con el menor es obligatoria.")
    @Size(max = 60)
    @Column(name = "relacion_tutor", nullable = false, length = 60)
    private String relacionTutor;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 15)
    private EstadoBeneficiario estado = EstadoBeneficiario.ACTIVO;

    @NotNull
    @Column(name = "fecha_registro", nullable = false)
    private LocalDate fechaRegistro;

    @Size(max = 120)
    @Column(name = "usuario_responsable", length = 120)
    private String usuarioResponsable;

    @Size(max = 500)
    @Column(length = 500)
    private String observaciones;

    @PrePersist
    private void asignarFechaRegistro() {
        if (fechaRegistro == null) {
            fechaRegistro = LocalDate.now();
        }
        normalizarTextos();
    }

    @PreUpdate
    private void normalizarParaActualizar() {
        normalizarTextos();
    }

    @AssertTrue(message = "La edad del menor debe estar entre 0 y 15 años.")
    public boolean isEdadPermitida() {
        return fechaNacimiento == null
                || (!fechaNacimiento.isAfter(LocalDate.now())
                && Period.between(fechaNacimiento, LocalDate.now()).getYears() <= 15);
    }

    private void normalizarTextos() {
        nombres = StringUtils.trim(nombres);
        apellidos = StringUtils.trim(apellidos);
        numeroDocumento = StringUtils.defaultIfBlank(StringUtils.trim(numeroDocumento), null);
        direccion = StringUtils.trim(direccion);
        distrito = StringUtils.trim(distrito);
        tutorNombres = StringUtils.trim(tutorNombres);
        tutorDocumento = StringUtils.defaultIfBlank(StringUtils.trim(tutorDocumento), null);
        tutorTelefono = StringUtils.trim(tutorTelefono);
        tutorCorreo = StringUtils.defaultIfBlank(StringUtils.lowerCase(StringUtils.trim(tutorCorreo)), null);
        relacionTutor = StringUtils.trim(relacionTutor);
        usuarioResponsable = StringUtils.defaultIfBlank(StringUtils.trim(usuarioResponsable), null);
        observaciones = StringUtils.defaultIfBlank(StringUtils.trim(observaciones), null);
    }

    public Long getId() { return id; }
    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }
    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
    public Sexo getSexo() { return sexo; }
    public void setSexo(Sexo sexo) { this.sexo = sexo; }
    public TipoDocumento getTipoDocumento() { return tipoDocumento; }
    public void setTipoDocumento(TipoDocumento tipoDocumento) { this.tipoDocumento = tipoDocumento; }
    public String getNumeroDocumento() { return numeroDocumento; }
    public void setNumeroDocumento(String numeroDocumento) { this.numeroDocumento = numeroDocumento; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public String getDistrito() { return distrito; }
    public void setDistrito(String distrito) { this.distrito = distrito; }
    public String getTutorNombres() { return tutorNombres; }
    public void setTutorNombres(String tutorNombres) { this.tutorNombres = tutorNombres; }
    public String getTutorDocumento() { return tutorDocumento; }
    public void setTutorDocumento(String tutorDocumento) { this.tutorDocumento = tutorDocumento; }
    public String getTutorTelefono() { return tutorTelefono; }
    public void setTutorTelefono(String tutorTelefono) { this.tutorTelefono = tutorTelefono; }
    public String getTutorCorreo() { return tutorCorreo; }
    public void setTutorCorreo(String tutorCorreo) { this.tutorCorreo = tutorCorreo; }
    public String getRelacionTutor() { return relacionTutor; }
    public void setRelacionTutor(String relacionTutor) { this.relacionTutor = relacionTutor; }
    public EstadoBeneficiario getEstado() { return estado; }
    public void setEstado(EstadoBeneficiario estado) { this.estado = estado; }
    public LocalDate getFechaRegistro() { return fechaRegistro; }
    public String getUsuarioResponsable() { return usuarioResponsable; }
    public void setUsuarioResponsable(String usuarioResponsable) { this.usuarioResponsable = usuarioResponsable; }
    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }
    public String getNombreCompleto() { return nombres + " " + apellidos; }
}
