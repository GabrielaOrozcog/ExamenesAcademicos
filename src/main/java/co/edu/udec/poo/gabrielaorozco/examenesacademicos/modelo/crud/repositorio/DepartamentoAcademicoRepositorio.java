/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.crud.repositorio;

import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.DepartamentoAcademico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Gabriela
 */

@Repository
public  interface DepartamentoAcademicoRepositorio extends JpaRepository<DepartamentoAcademico, Integer> {
    
}
