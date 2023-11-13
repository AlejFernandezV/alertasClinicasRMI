package servidor.Repositorios;

import java.util.LinkedList;
import java.util.List;
import servidor.DTO.Indicadores.contenedorIndicadores;
import servidor.DTO.PacienteDTO;
import servidor.Repositorios.PacienteRepositoryInt;
import servidor.operaciones.analisisIndicadores;
import servidor.operaciones.guardadoInfo.almacenarInfoAlerta;

/**
 *
 * @author Alejandro
 */
public class PacienteRepositoryImpl implements PacienteRepositoryInt{

    private LinkedList<PacienteDTO> pacientes;
    private analisisIndicadores objAnalisisInd;
    private almacenarInfoAlerta objArchivo;
    
    public PacienteRepositoryImpl() {
        this.pacientes = new LinkedList();
        this.objAnalisisInd = new analisisIndicadores();
        this.objArchivo = new almacenarInfoAlerta();
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
            this.objArchivo.guardarEnArchivo(objPaciente, puntuacion);
            System.out.println("Enviando alerta a enfermeras! ");
        }
        else if(puntuacion >= 3){
            this.objArchivo.guardarEnArchivo(objPaciente, puntuacion);
            System.out.println("Enviando alerta a enfermeras y médico!");
        }
        return objPaciente;
    }
}
