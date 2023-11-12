

package servidor.controladores;

import java.rmi.Remote;
import java.rmi.RemoteException;
import servidor.DTO.PacienteDTO;



//Hereda de la clase Remote, lo cual la convierte en interfaz remota
public interface ControladorGestorPacientesInt extends Remote
{
    public PacienteDTO registrarPaciente(PacienteDTO objPaciente) throws RemoteException;
    public PacienteDTO enviarDatos(PacienteDTO objPaciente) throws RemoteException;
}


