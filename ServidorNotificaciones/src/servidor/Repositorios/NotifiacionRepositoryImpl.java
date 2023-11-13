package servidor.Repositorios;


import java.util.LinkedList;
import java.util.List;
import servidor.DTO.NotificacionDTO;
import servidor.Repositorios.NotificacionRepositoryInt;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author USUARIO
 */
public class NotifiacionRepositoryImpl implements NotificacionRepositoryInt{

    private LinkedList<NotificacionDTO> notificacion;

    public NotifiacionRepositoryImpl() {
        this.notificacion = new LinkedList();
    }

    @Override
    public NotificacionDTO registrarNotificacion(NotificacionDTO objPaciente) {
        this.notificacion.add(objPaciente);
        return objPaciente;
    }

    @Override
    public int consultarCantidadNotificaciones() {
        return this.notificacion.size();
    }

    @Override
    public NotificacionDTO consultarNotificacion(int numHabitacion) {
        for(NotificacionDTO paciente: this.notificacion){
            if(paciente.getNumhabitacion()== numHabitacion){
                return paciente;
            }
        }
        return null;
    }

    @Override
    public List<NotificacionDTO> listarNotificacion() {
        return this.notificacion;
    }  
    
    
}
