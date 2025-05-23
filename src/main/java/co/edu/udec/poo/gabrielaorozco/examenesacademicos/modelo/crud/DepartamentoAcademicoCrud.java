/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.DepartamentoAcademico;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.DepartamentoAcademicoServicio;

/**
 *
 * @author Gabriela
 */

@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoAcademicoCrud {

    @Autowired
    private DepartamentoAcademicoServicio departamentoAcademicoServicio;

    
    @GetMapping
    public ResponseEntity<?> getAllDepartamentosAcademicos() {
       try {
           List<DepartamentoAcademico> deptosAcademicos = departamentoAcademicoServicio.getAllDepartamentosAcademicos();
           return ResponseEntity.ok(deptosAcademicos);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al obtener los departamentos academicos: " + e.getMessage());
        }
    }
    
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getDepartamentoAcademicoById(@PathVariable Integer id) {
        try {
            DepartamentoAcademico deptoAcademico = departamentoAcademicoServicio.getDepartamentoAcademicoById(id);
            return ResponseEntity.ok(deptoAcademico);
        } catch (Exception e) {
            return ResponseEntity.status(404).body("No se encontró el departamento academico con ID: " + id + ". " + e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> createDepartamentoAcademico(@RequestBody DepartamentoAcademico departamentoAcademico) {
        try {
            DepartamentoAcademico nuevoDeptoAcademico = departamentoAcademicoServicio.createDepartamentoAcademico(departamentoAcademico);
            return ResponseEntity.ok(nuevoDeptoAcademico);
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Error al crear el departamento academico: " + e.getMessage());
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateDepartamentoAcademico(@PathVariable Integer id, @RequestBody DepartamentoAcademico departamentoAcademicoDetails) {
        try {
            DepartamentoAcademico actualizado = departamentoAcademicoServicio.updateDepartamentoAcademico(id, departamentoAcademicoDetails);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Error al actualizar el departamento academico: " + e.getMessage());
        }
    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDepartamentoAcademico(@PathVariable Integer id) {
        try {
            departamentoAcademicoServicio.deleteDepartamentoAcademico(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Error al eliminar el departamento academico: " + e.getMessage());
        }
    }
    
    
    @GetMapping("/contar")
    public ResponseEntity<Integer> contarDepartamentosAcademicos() {
    try {
        Integer total = departamentoAcademicoServicio.contarDepartamentosAcademicos();
        return ResponseEntity.ok(total);
        } catch (Exception e) {
        return ResponseEntity.status(500).body(null);
        }
    }

}
