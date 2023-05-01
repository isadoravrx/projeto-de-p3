import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Main {
    static Paciente fulano;

    public static void main(String[] args) throws SQLException{

        Banco_de_dados bdd = new Banco_de_dados();

        JFrame janela = new JFrame("Login");
        
        /*  Criação dos componentes da interface */
        JButton botaoLogar = new JButton("Logar");
        JButton botaoCriarConta = new JButton("Criar Conta");

        /* Adição dos componentes à janela */
        janela.setLayout(new GridLayout(2, 1, 10, 10));
        janela.add(botaoLogar);
        janela.add(botaoCriarConta);

        /* Configurações da janela */ 
        janela.setSize(300, 150);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);

        /* Adição de ação para o botão "Logar" */
        botaoLogar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Jframe_after_login.prt();
                janela.dispose();
            }
        });

        /* Adição de ação para o botão "Criar Conta" */ 
        botaoCriarConta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {    
                janela.dispose();                 
                Dados_pessoais.prnt();
            }
        });
        


    }
}
