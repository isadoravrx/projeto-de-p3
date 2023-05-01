import java.util.List;

public class Paciente extends Pessoa{
    private List<String> vacinas;
    private int[] arraydose;

    Paciente(String nome, String cpf, int idade, List<String> vacinas, int[] arraydose){
        super(nome, cpf, idade);
        this.vacinas = vacinas;
        this.arraydose = arraydose;
    }

    public List<String> getVacinas() {
        return vacinas;
    }    

    public int[] getArraydose() {
        return arraydose;
    }
}
