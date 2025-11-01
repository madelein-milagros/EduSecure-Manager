package tarea11.demo.persistence;

import tarea11.demo.entities.Curso;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface CursoDao extends CrudRepository<Curso, Long> {
    List<Curso> findAll();
    List<Curso> findByNombreContainingIgnoreCase(String nombre);
}