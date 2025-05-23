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
    public String listarDepartamentosAcademicos(Model model) {
        try {
            model.addAttribute("departamentos", departamentoAcademicoServicio.getAllDepartamentosAcademicos());
        } catch (Exception e) {
            model.addAttribute("error", "Error al listar departamentos academicos: " + e.getMessage());
        }
        return "departamentoAcademico";
    }
    
    @GetMapping("/crear")
    public String formularioCrearDepartamentoAcademico(Model model) {
        try {
            model.addAttribute("departamento", new DepartamentoAcademico());
            return "crearDepartamentoAcademico";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar formulario: " + e.getMessage());
            return "redirect:/vistas/departamentoacademico";
        }
    }
    
    
    @PostMapping("/crear")
    public String guardarDepartamentoAcademico(@ModelAttribute("departamento") DepartamentoAcademico departamento, Model model) {
       try {
           departamentoAcademicoServicio.createDepartamentoAcademico(departamento);
           return "redirect:/vistas/departamentoacademico";
        } catch (Exception e) {
            model.addAttribute("error", "Error al guardar el departamento academico: " + e.getMessage());
            return "crearDepartamentoAcademico";
        }
    
    }
    
    
    @GetMapping("/editar/{id}")
    public String formularioEditarDepartamnetoAcademico(@PathVariable Integer id, Model model) {
        try {
            DepartamentoAcademico departamento = departamentoAcademicoServicio.getDepartamentoAcademicoById(id);
            model.addAttribute("departamento", departamento);
            return "editarDepartamentoAcademico";
        } catch (Exception e) {
            model.addAttribute("error", "Error al cargar el departamento: " + e.getMessage());
            return "redirect:/vistas/departamentoacademico";
        }
    }
    
    
    @PostMapping("/editar/{id}")
    public String actualizarDepartamentoAcademico(@PathVariable Integer id, @ModelAttribute("departamento") DepartamentoAcademico departamentoDetails, Model model) {
        try {
            departamentoAcademicoServicio.updateDepartamentoAcademico(id, departamentoDetails);
            return "redirect:/vistas/departamentoacademico";
        } catch (Exception e) {
            model.addAttribute("error", "Error al actualizar el departamento: " + e.getMessage());
            return "editarDepartamentoAcademico";
        }
    }
    
    @GetMapping("/eliminar/{id}")
    public String eliminarDepartamentoAcademico(@PathVariable Integer id, Model model) {
        try {
            departamentoAcademicoServicio.deleteDepartamentoAcademico(id);
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar el departamento: " + e.getMessage());
        }
        return "redirect:/vistas/departamentoacademico";
    }
    
    
    @GetMapping("/contar")
    public String contarAlumnos(Model model) {
    try {
        Integer totalDepartamentosAcademicos = departamentoAcademicoServicio.contarDepartamentosAcademicos();
        model.addAttribute("totalDepartamentosAcademicos", totalDepartamentosAcademicos);
        } catch (Exception e) {
        model.addAttribute("error", "Error al contar departamentos academicos: " + e.getMessage());
        }
        return "departamentos academicos";
    }
    
}
