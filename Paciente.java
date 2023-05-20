import java.util.List;

public class Paciente extends Pessoa{
    private List<String> vacinas;
    private int[] arraydose, dias_apos_ultima_dose;

    Paciente(String nome, String cpf, int idade, List<String> vacinas, int[] arraydose, int[] dias_apos_ultima_dose){
        super(nome, cpf, idade);
        this.vacinas = vacinas;
        this.arraydose = arraydose;
        this.dias_apos_ultima_dose = dias_apos_ultima_dose;
    }

    public List<String> getVacinas() {
        return vacinas;
    }    

    public int[] getArraydose() {
        return arraydose;
    }

    public int[] getDias_apos_ultima_dose() {
        return dias_apos_ultima_dose;
    }
}
