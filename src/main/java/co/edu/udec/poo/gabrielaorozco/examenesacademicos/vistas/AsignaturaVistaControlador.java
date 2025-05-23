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
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Asignatura;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.AsignaturaServicio;

@Controller
@RequestMapping("/vistas/asignaturas")
public class AsignaturaVistaControlador {
    @Autowired
    private AsignaturaServicio asignaturaServicio;
    
    
    @GetMapping
    public String listarAsignaturas(Model model) {
        try {
            model.addAttribute("asignaturas", asignaturaServicio.getAllAsignaturas());
        } catch (Exception e) {
            model.addAttribute("error", "Error al listar asignaturas: " + e.getMessage());
        }
        return "asignaturas";
    }
    
    
    @GetMapping("/crear")
    public String formularioCrearAsignatura(Model model) {
        try {
            model.addAttribute("asignatura", new Asignatura());
            return "crearAsignatura";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar formulario: " + e.getMessage());
            return "redirect:/vistas/asignaturas";
        }
    }
    
    
    @PostMapping("/crear")
    public String guardarAsignatura(@ModelAttribute("asignatura") Asignatura asignatura, Model model) {
       try {
           asignaturaServicio.createAsignatura(asignatura);
           return "redirect:/vistas/asignatura";
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar la asignatura: " + e.getMessage());
            return "crearAsigantura";
        }
    
    }
    
    
    @GetMapping("/editar/{id}")
    public String formularioEditarAsignatura(@PathVariable Integer id, Model model) {
        try {
            Asignatura asignatura = asignaturaServicio.getAsignaturaById(id);
            model.addAttribute("asignatura", asignatura);
            return "editarAsignatura";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar la asignatura: " + e.getMessage());
            return "redirect:/vistas/asignatura";
        }
    }
    
    
    @PostMapping("/editar/{id}")
    public String actualizarAsignatura(@PathVariable Integer id, @ModelAttribute("asignatura") Asignatura asignaturaDetails, Model model) {
        try {
            asignaturaServicio.updateAsignatura(id, asignaturaDetails);
            return "redirect:/vistas/asignatura";
        } catch (Exception e) {
            model.addAttribute("error", "Error al actualizar la asignatura: " + e.getMessage());
            return "editarAsignatura";
        }
    }
    
    
    @GetMapping("/eliminar/{id}")
    public String eliminarAsignatura(@PathVariable Integer id, Model model) {
        try {
            asignaturaServicio.deleteAsignatura(id);
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar la asignatura: " + e.getMessage());
        }
        return "redirect:/vistas/asignatura";
    }
    
    
    @GetMapping("/contar")
    public String contarAsignaturas(Model model) {
    try {
        Integer totalAsignaturas = asignaturaServicio.contarAsignaturas();
        model.addAttribute("totalAsignaturas", totalAsignaturas);
        } catch (Exception e) {
        model.addAttribute("error", "Error al contar asignaturas : " + e.getMessage());
        }
        return "asignaturas";
    }
    
}
