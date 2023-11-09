

package servidor.controladores;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import servidor.DTO.PacienteDTO;



//Hereda de la clase Remote, lo cual la convierte en interfaz remota
public interface ControladorGestorPacientesInt extends Remote
{
    //Definicion del primer método remoto
    public  PacienteDTO registrarPaciente(PacienteDTO objPaciente) throws RemoteException;
    //cada definición del método debe especificar que puede lanzar la excepción java.rmi.RemoteException
    
    public boolean enviarDatos(PacienteDTO objPaciente) throws RemoteException;
    
    //Definicion del segundo método remoto
    public int consultarCantidadPacientes() throws RemoteException; 
    //cada definición del método debe especificar que puede lanzar la excepción java.rmi.RemoteException
    
    //Definicion del tercer método remoto
    public  List<PacienteDTO> listarPacientes() throws RemoteException; 
    //cada definición del método debe especificar que puede lanzar la excepción java.rmi.RemoteException
   
    //Definicion del cuarto método remoto
    public  PacienteDTO consultarPaciente(int numHabitacion)throws RemoteException;
     //cada definición del método debe especificar que puede lanzar la excepción java.rmi.RemoteException    
}


