import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame janela = new JFrame("Login");

        // Criação dos componentes da interface
        JButton botaoLogar = new JButton("Logar");
        JButton botaoCriarConta = new JButton("Criar Conta");

        // Adição dos componentes à janela
        janela.setLayout(new GridLayout(2, 1, 10, 10));
        janela.add(botaoLogar);
        janela.add(botaoCriarConta);

        // Configurações da janela
        janela.setSize(300, 150);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);

        // Adição de ação para o botão "Logar"
        botaoLogar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Faça algo quando o botão "Logar" for clicado...
                janela.dispose();
            }
        });

        // Adição de ação para o botão "Criar Conta"
        botaoCriarConta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                // Faça algo quando o botão "Criar Conta" for clicado...
               
                Dados_pessoais.prnt();
            }
        });


    }

}
