package servidor.Repositorios;


import java.util.LinkedList;
import java.util.List;
import servidor.DTO.Notificacion;
import servidor.Repositorios.NotificacionRepositoryInt;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author USUARIO
 */
public class NotifiacionRepositoryImpl implements NotificacionRepositoryInt{

    private LinkedList<Notificacion> notificaciones;
    
    public NotifiacionRepositoryImpl() {
        this.notificaciones = new LinkedList();
    }

    @Override
    public Notificacion registrarNotificacion(Notificacion objPaciente) {
        this.notificaciones.add(objPaciente);
        return objPaciente;
    }
    
    private void mostrarNotificacion (){
        LinkedList<Notificacion>auxNotificacion = this.notificaciones.reversed();
        
        System.out.println("Ultimas 5 alertas:");
        System.out.println("| Fecha | Hora | Puntuacion |");
        System.out.println("|---|---|---|");
        for (int i = 0; i<5;i++){
            System.out.printf("| %s | %s | %s |%n", auxNotificacion.get(i).getFechaAlerta(),
                    auxNotificacion.get(i).getHoraAlerta(),auxNotificacion.get(i).getPuntuacion());
        }   
    }
}
