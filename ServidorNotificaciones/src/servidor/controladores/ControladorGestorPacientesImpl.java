package servidor.controladores;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import servidor.DTO.PacienteDTO;
import servidor.Repositorios.PacienteRepositoryInt;

/**
 *
 * @author USUARIO
 */
public class ControladorGestorPacientesImpl extends UnicastRemoteObject implements ControladorGestorPacientesInt{

    PacienteRepositoryInt objRepositorio;
    
    public ControladorGestorPacientesImpl(PacienteRepositoryInt objRepositorio) throws RemoteException {
        super(); //Asigna el puerto de escucha (El que esté libre)
        this.objRepositorio = objRepositorio;
    }

    @Override
    public PacienteDTO registrarPaciente(PacienteDTO objPaciente) throws RemoteException {
        return this.objRepositorio.registrarPaciente(objPaciente);
    }

    @Override
    public int consultarCantidadPacientes() throws RemoteException {
        return this.objRepositorio.consultarCantidadPacientes();
    }

    @Override
    public List<PacienteDTO> listarPacientes() throws RemoteException {
        return this.objRepositorio.listarPacientes();
    }

    @Override
    public PacienteDTO consultarPaciente(int numHabitacion) throws RemoteException {
        return this.objRepositorio.consultarPaciente(numHabitacion);
    }

}
