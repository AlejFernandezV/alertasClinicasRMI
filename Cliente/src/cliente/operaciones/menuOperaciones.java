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
        this.objIndOps = new indicadorOperaciones();
    }

    public PacienteDTO getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteDTO paciente) {
        this.paciente = paciente;
    }

    public indicadorOperaciones getObjIndOps() {
        return objIndOps;
    }

    public void setObjIndOps(indicadorOperaciones objIndOps) {
        this.objIndOps = objIndOps;
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
            this.getObjIndOps().setObjPaciente(this.paciente);
            this.getObjIndOps().setCantidadEdad(this.paciente.getCantidadEdad());
            this.getObjIndOps().setTipoEdad(this.paciente.getTipoEdad());
            
            if (bandera != null) {
                System.out.println("Registro del paciente realizado satisfactoriamente...");
            } else {
                System.out.println("No se pudo realizar el registro...");
            }
        } catch (RemoteException e) {
            System.out.println("La operacion no se pudo completar, intente nuevamente...");
            System.out.println("Excepcion: "+e.getMessage());
        }
    }

    public void opcionComenzarLectura() {
        
        try{
            System.out.println("== Lectura de sensores ==");
            
            while (true){
                System.out.println("Enviando indicadores...\n");
                this.objIndOps.generarValoresIndicadores();
                PacienteDTO bandera = this.objRemoto.enviarDatos(this.paciente);
                
                if (bandera != null) {
                    System.out.println("Freecuencia cardiaca: " + this.getPaciente().getContInd().getObjFC().getLatidosPM());
                    System.out.println("Presion arterial: " + this.getPaciente().getContInd().getObjTA().getSistolica()+"/"+this.getPaciente().getContInd().getObjTA().getDiastolica());
                    System.out.println("Freecuencia respiratoria: " + this.getPaciente().getContInd().getObjFR().getVentilacionesPM());
                    System.out.println("Temperatura : " + this.getPaciente().getContInd().getObjTemp().getGradosC()+" C");
                    System.out.println("Saturacion de oxigeno: " + this.getPaciente().getContInd().getObjSO().getPerOxigeno()+"%");
                    System.out.println("");
                } else {
                    System.out.println("No se pudo realizar el envío de los datos...");
                }
                Thread.sleep(8000);
            }
        }catch(RemoteException e){
            System.out.println("La operacion no se pudo completar, intente nuevamente...");
        }catch(Exception e){
            System.out.println("Error! Excepcion: "+e.getMessage());
        }
        
    }
}
