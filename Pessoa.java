public class Pessoa{
    private String nome, cpf;
    private int idade;

    Pessoa(String nome, String cpf, int idade){
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        
    }

    Pessoa (int idade){
        this.idade = idade;
        
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
    public int getIdade() {
        return idade;
    }
}