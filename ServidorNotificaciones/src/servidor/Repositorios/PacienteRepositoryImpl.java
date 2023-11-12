package servidor.Repositorios;


import java.util.LinkedList;
import java.util.List;
import servidor.DTO.PacienteDTO;
import servidor.Repositorios.PacienteRepositoryInt;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author USUARIO
 */
public class PacienteRepositoryImpl implements PacienteRepositoryInt{

    private LinkedList<PacienteDTO> pacientes;

    public PacienteRepositoryImpl() {
        this.pacientes = new LinkedList();
    }

    @Override
    public PacienteDTO registrarPaciente(PacienteDTO objPaciente) {
        this.pacientes.add(objPaciente);
        return objPaciente;
    }

    @Override
    public int consultarCantidadPacientes() {
        return this.pacientes.size();
    }

    @Override
    public PacienteDTO consultarPaciente(int numHabitacion) {
        for(PacienteDTO paciente: this.pacientes){
            if(paciente.getNumhabitacion()== numHabitacion){
                return paciente;
            }
        }
        return null;
    }

    @Override
    public List<PacienteDTO> listarPacientes() {
        return this.pacientes;
    }  
}
