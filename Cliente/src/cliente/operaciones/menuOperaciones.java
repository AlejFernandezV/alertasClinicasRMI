package cliente.operaciones;

import java.rmi.RemoteException;
import servidor.DTO.PacienteDTO;
import servidor.controladores.ControladorGestorPacientesInt;

/**
 *
 * @author Alejandro
 */
public class menuOperaciones {
    
    private PacienteDTO paciente;
    private final ControladorGestorPacientesInt objRemoto;
    private pacienteOperaciones pOps;
    private indicadorOperaciones objIndOps;
    
    
    public menuOperaciones(ControladorGestorPacientesInt objRemoto) {
        this.objRemoto = objRemoto;
        this.pOps = new pacienteOperaciones();
        this.paciente = new PacienteDTO();
        this.objIndOps = new indicadorOperaciones(this.paciente);
    }
    
    public void imprimirMenu(){
        System.out.println("==========\tMenu de sensores\t==========");
        System.out.println("1. Ingresar datos del paciente");
        System.out.println("2. Comenzar lectura de los sensores");
        System.out.println("Digite una opcion: ");
    }
    
    public void opcionRegistroPaciente() {
        try {
            System.out.println("== Registro del paciente ==");

            this.pOps.ingresoNoHabitacion(this.paciente);
            this.pOps.ingresoNombreCompleto(this.paciente);
            this.pOps.ingresoEdad(this.paciente);
            
            this.paciente.imprimirInfo();

            PacienteDTO bandera = this.objRemoto.registrarPaciente(this.paciente);

            if (bandera != null) {
                System.out.println("Registro del paciente realizado satisfactoriamente...");
            } else {
                System.out.println("No se pudo realizar el registro...");
            }
        } catch (RemoteException e) {
            System.out.println("La operacion no se pudo completar, intente nuevamente...");
        }
    }

    public void opcionComenzarLectura() {
        
        try{
            System.out.println("== Lectura de sensores ==");
            
            while (true){
                
                System.out.println("Enviando indicadores...");
                this.objIndOps.generarValoresIndicadores();
                boolean bandera = this.objRemoto.enviarDatos(this.paciente);
                if (bandera) {
                    System.out.println("Freecuencia cardiaca: " + this.paciente.getContInd().getObjFR().getVentilacionesPM());
                    System.out.println("Presion arterial: " + this.paciente.getContInd().getObjTA().getSistolica()+"/"+this.paciente.getContInd().getObjTA().getDiastolica());
                    System.out.println("Freecuencia respiratoria: " + this.paciente.getContInd().getObjFR().getVentilacionesPM());
                    System.out.println("Temperatura : " + this.paciente.getContInd().getObjTemp().getGradosC()+"°");
                    System.out.println("Saturacion de oxigeno: " + this.paciente.getContInd().getObjSO().getPerOxigeno()+"%");
                    
                } else {
                    System.out.println("No se pudo realizar el envío de los datos...");
                }
                Thread.sleep(8000);
            }
        } catch(RemoteException e){
            System.out.println("La operacion no se pudo completar, intente nuevamente...");
        }catch(Exception e){
            System.out.println("Error al esperar 8 segundos!");
        }
        
    }
}
