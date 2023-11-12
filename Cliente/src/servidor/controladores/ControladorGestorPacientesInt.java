

package servidor.controladores;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import servidor.DTO.PacienteDTO;



//Hereda de la clase Remote, lo cual la convierte en interfaz remota
public interface ControladorGestorPacientesInt extends Remote
{
    public  PacienteDTO registrarPaciente(PacienteDTO objPaciente) throws RemoteException;
    public boolean enviarDatos(PacienteDTO objPaciente) throws RemoteException;
}


