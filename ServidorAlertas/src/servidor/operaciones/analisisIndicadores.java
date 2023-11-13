package servidor.operaciones;

import servidor.DTO.Indicador;
import servidor.DTO.Notificacion;
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
    
    public void agregarIndicadoresRaros( PacienteDTO paciente,Notificacion objNotificacion){
        verificarNormIndicador objVNI = new verificarNormIndicador(paciente);
        if(objVNI.normalidadFC() == 1){
            Indicador objIndicador = new Indicador("Frecuencia Cardiaca",paciente.getContInd().getObjFC().getLatidosPM()+"");
            objNotificacion.getIndicadores().add(objIndicador);
        }
        if(objVNI.normalidadTA() == 1){
            Indicador objIndicador = new Indicador("Tension Arterial",paciente.getContInd().getObjTA().getSistolica()+"/"+paciente.getContInd().getObjTA().getDiastolica());
            objNotificacion.getIndicadores().add(objIndicador);
        }
        if(objVNI.normalidadFR() == 1){
            Indicador objIndicador = new Indicador("Frecuencia Respiratoria",paciente.getContInd().getObjFR().getVentilacionesPM()+"");
            objNotificacion.getIndicadores().add(objIndicador);
        }
        if(objVNI.normalidadTemp() == 1){
            Indicador objIndicador = new Indicador("Temperatura",paciente.getContInd().getObjTemp().getGradosC()+"");
            objNotificacion.getIndicadores().add(objIndicador);
        }
        if(objVNI.normalidadSO() == 1){
            Indicador objIndicador = new Indicador("Saturacion Oxigeno",paciente.getContInd().getObjSO().getPerOxigeno()+"");
            objNotificacion.getIndicadores().add(objIndicador);
        }
    }
    
}
