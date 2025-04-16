package Modelo;
public class Veiculo extends Entidade {
    private String marca;
    private String modelo;
    private int ano;
    private String cor;
    private double valorDiario;

    public Veiculo (String marca, String modelo, int ano, String cor, double valorDiario, int id) {
        super(id);
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.valorDiario = valorDiario;
    }

    public String getMarca () {
        return this.marca;
    }

    public void setMarca (String marca) {
        this.marca = marca;
    }

    public String getModelo () {
        return this.modelo;
    }
    
    public void setModelo (String modelo) {
        this.modelo = modelo;
    }
    
    public String getCor () {
        return this.cor;
    }
    
    public void setCor (String cor) {
        this.cor = cor;
    }

    public double getValorDiario () {
        return this.valorDiario;
    }
    
    public void setValorDiario (double valorDiario) {
        this.valorDiario = valorDiario;
    }

    public int getAno () {
        return this.ano;
    }
    
    public void setAno (int ano) {
        this.ano = ano;
    }

    public String toString () {
        return "Carro: " + this.marca + " " + this.modelo + " " + this.ano + " " + this.cor + "\nValor diario: " + this.valorDiario + "\n";
    }
}
