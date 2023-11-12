package cliente.vista;

import cliente.operaciones.menuOperaciones;
import cliente.utilidades.UtilidadesConsola;
import servidor.controladores.ControladorGestorPacientesInt;

public class Menu {
    
    private final menuOperaciones mOps;
    
    public Menu(ControladorGestorPacientesInt objRemoto) {
        this.mOps = new menuOperaciones(objRemoto);
    }

    public void ejecutarMenuPrincipal() {
        int opcion = 0;
        do {
            
            this.mOps.imprimirMenu();
            opcion = UtilidadesConsola.leerEntero();

            switch (opcion) {
                case 1:
                    this.mOps.opcionRegistroPaciente();
                    break;
                case 2:
                    this.mOps.opcionComenzarLectura();
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }

        } while (opcion != 2);
    }  
}
