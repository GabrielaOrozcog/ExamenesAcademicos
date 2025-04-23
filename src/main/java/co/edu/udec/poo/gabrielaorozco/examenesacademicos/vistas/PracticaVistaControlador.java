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
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Practica;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.PracticaServicio;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.ProfesorServicio;

@Controller
@RequestMapping("/vistas/practicas")
public class PracticaVistaControlador {
    @Autowired
    private PracticaServicio practicaServicio;
    
    @Autowired
    private ProfesorServicio profesorServicio;
    
    @GetMapping
    public String listarPracticas(Model model) {
        model.addAttribute("practicas", practicaServicio.getAllPracticas());
        return "practicas";  
    }
    
    @GetMapping("/crear")
    public String formularioCrearPractica(Model model) {
        model.addAttribute("practica", new Practica());
        model.addAttribute("listaProfesores", profesorServicio.getAllProfesores());
        return "crearPractica";  
    }
    
    @PostMapping("/crear")
    public String guardarPractica(@ModelAttribute("practica") Practica practica,
                                  @RequestParam(value = "profesoresSeleccionados", required = false) Integer[] profesoresIds) {
        if (profesoresIds != null) {
            java.util.List<co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Profesor> profesores = new java.util.ArrayList<>();
            for (Integer id : profesoresIds) {
                profesores.add(profesorServicio.getProfesorById(id));
            }
            practica.setProfesores(profesores);
        }
        practicaServicio.createPractica(practica);
        return "redirect:/vistas/practicas";
    }
    
    @GetMapping("/editar/{id}")
    public String formularioEditarPractica(@PathVariable Integer id, Model model) {
        Practica practica = practicaServicio.getPracticaById(id);
        if (practica != null) {
            model.addAttribute("practica", practica);
            model.addAttribute("listaProfesores", profesorServicio.getAllProfesores());
            return "editarPractica";  
        }
        return "redirect:/vistas/practicas";
    }
    
    @PostMapping("/editar/{id}")
    public String actualizarPractica(@PathVariable Integer id, 
                                     @ModelAttribute("practica") Practica practicaDetails,
                                     @RequestParam(value = "profesoresSeleccionados", required = false) Integer[] profesoresIds) {
        if (profesoresIds != null) {
            java.util.List<co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Profesor> profesores = new java.util.ArrayList<>();
            for (Integer profId : profesoresIds) {
                profesores.add(profesorServicio.getProfesorById(profId));
            }
            practicaDetails.setProfesores(profesores);
        }
        practicaServicio.updatePractica(id, practicaDetails);
        return "redirect:/vistas/practicas";
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminarPractica(@PathVariable Integer id) {
        practicaServicio.deletePractica(id);
        return "redirect:/vistas/practicas";
    }
}
