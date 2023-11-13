package servidor.DTO.Notificacion;

import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author Alejandro
 */
public class Notificacion {
    private int noHabitacion;
    private String nombreCompleto;
    private String edad;
    private LocalTime horaAlerta;
    private Date fechaAlerta;

    public Notificacion() {
    }

    public Notificacion(int noHabitacion, String nombreCompleto, String edad, LocalTime horaAlerta, Date fechaAlerta) {
        this.noHabitacion = noHabitacion;
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
        this.horaAlerta = horaAlerta;
        this.fechaAlerta = fechaAlerta;
    }

    public int getNoHabitacion() {
        return noHabitacion;
    }

    public void setNoHabitacion(int noHabitacion) {
        this.noHabitacion = noHabitacion;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public LocalTime getHoraAlerta() {
        return horaAlerta;
    }

    public void setHoraAlerta(LocalTime horaAlerta) {
        this.horaAlerta = horaAlerta;
    }

    public Date getFechaAlerta() {
        return fechaAlerta;
    }

    public void setFechaAlerta(Date fechaAlerta) {
        this.fechaAlerta = fechaAlerta;
    }
    
    public void imprimir(){
    }
    
}
