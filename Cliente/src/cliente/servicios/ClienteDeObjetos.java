package cliente.servicios;

import cliente.utilidades.UtilidadesRegistroC;
import cliente.vista.Menu;
import servidor.controladores.ControladorGestorPacientesInt;

public class ClienteDeObjetos
{

    private static ControladorGestorPacientesInt objRemoto;

    public static void main(String[] args)
    {
        int numPuertoRMIRegistry = 2023;
        String direccionIpRMIRegistry = "localhost";        

        objRemoto = (ControladorGestorPacientesInt) UtilidadesRegistroC.obtenerObjRemoto(direccionIpRMIRegistry,numPuertoRMIRegistry, "idGestorPacientes");
        Menu objMenu= new Menu(objRemoto);
        objMenu.ejecutarMenuPrincipal();
    }
	
}

