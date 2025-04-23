package Persistencia;

public class BancoDeDados {
    private Persistente listaVeiculos;
    private Persistente listaFuncionarios;
    private Persistente listaClientes;
    private Persistente listaLocacao;

    public BancoDeDados () {
        listaVeiculos = new Persistente();
        listaFuncionarios = new Persistente();
        listaClientes = new Persistente();
        listaLocacao = new Persistente();
    }

    public Persistente getVeiculos () {
        return listaVeiculos;
    }

    public Persistente getFuncionarios () {
        return listaFuncionarios;
    }

    public Persistente getClientes () {
        return listaClientes;
    }

    public Persistente getLocacao () {
        return listaLocacao;
    }
}
