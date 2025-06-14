package co.edu.udec.poo.gabrielaorozco.examenesacademicos;

import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.controlador.AlumnoController;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.controlador.CursoController;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.controlador.DepartamentoAcademicoController;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.controlador.ProfesorController;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.AlumnoServicio;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.vistas.gui.VentanaPrincipal;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.swing.SwingUtilities;

/**
 *
 * @author Gabriela
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = "co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.crud.repositorio")
public class ExamenesAcademicos {

    public static void main(String[] args) {
     
        System.setProperty("spring.main.banner-mode", "off");

        ConfigurableApplicationContext context = new SpringApplicationBuilder(ExamenesAcademicos.class)
            .headless(false)
            .run(args);
        
        AlumnoController alumnoController = context.getBean(AlumnoController.class);
        CursoController cursoController = context.getBean(CursoController.class);
        ProfesorController profesorController = context.getBean(ProfesorController.class);
        DepartamentoAcademicoController departamentoAcademicoController = context.getBean(DepartamentoAcademicoController.class);

        SwingUtilities.invokeLater(() -> {
            
            VentanaPrincipal ventana = new VentanaPrincipal(alumnoController, cursoController, profesorController, departamentoAcademicoController);
            //ventana.setLocationRelativeTo(null); 
            ventana.setExtendedState(VentanaPrincipal.MAXIMIZED_BOTH);
            ventana.setVisible(true);
        });
    }
}
