package servidor.Repositorios;

import java.util.ArrayList;
import java.util.List;
import servidor.DTO.UsuarioDTO;


public class UsuarioRepository implements UsuarioRepositoryInt
{  
    private final ArrayList<UsuarioDTO> misPacientes;

    public UsuarioRepository()
    {        
        this.misPacientes = new ArrayList();
    }

    @Override
    public boolean registrarPaciente(UsuarioDTO objPaciente)
    {
        System.out.println("Entrando a registrar");
        boolean bandera=false;
        
        if(this.misPacientes.size() < 5)
        {            
            bandera=this.misPacientes.add(objPaciente);
        }
        
        return bandera;
    }
    
    
    @Override
    public int consultarCantidadPacientes()
    {
        System.out.println("Entrando a Cantidad");
        return this.misPacientes.size();
    }

    
    @Override
    public UsuarioDTO consultarPaciente(int nHabitacion)
    {
        UsuarioDTO objPaciente=null;
        
        for (int i = 0; i < this.misPacientes.size(); i++) {
            if(this.misPacientes.get(i).getNoHabitacion() == nHabitacion)
            {
                objPaciente=this.misPacientes.get(i);
                break;
            }
        }
        return objPaciente;    
    }
    @Override
    public List<UsuarioDTO> listarPacientes()
    {
        return this.misPacientes;
    }
       
}
