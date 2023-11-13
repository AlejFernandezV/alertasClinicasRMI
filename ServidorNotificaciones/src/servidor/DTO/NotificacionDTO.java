/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor.DTO;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author USUARIO
 */


public class NotificacionDTO implements Serializable{
    private int numhabitacion;
    private String nombres; 
    private String apellidos;
    private Date fecNacimiento;
    
    public NotificacionDTO(int numhabitacion, String nombres, String apellidos, Date fecNacimiento) {
        this.numhabitacion = numhabitacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fecNacimiento = fecNacimiento;
    }

    public NotificacionDTO() {
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

    public Date getFecNacimiento() {
        return fecNacimiento;
    }

    public void setFecNacimiento(Date fecNacimiento) {
        this.fecNacimiento = fecNacimiento;
    }
    
    public void imprimirInfo(){
        System.out.println("Información Paciente");
        System.out.println("Número de habitación: "+this.getNumhabitacion());
        System.out.println("Nombres: "+this.getNombres());
        System.out.println("Apellidos: "+this.getApellidos());
        System.out.println("Fecha nacimiento: "+this.getFecNacimiento().toString());
    }

    
    
}
