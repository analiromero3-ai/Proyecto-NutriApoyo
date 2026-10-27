package NutriApoyo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class SolicitudControllerTests {

    @Autowired
    private WebApplicationContext contextoWeb;

    private MockMvc mockMvc;

    @BeforeEach
    void prepararMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(contextoWeb).build();
    }

    @Test
    void muestraFormularioPublicoDeSolicitud() throws Exception {
        mockMvc.perform(get("/solicitudes/nueva"))
                .andExpect(status().isOk())
                .andExpect(content().string(org.hamcrest.Matchers.containsString("Registrar solicitud")));
    }

    @Test
    void muestraConsultaPublicaDeSeguimiento() throws Exception {
        mockMvc.perform(get("/seguimiento"))
                .andExpect(status().isOk())
                .andExpect(content().string(org.hamcrest.Matchers.containsString("Consultar solicitud")));
    }
}
