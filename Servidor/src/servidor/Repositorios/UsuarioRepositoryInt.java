
package servidor.Repositorios;

import java.util.List;
import servidor.DTO.UsuarioDTO;

public interface UsuarioRepositoryInt
{    
    public boolean registrarPaciente(UsuarioDTO objPaciente);
    public int consultarCantidadPacientes();
    public UsuarioDTO consultarPaciente(int nHabitacion);
    public List<UsuarioDTO> listarPacientes();
}


