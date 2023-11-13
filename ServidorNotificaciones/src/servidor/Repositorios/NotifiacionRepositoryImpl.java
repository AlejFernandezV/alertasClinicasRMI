package servidor.Repositorios;


import java.util.LinkedList;
import java.util.List;
import servidor.DTO.Notificacion;
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

    private LinkedList<Notificacion> notificacion;

    public NotifiacionRepositoryImpl() {
        this.notificacion = new LinkedList();
    }

    @Override
    public Notificacion registrarNotificacion(Notificacion objPaciente) {
        this.notificacion.add(objPaciente);
        return objPaciente;
    }
}
