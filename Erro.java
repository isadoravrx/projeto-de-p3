import javax.swing.*;

public class Erro {
    public static void prnt(String mensagem) {
        // Cria uma nova janela de erro com a mensagem fornecida
        JFrame janela = new JFrame("Erro");
        JOptionPane.showMessageDialog(janela, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
