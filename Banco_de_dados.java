import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Banco_de_dados {

    private String nomeArquivo = "dados.txt";

    public void adicionarPessoa(String nome, String cpf, int idade, List<String> selectedItems) {
        try (FileWriter writer = new FileWriter(nomeArquivo, true)) {
            writer.write(nome + "/" + cpf + "/" + idade + "/" + selectedItems + "\n");
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }

    public List<String[]> buscarPessoa(String cpf) {
        List<String[]> pessoasEncontradas = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;

            while ((linha = reader.readLine()) != null) {
                String[] campos = linha.split("/");

                if (campos[1].equals(cpf)) {
                    pessoasEncontradas.add(campos);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pessoasEncontradas;
    }

    public void atualizarPessoa(String nome, String cpf, int idade, List<String> selStrings) {
      List<String> linhas = new ArrayList<>();
  
      try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
          String linha;
  
          while ((linha = reader.readLine()) != null) {
              String[] campos = linha.split("/");
  
              if (campos[1].equals(cpf)) {
                  linhas.add(nome + "/" + cpf + "/" + idade + "/" + selStrings);
              } else {
                  linhas.add(linha);
              }
          }
      } catch (IOException e) {
          e.printStackTrace();
      }
  
      try (FileWriter writer = new FileWriter(nomeArquivo)) {
          for (String linha : linhas) {
              writer.write(linha + "\n");
          }
      } catch (IOException e) {
          e.printStackTrace();
      }
  }
  
}
