package servidor.DTO;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Jhossef
 */
public class Notificacion {
    private int noHabitacion;
    private String nombreCompleto;
    private String edad;
    private LocalTime horaAlerta;
    private Date fechaAlerta;
    private int puntuacion;
    private ArrayList<Indicador> indicadores;

    public Notificacion() {
    }

    public Notificacion(int noHabitacion, String nombreCompleto, String edad, LocalTime horaAlerta, Date fechaAlerta) {
        this.noHabitacion = noHabitacion;
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
        this.horaAlerta = horaAlerta;
        this.fechaAlerta = fechaAlerta;
        this.indicadores = new ArrayList<>();
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

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
    
    public ArrayList<Indicador> getIndicadores() {
        return indicadores;
    }

    public void setIndicadores(ArrayList<Indicador> indicadores) {
        this.indicadores = indicadores;
    }
    
    public void imprimir(){
        System.out.println("Alerta generada");
        System.out.println("Número de habitación: " + this.getNoHabitacion());
        System.out.println("Nombres y apellidos: " + this.getNombreCompleto());
        System.out.println("Edad: " + this.getEdad());
        System.out.println("Hora de la alerta: " + this.getHoraAlerta());
        System.out.println("Fecha de la alerta: " + this.getFechaAlerta());
        if(!this.getIndicadores().isEmpty()){
            System.out.println("Indicadores:");
            System.out.println("| Nombre | Valor |");
            System.out.println("|---|---|");
            for (Indicador indicador : indicadores) {
                System.out.printf("| %s | %s |%n", indicador.getNombre(), indicador.getValor());
            }
        }
        if(this.getPuntuacion()==2){
            System.out.printf("Se necesita una enfermera en la habitacion "+ this.getNoHabitacion());
        }
        else if(this.getPuntuacion()>=3){
            System.out.printf("Se necesita una enfermera y un medico en la habitacion "+ this.getNoHabitacion());
        }
    }
    
}
