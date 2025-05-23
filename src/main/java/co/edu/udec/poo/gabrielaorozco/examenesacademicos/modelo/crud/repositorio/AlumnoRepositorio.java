/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.crud.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Alumno;

/**
 *
 * @author Gabriela
 */
@Repository
public interface AlumnoRepositorio extends JpaRepository<Alumno, Integer> {
    
    
}
