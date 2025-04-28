package Visao;
import Modelo.*;
import Persistencia.*;
import java.util.Scanner;

public class Interface {

    static Scanner scan = new Scanner(System.in);
    static BancoDeDados bancoDeDados = new BancoDeDados();
    
    public static void adicionarCliente () {
        int id;
        String nome;
        System.out.println("Digite nome do cliente");
        nome = scan.nextLine();
        try {
            System.out.println("Digite o id do cliente");
            id = scan.nextInt();
        } catch (Exception e) {
            System.out.println("Id invalido");
            return;
        }
        Cliente cliente = new Cliente(id, nome);
        bancoDeDados.getClientes().insercao(cliente);
    }

    public static void alterarCliente () {
        int id;
        String nome;
        try {
            System.out.println("Digite o id do cliente");
            id = scan.nextInt();
        } catch (Exception e) {
            System.out.println("Id invalido");
            return;
        }
        System.out.println("Digite o novo nome do cliente");
        nome = scan.nextLine();
        Cliente cliente = new Cliente(id, nome);
        bancoDeDados.getClientes().alteracao(cliente, id);
    }

    public static void apagarCliente(){
        int id;
        try {
            System.out.println("Digite o id do cliente");
            id = scan.nextInt();
        } catch (Exception e) {
            System.out.println("Id invalido");
            return;
        }
        bancoDeDados.getClientes().remover(id);
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
                            case "1":
                                adicionarCliente();
                                break;
                            case "2":
                                alterarCliente();
                                break;
                            case "3":
                                //apagarCliente();
                                break;
                            case "4":
                                //buscarClientePorId();
                                break;
                            case "5":
                                //visualizarTodosClientes();
                                break;
                            default:
                                System.out.println("Número inválido");
                        }
                    }
                    break;
                case "2":   
                    break;
                case "3":   
                    break;
                case "4":   
                    break;
                case "0":   
                    return;
                default: System.out.println("Numero inválido");
            }
        }
    }
}
