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
        model.addAttribute("temas", temaServicio.getAllTemas());
        return "temas";
    }
    
    @GetMapping("/crear")
    public String formularioCrearTema(Model model) {
        model.addAttribute("tema", new Tema());
        return "crearTema";
    }
    
    @PostMapping("/crear")
    public String guardarTema(@ModelAttribute("tema") Tema tema) {
        temaServicio.createTema(tema);
        return "redirect:/vistas/temas";
    }
    
    @GetMapping("/editar/{id}")
    public String formularioEditarTema(@PathVariable Integer id, Model model) {
        Tema tema = temaServicio.getTemaById(id);
        if (tema != null) {
            model.addAttribute("tema", tema);
            return "editarTema";
        }
        return "redirect:/vistas/temas";
    }
    
    @PostMapping("/editar/{id}")
    public String actualizarTema(@PathVariable Integer id, @ModelAttribute("tema") Tema temaDetails) {
        temaServicio.updateTema(id, temaDetails);
        return "redirect:/vistas/temas";
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminarTema(@PathVariable Integer id) {
        temaServicio.deleteTema(id);
        return "redirect:/vistas/temas";
    }
}
