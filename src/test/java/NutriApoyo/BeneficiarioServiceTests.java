package NutriApoyo;

import NutriApoyo.model.Beneficiario;
import NutriApoyo.model.EstadoBeneficiario;
import NutriApoyo.service.BeneficiarioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BeneficiarioServiceTests {

    @Autowired
    private BeneficiarioService beneficiarioService;

    @Test
    void registraFechaEnServidorYLaConservaAlEditar() {
        String documento = "DOC-" + UUID.randomUUID().toString().substring(0, 12);
        Beneficiario creado = beneficiarioService.registrar(crearBeneficiario(documento), "prueba@nutriapoyo.local");
        LocalDate fechaOriginal = creado.getFechaRegistro();

        Beneficiario cambios = crearBeneficiario(documento);
        cambios.setDistrito("Castilla");
        cambios.setEstado(EstadoBeneficiario.INACTIVO);
        Beneficiario actualizado = beneficiarioService.actualizar(creado.getId(), cambios);

        assertNotNull(fechaOriginal);
        assertEquals(creado.getId(), actualizado.getId());
        assertEquals(fechaOriginal, actualizado.getFechaRegistro());
        assertEquals(EstadoBeneficiario.INACTIVO, actualizado.getEstado());
    }

    private Beneficiario crearBeneficiario(String documento) {
        Beneficiario beneficiario = new Beneficiario();
        beneficiario.setNombres("Menor");
        beneficiario.setApellidos("Prueba");
        beneficiario.setFechaNacimiento(LocalDate.now().minusYears(10));
        beneficiario.setNumeroDocumento(documento);
        beneficiario.setDireccion("Dirección ficticia");
        beneficiario.setDistrito("Piura");
        beneficiario.setTutorNombres("Tutor de prueba");
        beneficiario.setTutorTelefono("999999999");
        beneficiario.setRelacionTutor("Madre");
        return beneficiario;
    }
}
