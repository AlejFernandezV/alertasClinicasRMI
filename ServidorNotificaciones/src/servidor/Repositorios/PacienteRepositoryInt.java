
package servidor.Repositorios;

import java.util.List;
import servidor.DTO.PacienteDTO;

public interface PacienteRepositoryInt
{    
    public PacienteDTO registrarPaciente(PacienteDTO objPaciente);
    public int consultarCantidadPacientes();
    public PacienteDTO consultarPaciente(int numeroHabitacion);
    public List<PacienteDTO> listarPacientes();
}


