package servidor.DTO;

import cliente.operaciones.indicadorOperaciones;
import java.io.Serializable;
import servidor.DTO.Indicadores.contenedorIndicadores;

/**
 *
 * @author Alejandro
 */

public class PacienteDTO implements Serializable{
    private int numhabitacion;
    private String nombres;
    private String apellidos;
    private int cantidadEdad;
    private String tipoEdad;
    private contenedorIndicadores contInd;

    public PacienteDTO() {
        this.contInd = new contenedorIndicadores();
    }

    public PacienteDTO(int numhabitacion, String nombres, String apellidos, int cantidadEdad, String tipoEdad) {
        this.numhabitacion = numhabitacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cantidadEdad = cantidadEdad;
        this.tipoEdad = tipoEdad;
        this.contInd = new contenedorIndicadores();
    }

    public int getNumhabitacion() {
        return numhabitacion;
    }

    public void setNumhabitacion(int numhabitacion) {
        this.numhabitacion = numhabitacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getCantidadEdad() {
        return cantidadEdad;
    }

    public void setCantidadEdad(int cantidadEdad) {
        this.cantidadEdad = cantidadEdad;
    }

    public String getTipoEdad() {
        return tipoEdad;
    }

    public void setTipoEdad(String tipoEdad) {
        this.tipoEdad = tipoEdad;
    }

    public contenedorIndicadores getContInd() {
        return contInd;
    }

    public void setContInd(contenedorIndicadores contInd) {
        this.contInd = contInd;
    }
    
 
    public void imprimirInfo(){
        System.out.println("Información Paciente");
        System.out.println("Número de habitación: "+this.getNumhabitacion());
        System.out.println("Nombres: "+this.getNombres());
        System.out.println("Apellidos: "+this.getApellidos());
        System.out.println("Edad: "+this.getCantidadEdad() + this.getTipoEdad());
    }  
}
