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
@Table(name = "asignatura", schema = "public")
public class Asignatura {
    
    @Id
    @NotEmpty(message = "El id de la asignatura no puede estar vacío")
    @Column(name = "id_asignatura")
    private int idAsignatura;
    
    // Relación: Cada asignatura pertenece a un curso.
    @ManyToOne
    @JoinColumn(name = "id_curso", nullable = false)
    private Curso curso;
    
    @NotEmpty(message = "El nombre de la asignatura no puede estar vacío")
    @Column(name = "nombre_asignatura")
    private String nombreAsignatura;
    
    @Column(name = "creditos")
    private int creditos;
    
    @Column(name = "descripcion_asignatura")
    private String descripcionAsignatura;
    
    @Column(name = "anio_academico")
    private int anioAcademico;
    
    @Column(name = "semestre")
    private int semestre;
    
    @NotEmpty(message = "El horario no puede estar vacío")
    @Column(name = "horario")
    private String horario;
    
    // Relación: Muchos profesores imparten esta asignatura.
    @ManyToMany(mappedBy = "asignaturas")
    private List<Profesor> profesores;
    
    // Relación: Una asignatura puede contener varios temas.
    @OneToMany(mappedBy = "asignatura")
    private List<Tema> temas;
}
