package Modelo;
public class Funcionario extends Entidade {
    private String nome;
    private double comissao;

    public Funcionario (String nome, double comissao, int id) {
        super (id);
        this.nome = nome;
        this.comissao = comissao;
    }

    public String getNome () {
        return nome;
    }

    public void setNome (String nome) {
        this.nome = nome;
    }

    public double getComissao () {
        return comissao;
    }

    public void addComissao (double valor) {
        this.comissao += 0.05 * valor;          //comissao de 5%
    }

    @Override
    public String toString () {
        return "Funcionario: " + this.nome + "\nComissao: " + this.comissao + "\n";
    }
}
