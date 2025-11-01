package tarea11.demo.config;

import tarea11.demo.entities.Rol;
import tarea11.demo.entities.Usuario;
import tarea11.demo.persistence.UsuarioDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(DataInitializer.class);

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    @Lazy  // AÑADE esta anotación
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        Thread.sleep(1000);

        // Crear usuarios de prueba si no existen
        if(usuarioDao.findByUsername("admin") == null) {
            Usuario admin = new Usuario();
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("12345"));
            admin.setEnabled(true);

            Rol rolAdmin = new Rol();
            rolAdmin.setAuthority("ROLE_ADMIN");
            admin.setRoles(Arrays.asList(rolAdmin));

            usuarioDao.save(admin);
            log.info("Usuario admin creado: admin / 12345");
        }

        if(usuarioDao.findByUsername("user") == null) {
            Usuario user = new Usuario();
            user.setUsername("user");
            user.setPassword(passwordEncoder.encode("12345"));
            user.setEnabled(true);

            Rol rolUser = new Rol();
            rolUser.setAuthority("ROLE_USER");
            user.setRoles(Arrays.asList(rolUser));

            usuarioDao.save(user);
            log.info("Usuario user creado: user / 12345");
        }
    }
}