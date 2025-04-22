/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Gabriela
 */
@Getter
@Setter
@Data
@Entity
@Table(name = "curso", schema = "public")
public class Curso {
    
    @Id
    @NotEmpty(message = "El id del curso no puede estar vacío")
    @Column(name = "id_curso")
    private int idCurso;
    
    @NotEmpty(message = "El nombre del curso no puede estar vacío")
    @Column(name = "nombre_curso")
    private String nombreCurso;
    
    // Relación: Un curso tiene muchos alumnos.
    @OneToMany(mappedBy = "curso")
    private List<Alumno> alumnos;
    
    // Relación: Muchos profesores pueden estar asociados a este curso.
    @ManyToMany(mappedBy = "cursos")
    private List<Profesor> profesores;
}
