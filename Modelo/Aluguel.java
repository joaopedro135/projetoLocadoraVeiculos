package Modelo;

public class Aluguel extends Entidade {
    private Veiculo veiculo;
    private int diasDeAluguel;
    private double valorTotal;

    public Aluguel (int id, Veiculo veiculo, int diasDeAluguel) {
        super(id);
        this.veiculo = veiculo;
        this.diasDeAluguel = diasDeAluguel;
        this.valorTotal = veiculo.getValorDiario() * diasDeAluguel;
    }
    
    public Veiculo getVeiculo () {
        return veiculo;
    }

    public int getDiasDeAluguel () {
        return diasDeAluguel;
    }

    public double getValorTotal () {
        return valorTotal;
    }

    @Override
    public String toString() {
        return this.getVeiculo() + 
        "Dias Alugados: " + this.getDiasDeAluguel() + 
        "\nValor total: R$" + this.getValorTotal() + "\n"; 
    }
    //sem sets pois na ideia de um aluguel não é necessario alterar algum valor do aluguel, mas sim criar outro para sobrepor ao antigo
}
