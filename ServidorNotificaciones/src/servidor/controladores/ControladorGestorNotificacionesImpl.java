package servidor.controladores;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import servidor.DTO.Notificacion;
import servidor.Repositorios.NotificacionRepositoryInt;
/**
 *
 * @author Jhossef
 */
public class ControladorGestorNotificacionesImpl extends UnicastRemoteObject implements ControladorGestorNotificacionesInt{
    
    NotificacionRepositoryInt repositorio;
    
    public ControladorGestorNotificacionesImpl(NotificacionRepositoryInt repositorio) throws RemoteException {
        super();
        this.repositorio = repositorio;
    }
    
    @Override
    public Notificacion notificar(Notificacion objNotificacion) throws RemoteException {
        System.out.println("Notificación recibida!");
        return repositorio.registrarNotificacion(objNotificacion);
    }
}
