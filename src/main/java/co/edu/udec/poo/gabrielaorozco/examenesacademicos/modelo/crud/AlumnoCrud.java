/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.crud;

/**
 *
 * @author Gabriela
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Alumno;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.AlumnoServicio;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoCrud {

    @Autowired
    private AlumnoServicio alumnoServicio;

    @GetMapping
    public List<Alumno> getAll() {
        return alumnoServicio.getAllAlumnos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alumno> getById(@PathVariable Integer id) {
        Alumno alumno = alumnoServicio.getAlumnoById(id);
        if (alumno != null) {
            return ResponseEntity.ok(alumno);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Alumno create(@RequestBody Alumno alumno) {
        return alumnoServicio.createAlumno(alumno);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alumno> update(@PathVariable Integer id, @RequestBody Alumno alumnoDetails) {
        Alumno updatedAlumno = alumnoServicio.updateAlumno(id, alumnoDetails);
        if (updatedAlumno != null) {
            return ResponseEntity.ok(updatedAlumno);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        alumnoServicio.deleteAlumno(id);
        return ResponseEntity.ok().build();
    }
}

