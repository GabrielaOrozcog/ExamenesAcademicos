/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Asignatura;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.AsignaturaServicio;
/**
 *
 * @author torrestr
 */
@RestController
@RequestMapping("/api/asignaturas")
public class AsignaturaCrud {

    @Autowired
    private AsignaturaServicio asignaturaServicio;

    @GetMapping
    public List<Asignatura> getAll() {
        return asignaturaServicio.getAllAsignaturas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asignatura> getById(@PathVariable Integer id) {
        Asignatura asignatura = asignaturaServicio.getAsignaturaById(id);
        if (asignatura != null) {
            return ResponseEntity.ok(asignatura);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Asignatura create(@RequestBody Asignatura asignatura) {
        return asignaturaServicio.createAsignatura(asignatura);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Asignatura> update(@PathVariable Integer id, @RequestBody Asignatura asignaturaDetails) {
        Asignatura updatedAsignatura = asignaturaServicio.updateAsignatura(id, asignaturaDetails);
        if (updatedAsignatura != null) {
            return ResponseEntity.ok(updatedAsignatura);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        asignaturaServicio.deleteAsignatura(id);
        return ResponseEntity.ok().build();
    }
}
