package NutriApoyo.service;

import NutriApoyo.dao.BeneficiarioRepository;
import NutriApoyo.model.Beneficiario;
import NutriApoyo.model.EstadoBeneficiario;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BeneficiarioService {

    private final BeneficiarioRepository beneficiarioRepository;

    public BeneficiarioService(BeneficiarioRepository beneficiarioRepository) {
        this.beneficiarioRepository = beneficiarioRepository;
    }

    @Transactional(readOnly = true)
    public List<Beneficiario> buscar(String termino, EstadoBeneficiario estado, String distrito) {
        return beneficiarioRepository.buscar(
                StringUtils.defaultIfBlank(StringUtils.trim(termino), null),
                estado,
                StringUtils.defaultIfBlank(StringUtils.trim(distrito), null));
    }

    @Transactional(readOnly = true)
    public List<String> obtenerDistritos() {
        return beneficiarioRepository.encontrarDistritos();
    }

    @Transactional(readOnly = true)
    public Beneficiario obtenerPorId(Long id) {
        return beneficiarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No se encontró el beneficiario solicitado."));
    }

    @Transactional
    public Beneficiario registrar(Beneficiario beneficiario, String usuarioResponsable) {
        validarDocumentoUnico(beneficiario.getNumeroDocumento(), null);
        beneficiario.setUsuarioResponsable(usuarioResponsable);
        return beneficiarioRepository.save(beneficiario);
    }

    @Transactional
    public Beneficiario actualizar(Long id, Beneficiario datosFormulario) {
        Beneficiario beneficiarioActual = obtenerPorId(id);
        validarDocumentoUnico(datosFormulario.getNumeroDocumento(), id);

        beneficiarioActual.setNombres(datosFormulario.getNombres());
        beneficiarioActual.setApellidos(datosFormulario.getApellidos());
        beneficiarioActual.setFechaNacimiento(datosFormulario.getFechaNacimiento());
        beneficiarioActual.setSexo(datosFormulario.getSexo());
        beneficiarioActual.setTipoDocumento(datosFormulario.getTipoDocumento());
        beneficiarioActual.setNumeroDocumento(datosFormulario.getNumeroDocumento());
        beneficiarioActual.setDireccion(datosFormulario.getDireccion());
        beneficiarioActual.setDistrito(datosFormulario.getDistrito());
        beneficiarioActual.setTutorNombres(datosFormulario.getTutorNombres());
        beneficiarioActual.setTutorDocumento(datosFormulario.getTutorDocumento());
        beneficiarioActual.setTutorTelefono(datosFormulario.getTutorTelefono());
        beneficiarioActual.setTutorCorreo(datosFormulario.getTutorCorreo());
        beneficiarioActual.setRelacionTutor(datosFormulario.getRelacionTutor());
        beneficiarioActual.setEstado(datosFormulario.getEstado());
        beneficiarioActual.setObservaciones(datosFormulario.getObservaciones());
        return beneficiarioRepository.save(beneficiarioActual);
    }

    private void validarDocumentoUnico(String numeroDocumento, Long idActual) {
        String documento = StringUtils.trimToNull(numeroDocumento);
        if (documento == null) {
            return;
        }
        boolean yaExiste = idActual == null
                ? beneficiarioRepository.findByNumeroDocumento(documento).isPresent()
                : beneficiarioRepository.existsByNumeroDocumentoAndIdNot(documento, idActual);
        if (yaExiste) {
            throw new IllegalArgumentException("Ya existe un beneficiario con ese número de documento.");
        }
    }
}
