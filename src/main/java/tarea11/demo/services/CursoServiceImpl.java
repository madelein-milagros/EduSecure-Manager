package tarea11.demo.services;

import tarea11.demo.entities.Curso;
import tarea11.demo.persistence.CursoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoDao cursoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Curso> findAll() {
        return cursoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Curso> findById(Long id) {
        return cursoDao.findById(id);
    }

    @Override
    @Transactional
    public Curso save(Curso curso) {
        return cursoDao.save(curso);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        cursoDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Curso> findByNombre(String nombre) {
        return cursoDao.findByNombreContainingIgnoreCase(nombre);
    }
}