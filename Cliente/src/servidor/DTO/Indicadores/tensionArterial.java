package servidor.DTO.Indicadores;

/**
 *
 * @author Alejandro
 */
public class tensionArterial{
    private int sistolica;
    private int diastolica;

    public tensionArterial() {
    }

    public int getSistolica() {
        return sistolica;
    }

    public void setSistolica(int sistolica) {
        this.sistolica = sistolica;
    }

    public int getDiastolica() {
        return diastolica;
    }

    public void setDiastolica(int diastolica) {
        this.diastolica = diastolica;
    } 
}
