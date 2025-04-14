public class Locacao extends Entidade {
    private Cliente cliente;
    private Veiculo veiculo;
    private Funcionario funcionario;
    private int diasAlugados;

    public Locacao (Cliente cliente, Veiculo veiculo, Funcionario funcionario, int diasAlugados, int id) {
        super (id);
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.funcionario = funcionario;
        this.diasAlugados = diasAlugados;
    }

    public Cliente getCliente () {
        return cliente;
    }

    public void setCliente (Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo () {
        return veiculo;
    }

    public void setVeiculo (Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Funcionario getFuncionario () {
        return funcionario;
    }

    public void setFuncionario (Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public int getDiasAlugados () {
        return diasAlugados;
    }

    public void setDiasAlugados (int diasAlugados) {
        this.diasAlugados = diasAlugados;
    }

    @Override
    public String toString () {
        return this.cliente + "\n" + this.veiculo + "\nDias Alugados: " + this.diasAlugados + "\nValor total: " + (this.diasAlugados*this.veiculo.getValorDiario()) + "\n\n" + this.funcionario.getNome() + "\n\n";
    }
}