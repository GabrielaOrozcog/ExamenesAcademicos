/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades;

import jakarta.persistence.*;

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
@Table(name = "examen_escrito", schema = "public")
public class ExamenEscrito extends Examen {
    
    @Column(name = "numero_preguntas")
    private int numeroPreguntas;
    
    @Column(name = "componente_teorico")
    private double componenteTeorico;
    
    @Column(name = "componente_redaccion")
    private double componenteRedaccion;
    
    @Override
    public double calcularNotaFinal() {
        double finalNota = (getComponenteTeorico() + getComponenteRedaccion()) / 2.0;
        System.out.println("ExamenEscrito final nota calculada: " + finalNota);
        return finalNota;
    }
}
