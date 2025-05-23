package co.edu.udec.poo.gabrielaorozco.examenesacademicos;

import co.edu.udec.poo.gabrielaorozco.examenesacademicos.servicios.CursoServicio;
import co.edu.udec.poo.gabrielaorozco.examenesacademicos.modelo.entidades.Curso;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;

@Component
@Order(1)
public class CursoPrueba implements CommandLineRunner {

    @Autowired
    private CursoServicio cursoServicio;
    
    

    @Override
    public void run(String... args) throws Exception {
        try {
            
            Curso curso = crearCurso(1, "A1");
            
            demostrarOperacionesCRUD(curso.getIdCurso());
            
        } catch (Exception e) {
            System.err.println("Error en pruebas: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    
    
    private Curso crearCurso(Integer id, String nombre) throws Exception {
        System.out.println("\n=== Creando nuevo curso ===");
        Curso curso = new Curso();
        curso.setIdCurso(id);
        curso.setNombreCurso(nombre);
        
        Curso creado = cursoServicio.createCurso(curso);
        System.out.println("Curso creado exitosamente: ID: " + creado.getIdCurso()+ " | Nombre: " + creado.getNombreCurso());
        return creado;
    }
    
    private void demostrarOperacionesCRUD(Integer idCurso) throws Exception {
        System.out.println("\n=== Obteniendo curso por ID ===");
        Curso curso = cursoServicio.getCursoById(idCurso);
        System.out.println("Curso obtenido: " + curso.getNombreCurso()) ;
                         
        
        
        System.out.println("\n=== Actualizando Curso ===");
        Curso actualizacion = new Curso();
        actualizacion.setNombreCurso("A4");
        
        
        Curso actualizado = cursoServicio.updateCurso(idCurso, actualizacion);
        System.out.println("Curso actualizado: " + actualizado.getNombreCurso());
        

        System.out.println("\n=== Listado completo de cursos ===");
        cursoServicio.getAllCursos().forEach(a -> 
            System.out.println(String.format(
                "ID: %d | Nombre: %-15s ",
                a.getIdCurso(),
                a.getNombreCurso()
            ))
        );
        
  
        System.out.println("\nTotal cursos registrados: " + cursoServicio.contarCursos());
        
        /*System.out.println("\n=== Eliminando curso ===");
        cursoServicio.deleteCurso(idCurso);
        System.out.println("Curso eliminado exitosamente");*/
        
    }
}
