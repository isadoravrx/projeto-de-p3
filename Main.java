import java.util.Calendar;

public class Main{

    public static void main(String[] args) {
        Dados_pessoais.prnt();

        int ano = Dados_pessoais.getAnoNascimento();
        int mes = Dados_pessoais.getMesNascimento();
        int dia = Dados_pessoais.getDiaNascimento();

        int idade;
        Calendar hoje = Calendar.getInstance();
        int anodehoje = hoje.get(Calendar.YEAR);
        int mesdehoje = hoje.get(Calendar.MONTH);
        int diadehoje = hoje.get(Calendar.DAY_OF_MONTH);
        
        idade = anodehoje - ano;
        if(mesdehoje < mes){
            idade--;
        }else if(diadehoje < dia && mesdehoje == mes){
            idade--;
        }

        
        Selecionando_vacinas.prnt(idade);
        
    }
}