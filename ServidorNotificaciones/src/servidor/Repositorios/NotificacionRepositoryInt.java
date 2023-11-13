
package servidor.Repositorios;

import java.rmi.RemoteException;
import java.util.List;
import servidor.DTO.Notificacion;

public interface NotificacionRepositoryInt
{    
    public Notificacion registrarNotificacion (Notificacion objNotificacion)throws RemoteException;
}


