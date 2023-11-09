package servidor.controladores;

import cliente.controladores.ControladorCallbackInt;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import servidor.DTO.UsuarioDTO;

public class ControladorGestorEquiposNotificacionImpl extends UnicastRemoteObject implements ControladorGestorEquiposNotificacionInt {

    private final LinkedList<ControladorCallbackInt> listaReferencias;

    public ControladorGestorEquiposNotificacionImpl() throws RemoteException {
        super();
        this.listaReferencias = new LinkedList();
    }

    @Override
    public boolean registrarReferenciaRemota(ControladorCallbackInt referencia) throws RemoteException {
        return this.listaReferencias.add(referencia);
    }

    public void notificarEquiposSobreNuevoRegistroPaciente(UsuarioDTO objUsuario) {
        this.listaReferencias.forEach(
                obj -> {
                    try {
                        obj.notificarRegistroUsuario(objUsuario);
                    } catch (RemoteException ex) {
                        System.out.println("Error al notificar al administrador");
                    }
                }
        );
    }

}
