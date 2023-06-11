import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Jframe_mostrando_doses_faltam {
    public static void prnt(String cpf) {
        
        /* banco de dados */
        Banco_de_dados bdd = new Banco_de_dados();
        List<String[]> informacoespessois = bdd.buscarPessoa(cpf);

        /* idade */
        int idade = Integer.parseInt(informacoespessois.get(0)[2]);
        
        /* armazenar nome das doses */
        String[] vacinastomadas = informacoespessois.get(0)[3].split(", ");
        List<String> listavacinastomadas = new ArrayList<>();
        vacinastomadas[0] = vacinastomadas[0].replaceAll("\\[", "");
        vacinastomadas[vacinastomadas.length - 1] = vacinastomadas[vacinastomadas.length - 1].replaceAll("]", "");
        for (int i = 0; i < vacinastomadas.length; i++) {
            listavacinastomadas.add(vacinastomadas[i]);
        }

        /* coletar do banco de dados a quantidade de doses */
        String[] doses = informacoespessois.get(0)[7].split(", ");
        doses[0] = doses[0].replaceAll("\\[", "");
        doses[doses.length - 1] = doses[doses.length - 1].replaceAll("]", "");

        /* armazenar quantidade de doses */
        int[] quantidades_de_doses = new int[doses.length];
        for (int i = 0; i != quantidades_de_doses.length; i++) {
            quantidades_de_doses[i] = Integer.parseInt(doses[i]);
        }

        /* coletar do banco de dados o dia que tomou a dose */
        /* dia */
        String[] dias = informacoespessois.get(0)[4].split(", ");
        dias[0] = dias[0].replaceAll("\\[", "");
        dias[dias.length - 1] = dias[dias.length - 1].replaceAll("]", "");
        /* mes */
        String[] meses = informacoespessois.get(0)[5].split(", ");
        meses[0] = meses[0].replaceAll("\\[", "");
        meses[meses.length - 1] = meses[dias.length - 1].replaceAll("]", "");
        /* ano */
        String[] anos = informacoespessois.get(0)[6].split(", ");
        anos[0] = anos[0].replaceAll("\\[", "");
        anos[anos.length - 1] = anos[dias.length - 1].replaceAll("]", "");

        /* armazenar proximas doses */
        int[] dias_apos_ultima_dose = new int[doses.length];
        for (int i = 0; i != dias_apos_ultima_dose.length; i++) {
            int ano_passou = Calendar.getInstance().get(Calendar.YEAR) - Integer.parseInt(anos[i]);
            int mes_passou = Calendar.getInstance().get(Calendar.MONTH) + 1 - Integer.parseInt(meses[i]);
            int dia_passou = Calendar.getInstance().get(Calendar.DAY_OF_MONTH) - Integer.parseInt(dias[i]);
            
            dias_apos_ultima_dose[i] = (ano_passou*365) + (mes_passou*30) + dia_passou;
        }

        /* dodos paciente */
        Paciente dados = new Paciente(informacoespessois.get(0)[0], informacoespessois.get(0)[1], idade, listavacinastomadas, quantidades_de_doses, dias_apos_ultima_dose);

        /* JFrame */
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
        janela.add(labelCPF, gbc);
        gbc.gridy++;
        janela.add(labelidade, gbc);
        gbc.gridy++;

        /* ver quantas doses faltam */
        int index = 0, k = 0;   
        int[] newArrayDose;
        if (idade < 12) {
            newArrayDose = new int[Vacina.getDosesCrianca().length];
            for (String i : Vacina.getVacinas_crianca()) {
                for (String j : dados.getVacinas()) {
                    if (i.equals(j)) {
                        newArrayDose[index] = Vacina.getDosesAdolescentes()[index] - dados.getArraydose()[k];
                        k++;
                    } else {
                        newArrayDose[index] = Vacina.getDosesCrianca()[index];
                    }

                }
                index++;
            }
        } else if (idade < 18) {
            newArrayDose = new int[Vacina.getDosesAdolescentes().length];

            for (String i : Vacina.getVacinas_adolescente()) {
                for (String j : dados.getVacinas()) {
                    if (i.equals(j)) {
                        newArrayDose[index] = Vacina.getDosesAdutos()[index] - dados.getArraydose()[k];
                        k++;
                    } else {
                        newArrayDose[index] = Vacina.getDosesAdolescentes()[index];
                    }

                }
                index++;
            }
        } else {
            newArrayDose = new int[Vacina.getDosesAdutos().length];

            for (String i : Vacina.getVacinas_adulto()) {
                for (String j : dados.getVacinas()) {
                    if (i.equals(j)) {
                        newArrayDose[index] = Vacina.getDosesAdutos()[index] - dados.getArraydose()[k];
                        k++;
                        break;
                    } else {
                        newArrayDose[index] = Vacina.getDosesAdutos()[index];
                    }

                }
                index++;
            }
        }
    
        /* ver quantas doses faltam */
        index = k = 0;   
        int[] newTimeDose;
        if (idade < 12) {
            newTimeDose = new int[Vacina.getDosesCrianca().length];
            for (String i : Vacina.getVacinas_crianca()) {
                for (String j : dados.getVacinas()) {
                    if (i.equals(j)) {
                        newTimeDose[index] = Vacina.getIntervalo_entre_doses_crianca()[index] - dados.getDias_apos_ultima_dose()[k];
                        k++;
                    } else {
                        newTimeDose[index] = Vacina.getIntervalo_entre_doses_crianca()[index];
                    }

                }
                index++;
            }
        } else if (idade < 18) {
            newTimeDose = new int[Vacina.getDosesAdolescentes().length];

            for (String i : Vacina.getVacinas_adolescente()) {
                for (String j : dados.getVacinas()) {
                    if (i.equals(j)) {
                        newTimeDose[index] = Vacina.getIntervalo_entre_doses_adolescentes()[index] - dados.getDias_apos_ultima_dose()[k];
                        k++;
                    } else {
                        newTimeDose[index] = Vacina.getIntervalo_entre_doses_adolescentes()[index];
                    }

                }
                index++;
            }
        }else {
            newTimeDose = new int[Vacina.getDosesAdutos().length];

            for (String i : Vacina.getVacinas_adulto()) {
                for (String j : dados.getVacinas()) {
                    if (i.equals(j)) {
                        newTimeDose[index] = Vacina.getIntervalo_entre_doses_adultos()[index] - dados.getDias_apos_ultima_dose()[k];
                        k++;
                        break;
                    } else {
                        newTimeDose[index] = Vacina.getIntervalo_entre_doses_adultos()[index];
                    }

                }
                index++;
            }
        }

        /* apresentar os dados das doses */
        index = 0;
        if (idade < 12) {
            for (String i : Vacina.getVacinas_crianca()) {
                JLabel vacina = new JLabel(i);
                janela.add(vacina, gbc);
                gbc.gridx++;

                /* quantidade de doses que falta */
                if (newArrayDose[index] <= 0) {
                    JLabel falta = new JLabel("Concluído");
                    janela.add(falta, gbc);
                } else {
                    JLabel falta = new JLabel("faltam: " + newArrayDose[index] + " doses");
                    janela.add(falta, gbc);
                }
               
                gbc.gridx++;

                /* proxima doses */
                if (newArrayDose[index] <= 0) {
                    JLabel next = new JLabel("Concluído");
                    janela.add(next, gbc);
                }else if(newTimeDose[index] <= 0){
                    JLabel next = new JLabel("Pendente");
                    janela.add(next, gbc);
                }else{
                    JLabel next = new JLabel("proxima dose em: " + Math.abs(newTimeDose[index]) + " dias");
                    janela.add(next, gbc);
                }

                gbc.gridx = 0;
                gbc.gridy++;
                index++;
            }
        } else if (idade <= 18) {
            for (String i : Vacina.getVacinas_adolescente()) {
                JLabel vacina = new JLabel(i);
                janela.add(vacina, gbc);
                gbc.gridx++;

                /* quantidade de doses que falta */
                if (newArrayDose[index] <= 0) {
                    JLabel falta = new JLabel("Concluído");
                    janela.add(falta, gbc);
                } else {
                    JLabel falta = new JLabel("faltam: " + newArrayDose[index] + " doses");
                    janela.add(falta, gbc);
                }

                gbc.gridx++;

                /* proxima doses */
                if (newArrayDose[index] <= 0) {
                    JLabel next = new JLabel("Concluído");
                    janela.add(next, gbc);
                }else if(newTimeDose[index] <= 0){
                    JLabel next = new JLabel("Pendente");
                    janela.add(next, gbc);
                }else{
                    JLabel next = new JLabel("proxima dose em: " + Math.abs(newTimeDose[index]) + " dias");
                    janela.add(next, gbc);
                }

                gbc.gridx = 0;
                gbc.gridy++;
                index++;
            }
        } else {
            for (String i : Vacina.getVacinas_adulto()) {
                JLabel vacina = new JLabel(i);
                janela.add(vacina, gbc);
                gbc.gridx++;

                /* quantidade de doses que falta */
                if (newArrayDose[index] <= 0) {
                    JLabel falta = new JLabel("Concluído");
                    janela.add(falta, gbc);
                } else {
                    JLabel falta = new JLabel("faltam: " + newArrayDose[index] + " doses");
                    janela.add(falta, gbc);
                }

                gbc.gridx ++;

                /* proxima doses */
                if (newArrayDose[index] <= 0) {
                    JLabel next = new JLabel("Concluído");
                    janela.add(next, gbc);
                }else if(newTimeDose[index] <= 0){
                    JLabel next = new JLabel("Pendente");
                    janela.add(next, gbc);
                }else{
                    JLabel next = new JLabel("proxima dose em: " + Math.abs(newTimeDose[index]) + " dias");
                    janela.add(next, gbc);
                }

                gbc.gridx = 0;
                gbc.gridy++;
                index++;
            }
        }

        /* Botão Atualizar */
        JButton botaoAtualizar = new JButton("Atualizar");
        gbc.gridx = 0;
        gbc.gridy++;
        janela.add(botaoAtualizar, gbc);

        /* Botão Todas Vacinas */
        JButton botaoTodasVacinas = new JButton("Todas Vacinas");
        gbc.gridx++;
        janela.add(botaoTodasVacinas, gbc);



        /* Adição de ação para o botão "Atualizar" */
        botaoAtualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // adicionar aba para atualizar os dados
                Selecionando_vacinas.prnt(dados.getNome(), cpf, idade);
                janela.dispose();
                Jframe_after_login.prt();
            }
        });

        /* Adição de ação para o botão "TodasVacinas" */
        botaoTodasVacinas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Jframe_paciente_perfeito.prnt(idade);
            }
        });

        /* configuração da janela */
        janela.pack();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);

    }
}
