import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class selecionando_quantidade_doses {
    public static void prnt(String cpf) {

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
        List<String> dataUltimaDose = new ArrayList<>();

        List<JComboBox<Integer>> comboDosesList = new ArrayList<>();

        for (int l = 0; l < vacinastomadas.length; l++) {
            JLabel vacinatomada = new JLabel(listavacinastomadas.get(l));
            janela.add(vacinatomada, gbc);

            gbc.gridx++;
            JLabel quantidadedose = new JLabel("doses:");
            janela.add(quantidadedose, gbc);

            gbc.gridx++;

            JComboBox<Integer> comboDoses = new JComboBox<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
            janela.add(comboDoses, gbc);
            comboDosesList.add(comboDoses);

            gbc.gridx++;
            JLabel data = new JLabel("data:");
            janela.add(data, gbc);

            gbc.gridy++;
            gbc.gridx = 0;
        }

        gbc.gridy = 0;
        gbc.gridx = 3;

        JButton salvar = new JButton("Save");
        janela.add(salvar, gbc);

        salvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                quantidadevacinastomadas.clear();

                for (JComboBox<Integer> combo : comboDosesList) {
                    int quantidade = (int) combo.getSelectedItem();
                    quantidadevacinastomadas.add(quantidade);
                }

                System.out.println("Quantidades de doses selecionadas: " + quantidadevacinastomadas);
            }
        });

        // configuração da janela
        janela.pack();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }
}
