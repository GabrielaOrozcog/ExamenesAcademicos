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
        model.addAttribute("asignaturas", asignaturaServicio.getAllAsignaturas());
        return "asignaturas";
    }
    
    @GetMapping("/crear")
    public String formularioCrearAsignatura(Model model) {
        model.addAttribute("asignatura", new Asignatura());
        return "crearAsignatura";
    }
    
    @PostMapping("/crear")
    public String guardarAsignatura(@ModelAttribute("asignatura") Asignatura asignatura) {
        asignaturaServicio.createAsignatura(asignatura);
        return "redirect:/vistas/asignaturas";
    }
    
    @GetMapping("/editar/{id}")
    public String formularioEditarAsignatura(@PathVariable Integer id, Model model) {
        Asignatura asignatura = asignaturaServicio.getAsignaturaById(id);
        if (asignatura != null) {
            model.addAttribute("asignatura", asignatura);
            return "editarAsignatura";
        }
        return "redirect:/vistas/asignaturas";
    }
    
    @PostMapping("/editar/{id}")
    public String actualizarAsignatura(@PathVariable Integer id, @ModelAttribute("asignatura") Asignatura asignaturaDetails) {
        asignaturaServicio.updateAsignatura(id, asignaturaDetails);
        return "redirect:/vistas/asignaturas";
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminarAsignatura(@PathVariable Integer id) {
        asignaturaServicio.deleteAsignatura(id);
        return "redirect:/vistas/asignaturas";
    }
}
