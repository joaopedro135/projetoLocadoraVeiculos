package Visao;

import Modelo.*;
import Persistencia.*;
import java.util.Scanner;

public class Interface {

    static Scanner scan = new Scanner(System.in);
    static BancoDeDados bancoDeDados = new BancoDeDados();

    public static void adicionarCliente() {
        int id;
        String nome;
        scan.nextLine();
        System.out.println("Digite nome do cliente");
        nome = scan.nextLine();
        try {
            System.out.println("Digite o id do cliente");
            id = scan.nextInt();
            scan.nextLine();
        } catch (Exception e) {
            System.out.println("Id invalido");
            return;
        }
        if (bancoDeDados.getClientes().procuraId(id) != null) {
            System.out.println("Id já existe");
            return;
        }
        Cliente cliente = new Cliente(id, nome);
        bancoDeDados.getClientes().insercao(cliente);
    }

    public static void alterarCliente() {
        int id;
        String nome;
        try {
            System.out.println("Digite o id do cliente");
            id = scan.nextInt();
            scan.nextLine();
        } catch (Exception e) {
            System.out.println("Id invalido");
            return;
        }
        System.out.println("Digite o novo nome do cliente");
        nome = scan.nextLine();
        Cliente cliente = new Cliente(id, nome);
        bancoDeDados.getClientes().alteracao(cliente, id);
    }

    public static void apagarCliente() {
        int id;
        try {
            System.out.println("Digite o id do cliente");
            id = scan.nextInt();
            scan.nextLine();
        } catch (Exception e) {
            System.out.println("Id invalido");
            return;
        }
        for (Entidade locacao : bancoDeDados.getLocacao().getArray()) {
            if (((Locacao)locacao).getCliente().getId() == id) {
                System.out.println("Cliente possui locação ativa, não é possível apagar.");
                return;
            }
        }
            
        bancoDeDados.getClientes().remover(id);
    }

    public static void buscarClientePorId() {
        int id;
        try {
            System.out.println("Digite o id do cliente");
            id = scan.nextInt();
            scan.nextLine();
        } catch (Exception e) {
            System.out.println("Id invalido");
            return;
        }
        System.out.println(bancoDeDados.getClientes().procuraId(id));
    }

    public static void visualizarTodosClientes() {
        System.out.print(bancoDeDados.getClientes());
    }

    // Veiculo
    public static void adicionarVeiculo() {
        int id, ano;
        double valorDiario;
        String marca, modelo, cor;
        scan.nextLine();
        System.out.println("Digite a marca do Veiculo:");
        marca = scan.nextLine();
        System.out.println("Digite a modelo do Veiculo:");
        modelo = scan.nextLine();
        System.out.println("Digite a cor do Veiculo:");
        cor = scan.nextLine();
        try {
            System.out.println("Digite o ano do Veiculo:");
            ano = scan.nextInt();
            scan.nextLine();
            System.out.println("Digite o valor da diaria do Veiculo:");
            valorDiario = scan.nextDouble();
            scan.nextLine();
            System.out.println("Digite o id do Veiculo:");
            id = scan.nextInt();
            scan.nextLine();
        } catch (Exception e) {
            System.out.println("Digite um numero valido.");
            return;
        }
        if (bancoDeDados.getVeiculos().procuraId(id) != null) {
            System.out.println("Id já existe");
            return;
        }
        Veiculo veiculo = new Veiculo(marca, modelo, ano, cor, valorDiario, id);
        bancoDeDados.getVeiculos().insercao(veiculo);
    }

    public static void alterarVeiculo() {
        int id, ano;
        double valorDiario;
        String marca, modelo, cor;
        scan.nextLine();
        System.out.println("Digite a marca do Veiculo");
        marca = scan.nextLine();
        System.out.println("Digite o modelo do Veiculo");
        modelo = scan.nextLine();
        System.out.println("Digite a cor do Veiculo");
        cor = scan.nextLine();
        try {
            System.out.println("Digite o ano do Veiculo");
            ano = scan.nextInt();
            scan.nextLine();
            System.out.println("Digite o valor da diaria do Veiculo");
            valorDiario = scan.nextDouble();
            System.out.println("Digite o id do Veiculo");
            id = scan.nextInt();
            scan.nextLine();
        } catch (Exception e) {
            System.out.println("Digite um numero valido.");
            return;
        }

        Veiculo Veiculo = new Veiculo(marca, modelo, ano, cor, valorDiario, id);
        bancoDeDados.getVeiculos().alteracao(Veiculo, id);
    }

