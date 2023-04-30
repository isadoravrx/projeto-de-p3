import java.util.List;

public class Paciente extends Pessoa{
    List<String> vacinas;

    Paciente(String nome, String cpf, int idade, List<String> vacinas){
        super(null, null, 0, 0, 0);
        this.vacinas = vacinas;
    }
}
