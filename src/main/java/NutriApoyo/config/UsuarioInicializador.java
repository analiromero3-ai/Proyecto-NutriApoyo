package NutriApoyo.config;

import NutriApoyo.dao.UsuarioRepository;
import NutriApoyo.service.UsuarioService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

@Configuration
public class UsuarioInicializador {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioInicializador.class);

    @Bean
    @ConditionalOnProperty(
            prefix = "nutriapoyo.usuario-inicial",
            name = "habilitado",
            havingValue = "true",
            matchIfMissing = false)
    ApplicationRunner crearAdministradorInicial(
            UsuarioRepository usuarioRepository,
            UsuarioService usuarioService,
            @Value("${nutriapoyo.usuario-inicial.nombres}") String nombres,
            @Value("${nutriapoyo.usuario-inicial.apellidos}") String apellidos,
            @Value("${nutriapoyo.usuario-inicial.correo}") String correo,
            @Value("${nutriapoyo.usuario-inicial.contrasena}") String contrasena) {
        return argumentos -> {
            if (StringUtils.isAnyBlank(nombres, apellidos, correo, contrasena)) {
                LOGGER.warn("No se creó el usuario inicial: faltan variables de configuración obligatorias.");
                return;
            }

            String correoNormalizado = StringUtils.lowerCase(StringUtils.trim(correo), Locale.ROOT);
            if (usuarioRepository.findByCorreo(correoNormalizado).isPresent()) {
                LOGGER.info("No se creó el usuario inicial porque el correo configurado ya existe.");
                return;
            }

            usuarioService.registrarAdministradorInicial(nombres, apellidos, correo, contrasena);
            LOGGER.info("Se creó el administrador inicial de NutriApoyo.");
        };
    }
}
