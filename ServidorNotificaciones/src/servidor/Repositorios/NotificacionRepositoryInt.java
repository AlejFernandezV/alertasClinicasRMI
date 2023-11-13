
package servidor.Repositorios;

import java.util.List;
import servidor.DTO.NotificacionDTO;

public interface NotificacionRepositoryInt
{    
    public NotificacionDTO registrarNotificacion(NotificacionDTO objPaciente);
    public int consultarCantidadNotificaciones();
    public NotificacionDTO consultarNotificacion(int numeroHabitacion);
    public List<NotificacionDTO> listarNotificacion();
}


