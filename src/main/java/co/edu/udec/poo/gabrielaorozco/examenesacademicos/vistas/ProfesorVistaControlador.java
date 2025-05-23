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
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Profesor;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.ProfesorServicio;

@Controller
@RequestMapping("/vistas/profesores")
public class ProfesorVistaControlador {
    @Autowired
    private ProfesorServicio profesorServicio;
    
    @GetMapping
    public String listarProfesores(Model model) {
<<<<<<< HEAD
        model.addAttribute("profesores", profesorServicio.getAllProfesores());
        return "profesores";
    }
    
    @GetMapping("/crear")
    public String formularioCrearProfesor(Model model) {
        model.addAttribute("profesor", new Profesor());
        return "crearProfesor";
    }
    
    @PostMapping("/crear")
    public String guardarProfesor(@ModelAttribute("profesor") Profesor profesor) {
        profesorServicio.createProfesor(profesor);
        return "redirect:/vistas/profesores";
    }
    
    @GetMapping("/editar/{id}")
    public String formularioEditarProfesor(@PathVariable Integer id, Model model) {
        Profesor profesor = profesorServicio.getProfesorById(id);
        if (profesor != null) {
            model.addAttribute("profesor", profesor);
            return "editarProfesor";
=======
        try {
            model.addAttribute("profesores", profesorServicio.getAllProfesores());
        } catch (Exception e) {
            model.addAttribute("error", "Error al listar profesores : " + e.getMessage());
        }
        return "profesores";
    }
    
    
    @GetMapping("/crear")
    public String formularioCrearProfesor(Model model) {
        try {
            model.addAttribute("profesor", new Profesor());
            return "crearProfesor";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar formulario: " + e.getMessage());
            return "redirect:/vistas/profesores";
        }
    }
    
    
    @PostMapping("/crear")
    public String guardarProfesor(@ModelAttribute("profesor") Profesor profesor, Model model) {
         try {
             profesorServicio.createProfesor(profesor);
             return "redirect:/vistas/profesores";
            } catch (Exception e) {
               model.addAttribute("error", "Error al guardar el profesor : " + e.getMessage());
              return "crearProfesor";
        }
    }
    
    
    @GetMapping("/editar/{id}")
    public String formularioEditarProfesor(@PathVariable Integer id, Model model) {
        try {
            Profesor profesor = profesorServicio.getProfesorById(id);
            model.addAttribute("profesor", profesor);
            return "editarProfesor";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el profesor : " + e.getMessage());
            return "redirect:/vistas/profesores";
        }
    }
    
    
    @PostMapping("/editar/{id}")
    public String actualizarProfesor(@PathVariable Integer id, @ModelAttribute("profesor") Profesor profesorDetails, Model model) {
        try {
            profesorServicio.updateProfesor(id, profesorDetails);
            return "redirect:/vistas/profesores";
        } catch (Exception e) {
            model.addAttribute("error", "Error al actualizar el profesor: " + e.getMessage());
            return "editarProfesor";
        }
    }
    
    
    @GetMapping("/eliminar/{id}")
    public String eliminarProfesor(@PathVariable Integer id, Model model) {
        try {
            profesorServicio.deleteProfesor(id);
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar el profesor : " + e.getMessage());
>>>>>>> Gabriela
        }
        return "redirect:/vistas/profesores";
    }
    
<<<<<<< HEAD
    @PostMapping("/editar/{id}")
    public String actualizarProfesor(@PathVariable Integer id, @ModelAttribute("profesor") Profesor profesorDetails) {
        profesorServicio.updateProfesor(id, profesorDetails);
        return "redirect:/vistas/profesores";
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminarProfesor(@PathVariable Integer id) {
        profesorServicio.deleteProfesor(id);
        return "redirect:/vistas/profesores";
    }
=======
    
    @GetMapping("/contar")
    public String contarProfesores(Model model) {
    try {
        Integer totalProfesores = profesorServicio.contarProfesores();
        model.addAttribute("totalProfesores", totalProfesores);
        } catch (Exception e) {
        model.addAttribute("error", "Error al contar profesores : " + e.getMessage());
        }
        return "profesores";
    }
    
>>>>>>> Gabriela
}
