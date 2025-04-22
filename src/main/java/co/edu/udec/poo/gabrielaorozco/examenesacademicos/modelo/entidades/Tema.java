/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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
@Table(name = "tema", schema = "public")
public class Tema {
    
    @Id
    @NotEmpty(message = "El id del tema no puede estar vacío")
    @Column(name = "id_tema")
    private int id_Tema;
    
    @NotEmpty(message = "El nombre del tema no puede estar vacío")
    @Column(name = "nombre_tema")
    private String nombreTema;
    
    @Column(name = "descripcion_tema")
    private String descripcionTema;
    
    @Column(name = "recursos")
    private String recursos;
    
    @NotEmpty(message = "El nivel de dificultad no puede estar vacío")
    @Column(name = "nivel_dificultad_tema")
    private String nivelDificultadTema;
    
    @ManyToOne
    @JoinColumn(name = "id_asignatura", nullable = false)
    private Asignatura asignatura;
}
