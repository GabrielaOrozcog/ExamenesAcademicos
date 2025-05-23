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
        try {
            model.addAttribute("examenPracticos", examenPracticoServicio.getAllExamenesPracticos());
        } catch (Exception e) {
            model.addAttribute("error", "Error al listar examenes practicos: " + e.getMessage());
        }
        return "examenesPracticos";
    }
    
    
    @GetMapping("/crear")
    public String formularioCrearExamenPractico(Model model) {
        try {
            model.addAttribute("examenPractico", new ExamenPractico());
            return "crearExamenPractico";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar formulario: " + e.getMessage());
            return "redirect:/vistas/examenes-practicos";
        }
    }
    
    
    @PostMapping("/crear")
    public String guardarExamenPractico(@ModelAttribute("examenPractico") ExamenPractico examenPractico, Model model) {
       try {
           examenPracticoServicio.createExamenPractico(examenPractico);
           return "redirect:/vistas/examenes-practicos";
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el examen practico: " + e.getMessage());
            return "crearExamenPractico";
        }
    }
    
    
    @GetMapping("/editar/{id}")
    public String formularioEditarExamenPractico(@PathVariable Integer id, Model model) {
        try {
            ExamenPractico examenPractico = examenPracticoServicio.getExamenPracticoById(id);
            model.addAttribute("examenPractico", examenPractico);
            return "editarExamenPractico";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el examen practico: " + e.getMessage());
            return "redirect:/vistas/examenes-practicos";
        }
    }
    
    
    @PostMapping("/editar/{id}")
    public String actualizarExamenPractico(@PathVariable Integer id, @ModelAttribute("examenPractico") ExamenPractico examenPracticoDetails, Model model) {
        try {
            examenPracticoServicio.updateExamenPractico(id, examenPracticoDetails);
            return "redirect:/vistas/examenes-practicos";
        } catch (Exception e) {
            model.addAttribute("error", "Error al actualizar el examen practico: " + e.getMessage());
            return "editarExamenPractico";
        }
    }
    
    
    @GetMapping("/eliminar/{id}")
    public String eliminarExamenPractico(@PathVariable Integer id, Model model) {
        try {
            examenPracticoServicio.deleteExamenPractico(id);
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar el examen practico: " + e.getMessage());
        }
        return "redirect:/vistas/examenes-practicos";
    }
    
    
    @GetMapping("/contar")
    public String contarExamenesPracticos(Model model) {
    try {
        Integer totalExamenesPracticos = examenPracticoServicio.contarExamenesPracticos();
        model.addAttribute("totalExamenesPracticos", totalExamenesPracticos);
        } catch (Exception e) {
        model.addAttribute("error", "Error al contar examenes practicas : " + e.getMessage());
        }
        return "examenesPracticos";
    }
    
}
