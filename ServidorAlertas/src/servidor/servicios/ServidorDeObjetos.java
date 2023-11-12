/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.servicios;


import servidor.utilidades.UtilidadesRegistroS;
import servidor.utilidades.UtilidadesConsola;
import java.rmi.RemoteException;
import servidor.Repositorios.PacienteRepositoryImpl;
import servidor.controladores.ControladorGestorNotificacionesInt;
import servidor.controladores.ControladorGestorPacientesImpl;

public class ServidorDeObjetos
{
    public static void main(String args[]) throws RemoteException
    {        
         
        int numPuertoRMIRegistry = 2023;
        String direccionIpRMIRegistry = "localhost";
                       
        //Crear el repositorio
        PacienteRepositoryImpl objPacienteRepositoryImpl = new PacienteRepositoryImpl();
        //Crear el objeto remoto
        ControladorGestorPacientesImpl objRemoto = new ControladorGestorPacientesImpl(objPacienteRepositoryImpl);
        // Obtener la referencia al servicio de notificación del servidor de notificaciones
        ControladorGestorNotificacionesInt servicioNotificacion = (ControladorGestorNotificacionesInt) UtilidadesRegistroS.obtenerObjRemoto("localhost", 2024, "idGestorNotificaciones");

        try
        {
           UtilidadesRegistroS.arrancarNS(numPuertoRMIRegistry);
           UtilidadesRegistroS.RegistrarObjetoRemoto(objRemoto, direccionIpRMIRegistry, numPuertoRMIRegistry, "idGestorPacientes");            
           
           // Intento de  Llamada al método de notificación   que queda en NULL
           //servicioNotificacion.notificar("Se ha generado una alerta en el servidor de alertas.");
      
        } catch (Exception e)
        {
            System.err.println("No fue posible Arrancar el NS o Registrar el objeto remoto" +  e.getMessage());
        }
    }
}
