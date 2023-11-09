package servidor.DTO;

import java.io.Serializable;
import java.util.Date;

public class UsuarioDTO implements Serializable
{	
    private int  noHabitacion;
    private String nombres, apellidos;
    private Date fechaNa;

    public UsuarioDTO(int noHabitacion, String nombres, String apellidos, Date fechaNa) {
        this.noHabitacion = noHabitacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNa = fechaNa;
    }

    public int getNoHabitacion() {
        return noHabitacion;
    }

    public void setNoHabitacion(int noHabitacion) {
        this.noHabitacion = noHabitacion;
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

    public Date getFechaNa() {
        return fechaNa;
    }

    public void setFechaNa(Date fechaNa) {
        this.fechaNa = fechaNa;
    }

    

    
       
}
