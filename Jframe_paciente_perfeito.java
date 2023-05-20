import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Jframe_paciente_perfeito {

    public static void prnt(int idade) {
        JFrame janela = new JFrame("Todas as doses");
        
        /* Configurações da janela */
        janela.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        
        /* dados das vacinas */
        Paciente_perfeito cdb = new Paciente_perfeito(idade);
     
        /* mostrar informacoes das doses */
        int index = 0;
        for (String i : cdb.getVacinas()) {
            JLabel vacina = new JLabel(i);
            janela.add(vacina, gbc);
            gbc.gridx++;

            /* quantidade de doses */
            JLabel falta = new JLabel(cdb.getDoses()[index] + " doses");
            janela.add(falta, gbc);   
           
            gbc.gridx++;

            /* proxima doses */
            JLabel next = new JLabel("a cada " + cdb.getArraydose()[index] + " dias");
            janela.add(next, gbc);
            

            gbc.gridx = 0;
            gbc.gridy++;
            index++;
        }

        /* Botão "fechar" */
        JButton botaoFechar = new JButton("Fechar");
        gbc.gridx = 0;
        gbc.gridy++;
        janela.add(botaoFechar, gbc);

        /* Adição de ação para o botão "fechar" */
        botaoFechar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                janela.dispose();
            }
        });

        /* configuração da janela */
        janela.pack();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }
}
