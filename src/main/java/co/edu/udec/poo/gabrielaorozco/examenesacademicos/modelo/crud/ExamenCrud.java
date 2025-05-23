/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Examen;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.ExamenServicio;

/**
 *
 * @author Gabriela
 */

@RestController
@RequestMapping("/api/examenes")
public class ExamenCrud {

    @Autowired
    private ExamenServicio examenServicio;
    
    
    @GetMapping
    public ResponseEntity<?> getAllExamenes() {
        try {
            List<Examen> examenes = examenServicio.getAllExamenes();
            return ResponseEntity.ok(examenes);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al obtener los exámenes : " + e.getMessage());
        }
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<?> getExamenById(@PathVariable Integer id) {
        try {
            Examen examen = examenServicio.getExamenById(id);
            return ResponseEntity.ok(examen);
        } catch (Exception e) {
            return ResponseEntity.status(404).body("No se encontró el examen  con ID " + id + ": " + e.getMessage());
        }
    }
    
   
    @PostMapping
    public ResponseEntity<?> createExamen(@RequestBody Examen examen) {
        try {
            Examen nuevoExamen = examenServicio.createExamen(examen);
            return ResponseEntity.ok(nuevoExamen);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al crear examen : " + e.getMessage());
        }
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateExamen(@PathVariable Integer id, @RequestBody Examen examenDetails) {
        try {
            Examen actualizado = examenServicio.updateExamen(id, examenDetails);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Error al actualizar examen : " + e.getMessage());
        }
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteExamen(@PathVariable Integer id) {
        try {
            examenServicio.deleteExamen(id);
            return ResponseEntity.ok("Examen eliminado exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Error al eliminar examen : " + e.getMessage());
        }
    }
    
    
    @GetMapping("/contar")
    public ResponseEntity<Integer> contarExamenes() {
    try {
        Integer total = examenServicio.contarExamenes();
        return ResponseEntity.ok(total);
        } catch (Exception e) {
        return ResponseEntity.status(500).body(null);
        }
    }
    
}
