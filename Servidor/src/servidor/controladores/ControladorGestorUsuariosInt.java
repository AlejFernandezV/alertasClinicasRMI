package servidor.controladores;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import servidor.DTO.UsuarioDTO;


public interface ControladorGestorUsuariosInt extends Remote
{
    //Definicion del primer método remoto
    public boolean registrarPaciente(UsuarioDTO objPaciente) throws RemoteException;
    //cada definición del método debe especificar que puede lanzar la excepción java.rmi.RemoteException
    
    //Definicion del segundo método remoto
    public int consultarCantidadPacientes() throws RemoteException; 
    //cada definición del método debe especificar que puede lanzar la excepción java.rmi.RemoteException
    
    //Definicion del tercer método remoto
    public List<UsuarioDTO> listarPacientes() throws RemoteException; 
    //cada definición del método debe especificar que puede lanzar la excepción java.rmi.RemoteException
   
    //Definicion del cuarto método remoto
    public UsuarioDTO consultarPaciente(int nHabitacion)throws RemoteException;
     //cada definición del método debe especificar que puede lanzar la excepción java.rmi.RemoteException    
}


