package servidor.Repositorios;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;
import servidor.DTO.Notificacion;
import servidor.DTO.PacienteDTO;
import servidor.controladores.ControladorGestorNotificacionesInt;
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
    private final ControladorGestorNotificacionesInt objRemoto;
    
    public PacienteRepositoryImpl(ControladorGestorNotificacionesInt objRemoto) {
        this.pacientes = new LinkedList();
        this.objAnalisisInd = new analisisIndicadores();
        this.objArchivo = new almacenarInfoAlerta();
        this.objRemoto = objRemoto;
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
            this.enviarNotificacion(objPaciente,puntuacion);
            System.out.println("Enviando alerta a enfermeras! ");
        }
        else if(puntuacion >= 3){
            this.objArchivo.guardarEnArchivo(objPaciente, puntuacion);
            System.out.println("Enviando alerta a enfermeras y médico!");
        }
        return objPaciente;
    }
    
    private void enviarNotificacion(PacienteDTO paciente,int puntuacion){
        try {
            String nombreCompleto = paciente.getNombres()+" "+paciente.getApellidos();
            String edad = paciente.getCantidadEdad()+" "+paciente.getTipoEdad();
            LocalTime horaActual = LocalTime.now();
            LocalDate fechaActual = LocalDate.now();
            Notificacion objNotificacion = new Notificacion(paciente.getNumhabitacion()
                    ,nombreCompleto,edad,horaActual,fechaActual,puntuacion);
            
            this.objAnalisisInd.agregarIndicadoresRaros(paciente, objNotificacion);
            
            Notificacion band = this.objRemoto.notificar(objNotificacion);
            
            if(band != null){
                System.out.println("Notificación enviada con exito!");
            }
            else{
                System.out.println("Error al enviar la notificación!");
            }
        } catch (RemoteException ex) {
            System.out.println("Excepcion: "+ex.getMessage());
        }
    }
}
