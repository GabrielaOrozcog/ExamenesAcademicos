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
        model.addAttribute("examenes", examenServicio.getAllExamenes());
        return "examenes";
    }
    
    @GetMapping("/crear")
    public String formularioCrearExamen(Model model) {
        model.addAttribute("examen", new Examen());
        return "crearExamen";
    }
    
    @PostMapping("/crear")
    public String guardarExamen(@ModelAttribute("examen") Examen examen) {
        examenServicio.createExamen(examen);
        return "redirect:/vistas/examenes";
    }
    
    @GetMapping("/editar/{id}")
    public String formularioEditarExamen(@PathVariable Integer id, Model model) {
        Examen examen = examenServicio.getExamenById(id);
        if (examen != null) {
            model.addAttribute("examen", examen);
            return "editarExamen";
        }
        return "redirect:/vistas/examenes";
    }
    
    @PostMapping("/editar/{id}")
    public String actualizarExamen(@PathVariable Integer id, @ModelAttribute("examen") Examen examenDetails) {
        examenServicio.updateExamen(id, examenDetails);
        return "redirect:/vistas/examenes";
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminarExamen(@PathVariable Integer id) {
        examenServicio.deleteExamen(id);
        return "redirect:/vistas/examenes";
    }
}
