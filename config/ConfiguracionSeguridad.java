package NutriApoyo.config;

import NutriApoyo.dao.UsuarioRepository;
import NutriApoyo.model.Usuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class ConfiguracionSeguridad {

    @Bean
    SecurityFilterChain filtroSeguridad(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(autorizacion -> autorizacion
                .requestMatchers("/login", "/css/**").permitAll()
                .requestMatchers("/administracion/**").hasRole("ADMINISTRADOR")
                .requestMatchers("/evaluaciones/**").hasAnyRole("ADMINISTRADOR", "EVALUADOR")
                .requestMatchers("/salud/**").hasAnyRole("ADMINISTRADOR", "PERSONAL_SALUD")
                .requestMatchers("/tutoria/**").hasAnyRole("ADMINISTRADOR", "TUTOR")
                .anyRequest().authenticated())
            .formLogin(login -> login
                .loginPage("/login")
                .defaultSuccessUrl("/inicio", true)
                .failureUrl("/login?error=true")
                .permitAll())
            .logout(logout -> logout
                .logoutSuccessUrl("/login?salida=true")
                .permitAll());
        return http.build();
    }

    @Bean
    PasswordEncoder codificadorContrasena() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    UserDetailsService servicioDetalleUsuario(UsuarioRepository usuarioRepository) {
        return correo -> {
            Usuario usuario = usuarioRepository.findByCorreo(correo.trim().toLowerCase())
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado."));

            return org.springframework.security.core.userdetails.User.withUsername(usuario.getCorreo())
                .password(usuario.getContrasena())
                .authorities(new SimpleGrantedAuthority("ROLE_" + usuario.getRol().name()))
                .disabled(!usuario.isActivo())
                .build();
        };
    }
}
