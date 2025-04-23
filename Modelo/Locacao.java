package Modelo;
public class Locacao extends Entidade {
    private Cliente cliente;
    private Aluguel aluguel;
    private Funcionario funcionario;

    public Locacao (int id, Cliente cliente, Veiculo veiculo, Funcionario funcionario, int diasAlugados) {
        super (id);
        this.aluguel = new Aluguel (id, veiculo, diasAlugados); //Classe intermediária que representa a transação por si só
        this.cliente = cliente;
        this.funcionario = funcionario;
    }

    public Cliente getCliente () {
        return cliente;
    }

    public void setCliente (Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario () {
        return funcionario;
    }

    public void setFuncionario (Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Aluguel getAluguel () {
        return aluguel;
    }

    @Override
    public String toString () {
        return this.cliente + "\n" + this.aluguel.getVeiculo() + "\nDias Alugados: " + this.aluguel.getDiasDeAluguel() + "\nValor total: " + this.aluguel.getValorTotal() + "\n\n" + this.funcionario.getNome() + "\n\n";
    }
}