    public static void apagarVeiculo() {
        int id;
        try {
            System.out.println("Digite o id do Veiculo");
            id = scan.nextInt();
            scan.nextLine();
        } catch (Exception e) {
            System.out.println("Id invalido");
            return;
        }

        for (Entidade locacao : bancoDeDados.getLocacao().getArray()) {
            if (((Locacao)locacao).getAluguel().getVeiculo().getId() == id) {
                System.out.println("Veiculo possui locação ativa, não é possível apagar.");
                return;
            }
        }

        bancoDeDados.getVeiculos().remover(id);
    }

    public static void buscarVeiculoPorId() {
        int id;
        try {
            System.out.println("Digite o id do Veiculo");
            id = scan.nextInt();
            scan.nextLine();
        } catch (Exception e) {
            System.out.println("Id invalido");
            return;
        }
        System.out.println(bancoDeDados.getVeiculos().procuraId(id));
    }

    public static void visualizarTodosVeiculos() {
        System.out.print(bancoDeDados.getVeiculos());
    }

    // Funcionario
    public static void adicionarFuncionario() {
        int id;
        String nome;
        scan.nextLine();
        System.out.println("Digite nome do Funcionario");
        nome = scan.nextLine();
        try {
            System.out.println("Digite o id do Funcionario");
            id = scan.nextInt();
            scan.nextLine();
        } catch (Exception e) {
            System.out.println("Id invalido");
            return;
        }
        if (bancoDeDados.getFuncionarios().procuraId(id) != null) {
            System.out.println("Id já existe");
            return;
        }
        Funcionario Funcionario = new Funcionario(nome, id);
        bancoDeDados.getFuncionarios().insercao(Funcionario);
    }

    public static void alterarFuncionario() {
        int id;
        String nome;
        try {
            System.out.println("Digite o id do Funcionario");
            id = scan.nextInt();
            scan.nextLine();
        } catch (Exception e) {
            System.out.println("Id invalido");
            return;
        }
        System.out.println("Digite o novo nome do Funcionario");
        nome = scan.nextLine();
        Funcionario funcionario = new Funcionario(nome, id);
        bancoDeDados.getFuncionarios().alteracao(funcionario, id);
    }

    public static void apagarFuncionario() {
        int id;
        try {
            System.out.println("Digite o id do Funcionario");
            id = scan.nextInt();
            scan.nextLine();
        } catch (Exception e) {
            System.out.println("Id invalido");
            return;
        }
        for (Entidade locacao : bancoDeDados.getLocacao().getArray()) {
            if (((Locacao)locacao).getFuncionario().getId() == id) {
                System.out.println("Funcionario possui locação ativa, não é possível apagar.");
                return;
            }
        }
        bancoDeDados.getFuncionarios().remover(id);
    }

    public static void buscarFuncionarioPorId() {
        int id;
        try {
            System.out.println("Digite o id do Funcionario");
            id = scan.nextInt();
            scan.nextLine();
        } catch (Exception e) {
            System.out.println("Id invalido");
            return;
        }
        System.out.println(bancoDeDados.getFuncionarios().procuraId(id));
    }

    public static void visualizarTodosFuncionarios() {
        System.out.print(bancoDeDados.getFuncionarios());
    }

