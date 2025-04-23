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
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.DepartamentoAcademico;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.DepartamentoAcademicoServicio;

@Controller
@RequestMapping("/vistas/departamentoacademico")
public class DepartamentoAcademicoVistaControlador {
    @Autowired
    private DepartamentoAcademicoServicio departamentoAcademicoServicio;
    
    @GetMapping
    public String listarDepartamentoAcademicos(Model model) {
        model.addAttribute("departamentos", departamentoAcademicoServicio.getAllDepartamentoAcademicos());
        return "departamentoAcademico";
    }
    
    @GetMapping("/crear")
    public String formularioCrearDepartamentoAcademico(Model model) {
        model.addAttribute("departamento", new DepartamentoAcademico());
        return "crearDepartamentoAcademico"; 
    }
    
    @PostMapping("/crear")
    public String guardarDepartamentoAcademico(@ModelAttribute("departamento") DepartamentoAcademico departamento) {
        departamentoAcademicoServicio.createDepartamentoAcademico(departamento);
        return "redirect:/vistas/departamentoacademico";
    }
    
    @GetMapping("/editar/{id}")
    public String formularioEditarDepartamentoAcademico(@PathVariable Integer id, Model model) {
        DepartamentoAcademico departamento = departamentoAcademicoServicio.getDepartamentoAcademicoById(id);
        if (departamento != null) {
            model.addAttribute("departamento", departamento);
            return "editarDepartamentoAcademico";
        } else {
            return "redirect:/vistas/departamentoacademico";
        }
    }
    
    @PostMapping("/editar/{id}")
    public String actualizarDepartamentoAcademico(@PathVariable Integer id, @ModelAttribute("departamento") DepartamentoAcademico departamentoDetails) {
        departamentoAcademicoServicio.updateDepartamentoAcademico(id, departamentoDetails);
        return "redirect:/vistas/departamentoacademico";
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminarDepartamentoAcademico(@PathVariable Integer id) {
        departamentoAcademicoServicio.deleteDepartamentoAcademico(id);
        return "redirect:/vistas/departamentoacademico";
    }
}
