/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package co.edu.udec.poo.gabrielaorozco.examenesacademicos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 *
 * @author Gabriela
 */

@SpringBootApplication
@EnableJpaRepositories(basePackages = "co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.crud.repositorio")
public class ExamenesAcademicos {
    public static void main(String[] args) {
        SpringApplication.run(ExamenesAcademicos.class, args);
    }
}