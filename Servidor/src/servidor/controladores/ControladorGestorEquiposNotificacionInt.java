package servidor.controladores;


import cliente.controladores.ControladorCallbackInt;
import java. rmi. Remote;
import java.rmi. RemoteException;

public interface ControladorGestorEquiposNotificacionInt extends Remote
{
    public boolean registrarReferenciaRemota(ControladorCallbackInt referencia) throws RemoteException;
}

