package Persistencia;

import Modelo.Cliente;
import Modelo.Funcionario;
import Modelo.Locacao;
import Modelo.Veiculo;

public class BancoDeDados {
    private Persistente<Veiculo> listaVeiculos;
    private Persistente<Funcionario> listaFuncionarios;
    private Persistente<Cliente> listaClientes;
    private Persistente<Locacao> listaLocacao;

    public BancoDeDados () {
        listaVeiculos = new Persistente<Veiculo>();
        listaFuncionarios = new Persistente<Funcionario>();
        listaClientes = new Persistente<Cliente>();
        listaLocacao = new Persistente<Locacao>();
    }

    public Persistente<Veiculo> getVeiculos () {
        return listaVeiculos;
    }

    public Persistente<Funcionario> getFuncionarios () {
        return listaFuncionarios;
    }

    public Persistente<Cliente> getClientes () {
        return listaClientes;
    }

    public Persistente<Locacao> getLocacao () {
        return listaLocacao;
    }
}
