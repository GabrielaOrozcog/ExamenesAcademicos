/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.ExamenEscrito;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.ExamenEscritoServicio;

/**
 *
 * @author Gabriela
 */
@RestController
@RequestMapping("/api/examenes-escritos")
public class ExamenEscritoCrud {

    @Autowired
    private ExamenEscritoServicio examenEscritoServicio;

    
    @GetMapping
    public ResponseEntity<?> getAllExamenesEscritos() {
        try {
            List<ExamenEscrito> examenesEscritos = examenEscritoServicio.getAllExamenesEscritos();
            return ResponseEntity.ok(examenesEscritos);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al obtener los exámenes escritos: " + e.getMessage());
        }
    }
    
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getExamenEscritoById(@PathVariable Integer id) {
        try {
            ExamenEscrito examenEscrito = examenEscritoServicio.getExamenEscritoById(id);
            return ResponseEntity.ok(examenEscrito);
        } catch (Exception e) {
            return ResponseEntity.status(404).body("No se encontró el examen escrito con ID " + id + ": " + e.getMessage());
        }
    }
    

    @PostMapping
    public ResponseEntity<?> createExamenEscrito(@RequestBody ExamenEscrito examenEscrito) {
        try {
            ExamenEscrito nuevoExamenEscrito = examenEscritoServicio.createExamenEscrito(examenEscrito);
            return ResponseEntity.ok(nuevoExamenEscrito);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al crear examen escrito: " + e.getMessage());
        }
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateExamenEscrito(@PathVariable Integer id, @RequestBody ExamenEscrito examenEscritoDetails) {
        try {
            ExamenEscrito actualizado = examenEscritoServicio.updateExamenEscrito(id, examenEscritoDetails);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Error al actualizar examen escrito: " + e.getMessage());
        }
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteExamenEscrito(@PathVariable Integer id) {
        try {
            examenEscritoServicio.deleteExamenEscrito(id);
            return ResponseEntity.ok("Examen escrito eliminado exitosamente.");
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Error al eliminar examen escrito: " + e.getMessage());
        }
    }
    
    
    @GetMapping("/contar")
    public ResponseEntity<Integer> contarExamenesEscritos() {
    try {
        Integer total = examenEscritoServicio.contarExamenesEscritos();
        return ResponseEntity.ok(total);
        } catch (Exception e) {
        return ResponseEntity.status(500).body(null);
        }
    }

}
