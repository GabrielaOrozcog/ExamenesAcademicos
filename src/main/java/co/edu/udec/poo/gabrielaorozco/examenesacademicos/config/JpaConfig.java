/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Gabriela
 */
package co.edu.udec.poo.gabrielaorozco.examenesacademicos.config;

import jakarta.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
public class JpaConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder, DataSource dataSource) {
        
        LocalContainerEntityManagerFactoryBean factoryBean = builder
            .dataSource(dataSource)
            .packages("co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades")
            .persistenceUnit("default")
            .build();
        
        factoryBean.setEntityManagerFactoryInterface(EntityManagerFactory.class);
        return factoryBean;
    }
}