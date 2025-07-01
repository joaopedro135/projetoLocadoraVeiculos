package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Locacao extends Entidade {
    private Cliente cliente;
    private Funcionario funcionario;
    private ArrayList<Aluguel> alugueis;

    public Locacao (int id, Cliente cliente, Funcionario funcionario, ArrayList<Aluguel> listaAluguel) {
        super (id);
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.alugueis = new ArrayList<Aluguel> ();
        alugueis.addAll(listaAluguel);
        funcionario.addComissao(getValorTotal());
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

    public double getValorTotal () {
        double valorTotal = 0;
        for (Aluguel aluguel : alugueis) {
            valorTotal += aluguel.getValorTotal();
        }
        return valorTotal;
    }

    @Override
    public String toString () {
        String txt = this.cliente + "" +  this.funcionario + "\n";
        for (Aluguel aluguel : alugueis) {
            txt += aluguel + "\n";
        }
        txt += "Id locacao: " + this.getId();
        txt += "\n";
        txt += "----------------------------------------\n";
        return txt;
    }
}