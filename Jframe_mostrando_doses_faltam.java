import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
public class Jframe_mostrando_doses_faltam {
    public static void prnt(String cpf){
        Banco_de_dados bdd = new Banco_de_dados();
        List<String[]> informacoespessois = bdd.buscarPessoa(cpf);

        

        int idade = Integer.parseInt(informacoespessois.get(0)[2]);
        String[] vacinastomadas = informacoespessois.get(0)[3].split(", "); 
        List<String>listavacinastomadas = new ArrayList<>();
        vacinastomadas[0] = vacinastomadas[0].replaceAll("\\[", "");
        vacinastomadas[vacinastomadas.length - 1 ] = vacinastomadas[vacinastomadas.length - 1].replaceAll("]", "");
        for(int i = 0; i < vacinastomadas.length; i++){

            listavacinastomadas.add(vacinastomadas[i]);
        }

        Paciente dados = new Paciente(informacoespessois.get(0)[0], informacoespessois.get(0)[1],idade, listavacinastomadas);
        JFrame janela = new JFrame("Próximas doses");
        JLabel labelnome = new JLabel("Nome: " + dados.getNome());
        
        JLabel labelCPF = new JLabel("CPF: " + dados.getCpf());
        JLabel labelidade = new JLabel("Idade: " + dados.getIdade());
        
        /* Configurações da janela */
        janela.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);

        janela.add(labelnome, gbc);
        gbc.gridy++;
        janela.add(labelCPF,gbc);
        gbc.gridy++;
        janela.add(labelidade,gbc);
        gbc.gridy++;

        for(int i = 0; i < vacinastomadas.length; i++){
            JLabel vacinatomada = new JLabel(listavacinastomadas.get(i) + " ->" + " faltam " + " doses"); //acrescentar proxima dose dia
            janela.add(vacinatomada,gbc);
            gbc.gridy++;
        }

        //configuração da janela
        janela.pack();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);

    }
}
