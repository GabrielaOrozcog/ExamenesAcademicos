package co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

import lombok.Data;

/**
*
* 
* @author Gabriela
* */


@Data
@Entity
@Table(name= "alumno", schema = "public")
public class Alumno {
        
        @Id
	@NotEmpty(message = "el id de alumno no puede estar vacio o ser nulo")
	@Column(name="id_alumno")
	private int idAlumno;
        
	@NotEmpty(message = "El nombre no puede estar vacio o ser nulo")
	@Column(name="nombre_alumno")
	private String nombre_Alumno;
        
	@NotEmpty(message = "El grupo no puede estar vacío o ser nulo")
        @Column(name = "grupo")
        private String grupo;
    
        @ManyToOne
        @JoinColumn(name = "id_curso", nullable = false)
        private Curso curso;
    
        @OneToMany(mappedBy = "alumno")
        private List<Examen> examenes;
    
        public void realizarControl() {
            System.out.println("Alumno " + this.nombre_Alumno + " está tomando un examen de control.");
        }
    
        public void registrarPractica() {
            System.out.println("Alumno " + this.nombre_Alumno + " ha registrado una práctica.");
        }
    
        public double calcularNota() {
            double total = 0.0;
            if (examenes != null && !examenes.isEmpty()) {
                for (Examen examen : examenes) {
                    total += examen.calcularNotaFinal();
                }
                return total / examenes.size();
            }
            return 0.0;
        }


        
}
