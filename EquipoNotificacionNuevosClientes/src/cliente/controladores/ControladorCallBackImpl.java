package cliente.controladores;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import servidor.DTO.UsuarioDTO;

public class ControladorCallBackImpl extends UnicastRemoteObject implements ControladorCallbackInt {

    public ControladorCallBackImpl() throws RemoteException {
        super();
    }

    @Override
    public void notificarRegistroUsuario(UsuarioDTO objUsuario) throws RemoteException {

        System.out.println("Un paciente nuevo se ha registrado");
        System.out.println("No habitacion: " + objUsuario.getNoHabitacion());
        System.out.println("Nombres: " + objUsuario.getNombres());
        System.out.println("Apellidos: " + objUsuario.getApellidos());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");
        String fecha = simpleDateFormat.format(objUsuario.getFechaNa());
        System.out.println("Fecha nacimiento: " + fecha);
        Date fechaActual = Date.from(Instant.now());
        fecha = simpleDateFormat.format(fechaActual);
        System.out.println("Fecha actual del registro: " + fecha);
    }

}
