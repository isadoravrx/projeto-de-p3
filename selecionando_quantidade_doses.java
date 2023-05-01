import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;

public class Selecionando_quantidade_doses {
    public static void prnt(String cpf, int idade, String nome) {

        Banco_de_dados bdd = new Banco_de_dados();
        List<String[]> informacoespessois = bdd.buscarPessoa(cpf);
        String[] vacinastomadas = informacoespessois.get(0)[3].split(", ");
        List<String> listavacinastomadas = new ArrayList<>();
        vacinastomadas[0] = vacinastomadas[0].replaceAll("\\[", "");
        vacinastomadas[vacinastomadas.length - 1] = vacinastomadas[vacinastomadas.length - 1].replaceAll("]", "");
        for (int i = 0; i < vacinastomadas.length; i++) {

            listavacinastomadas.add(vacinastomadas[i]);
        }

        JFrame janela = new JFrame("Selecionar quantidade de doses tomada e data da última dose");

        /* Configurações da janela */
        janela.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);

        List<Integer> quantidadevacinastomadas = new ArrayList<>(); 
        List<JComboBox<Integer>> dia = new ArrayList<>();
        List<JComboBox<Integer>> mes = new ArrayList<>();
        List<JComboBox<Integer>> ano = new ArrayList<>();
        

        List<JComboBox<Integer>> comboDosesList = new ArrayList<>();

        int anodehoje = Calendar.getInstance().get(Calendar.YEAR);

        for (int l = 0; l < vacinastomadas.length; l++) {
            JLabel vacinatomada = new JLabel(listavacinastomadas.get(l));
            janela.add(vacinatomada, gbc);

            gbc.gridx++;
            JLabel quantidadedose = new JLabel("doses:");
            janela.add(quantidadedose, gbc);

            gbc.gridx++;

            JComboBox<Integer> comboDoses = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8}); //2)criar jcombobox pra dia mes e ano, lembrando que o jcombobox
            janela.add(comboDoses, gbc);
            comboDosesList.add(comboDoses);

            gbc.gridx++;
            JLabel data = new JLabel("data:");
            janela.add(data, gbc);

            gbc.gridx++;

            JComboBox<Integer> combodias = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30});
            janela.add(combodias, gbc);
            dia.add(combodias);

            gbc.gridx++;

            JComboBox<Integer> combomeses = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12});
            janela.add(combomeses, gbc);
            mes.add(combomeses);

            gbc.gridx++;

            JComboBox<Integer> comboanos = new JComboBox<>();
            for(int i = anodehoje; i >= anodehoje - 50; i--){
                comboanos.addItem(i);
            } 
            janela.add(comboanos, gbc);
            ano.add(comboanos);

            gbc.gridy++;
            gbc.gridx = 0;
        }

        gbc.gridy = vacinastomadas.length; 
        gbc.gridx = 3; 

        JButton salvar = new JButton("Save");
        janela.add(salvar, gbc);


        List<Integer>diaselecionado = new ArrayList<>();
        List<Integer>meselecionado = new ArrayList<>();
        List<Integer>anoselecionado = new ArrayList<>();
        salvar.addActionListener(new ActionListener() {  //3) botar um for, que passa pelos elementos de cada lista de inteiro(dia mes e ano), e vai adicionar na datalistadose , dia|mes|ano
            public void actionPerformed(ActionEvent e) {
                quantidadevacinastomadas.clear();

                for (JComboBox<Integer> combo : comboDosesList) {
                    int quantidade = (int) combo.getSelectedItem();
                    quantidadevacinastomadas.add(quantidade);
                }

                for(JComboBox<Integer> combo : dia){
                    int diaselec = (int) combo.getSelectedItem();
                    diaselecionado.add(diaselec);
                }

                for(JComboBox<Integer> combo : mes){
                    int meselc = (int) combo.getSelectedItem();
                    meselecionado.add(meselc);
                }

                for(JComboBox<Integer> combo : ano){
                    int anoselec = (int) combo.getSelectedItem();
                    anoselecionado.add(anoselec);
                }

                bdd.atualizarPessoa(nome, cpf, idade, listavacinastomadas, diaselecionado, meselecionado, anoselecionado, quantidadevacinastomadas);
                janela.dispose();
            }
        });

        // configuração da janela
        janela.pack();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);

        
    }
}
