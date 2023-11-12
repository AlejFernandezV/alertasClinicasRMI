package servidor.Repositorios;

import java.util.LinkedList;
import java.util.List;
import servidor.DTO.Indicadores.contenedorIndicadores;
import servidor.DTO.PacienteDTO;
import servidor.Repositorios.PacienteRepositoryInt;
import servidor.operaciones.analisisIndicadores;

/**
 *
 * @author Alejandro
 */
public class PacienteRepositoryImpl implements PacienteRepositoryInt{

    private LinkedList<PacienteDTO> pacientes;
    private analisisIndicadores objAnalisisInd;
    
    public PacienteRepositoryImpl() {
        this.pacientes = new LinkedList();
        this.objAnalisisInd = new analisisIndicadores();
    }

    @Override
    public PacienteDTO registrarPaciente(PacienteDTO objPaciente) {
        this.pacientes.add(objPaciente);
        return objPaciente;
    }

    @Override
    public PacienteDTO enviarDatos(PacienteDTO objPaciente) {
        int puntuacion = this.objAnalisisInd.calcularPuntuacion(objPaciente);
        System.out.println("Imprimiendo puntuacion: "+ puntuacion);
        if(puntuacion == 2){
            System.out.println("Enviando alerta a enfermeras! ");
        }
        else if(puntuacion >= 3){
            System.out.println("Enviando alerta a enfermeras y médico!");
        }
        return objPaciente;
    }
}