    // Locacao
    public static void adicionarLocacao() {
        int id, idCliente, idFuncionario, idVeiculo;
        Cliente cliente;
        Funcionario funcionario;
        Veiculo veiculo;
        int diasAlugados;
        try {
            scan.nextLine();
            System.out.println("Digite o id do cliente");
            idCliente = scan.nextInt();
            scan.nextLine();
            System.out.println("Digite o id do funcionario");
            idFuncionario = scan.nextInt();
            scan.nextLine();
            System.out.println("Digite o id do veiculo");
            idVeiculo = scan.nextInt();
            scan.nextLine();
            System.out.println("Digite o numero de dias alugados");
            diasAlugados = scan.nextInt();
            scan.nextLine();
            System.out.println("Digite o id da Locacao");
            id = scan.nextInt();
            scan.nextLine();
        } catch (Exception e) {
            System.out.println("Digite um numero valido.");
            return;
        }
        cliente = (Cliente)bancoDeDados.getClientes().procuraId(idCliente);
        funcionario = (Funcionario)bancoDeDados.getFuncionarios().procuraId(idFuncionario);
        veiculo = (Veiculo)bancoDeDados.getVeiculos().procuraId(idVeiculo);
        funcionario.addComissao(diasAlugados * veiculo.getValorDiario());
        if (bancoDeDados.getLocacao().procuraId(id) != null) {
            System.out.println("Id já existe");
            return;
        }
        Locacao locacao = new Locacao(id, cliente, veiculo, funcionario, diasAlugados);
        bancoDeDados.getLocacao().insercao(locacao);
    }

    public static void alterarLocacao() {
        int id, idCliente, idFuncionario, idVeiculo;
        Cliente cliente;
        Funcionario funcionario;
        Veiculo veiculo;
        int diasAlugados;
        try {
            scan.nextLine();
            System.out.println("Digite o id do cliente");
            idCliente = scan.nextInt();
            scan.nextLine();
            System.out.println("Digite o id do funcionario");
            idFuncionario = scan.nextInt();
            scan.nextLine();
            System.out.println("Digite o id do veiculo");
            idVeiculo = scan.nextInt();
            scan.nextLine();
            System.out.println("Digite o numero de dias alugados");
            diasAlugados = scan.nextInt();
            scan.nextLine();
            System.out.println("Digite o id da Locacao");
            id = scan.nextInt();
            scan.nextLine();
        } catch (Exception e) {
            System.out.println("Digite um numero valido.");
            return;
        }
        cliente = (Cliente)bancoDeDados.getClientes().procuraId(idCliente);
        funcionario = (Funcionario)bancoDeDados.getFuncionarios().procuraId(idFuncionario);
        veiculo = (Veiculo)bancoDeDados.getVeiculos().procuraId(idVeiculo);
        Locacao locacao = new Locacao(id, cliente, veiculo, funcionario, diasAlugados);
        bancoDeDados.getLocacao().alteracao(locacao, id);
    }

    public static void apagarLocacao() {
        int id;
        try {
            System.out.println("Digite o id do Locacao");
            id = scan.nextInt();
            scan.nextLine();
        } catch (Exception e) {
            System.out.println("Id invalido");
            return;
        }
        bancoDeDados.getLocacao().remover(id);
    }

    public static void buscarLocacaoPorId() {
        int id;
        try {
            System.out.println("Digite o id do Locacao");
            id = scan.nextInt();
            scan.nextLine();
        } catch (Exception e) {
            System.out.println("Id invalido");
            return;
        }
        System.out.println(bancoDeDados.getLocacao().procuraId(id));
    }

    public static void visualizarTodasLocacoes() {
        System.out.print(bancoDeDados.getLocacao());
    }


