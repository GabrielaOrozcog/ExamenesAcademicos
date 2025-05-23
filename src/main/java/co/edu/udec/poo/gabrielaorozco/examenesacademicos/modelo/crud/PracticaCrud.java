package co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Practica;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.PracticaServicio;

@RestController
@RequestMapping("/api/practicas")
public class PracticaCrud {

    @Autowired
    private PracticaServicio practicaServicio;
    
    
    @GetMapping
    public ResponseEntity<?> getAllPracticas() {
       try {
           List<Practica> practicas = practicaServicio.getAllPracticas();
           return ResponseEntity.ok(practicas);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al obtener las practicas : " + e.getMessage());
        }
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<?> getPracticaById(@PathVariable Integer id) {
        try {
            Practica practica = practicaServicio.getPracticaById(id);
            return ResponseEntity.ok(practica);
        } catch (Exception e) {
            return ResponseEntity.status(404).body("No se encontró la practica con ID: " + id + ". " + e.getMessage());
        }
    }

    
    @PostMapping
    public ResponseEntity<?> createPractica(@RequestBody Practica practica) {
        try {
            Practica nuevaPractica = practicaServicio.createPractica(practica);
            return ResponseEntity.ok(nuevaPractica);
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Error al crear la practica : " + e.getMessage());
        }
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePractica(@PathVariable Integer id, @RequestBody Practica practicaDetails) {
        try {
            Practica actualizada = practicaServicio.updatePractica(id, practicaDetails);
            return ResponseEntity.ok(actualizada);
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Error al actualizar la practica : " + e.getMessage());
        }
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePractica(@PathVariable Integer id) {
        try {
            practicaServicio.deletePractica(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Error al eliminar la practica : " + e.getMessage());
        }
    }
    
    
    @GetMapping("/contar")
    public ResponseEntity<Integer> contarPracticas() {
    try {
        Integer total = practicaServicio.contarPracticas();
        return ResponseEntity.ok(total);
        } catch (Exception e) {
        return ResponseEntity.status(500).body(null);
        }
    }

}
