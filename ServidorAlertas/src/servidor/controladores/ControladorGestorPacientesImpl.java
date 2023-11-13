package servidor.controladores;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import servidor.DTO.PacienteDTO;
import servidor.Repositorios.PacienteRepositoryInt;
import servidor.operaciones.analisisIndicadores;

/**
 *
 * @author Alejandro
 */
public class ControladorGestorPacientesImpl extends UnicastRemoteObject implements ControladorGestorPacientesInt{

    PacienteRepositoryInt objRepositorio;
    private analisisIndicadores objAnalisisInd;
    
    public ControladorGestorPacientesImpl(PacienteRepositoryInt objRepositorio) throws RemoteException {
        super(); //Asigna el puerto de escucha (El que esté libre)
        this.objRepositorio = objRepositorio;
        this.objAnalisisInd = new analisisIndicadores();
    }

    @Override
    public PacienteDTO registrarPaciente(PacienteDTO objPaciente) throws RemoteException {
        System.out.println("Paciente registrado!\n");
        return this.objRepositorio.registrarPaciente(objPaciente);
    }

    @Override
    public PacienteDTO enviarDatos(PacienteDTO objPaciente) throws RemoteException {
        System.out.println("Recibiendo paciente con sus indicadores!");
        return this.objRepositorio.enviarDatos(objPaciente);
    }
}
