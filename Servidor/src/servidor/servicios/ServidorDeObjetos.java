package servidor.servicios;


import servidor.utilidades.UtilidadesRegistroS;
import servidor.utilidades.UtilidadesConsola;
import java.rmi.RemoteException;
import servidor.Repositorios.UsuarioRepository;
import servidor.controladores.ControladorGestorEquiposNotificacionImpl;
import servidor.controladores.ControladorGestorUsuariosImpl;
import java.rmi.Remote;

public class ServidorDeObjetos
{
    public static void main(String args[]) throws RemoteException
    {        
         
        int numPuertoRMIRegistry = 0;
        String direccionIpRMIRegistry = "";
                       
        System.out.println("Cual es el la dirección ip donde se encuentra  el rmiRegistry ");
        direccionIpRMIRegistry = UtilidadesConsola.leerCadena();
        System.out.println("Cual es el número de puerto por el cual escucha el rmiRegistry ");
        numPuertoRMIRegistry = UtilidadesConsola.leerEntero(); 
     
        UsuarioRepository objRepository = new UsuarioRepository();
        ControladorGestorEquiposNotificacionImpl objControladorGestorEquipos = new ControladorGestorEquiposNotificacionImpl();//se leasigna el puerto de escucha del objeto remoto
        ControladorGestorUsuariosImpl objRemotoGestionUsuarios = new ControladorGestorUsuariosImpl(objRepository,objControladorGestorEquipos);
        try
        {
           UtilidadesRegistroS.arrancarNS(numPuertoRMIRegistry);
           UtilidadesRegistroS.RegistrarObjetoRemoto((Remote) objRemotoGestionUsuarios,direccionIpRMIRegistry, numPuertoRMIRegistry, "objServicioGestionUsuarios");            
           UtilidadesRegistroS.RegistrarObjetoRemoto((Remote) objControladorGestorEquipos,direccionIpRMIRegistry, numPuertoRMIRegistry, "objServicioGestionEquipos");            
          
        } catch (Exception e)
        {
            System.err.println("No fue posible Arrancar el NS o Registrar el objeto remoto" +  e.getMessage());
        }
        
        
    }
}
