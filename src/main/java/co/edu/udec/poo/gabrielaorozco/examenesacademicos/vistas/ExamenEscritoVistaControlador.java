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
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.ExamenEscrito;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.ExamenEscritoServicio;

@Controller
@RequestMapping("/vistas/examenes-escritos")
public class ExamenEscritoVistaControlador {
    @Autowired
    private ExamenEscritoServicio examenEscritoServicio;
    
    @GetMapping
    public String listarExamenesEscritos(Model model) {
        model.addAttribute("examenes", examenEscritoServicio.getAllExamenesEscritos());
        return "examenesEscritos"; 
    }
    
    @GetMapping("/crear")
    public String formularioCrearExamenEscrito(Model model) {
        model.addAttribute("examenEscrito", new ExamenEscrito());
        return "crearExamenEscrito"; 
    }
    
    @PostMapping("/crear")
    public String guardarExamenEscrito(@ModelAttribute("examenEscrito") ExamenEscrito examenEscrito) {
        examenEscritoServicio.createExamenEscrito(examenEscrito);
        return "redirect:/vistas/examenes-escritos";
    }
    
    @GetMapping("/editar/{id}")
    public String formularioEditarExamenEscrito(@PathVariable Integer id, Model model) {
        ExamenEscrito examen = examenEscritoServicio.getExamenEscritoById(id);
        if (examen != null) {
            model.addAttribute("examenEscrito", examen);
            return "editarExamenEscrito"; 
        } else {
            return "redirect:/vistas/examenes-escritos";
        }
    }
    
    @PostMapping("/editar/{id}")
    public String actualizarExamenEscrito(@PathVariable Integer id,
                                          @ModelAttribute("examenEscrito") ExamenEscrito examenDetails) {
        examenEscritoServicio.updateExamenEscrito(id, examenDetails);
        return "redirect:/vistas/examenes-escritos";
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminarExamenEscrito(@PathVariable Integer id) {
        examenEscritoServicio.deleteExamenEscrito(id);
        return "redirect:/vistas/examenes-escritos";
    }
}
