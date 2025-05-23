/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import java.util.Date;
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
@Table(name = "practica", schema = "public")
public class Practica {

    @Id
    @NotEmpty(message = "el id de practica no puede estar vacio o ser nulo")
    @Column(name = "id_practica")
    private int idPractica;

    @NotEmpty(message = "El título no puede estar vacío o ser nulo")
    @Column(name = "titulo")
    private String titulo;

    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @NotEmpty(message = "El nivel de dificultad no puede estar vacío o ser nulo")
    @Column(name = "nivel_dificultad_practica")
    private String nivelDificultadPractica;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "profesor_practica",
            joinColumns = @JoinColumn(name = "id_practica"),
            inverseJoinColumns = @JoinColumn(name = "id_profesor"))
    private List<Profesor> profesores;

}
