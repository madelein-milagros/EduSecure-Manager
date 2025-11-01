package tarea11.demo.config;

import tarea11.demo.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
@EnableMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SpringSecurityConfig {

    @Autowired
    private UsuarioService usuarioService;

    // QUITA el @Bean de aquí y ponlo en una clase separada
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
        build.userDetailsService(usuarioService)
                .passwordEncoder(passwordEncoder);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authz -> authz
                        .requestMatchers("/", "/css/**", "/js/**", "/images/**", "/locale").permitAll()
                        .requestMatchers("/cursos/ver/**").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/cursos/form/**", "/cursos/eliminar/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .permitAll()
                )
                .logout(logout -> logout
                        .permitAll()
                )
                .exceptionHandling(ex -> ex
                        .accessDeniedPage("/error_403")
                );
        return http.build();
    }
}