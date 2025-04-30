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
        bancoDeDados.getClientes().procuraId(id);
    }

    public static void visualizarTodosClientes() {
        System.out.println(bancoDeDados.getClientes());
    }

    // Veiculo
    public static void adicionarVeiculo() {
        int id, ano;
        double valorDiario;
        String marca, modelo, cor;
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
            System.out.println("Digite o id do Veiculo:");
            id = scan.nextInt();
            scan.nextLine();
        } catch (Exception e) {
            System.out.println("Digite um numero valido.");
            return;
        }
        Veiculo veiculo = new Veiculo(marca, modelo, ano, cor, valorDiario, id);
        bancoDeDados.getVeiculos().insercao(veiculo);
    }

    public static void alterarVeiculo() {
        int id, ano;
        double valorDiario;
        String marca, modelo, cor;
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
        bancoDeDados.getVeiculos().procuraId(id);
    }

    public static void visualizarTodosVeiculos() {
        System.out.println(bancoDeDados.getVeiculos());
    }

    // Funcionario
    public static void adicionarFuncionario() {
        int id;
        String nome;
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
        bancoDeDados.getFuncionarios().procuraId(id);
    }

    public static void visualizarTodosFuncionarios() {
        System.out.println(bancoDeDados.getFuncionarios());
    }

    // Locacao
    public static void adicionarLocacao() {
        int id, idCliente, idFuncionario, idVeiculo;
        Cliente cliente;
        Funcionario funcionario;
        Veiculo veiculo;
        int diasAlugados;
        try {
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
        bancoDeDados.getLocacao().insercao(locacao);
    }

    public static void alterarLocacao() {
        int id, idCliente, idFuncionario, idVeiculo;
        Cliente cliente;
        Funcionario funcionario;
        Veiculo veiculo;
        int diasAlugados;
        try {
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
        bancoDeDados.getLocacao().procuraId(id);
    }

    public static void visualizarTodasLocacoes() {
        System.out.println(bancoDeDados.getLocacao());
    }


    public static void main(String[] args) {
        String op;
        System.out.println("Bem vindo a Uma Locadora Chamada Maciota!!!");
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
                        System.out.println("===== MENU CLIENTE =====");
                        System.out.println("1 - Inserir");
                        System.out.println("2 - Alterar");
                        System.out.println("3 - Apagar");
                        System.out.println("4 - Buscar por ID");
                        System.out.println("5 - Visualizar todos");
                        System.out.println("0 - Voltar ao menu principal");
                        System.out.println("==========================");
                        System.out.print("Escolha uma opção: ");

                        op = scan.next();

                        switch (op) {
                            case "0":
                                break;
                            case "1":
                                adicionarCliente();
                                break;
                            case "2":
                                alterarCliente();
                                break;
                            case "3":
                                apagarCliente();
                                break;
                            case "4":
                                buscarClientePorId();
                                break;
                            case "5":
                                visualizarTodosClientes();
                                break;
                            default:
                                System.out.println("Número inválido");
                        }
                    }
                    break;
                case "2":
                    while (op != "0") {
                        System.out.println("===== MENU VEICULO =====");
                        System.out.println("1 - Inserir");
                        System.out.println("2 - Alterar");
                        System.out.println("3 - Apagar");
                        System.out.println("4 - Buscar por ID");
                        System.out.println("5 - Visualizar todos");
                        System.out.println("0 - Voltar ao menu principal");
                        System.out.println("==========================");
                        System.out.print("Escolha uma opção: ");

                        op = scan.next();

                        switch (op) {
                            case "0":
                                break;
                            case "1":
                                adicionarVeiculo();
                                break;
                            case "2":
                                alterarVeiculo();
                                break;
                            case "3":
                                apagarVeiculo();
                                break;
                            case "4":
                                buscarVeiculoPorId();
                                break;
                            case "5":
                                visualizarTodosVeiculos();
                                break;
                            default:
                                System.out.println("Número inválido");
                        }
                    }
                    break;
                case "3":
                    while (op != "0") {
                        System.out.println("===== MENU FUNCIONARIO =====");
                        System.out.println("1 - Inserir");
                        System.out.println("2 - Alterar");
                        System.out.println("3 - Apagar");
                        System.out.println("4 - Buscar por ID");
                        System.out.println("5 - Visualizar todos");
                        System.out.println("0 - Voltar ao menu principal");
                        System.out.println("==========================");
                        System.out.print("Escolha uma opção: ");

                        op = scan.next();

                        switch (op) {
                            case "0":
                                break;
                            case "1":
                                adicionarFuncionario();
                                break;
                            case "2":
                                alterarFuncionario();
                                break;
                            case "3":
                                apagarFuncionario();
                                break;
                            case "4":
                                buscarFuncionarioPorId();
                                break;
                            case "5":
                                visualizarTodosFuncionarios();
                                break;
                            default:
                                System.out.println("Número inválido");
                        }
                    }
                    break;
                case "4":
                    while (op != "0") {
                        System.out.println("===== MENU LOCACAO =====");
                        System.out.println("1 - Inserir");
                        System.out.println("2 - Alterar");
                        System.out.println("3 - Apagar");
                        System.out.println("4 - Buscar por ID");
                        System.out.println("5 - Visualizar todos");
                        System.out.println("0 - Voltar ao menu principal");
                        System.out.println("==========================");
                        System.out.print("Escolha uma opção: ");

                        op = scan.next();

                        switch (op) {
                            case "0":
                                break;
                            case "1":
                                adicionarLocacao();
                                break;
                            case "2":
                                alterarLocacao();
                                break;
                            case "3":
                                apagarLocacao();
                                break;
                            case "4":
                                buscarLocacaoPorId();
                                break;
                            case "5":
                                visualizarTodasLocacoes();
                                break;
                            default:
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
