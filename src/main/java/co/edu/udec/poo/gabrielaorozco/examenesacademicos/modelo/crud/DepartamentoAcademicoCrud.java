/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
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
    public List<DepartamentoAcademico> getAll() {
        return departamentoAcademicoServicio.getAllDepartamentoAcademicos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartamentoAcademico> getById(@PathVariable Integer id) {
        DepartamentoAcademico departamentoAcademico = departamentoAcademicoServicio.getDepartamentoAcademicoById(id);
        if (departamentoAcademico != null) {
            return ResponseEntity.ok(departamentoAcademico);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public DepartamentoAcademico create(@RequestBody DepartamentoAcademico departamentoAcademico) {
        return departamentoAcademicoServicio.createDepartamentoAcademico(departamentoAcademico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartamentoAcademico> update(@PathVariable Integer id, @RequestBody DepartamentoAcademico departamentoAcademicoDetails) {
        DepartamentoAcademico updatedDepartamentoAcademico = departamentoAcademicoServicio.updateDepartamentoAcademico(id, departamentoAcademicoDetails);
        if (updatedDepartamentoAcademico != null) {
            return ResponseEntity.ok(updatedDepartamentoAcademico);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        departamentoAcademicoServicio.deleteDepartamentoAcademico(id);
        return ResponseEntity.ok().build();
    }

    @Repository
    public static interface DepartamentoAcademicoRepository extends JpaRepository<DepartamentoAcademico, Integer> { }
}
