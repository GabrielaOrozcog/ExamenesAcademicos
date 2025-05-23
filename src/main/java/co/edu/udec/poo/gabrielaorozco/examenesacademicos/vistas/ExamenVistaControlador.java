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
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Examen;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.ExamenServicio;

@Controller
@RequestMapping("/vistas/examenes")
public class ExamenVistaControlador {
    @Autowired
    private ExamenServicio examenServicio;
    
    
    @GetMapping
    public String listarExamenes(Model model) {
        try {
            model.addAttribute("examenes", examenServicio.getAllExamenes());
        } catch (Exception e) {
            model.addAttribute("error", "Error al listar examenes : " + e.getMessage());
        }
        return "examenes";
    }
    
    
    @GetMapping("/crear")
    public String formularioCrearExamen(Model model) {
        try {
            model.addAttribute("examen", new Examen());
            return "crearExamen";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar formulario: " + e.getMessage());
            return "redirect:/vistas/examenes";
        }
    }
    
    
    @PostMapping("/crear")
    public String guardarExamen(@ModelAttribute("examen") Examen examen, Model model) {
       try {
           examenServicio.createExamen(examen);
           return "redirect:/vistas/examenes";
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el examen : " + e.getMessage());
            return "crearExamen";
        }
    
    }
    
    
    @GetMapping("/editar/{id}")
    public String formularioEditarExamen(@PathVariable Integer id, Model model) {
        try {
            Examen examen = examenServicio.getExamenById(id);
            model.addAttribute("examen", examen);
            return "editarExamen";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el examen : " + e.getMessage());
            return "redirect:/vistas/examenes";
        }
    }
    
    
    @PostMapping("/editar/{id}")
    public String actualizarExamen(@PathVariable Integer id, @ModelAttribute("examen") Examen examenDetails, Model model) {
        try {
            examenServicio.updateExamen(id, examenDetails);
            return "redirect:/vistas/examenes";
        } catch (Exception e) {
            model.addAttribute("error", "Error al actualizar el examen : " + e.getMessage());
            return "editarExamen";
        }
    }
    
    
    @GetMapping("/eliminar/{id}")
    public String eliminarExamen(@PathVariable Integer id, Model model) {
        try {
            examenServicio.deleteExamen(id);
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar el examen : " + e.getMessage());
        }
        return "redirect:/vistas/examenes";
    }
    
    
    @GetMapping("/contar")
    public String contarExamenes(Model model) {
    try {
        Integer totalExamenes = examenServicio.contarExamenes();
        model.addAttribute("totalExamenes", totalExamenes);
        } catch (Exception e) {
        model.addAttribute("error", "Error al contar examenes : " + e.getMessage());
        }
        return "alumnos";
    }
    
}
