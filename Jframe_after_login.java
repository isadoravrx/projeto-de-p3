import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import javax.swing.text.MaskFormatter;

public class Jframe_after_login extends JFrame {
    private JTextField cpfField;

    public CpfFrame() {
        // Configurações básicas do JFrame
        setTitle("Digite o CPF");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(300, 100));

        // Criação do JLabel para exibir a mensagem
        JLabel label = new JLabel("CPF: ");

        // Criação do JFormattedTextField para permitir a digitação do CPF formatado
        try {
            MaskFormatter formatter = new MaskFormatter("###.###.###-##");
            cpfField = new JFormattedTextField(formatter);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Criação do JButton para permitir que o usuário envie o CPF
        JButton button = new JButton("Enviar");
        button.addActionListener(e -> {
            String cpf = cpfField.getText();
            // Aqui você pode realizar as ações desejadas com o CPF, como armazená-lo em um banco de dados
            System.out.println("CPF digitado: " + cpf);
        });

        // Adiciona os componentes ao JFrame
        JPanel panel = new JPanel(new GridLayout(2, 2));
        panel.add(label);
        panel.add(cpfField);
        panel.add(new JLabel());
        panel.add(button);
        getContentPane().add(panel);

        // Exibe o JFrame
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CpfFrame();
    }
}

