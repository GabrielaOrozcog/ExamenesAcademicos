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
@Table(name = "examen_practico", schema = "public")
public class ExamenPractico extends Examen {
    
    @NotEmpty(message = "La descripción no puede estar vacía o ser nula")
    @Column(name = "descripcion_examen_practico")
    private String descripcionExamenPractico;
    
    @Column(name = "componente_laboratorio")
    private double componenteLaboratorio;
    
    @Column(name = "componente_eficiencia")
    private double componenteEficiencia;
    
    @ManyToOne
    @JoinColumn(name = "id_practica", nullable = false)
    private Practica practica;
    
    @Column(name = "grupal")
    private boolean grupal;
    
    @Override
    public double calcularNotaFinal() {
        double finalNota = (getComponenteLaboratorio() * 0.6) + (getComponenteEficiencia() * 0.4);
        System.out.println("ExamenPractico nota final calculada: " + finalNota);
        return finalNota;
    }
}
