/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package servidor.controladores;
import java.rmi.Remote;
import java.rmi.RemoteException;
import servidor.DTO.Notificacion;
/**
 *
 * @author Sublitextil
 */
public interface ControladorGestorNotificacionesInt extends Remote {
    Notificacion notificar(Notificacion objNotificacion) throws RemoteException;
}
