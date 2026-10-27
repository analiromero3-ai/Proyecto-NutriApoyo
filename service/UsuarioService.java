package NutriApoyo.service;

import NutriApoyo.dao.UsuarioRepository;
import NutriApoyo.model.RolUsuario;
import NutriApoyo.model.Usuario;
import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public Usuario registrarAdministradorInicial(String nombres, String apellidos, String correo, String contrasena) {
        // Guava deja clara la precondición antes de persistir una cuenta de inicio.
        Preconditions.checkArgument(StringUtils.isNotBlank(nombres), "Los nombres son obligatorios.");
        Preconditions.checkArgument(StringUtils.isNotBlank(apellidos), "Los apellidos son obligatorios.");
        Preconditions.checkArgument(StringUtils.isNotBlank(correo), "El correo es obligatorio.");
        Preconditions.checkArgument(StringUtils.isNotBlank(contrasena), "La contraseña es obligatoria.");

        String correoNormalizado = StringUtils.lowerCase(StringUtils.trim(correo), Locale.ROOT);
        if (usuarioRepository.findByCorreo(correoNormalizado).isPresent()) {
            throw new IllegalArgumentException("Ya existe un usuario con ese correo.");
        }

        Usuario usuario = new Usuario();
        usuario.setNombres(StringUtils.trim(nombres));
        usuario.setApellidos(StringUtils.trim(apellidos));
        usuario.setCorreo(correoNormalizado);
        usuario.setContrasena(passwordEncoder.encode(contrasena));
        usuario.setRol(RolUsuario.ADMINISTRADOR);
        usuario.setActivo(true);
        return usuarioRepository.save(usuario);
    }
}
