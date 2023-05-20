import java.util.List;

public class Paciente_perfeito extends Pessoa{
    private List<String> vacinas;
    private int[] arraydose;
    private int[] doses;

    Paciente_perfeito(int idade){
        super(idade);
        if(idade < 12){
            this.doses = Vacina.getDosesCrianca();
            this.vacinas = Vacina.getVacinas_crianca();
            this.arraydose = Vacina.getDosesCrianca();
        }else if(idade < 18){
            this.doses = Vacina.getDosesAdolescentes();
            this.vacinas = Vacina.getVacinas_adolescente();
            this.arraydose = Vacina.getDosesAdolescentes();
        }else{
            this.doses = Vacina.getDosesAdutos();
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

    public int[] getDoses() {
        return doses;
    }
}
