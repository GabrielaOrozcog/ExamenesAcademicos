/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades;

import java.util.Date;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
*
* 
* @author Gabriela
* */
@Data
@Entity
@Table(name= "profesor", schema = "public")
public class Profesor {

        @Id
	@NotEmpty(message = "el id de profesor no puede estar vacio o ser nulo")
	@Column(name="id_profesor")
	private int id_Profesor;

        @NotEmpty(message = "El nombre no puede estar vacío o ser nulo")
        @Column(name = "nombre_profesor")
        private String nombre_Profesor;

        @NotEmpty(message = "El email no puede estar vacío o ser nulo")
        @Column(name = "email_profesor")
        private String email_Profesor;

        @Column(name = "telefono_profesor")
        private int telefono_Profesor;

        @NotEmpty(message = "El cargo no puede estar vacío o ser nulo")
        @Column(name = "cargo")
        private String cargo;

        @ManyToOne
        @JoinColumn(name = "id_departamento_academico", nullable = false)
        private DepartamentoAcademico departamentoAcademico;

        @Column(name = "fecha_inicio_contrato")
        private Date fecha_InicioContrato;

        @Column(name = "fecha_fin_contrato")
        private Date fecha_FinContrato;

        @OneToMany(mappedBy = "profesor")
        private List<Examen> examenes;

        @ManyToMany(mappedBy = "profesores")
        private List<Practica> practicas;

        @ManyToMany
        @JoinTable(name = "profesor_asignatura",
                   joinColumns = @JoinColumn(name = "id_profesor"),
                   inverseJoinColumns = @JoinColumn(name = "id_asignatura"))
        private List<Asignatura> asignaturas;

        @ManyToMany
        @JoinTable(name = "profesor_curso",
                   joinColumns = @JoinColumn(name = "id_profesor"),
                   inverseJoinColumns = @JoinColumn(name = "id_curso"))
        private List<Curso> cursos;
        
        public void diseniarPractica() {
        System.out.println("Profesor " + this.nombre_Profesor + " esta diseñando una nueva practica.");
        }
        
    /**
     *
     * @param titulo
     * @param nivelDificultad
     * @return
     */
    public Practica diseniarPractica(String titulo, String nivelDificultad) {
        Practica practica = new Practica();
        practica.setTitulo(titulo);
        practica.setNivelDificultadPractica(nivelDificultad);
        practica.setFechaCreacion(new Date());
        practicas.add(practica);
        System.out.println("Profesor " + this.nombre_Profesor + " diseño una nueva practica: " + titulo);
        return practica;
        }

}