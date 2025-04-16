package Modelo;
public class Cliente extends Entidade {
    private String nome;
    //private float contaBancaria;

    public Cliente (int id, String nome) {
        super (id);
        this.nome = nome;
    }

    public String getCliente () {
        return this.nome;
    }

    public void setCliente (String nome) {
        this.nome = nome;
    }

    @Override
    public String toString () {
        return "Cliente: " + this.nome + "\n";
    }
}
