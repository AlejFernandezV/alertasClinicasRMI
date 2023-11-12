package servidor.operaciones.guardadoInfo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import servidor.DTO.PacienteDTO;

/**
 *
 * @author Alejandro
 */
public class almacenarInfoAlerta {
    
    public almacenarInfoAlerta() {
    }
    
    public void guardarEnArchivo(PacienteDTO paciente, int puntuacion){
        LocalTime horaActual = LocalTime.now();
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        
        String linea = paciente.getNumhabitacion()+","+paciente.getNombres()+" "+paciente.getApellidos()+","+fechaActual+","+horaActual.format(formatoHora)+","+puntuacion;
        try {
            File archivo = new File("./src/servidor/Historial/historialAlertas.txt");

            if (!archivo.exists()) {
                archivo.getParentFile().mkdirs();
                archivo.createNewFile();
            }
            
            FileWriter fw = new FileWriter(archivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write(linea);
            bw.newLine();
            
            bw.close();

            System.out.println("Alerta ingresada al historial correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
