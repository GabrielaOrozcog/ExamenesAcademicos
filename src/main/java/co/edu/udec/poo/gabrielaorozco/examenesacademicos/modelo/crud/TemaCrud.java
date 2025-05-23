/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Tema;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.TemaServicio;

/**
 *
 * @author Gabriela
 */

@RestController
@RequestMapping("/api/temas")
public class TemaCrud {

    @Autowired
    private TemaServicio temaServicio;
    
    
    @GetMapping
    public ResponseEntity<?> getAllTemas() {
       try {
           List<Tema> temas = temaServicio.getAllTemas();
           return ResponseEntity.ok(temas);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al obtener los temas: " + e.getMessage());
        }
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<?> getTemaById(@PathVariable Integer id) {
        try {
            Tema tema = temaServicio.getTemaById(id);
            return ResponseEntity.ok(tema);
        } catch (Exception e) {
            return ResponseEntity.status(404).body("No se encontró el tema con ID: " + id + ". " + e.getMessage());
        }
    }

    
    @PostMapping
    public ResponseEntity<?> createTema(@RequestBody Tema tema) {
        try {
            Tema nuevoTema = temaServicio.createTema(tema);
            return ResponseEntity.ok(nuevoTema);
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Error al crear el tema : " + e.getMessage());
        }
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateTema(@PathVariable Integer id, @RequestBody Tema temaDetails) {
        try {
            Tema actualizado = temaServicio.updateTema(id, temaDetails);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Error al actualizar el tema : " + e.getMessage());
        }
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTema(@PathVariable Integer id) {
        try {
            temaServicio.deleteTema(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(404).body("Error al eliminar el tema : " + e.getMessage());
        }
    }
    
    
    @GetMapping("/contar")
    public ResponseEntity<Integer> contarTemas() {
    try {
        Integer total = temaServicio.contarTemas();
        return ResponseEntity.ok(total);
        } catch (Exception e) {
        return ResponseEntity.status(500).body(null);
        }
    }

}
