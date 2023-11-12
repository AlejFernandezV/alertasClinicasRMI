
package servidor.Repositorios;

import java.util.LinkedList;
import java.util.List;
import servidor.DTO.Indicadores.contenedorIndicadores;
import servidor.DTO.PacienteDTO;

public interface PacienteRepositoryInt
{    
    public PacienteDTO registrarPaciente(PacienteDTO objPaciente);
    public boolean enviarDatos(PacienteDTO objPaciente);
}


