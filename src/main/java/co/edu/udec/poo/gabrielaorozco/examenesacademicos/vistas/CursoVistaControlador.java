/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.gabrielaorozco.examenesacademicos.vistas;

/**
 *
 * @author Gabriela
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Curso;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.CursoServicio;

@Controller
@RequestMapping("/vistas/cursos")
public class CursoVistaControlador {
    @Autowired
    private CursoServicio cursoServicio;
<<<<<<< HEAD

    @GetMapping
    public String listarCursos(Model model) {
        model.addAttribute("cursos", cursoServicio.getAllCursos());
        return "cursos";
    }

    @GetMapping("/crear")
    public String formularioCrearCurso(Model model) {
        model.addAttribute("curso", new Curso());
        return "crearCurso";
    }

    @PostMapping("/crear")
    public String guardarCurso(@ModelAttribute("curso") Curso curso) {
        cursoServicio.createCurso(curso);
        return "redirect:/vistas/cursos";
    }

    @GetMapping("/editar/{id}")
    public String formularioEditarCurso(@PathVariable Integer id, Model model) {
        Curso curso = cursoServicio.getCursoById(id);
        if (curso != null) {
            model.addAttribute("curso", curso);
            return "editarCurso";
        } else {
            return "redirect:/vistas/cursos";
        }
    }

    @PostMapping("/editar/{id}")
    public String actualizarCurso(@PathVariable Integer id, @ModelAttribute("curso") Curso cursoDetails) {
        cursoServicio.updateCurso(id, cursoDetails);
        return "redirect:/vistas/cursos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCurso(@PathVariable Integer id) {
        cursoServicio.deleteCurso(id);
        return "redirect:/vistas/cursos";
    }
=======
    
    
    @GetMapping
    public String listarCursos(Model model) {
        try {
            model.addAttribute("cursos", cursoServicio.getAllCursos());
        } catch (Exception e) {
            model.addAttribute("error", "Error al listar cursos: " + e.getMessage());
        }
        return "cursos";
    }
    
    
    @GetMapping("/crear")
    public String formularioCrearCurso(Model model) {
        try {
            model.addAttribute("curso", new Curso());
            return "crearCurso";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar formulario: " + e.getMessage());
            return "redirect:/vistas/cursos";
        }
    }
    
    
    @PostMapping("/crear")
    public String guardarCurso(@ModelAttribute("curso") Curso curso, Model model) {
         try {
             cursoServicio.createCurso(curso);
             return "redirect:/vistas/cursos";
            } catch (Exception e) {
               model.addAttribute("error", "Error al guardar el curso: " + e.getMessage());
        return "crearCurso";
        }
    }

    
    @GetMapping("/editar/{id}")
    public String formularioEditarCurso(@PathVariable Integer id, Model model) {
        try {
            Curso curso = cursoServicio.getCursoById(id);
            model.addAttribute("curso", curso);
            return "editarCurso";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el curso: " + e.getMessage());
            return "redirect:/vistas/cursos";
        }
    }
    
    
    @PostMapping("/editar/{id}")
    public String actualizarCurso(@PathVariable Integer id, @ModelAttribute("curso") Curso cursoDetails, Model model) {
        try {
            cursoServicio.updateCurso(id, cursoDetails);
            return "redirect:/vistas/cursos";
        } catch (Exception e) {
            model.addAttribute("error", "Error al actualizar el curso: " + e.getMessage());
            return "editarCurso";
        }
    }

    
    @GetMapping("/eliminar/{id}")
    public String eliminarCurso(@PathVariable Integer id, Model model) {
        try {
            cursoServicio.deleteCurso(id);
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar el curso: " + e.getMessage());
        }
        return "redirect:/vistas/cursos";
    }
    
    
    @GetMapping("/contar")
    public String contarCursos(Model model) {
    try {
        Integer totalCursos = cursoServicio.contarCursos();
        model.addAttribute("totalCursos", totalCursos);
        } catch (Exception e) {
        model.addAttribute("error", "Error al contar cursos: " + e.getMessage());
        }
        return "cursos";
    }

>>>>>>> Gabriela
}
