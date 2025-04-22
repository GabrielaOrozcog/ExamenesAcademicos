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
    public List<Tema> getAll() {
        return temaServicio.getAllTemas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tema> getById(@PathVariable Integer id) {
        Tema tema = temaServicio.getTemaById(id);
        if (tema != null) {
            return ResponseEntity.ok(tema);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Tema create(@RequestBody Tema tema) {
        return temaServicio.createTema(tema);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tema> update(@PathVariable Integer id, @RequestBody Tema temaDetails) {
        Tema updatedTema = temaServicio.updateTema(id, temaDetails);
        if (updatedTema != null) {
            return ResponseEntity.ok(updatedTema);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        temaServicio.deleteTema(id);
        return ResponseEntity.ok().build();
    }
}
