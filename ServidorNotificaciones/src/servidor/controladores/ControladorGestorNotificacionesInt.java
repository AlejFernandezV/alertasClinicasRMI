package servidor.controladores;
import java.rmi.Remote;
import java.rmi.RemoteException;
import servidor.DTO.Notificacion;
/**
 *
 * @author Jhosseff
 */
public interface ControladorGestorNotificacionesInt extends Remote {
    Notificacion notificar(Notificacion objNotificacion) throws RemoteException;
}
