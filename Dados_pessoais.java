import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

public class Dados_pessoais{
    private static int diaNascimento, anoNascimento, idade;
    private static String nome, cpf, mesNascimento;

    public static void prnt() {
        Banco_de_dados bdd = new Banco_de_dados();

        JFrame janela = new JFrame("Dados da Pessoa");

        /* Criação dos componentes da interface */ 
        JLabel labelNome = new JLabel("Nome:");
        JTextField campoNome = new JTextField(20);

        JLabel labelCPF = new JLabel("CPF:");
        JTextField campoCPF = new JTextField(14);

        JLabel labelDataNascimento = new JLabel("Data de Nascimento:");
        JComboBox<Integer> comboBoxDia = new JComboBox<>();
        for (int i = 1; i <= 31; i++) {
            comboBoxDia.addItem(i);
        }

        JComboBox<String> comboBoxMes = new JComboBox<>();
        String[] meses = { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho",
                "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" };
        for (String mes : meses) {
            comboBoxMes.addItem(mes);
        }

        JComboBox<Integer> comboBoxAno = new JComboBox<>();
        int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = anoAtual; i >= anoAtual - 100; i--) {
            comboBoxAno.addItem(i);
        }

        JButton botaoSalvar = new JButton("Salvar");

        /* Adição dos componentes à janela */ 
        janela.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        janela.add(labelNome, gbc);

        gbc.gridy++;
        janela.add(labelCPF, gbc);

        gbc.gridy++;
        janela.add(labelDataNascimento, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        janela.add(campoNome, gbc);

        gbc.gridy++;
        janela.add(campoCPF, gbc);

        JPanel panelDataNascimento = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        panelDataNascimento.add(comboBoxDia);
        panelDataNascimento.add(comboBoxMes);
        panelDataNascimento.add(comboBoxAno);
        gbc.gridy++;
        janela.add(panelDataNascimento, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        janela.add(botaoSalvar, gbc);

        /* Configurações da janela */ 
        janela.pack();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);

        /* Adição de ação para o botão "Salvar" */
        
        botaoSalvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nome = campoNome.getText();
                cpf = campoCPF.getText();
                diaNascimento = (int) comboBoxDia.getSelectedItem();
                mesNascimento = (String) comboBoxMes.getSelectedItem();
                anoNascimento = (int) comboBoxAno.getSelectedItem();
                
                Calendar hoje = Calendar.getInstance();
                int anodehoje = hoje.get(Calendar.YEAR);
                int mesdehoje = hoje.get(Calendar.MONTH);
                int diadehoje = hoje.get(Calendar.DAY_OF_MONTH);

                int mesnacimentointeiro = 0;
                for(int j = 0; j < 12; j++){
                    if(mesNascimento.equals(meses[j])){
                        mesnacimentointeiro = j + 1;
                        break;
                    }
                }
                

                idade = anodehoje - anoNascimento;
                if (mesdehoje < mesnacimentointeiro) {
                    idade--;
                } else if (diadehoje < diaNascimento && mesdehoje == mesnacimentointeiro) {
                    idade--;
                }
                
                janela.dispose();
                bdd.adicionarPessoa(nome, cpf, idade, null, null, null, null, null);
                Selecionando_vacinas.prnt(nome, cpf, idade);
            }
        });
    }
}