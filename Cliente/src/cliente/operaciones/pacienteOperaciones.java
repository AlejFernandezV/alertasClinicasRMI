package cliente.operaciones;

import cliente.utilidades.UtilidadesConsola;
import servidor.DTO.PacienteDTO;

/**
 *
 * @author Alejandro
 */
public class pacienteOperaciones {
    
    public void ingresoNoHabitacion(PacienteDTO paciente){
        int noHabitacion;
        
        do{
            System.out.println("Ingrese el número de la habitación: ");
            noHabitacion = UtilidadesConsola.leerEntero();
            
            if((noHabitacion < 100) || (noHabitacion > 999)){
                System.out.println("Error! Numero de habitación no válido...");
            }
            else{
                paciente.setNumhabitacion(noHabitacion);
                System.out.println("Ingreso del número de habitación exitoso");
            }
        }while((noHabitacion > 99) || (noHabitacion < 1000));
    }
    
    public void ingresoNombreCompleto(PacienteDTO paciente){
        String nombres, apellidos;
        
        System.out.println("Ingrese los nombres: ");
        nombres = UtilidadesConsola.leerCadena();
        
        System.out.println("Ingrese los apelidos: ");
        apellidos = UtilidadesConsola.leerCadena();
        
        paciente.setNombres(nombres);
        paciente.setApellidos(apellidos);
        
        System.out.println("Ingreso del nombre completo exitoso");
    }
    
    
    public void ingresoEdad(PacienteDTO paciente){
        
        String edad;
        
        do{
            System.out.println("Por favor ingresar la edad del paciente, especificando días, semanas, meses o años \n Ejm: 26 años o 20 semanas");
            edad = UtilidadesConsola.leerCadena();
            edad.toLowerCase();
            
            if (!edad.contains("dias") ||
                !edad.contains("días") ||
                !edad.contains("semanas") ||
                !edad.contains("meses") ||
                !edad.contains("años")){
                System.out.println("Error! La edad ingresada no es válida");   
            }
            else{
                this.cambiarFormatoEdad(paciente, edad);
                System.out.println("Edad ingresada exitosamente!");
            }            
        }while (!edad.contains("dias") ||
                !edad.contains("días") ||
                !edad.contains("semanas") ||
                !edad.contains("meses") ||
                !edad.contains("años") && paciente.getCantidadEdad() > 0); 
    }
    
    private void cambiarFormatoEdad(PacienteDTO paciente,String entradaEdad){
        String[] edad = entradaEdad.split(" ");
        int cantidadEdad = Integer.parseInt(edad[0]);
        
        if(cantidadEdad < 1){
            System.out.println("Error! La edad no puede ser menor a 0");
        }else{
            paciente.setCantidadEdad(cantidadEdad);
            paciente.setTipoEdad(edad[1]);
        }
    }   
}
