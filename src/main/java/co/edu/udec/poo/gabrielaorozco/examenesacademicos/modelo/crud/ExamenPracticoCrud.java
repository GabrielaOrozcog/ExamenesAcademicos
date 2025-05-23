/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.ExamenPractico;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.ExamenPracticoServicio;
/**
 *
 * @author Gabriela
 */
@RestController
@RequestMapping("/api/examenes-practicos")
public class ExamenPracticoCrud {

    @Autowired
    private ExamenPracticoServicio examenPracticoServicio;

    
    @GetMapping
    public ResponseEntity<?> getAllExamenesPracticos() {
        try {
            List<ExamenPractico> examenesPracticos = examenPracticoServicio.getAllExamenesPracticos();
            return ResponseEntity.ok(examenesPracticos);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al obtener los exámenes practicos: " + e.getMessage());
        }
    }
    
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getExamenPracticoById(@PathVariable Integer id) {
        try {
            ExamenPractico examenPractico = examenPracticoServicio.getExamenPracticoById(id);
            return ResponseEntity.ok(examenPractico);
        } catch (Exception e) {
            return ResponseEntity.status(404).body("No se encontró el examen practico con ID " + id + ": " + e.getMessage());
        }
    }
    
    
    @PostMapping
    public ResponseEntity<?> createExamenPractico(@RequestBody ExamenPractico examenPractico) {
        try {
            ExamenPractico nuevoExamenPractico = examenPracticoServicio.createExamenPractico(examenPractico);
            return ResponseEntity.ok(nuevoExamenPractico);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al crear examen practico: " + e.getMessage());
        }
    }
    

    @PutMapping("/{id}")
    public ResponseEntity<?> updateExamenPractico(@PathVariable Integer id, @RequestBody ExamenPractico examenPracticoDetails) {
        try {
            ExamenPractico actualizado = examenPracticoServicio.updateExamenPractico(id, examenPracticoDetails);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Error al actualizar examen practico: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteExamenPractico(@PathVariable Integer id) {
        try {
            examenPracticoServicio.deleteExamenPractico(id);
            return ResponseEntity.ok("Examen practico eliminado exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Error al eliminar examen practico: " + e.getMessage());
        }
    }
    
    
    @GetMapping("/contar")
    public ResponseEntity<Integer> contarExamenesPracticos() {
    try {
        Integer total = examenPracticoServicio.contarExamenesPracticos();
        return ResponseEntity.ok(total);
        } catch (Exception e) {
        return ResponseEntity.status(500).body(null);
        }
    }

}
