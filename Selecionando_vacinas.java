import javax.swing.*;
import java.util.List;

public class Selecionando_vacinas {
    private static List<String> selectedItems;

    public static void prnt(String nome, String cpf, int idade) {
        Banco_de_dados bdd = new Banco_de_dados();


        JScrollPane scrollPane;
        JCheckBoxList<String> checkBoxList;

        if (idade < 12) {

            List<String> vacinas_criancas = Vacina.getVacinas_crianca();
            checkBoxList = new JCheckBoxList<>(vacinas_criancas);
            scrollPane = new JScrollPane(checkBoxList);

        } else if (idade >= 12 && idade <= 18) {

            List<String> vacinas_adolescentes = Vacina.getVacinas_adolescente();
            checkBoxList = new JCheckBoxList<>(vacinas_adolescentes);
            scrollPane = new JScrollPane(checkBoxList);

        } else {

            List<String> vacinas_adultos = Vacina.getVacinas_adulto();
            checkBoxList = new JCheckBoxList<>(vacinas_adultos);
            scrollPane = new JScrollPane(checkBoxList);

        }

        JOptionPane.showMessageDialog(null, scrollPane, "Quais vacinas você já tomou?", JOptionPane.PLAIN_MESSAGE);
        selectedItems = checkBoxList.getSelectedItems();
    
        bdd.atualizarPessoa(nome, cpf, idade, selectedItems);
        // apos o botao save, adicionar uma outra janela perguntando a quantidade de doses tomadas e a quando
        selecionando_quantidade_doses.prnt(cpf);

    }
}
