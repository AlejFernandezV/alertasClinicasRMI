package servidor.operaciones;

import servidor.DTO.PacienteDTO;
import servidor.Repositorios.PacienteRepositoryImpl;
import servidor.Repositorios.PacienteRepositoryInt;
import servidor.operaciones.verificaciones.verificarNormIndicador;

/**
 *
 * @author Alejandro
 */
public class analisisIndicadores {
    
    private PacienteDTO paciente;
    private verificarNormIndicador objVNI;

    public analisisIndicadores() {
    }

    public analisisIndicadores(PacienteDTO paciente) {
        this.paciente = paciente;
        this.objVNI = new verificarNormIndicador(this.paciente);
    }

    public PacienteDTO getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteDTO paciente) {
        this.paciente = paciente;
    }

    public verificarNormIndicador getObjVNI() {
        return objVNI;
    }

    public void setObjVNI(verificarNormIndicador objVNI) {
        this.objVNI = objVNI;
    }
    
    public int calcularPuntuacion(){
        int sumPuntos = 0;
        if(this.objVNI.normalidadFC() == 1){
            sumPuntos += 1;
        }
        else if(this.objVNI.normalidadTA() == 1){
            sumPuntos += 1;
        }
        else if(this.objVNI.normalidadFR() == 1){
            sumPuntos += 1;
        }
        else if(this.objVNI.normalidadTemp() == 1){
            sumPuntos += 1;
        }
        else if(this.objVNI.normalidadSO() == 1){
            sumPuntos += 1;
        }
        
        return sumPuntos;
    }
    
}
