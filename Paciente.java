public class Paciente extends Pessoa{
    boolean[] vacinas;

    Paciente(String nome, String cpf, int dia, int mes, int ano, boolean[] vacinas){
        super(null, null, 0, 0, 0);
        this.vacinas = vacinas;
    }
}
