import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

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
        
        System.out.println(idade);

    }
}