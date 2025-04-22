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
    
    @GetMapping
    public String listarAlumnos(Model model) {
        model.addAttribute("alumnos", alumnoServicio.getAllAlumnos());
        return "alumnos"; // nombre de la vista (template) sin extensión
    }


    @GetMapping("/crear")
    public String formularioCrearAlumno(Model model) {
        model.addAttribute("alumno", new Alumno());
        model.addAttribute("cursos", cursoServicio.getAllCursos());
        return "crearAlumno";
    }

    @PostMapping("/crear")
    public String guardarAlumno(@ModelAttribute("alumno") Alumno alumno, @RequestParam("cursoId") int cursoId) {
        alumno.setCurso(cursoServicio.getCursoById(cursoId));
        alumnoServicio.createAlumno(alumno);
        return "redirect:/vistas/alumnos";
    }

    @GetMapping("/editar/{id}")
    public String formularioEditarAlumno(@PathVariable Integer id, Model model) {
        Alumno alumno = alumnoServicio.getAlumnoById(id);
        if (alumno != null) {
            model.addAttribute("alumno", alumno);
            return "editarAlumno";
        } else {
            return "redirect:/vistas/alumnos";
        }
    }

    @PostMapping("/editar/{id}")
    public String actualizarAlumno(@PathVariable Integer id, @ModelAttribute("alumno") Alumno alumnoDetails) {
        alumnoServicio.updateAlumno(id, alumnoDetails);
        return "redirect:/vistas/alumnos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarAlumno(@PathVariable Integer id) {
        alumnoServicio.deleteAlumno(id);
        return "redirect:/vistas/alumnos";
    }
}