    public static void main(String[] args) {
        String op;
        System.out.println("\nBem vindo a Locadora Torres!!!\n");
        while (true) {
            System.out.println("===== MENU PRINCIPAL =====");
            System.out.println("1 - Cliente");
            System.out.println("2 - Veiculo");
            System.out.println("3 - Funcionario");
            System.out.println("4 - Locacao");
            System.out.println("0 - Sair do programa");
            System.out.println("==========================");
            System.out.print("Escolha uma opção: ");

            op = scan.next();

            switch (op) {
                case "1":
                    while (op != "0") {
                        System.out.println("\n====== MENU CLIENTE ======");
                        System.out.println("1 - Inserir");
                        System.out.println("2 - Alterar");
                        System.out.println("3 - Apagar");
                        System.out.println("4 - Buscar por ID");
                        System.out.println("5 - Visualizar todos");
                        System.out.println("0 - Voltar ao menu principal");
                        System.out.println("============================");
                        System.out.print("Escolha uma opção: ");

                        op = scan.next();
                        System.out.println("");

                        if (op.equals("0")) {
                            break;
                        } else if (op.equals("1")) {
                            adicionarCliente();
                        } else if (op.equals("2")) {
                            alterarCliente();
                        } else if (op.equals("3")) {
                            apagarCliente();
                        } else if (op.equals("4")) {
                            buscarClientePorId();
                        } else if (op.equals("5")) {
                            visualizarTodosClientes();
                        } else {
                            System.out.println("Número inválido");
                        }
                    }
                    break;
                case "2":
                    while (op != "0") {
                        System.out.println("\n====== MENU VEICULO ======");
                        System.out.println("1 - Inserir");
                        System.out.println("2 - Alterar");
                        System.out.println("3 - Apagar");
                        System.out.println("4 - Buscar por ID");
                        System.out.println("5 - Visualizar todos");
                        System.out.println("0 - Voltar ao menu principal");
                        System.out.println("============================");
                        System.out.print("Escolha uma opção: ");

                        op = scan.next();
                        System.out.println("");

                        if (op.equals("0")) {
                            break;
                        } else if (op.equals("1")) {
                            adicionarVeiculo();
                        } else if (op.equals("2")) {
                            alterarVeiculo();
                        } else if (op.equals("3")) {
                            apagarVeiculo();
                        } else if (op.equals("4")) {
                            buscarVeiculoPorId();
                        } else if (op.equals("5")) {
                            visualizarTodosVeiculos();
                        } else {
                            System.out.println("Número inválido");
                        }
                    }
                    break;
                case "3":
                    while (op != "0") {
                        System.out.println("\n====== MENU FUNCIONARIO ======");
                        System.out.println("1 - Inserir");
                        System.out.println("2 - Alterar");
                        System.out.println("3 - Apagar");
                        System.out.println("4 - Buscar por ID");
                        System.out.println("5 - Visualizar todos");
                        System.out.println("0 - Voltar ao menu principal");
                        System.out.println("============================");
                        System.out.print("Escolha uma opção: ");

                        op = scan.next();
                        System.out.println("");

                        if (op.equals("0")) {
                            break;
                        } else if (op.equals("1")) {
                            adicionarFuncionario();
                        } else if (op.equals("2")) {
                            alterarFuncionario();
                        } else if (op.equals("3")) {
                            apagarFuncionario();
                        } else if (op.equals("4")) {
                            buscarFuncionarioPorId();
                        } else if (op.equals("5")) {
                            visualizarTodosFuncionarios();
                        } else {
                            System.out.println("Número inválido");
                        }
                    }
                    break;
                case "4":
                    while (op != "0") {
                        System.out.println("\n====== MENU LOCACAO ======");
                        System.out.println("1 - Inserir");
                        System.out.println("2 - Alterar");
                        System.out.println("3 - Apagar");
                        System.out.println("4 - Buscar por ID");
                        System.out.println("5 - Visualizar todos");
                        System.out.println("0 - Voltar ao menu principal");
                        System.out.println("============================");
                        System.out.print("Escolha uma opção: ");

                        op = scan.next();
                        System.out.println("");

                        if (op.equals("0")) {
                            break;
                        } else if (op.equals("1")) {
                            adicionarLocacao();
                        } else if (op.equals("2")) {
                            alterarLocacao();
                        } else if (op.equals("3")) {
                            apagarLocacao();
                        } else if (op.equals("4")) {
                            buscarLocacaoPorId();
                        } else if (op.equals("5")) {
                            visualizarTodasLocacoes();
                        } else {
                            System.out.println("Número inválido");
                        }
                    }
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Numero inválido");
            }
        }
    }
}
