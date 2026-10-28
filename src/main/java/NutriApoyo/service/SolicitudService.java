package NutriApoyo.service;

import NutriApoyo.dao.BeneficiarioRepository;
import NutriApoyo.dao.SolicitudRepository;
import NutriApoyo.dao.UsuarioRepository;
import NutriApoyo.model.Beneficiario;
import NutriApoyo.model.EstadoSolicitud;
import NutriApoyo.model.Solicitud;
import NutriApoyo.model.Usuario;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.time.Year;
import java.util.EnumSet;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

@Service
public class SolicitudService {

    private static final EnumSet<EstadoSolicitud> ESTADOS_VIGENTES = EnumSet.of(
            EstadoSolicitud.RECIBIDA,
            EstadoSolicitud.EN_EVALUACION,
            EstadoSolicitud.OBSERVADA,
            EstadoSolicitud.APROBADA);

    private final SolicitudRepository solicitudRepository;
    private final BeneficiarioRepository beneficiarioRepository;
    private final UsuarioRepository usuarioRepository;
    private final DocumentoRespaldoService documentoRespaldoService;

    public SolicitudService(
            SolicitudRepository solicitudRepository,
            BeneficiarioRepository beneficiarioRepository,
            UsuarioRepository usuarioRepository,
            DocumentoRespaldoService documentoRespaldoService) {
        this.solicitudRepository = solicitudRepository;
        this.beneficiarioRepository = beneficiarioRepository;
        this.usuarioRepository = usuarioRepository;
        this.documentoRespaldoService = documentoRespaldoService;
    }

    @Transactional
    public Solicitud registrar(Solicitud solicitud, Beneficiario datosBeneficiario, String correoUsuario, MultipartFile archivo) {
        Beneficiario beneficiario = obtenerORegistrarBeneficiario(datosBeneficiario);
        if (solicitudRepository.existsByBeneficiarioIdAndEstadoIn(beneficiario.getId(), ESTADOS_VIGENTES)) {
            throw new IllegalArgumentException("El menor ya tiene una solicitud vigente.");
        }

        solicitud.setBeneficiario(beneficiario);
        solicitud.setCodigoSeguimiento(generarCodigoSeguimiento());
        solicitud.setUsuarioRegistro(buscarUsuarioPorCorreo(correoUsuario));

        DocumentoRespaldoService.DocumentoGuardado documento = documentoRespaldoService.guardar(archivo);
        if (documento != null) {
            solicitud.setDocumentoRespaldo(documento.nombre());
            solicitud.setTipoDocumentoRespaldo(documento.tipoContenido());
        }
        return solicitudRepository.save(solicitud);
    }

    @Transactional(readOnly = true)
    public Solicitud consultarPorCodigo(String codigo, String numeroDocumento) {
        Solicitud solicitud = solicitudRepository
                .findByCodigoSeguimiento(StringUtils.upperCase(StringUtils.trim(codigo), Locale.ROOT))
                .orElseThrow(() -> new IllegalArgumentException("No se encontró una solicitud con esos datos."));
        String documentoConsultado = StringUtils.trimToNull(numeroDocumento);
        String documentoBeneficiario = StringUtils.trimToNull(solicitud.getBeneficiario().getNumeroDocumento());
        if (documentoConsultado == null || !documentoConsultado.equals(documentoBeneficiario)) {
            throw new IllegalArgumentException("No se encontró una solicitud con esos datos.");
        }
        return solicitud;
    }

    @Transactional(readOnly = true)
    public List<Solicitud> buscarParaEvaluacion(EstadoSolicitud estado) {
        return solicitudRepository.buscarParaEvaluacion(estado);
    }

    @Transactional(readOnly = true)
    public Solicitud obtenerDetalle(Long id) {
        return solicitudRepository.buscarDetallePorId(id)
                .orElseThrow(() -> new IllegalArgumentException("No se encontró la solicitud solicitada."));
    }

    @Transactional
    public Solicitud iniciarEvaluacion(Long id) {
        Solicitud solicitud = obtenerDetalle(id);
        if (solicitud.getEstado() == EstadoSolicitud.RECIBIDA) {
            solicitud.setEstado(EstadoSolicitud.EN_EVALUACION);
        }
        return solicitudRepository.save(solicitud);
    }

    @Transactional
    public Solicitud registrarDecision(Long id, EstadoSolicitud decision, String motivo, String correoEvaluador) {
        if (decision != EstadoSolicitud.APROBADA && decision != EstadoSolicitud.OBSERVADA && decision != EstadoSolicitud.RECHAZADA) {
            throw new IllegalArgumentException("Seleccione una decisión válida para la evaluación.");
        }
        if (StringUtils.isBlank(motivo)) {
            throw new IllegalArgumentException("Registre el motivo de la decisión.");
        }
        Solicitud solicitud = obtenerDetalle(id);
        solicitud.setEstado(decision);
        solicitud.setMotivoEvaluacion(StringUtils.trim(motivo));
        solicitud.setFechaEvaluacion(LocalDateTime.now());
        solicitud.setEvaluador(buscarUsuarioPorCorreo(correoEvaluador));
        return solicitudRepository.save(solicitud);
    }

    private Beneficiario obtenerORegistrarBeneficiario(Beneficiario datosBeneficiario) {
        String documento = StringUtils.trimToNull(datosBeneficiario.getNumeroDocumento());
        if (documento != null) {
            return beneficiarioRepository.findByNumeroDocumento(documento)
                    .orElseGet(() -> beneficiarioRepository.save(datosBeneficiario));
        }
        return beneficiarioRepository.save(datosBeneficiario);
    }

    private Usuario buscarUsuarioPorCorreo(String correo) {
        if (StringUtils.isBlank(correo)) {
            return null;
        }
        return usuarioRepository.findByCorreo(StringUtils.lowerCase(StringUtils.trim(correo), Locale.ROOT)).orElse(null);
    }

    private String generarCodigoSeguimiento() {
        String codigo;
        do {
            codigo = "SOL-" + Year.now().getValue() + "-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase(Locale.ROOT);
        } while (solicitudRepository.existsByCodigoSeguimiento(codigo));
        return codigo;
    }
}
