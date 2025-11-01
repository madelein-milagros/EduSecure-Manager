package tarea11.demo.persistence;

import tarea11.demo.entities.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDao extends CrudRepository<Usuario, Long> {
    Usuario findByUsername(String username);
}