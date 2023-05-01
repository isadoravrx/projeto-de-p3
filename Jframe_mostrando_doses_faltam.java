import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
public class Jframe_mostrando_doses_faltam {
    public static void prnt(String cpf){
        Banco_de_dados bdd = new Banco_de_dados();
        List<String[]> informacoespessois = bdd.buscarPessoa(cpf);
        JFrame janela = new JFrame("Próximas doses");
        int idade = Integer.parseInt(informacoespessois.get(0)[2]);
        String[] vacinastomadas = informacoespessois.get(0)[3].split(",");
        List<String>listavacinastomadas = null;
        for(int i = 0; i < vacinastomadas.length; i++){
            listavacinastomadas.add(vacinastomadas[i]);
        }
        Paciente dados = new Paciente(informacoespessois.get(0)[0], informacoespessois.get(0)[1],idade, listavacinastomadas);
    }
}
