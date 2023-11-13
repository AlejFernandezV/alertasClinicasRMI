/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor.servicios;


import servidor.utilidades.UtilidadesRegistroS;
import java.rmi.RemoteException;
import servidor.Repositorios.PacienteRepositoryImpl;
import servidor.controladores.ControladorGestorNotificacionesInt;
import servidor.controladores.ControladorGestorPacientesImpl;
public class ServidorDeObjetos
{
    private static ControladorGestorNotificacionesInt objRemoto;
    public static void main(String args[]) throws RemoteException
    {
         
        int numPuertoRMIRegistry = 2023;
        String direccionIpRMIRegistry = "localhost";
                       
        //Crear el repositorio
        PacienteRepositoryImpl objPacienteRepositoryImpl = new PacienteRepositoryImpl();
        objRemoto = (ControladorGestorNotificacionesInt) UtilidadesRegistroS.obtenerObjRemoto(direccionIpRMIRegistry,2024, "idGestorPacientes");
        //Crear el objeto remoto
        ControladorGestorPacientesImpl objRemotoPacientes = new ControladorGestorPacientesImpl(objPacienteRepositoryImpl);
        // Obtener la referencia al servicio de notificación del servidor de notificaciones  
        try
        {
           UtilidadesRegistroS.arrancarNS(numPuertoRMIRegistry);
           UtilidadesRegistroS.RegistrarObjetoRemoto(objRemotoPacientes, direccionIpRMIRegistry, numPuertoRMIRegistry, "idGestorPacientes");            
           
           //Llamada al método de notificación
           objRemoto.notificar("Conectado con el servidor Alertas");;
      
        } catch (Exception e)
        {
            System.err.println("No fue posible Arrancar el NS o Registrar el objeto remoto" +  e.getMessage());
        }
    }
}
