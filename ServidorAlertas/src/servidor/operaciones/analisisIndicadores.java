package servidor.operaciones;

import servidor.DTO.PacienteDTO;
import servidor.operaciones.verificaciones.verificarNormIndicador;

/**
 *
 * @author Alejandro
 */
public class analisisIndicadores {

    public analisisIndicadores() {
    }
    
    public int calcularPuntuacion(PacienteDTO paciente){
        verificarNormIndicador objVNI = new verificarNormIndicador(paciente);
        int sumPuntos = 0;
        if(objVNI.normalidadFC() == 1){
            sumPuntos = sumPuntos + 1;
        }
        if(objVNI.normalidadTA() == 1){
            sumPuntos = sumPuntos + 1;
        }
        if(objVNI.normalidadFR() == 1){
            sumPuntos = sumPuntos + 1;
        }
        if(objVNI.normalidadTemp() == 1){
            sumPuntos = sumPuntos + 1;
        }
        if(objVNI.normalidadSO() == 1){
            sumPuntos = sumPuntos + 1;
        }
        
        return sumPuntos;
    }
    
}
