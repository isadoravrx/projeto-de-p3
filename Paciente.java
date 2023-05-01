import java.util.List;

public class Paciente extends Pessoa{
    List<String> vacinas;

    Paciente(String nome, String cpf, int idade, List<String> vacinas){
        super(nome, cpf, idade);
        this.vacinas = vacinas;
    }

    public List<String> getVacinas() {
        return vacinas;
    }    
}
