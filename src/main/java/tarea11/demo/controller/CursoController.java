package tarea11.demo.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tarea11.demo.entities.Curso;
import tarea11.demo.services.CursoService;

import java.util.List;

@Controller
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping("/listar")
    public String listarCursos(Model model) {
        List<Curso> cursos = cursoService.findAll();
        model.addAttribute("cursos", cursos);
        model.addAttribute("titulo", "Listado de Cursos");
        return "cursos/listar";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/form")
    public String crearCursoForm(Model model) {
        Curso curso = new Curso();
        model.addAttribute("curso", curso);
        model.addAttribute("titulo", "Formulario de Curso");
        return "cursos/form";
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/form")
    public String guardarCurso(@Valid Curso curso, BindingResult result,
                               Model model, RedirectAttributes flash) {
        if(result.hasErrors()) {
            model.addAttribute("titulo", "Formulario de Curso");
            return "cursos/form";
        }

        cursoService.save(curso);
        flash.addFlashAttribute("success", "Curso guardado con éxito!");
        return "redirect:/cursos/listar";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/form/{id}")
    public String editarCurso(@PathVariable Long id, Model model, RedirectAttributes flash) {
        Curso curso = null;
        if(id > 0) {
            curso = cursoService.findById(id).orElse(null);
            if(curso == null) {
                flash.addFlashAttribute("error", "El curso no existe!");
                return "redirect:/cursos/listar";
            }
        } else {
            flash.addFlashAttribute("error", "ID de curso inválido!");
            return "redirect:/cursos/listar";
        }
        model.addAttribute("curso", curso);
        model.addAttribute("titulo", "Editar Curso");
        return "cursos/form";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/eliminar/{id}")
    public String eliminarCurso(@PathVariable Long id, RedirectAttributes flash) {
        if(id > 0) {
            cursoService.deleteById(id);
            flash.addFlashAttribute("success", "Curso eliminado con éxito!");
        }
        return "redirect:/cursos/listar";
    }

    @GetMapping("/ver/{id}")
    public String verCurso(@PathVariable Long id, Model model, RedirectAttributes flash) {
        Curso curso = cursoService.findById(id).orElse(null);
        if(curso == null) {
            flash.addFlashAttribute("error", "El curso no existe!");
            return "redirect:/cursos/listar";
        }
        model.addAttribute("curso", curso);
        model.addAttribute("titulo", "Detalle del Curso");
        return "cursos/ver";
    }
}