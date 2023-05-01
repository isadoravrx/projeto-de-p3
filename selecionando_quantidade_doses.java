import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;

public class selecionando_quantidade_doses {
    public static void prnt(String cpf){
        
        Banco_de_dados bdd = new Banco_de_dados();
        List<String[]> informacoespessois = bdd.buscarPessoa(cpf);
        String[] vacinastomadas = informacoespessois.get(0)[3].split(", "); 
        List<String>listavacinastomadas = new ArrayList<>();
        vacinastomadas[0] = vacinastomadas[0].replaceAll("\\[", "");
        vacinastomadas[vacinastomadas.length - 1 ] = vacinastomadas[vacinastomadas.length - 1].replaceAll("]", "");
        for(int i = 0; i < vacinastomadas.length; i++){

            listavacinastomadas.add(vacinastomadas[i]);
        }

        JFrame janela = new JFrame("Selecionar quantidade de doses tomada e data da última dose");
        
        JLabel quantidadedose = new JLabel("doses:");
        JComboBox<Integer>quantidadeDosesbox = new JComboBox<>();
        for(int i = 1; i <= 8;i++){
            quantidadeDosesbox.addItem(i);
        }

        JLabel data = new JLabel("data:");
        JComboBox<Integer>dia = new JComboBox<>();
        for(int i = 1; i <= 31; i++){
            dia.addItem(i);
        }

        JComboBox<Integer>mes = new JComboBox<>();
        for(int j = 1; j <= 12; j++){
            dia.addItem(j);
        }

        JComboBox<Integer>ano = new JComboBox<>();
        int anoatual = Calendar.getInstance().get(Calendar.YEAR);
        for(int k = anoatual ; k >= anoatual - 100; k-- ){
            ano.addItem(k);
        }
        
        /* Configurações da janela */
        janela.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);

        List<Integer>quantidadevacinastomadas = new ArrayList<>();
        List<String>dataUltimaDose = new ArrayList<>();
        
        for(int l = 0; l < vacinastomadas.length; l++){
            JLabel vacinatomada = new JLabel(listavacinastomadas.get(l));
            janela.add(vacinatomada, gbc);
            gbc.gridy ++;
        }

        gbc.gridx = 1;
        gbc.gridy = 0;
        
        for(int l = 0; l < vacinastomadas.length; l++){
            janela.add(quantidadedose, gbc);
            janela.add(quantidadeDosesbox, gbc);
            
            gbc.gridx++;
            janela.add(data, gbc);
            janela.add(dia, gbc);
            janela.add(mes, gbc);
            janela.add(ano, gbc);
            gbc.gridx--;
       
            gbc.gridy++;

            quantidadevacinastomadas.add((Integer) quantidadeDosesbox.getSelectedItem());
            dataUltimaDose.add( dia.getSelectedItem() + "|" + mes.getSelectedItem() + "|" + ano.getSelectedItem());
        }
         
        //configuração da janela
        janela.pack();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }
}
