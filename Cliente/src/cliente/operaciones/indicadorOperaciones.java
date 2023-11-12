package cliente.operaciones;

import java.security.SecureRandom;
import servidor.DTO.PacienteDTO;

/**
 *
 * @author Alejandro
 */
public class indicadorOperaciones {
    private PacienteDTO objPaciente;
    private int cantidadEdad;
    private String tipoEdad;
    
    public indicadorOperaciones(){
    }
    
    public indicadorOperaciones(PacienteDTO paciente) {
        this.objPaciente = paciente;
        this.cantidadEdad = paciente.getCantidadEdad();
        this.tipoEdad = paciente.getTipoEdad();
    }

    public PacienteDTO getObjPaciente() {
        return objPaciente;
    }

    public void setObjPaciente(PacienteDTO objPaciente) {
        this.objPaciente = objPaciente;
    }

    public int getCantidadEdad() {
        return cantidadEdad;
    }

    public void setCantidadEdad(int cantidadEdad) {
        this.cantidadEdad = cantidadEdad;
    }

    public String getTipoEdad() {
        return tipoEdad;
    }

    public void setTipoEdad(String tipoEdad) {
        this.tipoEdad = tipoEdad;
    }
    
    public void generarValoresIndicadores(){
        generarValorFrecuenciaCardiaca();
        generarValorTensionArterial();
        generarValorFrecuenciaRespiratoria();
        generarValorTemperatura();
        generarValorSaturacionOxigeno();
    }
    
    private void generarValorFrecuenciaCardiaca(){
        int valorFC = 0;
        
        if((tipoEdad.equals("semanas") || tipoEdad.equals("dias") || tipoEdad.equals("días")) && (cantidadEdad > 0 && cantidadEdad <= 6)){
            valorFC = generarValorIndicador(118,142);
        }
        else if((tipoEdad.equals("semanas") && cantidadEdad == 7) || (tipoEdad.equals("meses") && cantidadEdad <= 11)){
            valorFC = generarValorIndicador(98,135);
        }
        else if(tipoEdad.equals("años") && (cantidadEdad == 1 || cantidadEdad < 2)){
            valorFC = generarValorIndicador(98,122);
        }
        else if(tipoEdad.equals("años") && (cantidadEdad >= 2 || cantidadEdad < 6)){
            valorFC = generarValorIndicador(78,122);
        }
        else if(tipoEdad.equals("años") && (cantidadEdad >= 6 || cantidadEdad < 13)){
            valorFC = generarValorIndicador(78,102);
        }
        else if(tipoEdad.equals("años") && (cantidadEdad >= 13 || cantidadEdad < 16)){
            valorFC = generarValorIndicador(68,82);
        }
        else if(tipoEdad.equals("años") && (cantidadEdad >= 16)){
            valorFC = generarValorIndicador(58,82);
        }
        this.objPaciente.getContInd().getObjFC().setLatidosPM(valorFC);
    }
    
    private void generarValorTensionArterial(){
        int valorDiastolica = 0;
        int valorSistolica = 0;
        
        if((tipoEdad.equals("semanas") || tipoEdad.equals("dias") || tipoEdad.equals("días")) && (cantidadEdad > 0 && cantidadEdad <= 6)){
            valorDiastolica = generarValorIndicador(48,70);
            valorSistolica = generarValorIndicador(68,102);
        }
        else if((tipoEdad.equals("semanas") && cantidadEdad == 7) || (tipoEdad.equals("meses") && cantidadEdad <= 11)){
            valorDiastolica = generarValorIndicador(54,72);
            valorSistolica = generarValorIndicador(82,108);
        }
        else if(tipoEdad.equals("años") && (cantidadEdad == 1 && cantidadEdad < 2)){
            valorDiastolica = generarValorIndicador(56,72);
            valorSistolica = generarValorIndicador(96,108);
        }
        else if(tipoEdad.equals("años") && (cantidadEdad >= 2 && cantidadEdad < 6)){
            valorDiastolica = generarValorIndicador(62,72);
            valorSistolica = generarValorIndicador(97,114);
        }
        else if(tipoEdad.equals("años") && (cantidadEdad >= 6 && cantidadEdad < 13)){
            valorDiastolica = generarValorIndicador(62,88);
            valorSistolica = generarValorIndicador(102,126);
        }
        else if(tipoEdad.equals("años") && (cantidadEdad >= 13 && cantidadEdad < 16)){
            valorDiastolica = generarValorIndicador(116,134);
            valorSistolica = generarValorIndicador(118,142);
        }
        else if(tipoEdad.equals("años") && (cantidadEdad >= 16)){
            valorDiastolica = generarValorIndicador(68,84);
            valorSistolica = generarValorIndicador(108,142);
        }
        
        this.objPaciente.getContInd().getObjTA().setDiastolica(valorDiastolica);
        this.objPaciente.getContInd().getObjTA().setSistolica(valorSistolica);
    }
    
    private void generarValorFrecuenciaRespiratoria(){
        int valorFR = 0;
        
        if((tipoEdad.equals("semanas") || tipoEdad.equals("dias") || tipoEdad.equals("días")) && (cantidadEdad > 0 && cantidadEdad <= 6)){
            valorFR = generarValorIndicador(38,47);
        }
        else if((tipoEdad.equals("semanas") && cantidadEdad == 7) || 
                (tipoEdad.equals("meses") && cantidadEdad <= 11) || 
                (tipoEdad.equals("años") && (cantidadEdad >= 1 && cantidadEdad < 6))){
            valorFR = generarValorIndicador(18,32);
        }
        else if(tipoEdad.equals("años") && (cantidadEdad >= 6)){
            valorFR = generarValorIndicador(10,22);
        }
        
        this.objPaciente.getContInd().getObjFR().setVentilacionesPM(valorFR);
    }
    
    private void generarValorSaturacionOxigeno(){
        int valorSO = generarValorIndicador(88,100);
        this.objPaciente.getContInd().getObjSO().setPerOxigeno(valorSO);
    }
    
    private void generarValorTemperatura(){
        double valorTemp = 0.0;
        
        if((tipoEdad.equals("semanas") || tipoEdad.equals("dias")) && (cantidadEdad > 0 && cantidadEdad <= 6)){
            valorTemp = generarValorIndicador(37.0, 39.0);
        }
        else if((tipoEdad.equals("semanas") && cantidadEdad == 7) || 
                (tipoEdad.equals("meses") && cantidadEdad <= 11) || 
                (tipoEdad.equals("años") && (cantidadEdad >= 1 && cantidadEdad < 6))){
            valorTemp = generarValorIndicador(36.5,38.5);
        }
        else if(tipoEdad.equals("años") && (cantidadEdad >= 13 && cantidadEdad < 16)){
            valorTemp = generarValorIndicador(36.0,38.0);
        }
        else if(tipoEdad.equals("años") && (cantidadEdad >= 16)){
            valorTemp = generarValorIndicador(35.5,38.0);
        }
        
        this.objPaciente.getContInd().getObjTemp().setGradosC(valorTemp);
    }
    
    private int generarValorIndicador(int ranMin, int ranMax){
        SecureRandom sr = new SecureRandom();;
        sr.setSeed(sr.generateSeed(20));
        return sr.nextInt((ranMax - ranMin) + 1) + ranMin;
    }
    
    private double generarValorIndicador(double ranMin, double ranMax){
        SecureRandom sr = new SecureRandom();;
        sr.setSeed(sr.generateSeed(20));
        return Math.round((sr.nextDouble((ranMax - ranMin) + 1) + ranMin)*100.0)/100.0;
    }
}
