import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
public class Jframe_mostrando_doses_faltam {
    public static void prnt(String cpf){
        Banco_de_dados bdd = new Banco_de_dados();
        List<String[]> informacoespessois = bdd.buscarPessoa(cpf);

        

        int idade = Integer.parseInt(informacoespessois.get(0)[2]);
        String[] vacinastomadas = informacoespessois.get(0)[3].split(", "); 
        List<String>listavacinastomadas = new ArrayList<>();
        vacinastomadas[0] = vacinastomadas[0].replaceAll("\\[", "");
        vacinastomadas[vacinastomadas.length - 1 ] = vacinastomadas[vacinastomadas.length - 1].replaceAll("]", "");
        for(int i = 0; i < vacinastomadas.length; i++){

            listavacinastomadas.add(vacinastomadas[i]);
        }
        
        int[] arraydose = null;
        if(idade < 12){
            arraydose = new int[Vacina.getDosesCrianca().length];
        }else if(idade <= 18){
            arraydose = new int[Vacina.getDosesAdolescentes().length];
        }else{
            arraydose = new int[Vacina.getDosesAdutos().length];
        }
        String[] doses = informacoespessois.get(informacoespessois.size()-1); 
        List<String>listadose = new ArrayList<>();
        doses[0] = doses[0].replaceAll("\\[", "");
        doses[doses.length - 1 ] = doses[doses.length - 1].replaceAll("]", "");

        for(int i = 0; i != arraydose.length; i++){
            arraydose[i] = Integer.parseInt(doses[i]);
        }
        

        Paciente dados = new Paciente(informacoespessois.get(0)[0], informacoespessois.get(0)[1],idade, listavacinastomadas, arraydose);
        JFrame janela = new JFrame("Próximas doses");
        JLabel labelnome = new JLabel("Nome: " + dados.getNome());
        
        JLabel labelCPF = new JLabel("CPF: " + dados.getCpf());
        JLabel labelidade = new JLabel("Idade: " + dados.getIdade());
        
        /* Configurações da janela */
        janela.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);

        janela.add(labelnome, gbc);
        gbc.gridy++;
        janela.add(labelCPF,gbc);
        gbc.gridy++;
        janela.add(labelidade,gbc);
        gbc.gridy++;

        int index = 0, k = 0;
        int[] newArrayDose = new int[Vacina.getDosesCrianca().length];
        for(String i : Vacina.getVacinas_crianca()){
            for(String j : dados.getVacinas()){
                if(i.equals(j)){
                    newArrayDose[index] = dados.getArraydose()[k];
                    k++;
                }else{
                    newArrayDose[index] = Vacina.getDosesCrianca()[index];
                }
            }
            index++;
        }

        index = 0;

        if(idade < 12){
            for(String i : Vacina.getVacinas_crianca()){
                JLabel vacina = new JLabel(i);
                janela.add(vacina, gbc);
                gbc.gridx++;

                JLabel falta = new JLabel("faltam: "+arraydose[index]+" doses");
                janela.add(falta, gbc);
                
                gbc.gridx=0;
                gbc.gridy++;
            }
        }else if(idade <= 18){
            for(String i : Vacina.getVacinas_adolescente()){
                JLabel vacina = new JLabel(i);
                janela.add(vacina, gbc);
                gbc.gridx++;

                JLabel falta = new JLabel("faltam: "+arraydose[index]+" doses");
                janela.add(falta, gbc);
                
                gbc.gridx=0;
                gbc.gridy++;
            }
        }else{
            for(String i : Vacina.getVacinas_adulto()){
                JLabel vacina = new JLabel(i);
                janela.add(vacina, gbc);
                gbc.gridx++;

                JLabel falta = new JLabel("faltam: "+arraydose[index]+" doses");
                janela.add(falta, gbc);
                
                gbc.gridx=0;
                gbc.gridy++;
            }
        }
        

        //configuração da janela
        janela.pack();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);

    }
}
