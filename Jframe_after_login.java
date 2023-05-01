import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Jframe_after_login {

    public static void prt(){
        Banco_de_dados bdd = new Banco_de_dados();

        JFrame janela = new JFrame("Fazendo login");

        JLabel labelCPF = new JLabel("CPF:");
        JTextField campoCPF = new JTextField(14);
        JButton botaoentrar = new JButton("Entrar");
    
        
        /* Configurações da janela */
        janela.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);

        janela.add(labelCPF, gbc);
        gbc.gridy++;

        gbc.gridx = 1;
        gbc.gridy = 0;

        janela.add(campoCPF,gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        janela.add(botaoentrar, gbc);

        /* Configurações da janela */
        janela.pack();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);

        /* Adição de ação para o botão "Salvar" */
        botaoentrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String cpf = (String) campoCPF.getText();
                List<String[]> pessoa = bdd.buscarPessoa(cpf);

                if(pessoa.size() != 0){// pessoa foi encontrada
                    janela.dispose();
                    //janela com quantas doses falta, e o dia da próxima dose
                    Jframe_mostrando_doses_faltam.prnt(cpf);

                }else{
                    // janela com mensagem de erro
                    Erro.prnt("Ocorreu um erro!\nCPF não encontrado.");
                }
            }
        });
    }
   
}

