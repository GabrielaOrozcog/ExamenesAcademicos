/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
*
* 
* @author Gabriela
* */
@Getter
@Setter
@Data
@Entity
@Table(name= "examen", schema = "public")
public class Examen {
	
	@Id
        @NotEmpty(message = "El id del examen no puede estar vacío")
        @Column(name = "id_examen")
        private int idExamen;
        
        @ManyToOne
        @JoinColumn(name = "id_alumno", nullable = false)
        private Alumno alumno;
        
	@Column(name="grupo")
	private String grupo;
        
        @ManyToOne
        @JoinColumn(name = "id_profesor", nullable = false)
        private Profesor profesor;

        @Column(name = "fecha_realizacion")
        private Date fechaRealizacion;

        @Column(name = "fecha_creacion_examen")
        private Date fechaCreacionExamen;

        @NotEmpty(message = "El tipo de examen no puede estar vacío o ser nulo")
        @Column(name = "tipo_examen")
        private String tipoExamen;

        @ManyToOne
        @JoinColumn(name = "id_asignatura", nullable = false)
        private Asignatura asignatura;

        public double calcularNotaFinal() {
            System.out.println("Default implementation for Examen; please override in subclasses.");
            return 0.0;
        }


}
