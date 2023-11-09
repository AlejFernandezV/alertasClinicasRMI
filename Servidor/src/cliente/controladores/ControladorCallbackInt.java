package cliente.controladores;
import java.rmi.Remote;
import java.rmi.RemoteException;
import servidor.DTO.UsuarioDTO;

public interface ControladorCallbackInt extends Remote{
    public void notificarRegistroUsuario(UsuarioDTO objUsuario) throws RemoteException;
}