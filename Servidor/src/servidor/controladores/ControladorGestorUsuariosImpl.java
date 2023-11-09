package servidor.controladores;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import servidor.DTO.UsuarioDTO;
import servidor.Repositorios.UsuarioRepositoryInt;

public class ControladorGestorUsuariosImpl extends UnicastRemoteObject implements ControladorGestorUsuariosInt{
    
    private final UsuarioRepositoryInt objPacientesRepository;
    private final ControladorGestorEquiposNotificacionImpl objRemotoGestionEquiposNotificacion;

    public ControladorGestorUsuariosImpl(UsuarioRepositoryInt objPacientesRepository, ControladorGestorEquiposNotificacionImpl objRemotoGestionEquiposNotificacion) 
    throws RemoteException
    {
        super(); //se asigna un puerto de escucha al OR
        this.objPacientesRepository=objPacientesRepository;
        this.objRemotoGestionEquiposNotificacion = objRemotoGestionEquiposNotificacion;
    }    
    
    @Override
    public boolean registrarPaciente(UsuarioDTO objPaciente) throws RemoteException 
    {
        objRemotoGestionEquiposNotificacion.notificarEquiposSobreNuevoRegistroPaciente(objPaciente);
        return this.objPacientesRepository.registrarPaciente(objPaciente);
    }
       
    @Override
    public int consultarCantidadPacientes() {
        return this.objPacientesRepository.consultarCantidadPacientes();
    }
    
    @Override
    public List<UsuarioDTO> listarPacientes() 
    {
        return this.objPacientesRepository.listarPacientes();
    }
   
    @Override
    public UsuarioDTO consultarPaciente(int nHabitacion)
    {
        return this.objPacientesRepository.consultarPaciente(nHabitacion);
    }
    
}
