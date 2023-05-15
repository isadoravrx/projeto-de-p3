import java.util.List;

public class Paciente_perfeito extends Pessoa{
    private List<String> vacinas;
    private int[] arraydose;

    Paciente_perfeito(int idade){
        super("Gabriel", "95195923000", idade);
        if(idade < 12){
            this.vacinas = Vacina.getVacinas_crianca();
            this.arraydose = Vacina.getDosesCrianca();
        }else if(idade < 18){
            this.vacinas = Vacina.getVacinas_adolescente();
            this.arraydose = Vacina.getDosesAdolescentes();
        }else{
            this.vacinas = Vacina.getVacinas_adulto();
            this.arraydose = Vacina.getDosesAdutos();
        }
         
    }

    public List<String> getVacinas() {
        return vacinas;
    }    

    public int[] getArraydose() {
        return arraydose;
    }
}
