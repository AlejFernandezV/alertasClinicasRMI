/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor.controladores;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
/**
 *
 * @author Sublitextil
 */
public class ControladorGestorNotificacionesImpl extends UnicastRemoteObject implements ControladorGestorNotificacionesInt{
    public ControladorGestorNotificacionesImpl() throws RemoteException {
        super();
    }
    @Override
    public void notificar(String mensaje) throws RemoteException {
        System.out.println("Notificación recibida: " + mensaje);
        
    }
}
