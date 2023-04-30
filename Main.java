import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
import java.util.List;

public class Main{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nome;
        String cpf;
        int dia;
        int mes;
        int ano;

        String[] opcoes = {};

        System.out.println("Qual é o seu nome?");
        nome = sc.nextLine();
        System.out.println("Qual é o seu cpf?");
        cpf = sc.nextLine();
        System.out.println("Qual é o dia do seu nascimento?");
        dia = sc.nextInt();
        System.out.println("Qual é o mês do seu nascimento?");
        mes = sc.nextInt();
        System.out.println("Qual é o ano do seu nascimento?");
        ano = sc.nextInt();

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

        JScrollPane scrollPane;
        JCheckBoxList<String> checkBoxList;

        if(idade < 12){
        
            List<String> vacinas_criancas = Vacina.getVacinas_crianca();
            checkBoxList = new JCheckBoxList<>(vacinas_criancas);
            scrollPane = new JScrollPane(checkBoxList);
            
        }else if(idade >= 12 && idade <= 18){

            List<String> vacinas_adolescentes = Vacina.getVacinas_adolescente();
            checkBoxList = new JCheckBoxList<>(vacinas_adolescentes);
            scrollPane = new JScrollPane(checkBoxList); 

        }else{

            List<String> vacinas_adultos = Vacina.getVacinas_adulto();
            checkBoxList = new JCheckBoxList<>(vacinas_adultos);
            scrollPane = new JScrollPane(checkBoxList);
            
        }

        JOptionPane.showMessageDialog(null, scrollPane, "Quais vacinas você já tomou?", JOptionPane.PLAIN_MESSAGE);
        List<String> selectedItems = checkBoxList.getSelectedItems();
        
        
    }
}