package co.edu.udec.poo.gabrielaorozco.examenesacademicos;

import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.DepartamentoAcademicoServicio;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.DepartamentoAcademico;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;

@Component
@Order(4)
public class DepartamentoAcademicoPrueba implements CommandLineRunner {

    @Autowired
    private DepartamentoAcademicoServicio departamentoAcademicoServicio;
    
    

    @Override
    public void run(String... args) throws Exception {
        try {
            
            DepartamentoAcademico departamentoAcademico = crearDepartamentoAcademico(1, "Ciencias");
            
            demostrarOperacionesCRUD(departamentoAcademico.getIdDepartamentoAcademico());
            
        } catch (Exception e) {
            System.err.println("Error en pruebas: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    
    
    private DepartamentoAcademico crearDepartamentoAcademico(Integer id, String nombre) throws Exception {
        System.out.println("\n=== Creando nuevo departamentoAcademico ===");
        DepartamentoAcademico departamentoAcademico = new DepartamentoAcademico();
        departamentoAcademico.setIdDepartamentoAcademico(id);
        departamentoAcademico.setNombre(nombre);
        
        DepartamentoAcademico creado = departamentoAcademicoServicio.createDepartamentoAcademico(departamentoAcademico);
        System.out.println("Departamento academico creado exitosamente: ID: " + creado.getIdDepartamentoAcademico() + " | Nombre: " + creado.getNombre());
        return creado;
    }
    
    private void demostrarOperacionesCRUD(Integer idDepartamentoAcademico) throws Exception {
        System.out.println("\n=== Obteniendo departamento academico por ID ===");
        DepartamentoAcademico departamentoAcademico = departamentoAcademicoServicio.getDepartamentoAcademicoById(idDepartamentoAcademico);
        System.out.println("Departamento academico obtenido: " + departamentoAcademico.getNombre()) ;
                         
        
        
        System.out.println("\n=== Actualizando Departamento academico ===");
        DepartamentoAcademico actualizacion = new DepartamentoAcademico();
        actualizacion.setNombre("Departamento de Matematicas");
        
        
        DepartamentoAcademico actualizado = departamentoAcademicoServicio.updateDepartamentoAcademico(idDepartamentoAcademico, actualizacion);
        System.out.println("Departamento academico actualizado: " + actualizado.getNombre());
        

        System.out.println("\n=== Listado completo de departamentos academicos ===");
        departamentoAcademicoServicio.getAllDepartamentosAcademicos().forEach(a -> 
            System.out.println(String.format(
                "ID: %d | Nombre: %-15s ",
                a.getIdDepartamentoAcademico(),
                a.getNombre()
            ))
        );
        
  
        System.out.println("\nTotal departamentos academicos registrados: " + departamentoAcademicoServicio.contarDepartamentosAcademicos());
        
        //5. Eliminación (comentada por seguridad)
        //System.out.println("\n=== Eliminando departamento academico ===");
        //departamentoAcademicoServicio.deleteDepartamentoAcademico(idDepartamentoAcademico);
        //System.out.println("Departamento academico eliminado exitosamente");
        
    }
}