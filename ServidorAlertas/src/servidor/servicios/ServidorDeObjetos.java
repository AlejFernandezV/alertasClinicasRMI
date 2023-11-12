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
        try
        {
           UtilidadesRegistroS.arrancarNS(numPuertoRMIRegistry);
           UtilidadesRegistroS.RegistrarObjetoRemoto(objRemoto, direccionIpRMIRegistry, numPuertoRMIRegistry, "idGestorPacientes");            
           
        } catch (Exception e)
        {
            System.err.println("No fue posible Arrancar el NS o Registrar el objeto remoto" +  e.getMessage());
        }
    }
}
