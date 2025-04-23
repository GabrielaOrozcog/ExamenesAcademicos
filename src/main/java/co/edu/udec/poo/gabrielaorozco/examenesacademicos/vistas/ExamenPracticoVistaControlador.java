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
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.ExamenPractico;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.ExamenPracticoServicio;

@Controller
@RequestMapping("/vistas/examenes-practicos")
public class ExamenPracticoVistaControlador {
    @Autowired
    private ExamenPracticoServicio examenPracticoServicio;
    
    @GetMapping
    public String listarExamenesPracticos(Model model) {
        model.addAttribute("examenPracticos", examenPracticoServicio.getAllExamenesPracticos());
        return "examenesPracticos";
    }
    
    @GetMapping("/crear")
    public String formularioCrearExamenPractico(Model model) {
        model.addAttribute("examenPractico", new ExamenPractico());
        return "crearExamenPractico";
    }
    
    @PostMapping("/crear")
    public String guardarExamenPractico(@ModelAttribute("examenPractico") ExamenPractico examenPractico) {
        examenPracticoServicio.createExamenPractico(examenPractico);
        return "redirect:/vistas/examenes-practicos";
    }
    
    @GetMapping("/editar/{id}")
    public String formularioEditarExamenPractico(@PathVariable Integer id, Model model) {
        ExamenPractico examen = examenPracticoServicio.getExamenPracticoById(id);
        if(examen != null) {
            model.addAttribute("examenPractico", examen);
            return "editarExamenPractico";
        }
        return "redirect:/vistas/examenes-practicos";
    }
    
    @PostMapping("/editar/{id}")
    public String actualizarExamenPractico(@PathVariable Integer id, @ModelAttribute("examenPractico") ExamenPractico examenDetails) {
        examenPracticoServicio.updateExamenPractico(id, examenDetails);
        return "redirect:/vistas/examenes-practicos";
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminarExamenPractico(@PathVariable Integer id) {
        examenPracticoServicio.deleteExamenPractico(id);
        return "redirect:/vistas/examenes-practicos";
    }
}
