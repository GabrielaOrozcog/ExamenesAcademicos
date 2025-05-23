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
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Tema;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.TemaServicio;

@Controller
@RequestMapping("/vistas/temas")
public class TemaVistaControlador {
    @Autowired
    private TemaServicio temaServicio;
    
    
    @GetMapping
    public String listarTemas(Model model) {
        try {
            model.addAttribute("temas", temaServicio.getAllTemas());
        } catch (Exception e) {
            model.addAttribute("error", "Error al listar temas : " + e.getMessage());
        }
        return "temas";
    }
    
    
    @GetMapping("/crear")
    public String formularioCrearTema(Model model) {
        try {
            model.addAttribute("tema", new Tema());
            return "crearTema";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar formulario: " + e.getMessage());
            return "redirect:/vistas/temas";
        }
    }
    
    
    @PostMapping("/crear")
    public String guardarTema(@ModelAttribute("tema") Tema tema, Model model) {
       try {
           temaServicio.createTema(tema);
           return "redirect:/vistas/temas";
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el tema : " + e.getMessage());
            return "crearTema";
        }
    
    }
    
    
    @GetMapping("/editar/{id}")
    public String formularioEditarTema(@PathVariable Integer id, Model model) {
        try {
            Tema tema = temaServicio.getTemaById(id);
            model.addAttribute("tema", tema);
            return "editarTema";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el tema : " + e.getMessage());
            return "redirect:/vistas/temas";
        }
    }
    
    
    @PostMapping("/editar/{id}")
    public String actualizarTema(@PathVariable Integer id, @ModelAttribute("tema") Tema temaDetails, Model model) {
        try {
            temaServicio.updateTema(id, temaDetails);
            return "redirect:/vistas/temas";
        } catch (Exception e) {
            model.addAttribute("error", "Error al actualizar el tema : " + e.getMessage());
            return "editarTema";
        }
    }
    
    
    @GetMapping("/eliminar/{id}")
    public String eliminarTema(@PathVariable Integer id, Model model) {
        try {
            temaServicio.deleteTema(id);
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar el tema : " + e.getMessage());
        }
        return "redirect:/vistas/temas";
    }
    
    
    @GetMapping("/contar")
    public String contarTemas(Model model) {
    try {
        Integer totalTemas = temaServicio.contarTemas();
        model.addAttribute("totalTemas", totalTemas);
        } catch (Exception e) {
        model.addAttribute("error", "Error al contar temas : " + e.getMessage());
        }
        return "temas";
    }
    
}
