package Modelo;
public class Funcionario extends Entidade {
    private String nome;
    private double comissaoAcumulada;

    public Funcionario (String nome, int id) {
        super (id);
        this.nome = nome;
        this.comissaoAcumulada = 0;
    }

    public String getNome () {
        return nome;
    }

    public void setNome (String nome) {
        this.nome = nome;
    }

    public double getComissaoAcumulada () {
        return comissaoAcumulada;
    }

    public void addComissao (double valor) {
        this.comissaoAcumulada += 0.05 * valor;          //comissao de 5%
    }

    @Override
    public String toString () {
        return "Funcionario: " + this.nome + "\nComissao: " + this.comissaoAcumulada + "\n";
    }
}
