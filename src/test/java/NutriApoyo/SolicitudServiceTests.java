package NutriApoyo;

import NutriApoyo.dao.BeneficiarioRepository;
import NutriApoyo.dao.SolicitudRepository;
import NutriApoyo.model.Beneficiario;
import NutriApoyo.model.CondicionAnemiaDeclarada;
import NutriApoyo.model.Solicitud;
import NutriApoyo.service.SolicitudService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SolicitudServiceTests {

    @Autowired
    private SolicitudService solicitudService;

    @Autowired
    private SolicitudRepository solicitudRepository;

    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    @BeforeEach
    void prepararBaseDePrueba() {
        solicitudRepository.deleteAll();
        beneficiarioRepository.deleteAll();
    }

    @Test
    void registraCodigoYEvitaSolicitudVigenteDuplicada() {
        Solicitud registrada = solicitudService.registrar(crearSolicitud(), crearBeneficiario(), null, null);

        assertNotNull(registrada.getCodigoSeguimiento());
        assertTrue(registrada.getCodigoSeguimiento().startsWith("SOL-"));

        assertThrows(IllegalArgumentException.class,
                () -> solicitudService.registrar(crearSolicitud(), crearBeneficiario(), null, null));
    }

    private Beneficiario crearBeneficiario() {
        Beneficiario beneficiario = new Beneficiario();
        beneficiario.setNombres("Menor");
        beneficiario.setApellidos("De Prueba");
        beneficiario.setFechaNacimiento(LocalDate.now().minusYears(8));
        beneficiario.setNumeroDocumento("DOC-PRUEBA-001");
        beneficiario.setDireccion("Dirección ficticia");
        beneficiario.setDistrito("Piura");
        beneficiario.setTutorNombres("Tutor de Prueba");
        beneficiario.setTutorTelefono("999999999");
        beneficiario.setRelacionTutor("Madre");
        return beneficiario;
    }

    private Solicitud crearSolicitud() {
        Solicitud solicitud = new Solicitud();
        solicitud.setCondicionAnemia(CondicionAnemiaDeclarada.RIESGO_DECLARADO);
        solicitud.setConsentimientoDatos(true);
        return solicitud;
    }
}
