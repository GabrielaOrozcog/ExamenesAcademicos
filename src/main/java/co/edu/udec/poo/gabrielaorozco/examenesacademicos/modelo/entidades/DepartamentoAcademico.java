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
@Table(name = "departamento_academico", schema = "public")
public class DepartamentoAcademico {
    
    @Id
    @NotEmpty(message = "el id del departamento academico no puede estar vacio o ser nulo")
    @Column(name = "id_departamento_academico")
    private int idDepartamentoAcademico;
    
    @NotEmpty(message = "El nombre no puede estar vacío o ser nulo")
    @Column(name = "nombre")
    private String nombre;
    
    // Relación: Un departamento tiene muchos profesores.
    @OneToMany(mappedBy = "departamentoAcademico")
    private List<Profesor> profesores;
    
}
