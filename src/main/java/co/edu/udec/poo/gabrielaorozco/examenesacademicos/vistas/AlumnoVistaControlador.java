/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Gabriela
 */
package co.edu.udec.poo.gabrielaorozco.examenesacademicos.vistas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Alumno;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.AlumnoServicio;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.CursoServicio;

@Controller
@RequestMapping("/vistas/alumnos")
public class AlumnoVistaControlador {

    @Autowired
    private AlumnoServicio alumnoServicio;
    
    @Autowired
    private CursoServicio cursoServicio;
    
    
    @GetMapping ("/listar")
    public String listarAlumnos(Model model) {
<<<<<<< HEAD
        model.addAttribute("alumnos", alumnoServicio.getAllAlumnos());
=======
        try {
            model.addAttribute("alumnos", alumnoServicio.getAllAlumnos());
        } catch (Exception e) {
            model.addAttribute("error", "Error al listar alumnos: " + e.getMessage());
        }
>>>>>>> Gabriela
        return "alumnos";
    }
    
    
    @GetMapping("/crear")
    public String formularioCrearAlumno(Model model) {
        try {
            model.addAttribute("alumno", new Alumno());
            model.addAttribute("cursos", cursoServicio.getAllCursos());
            return "crearAlumno";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar formulario: " + e.getMessage());
            return "redirect:/vistas/alumnos";
        }
    }
    
    
    @PostMapping("/crear")
    public String guardarAlumno(@ModelAttribute("alumno") Alumno alumno, @RequestParam("cursoId") int cursoId, Model model) {
         try {
             alumno.setCurso(cursoServicio.getCursoById(cursoId));
             alumnoServicio.createAlumno(alumno);
             return "redirect:/vistas/alumnos";
            } catch (Exception e) {
               model.addAttribute("error", "Error al guardar el alumno: " + e.getMessage());
         try {
              model.addAttribute("cursos", cursoServicio.getAllCursos());
             } catch (Exception ex) {
                model.addAttribute("errorCursos", "No se pudo cargar la lista de cursos: " + ex.getMessage());
            }
        return "crearAlumno";
        }
    }


    @GetMapping("/editar/{id}")
    public String formularioEditarAlumno(@PathVariable Integer id, Model model) {
        try {
            Alumno alumno = alumnoServicio.getAlumnoById(id);
            model.addAttribute("alumno", alumno);
            model.addAttribute("cursos", cursoServicio.getAllCursos());
            return "editarAlumno";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el alumno: " + e.getMessage());
            return "redirect:/vistas/alumnos";
        }
    }

    @PostMapping("/editar/{id}")
    public String actualizarAlumno(@PathVariable Integer id, @ModelAttribute("alumno") Alumno alumnoDetails, Model model) {
        try {
            alumnoServicio.updateAlumno(id, alumnoDetails);
            return "redirect:/vistas/alumnos";
        } catch (Exception e) {
            model.addAttribute("error", "Error al actualizar el alumno: " + e.getMessage());
            return "editarAlumno";
        }
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarAlumno(@PathVariable Integer id, Model model) {
        try {
            alumnoServicio.deleteAlumno(id);
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar el alumno: " + e.getMessage());
        }
        return "redirect:/vistas/alumnos";
    }
    
    
    @GetMapping("/contar")
    public String contarAlumnos(Model model) {
    try {
        Integer totalAlumnos = alumnoServicio.contarAlumnos();
        model.addAttribute("totalAlumnos", totalAlumnos);
        } catch (Exception e) {
        model.addAttribute("error", "Error al contar alumnos: " + e.getMessage());
        }
        return "alumnos";
    }

}