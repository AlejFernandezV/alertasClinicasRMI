package servidor.controladores;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import servidor.DTO.PacienteDTO;
import servidor.Repositorios.PacienteRepositoryInt;
import servidor.operaciones.analisisIndicadores;
import servidor.operaciones.verificaciones.verificarNormIndicador;

/**
 *
 * @author Alejandro
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
    public boolean enviarDatos(PacienteDTO objPaciente) throws RemoteException {
        return this.objRepositorio.enviarDatos(objPaciente);
    }
}
