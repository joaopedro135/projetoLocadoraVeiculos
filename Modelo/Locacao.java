package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Locacao extends Entidade {
    private Cliente cliente;
    private ArrayList<Aluguel> alugueis;
    private Funcionario funcionario;

    public Locacao (int id, Cliente cliente, Veiculo veiculo, Funcionario funcionario, int diasAlugados) {
        super (id);
        this.alugueis = new ArrayList<>();
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

    public void addAluguel (Aluguel aluguel) {
        alugueis.add(aluguel);
    }

    public void removeAluguel (Aluguel aluguel) {
        for (int i = 0; i < alugueis.size(); i++) {
            if (alugueis.get(i).getId() == aluguel.getId()) {
                alugueis.remove(i);
                return;
            }
        }
        System.out.println("ID não encontrado");
    }

    public List<Aluguel> getAluguel () {
        return alugueis;
    }

    @Override
    public String toString () {
        String txt = this.cliente + "\n" + "Funcionario: " + this.funcionario.getNome() + "\n";
        for (Aluguel aluguel : alugueis) {
            txt += aluguel + "\n";
        }
        return txt;
    }
}