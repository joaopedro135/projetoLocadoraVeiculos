package Visao;

import java.awt.*;
import javax.swing.*;
import Modelo.Cliente;
import Modelo.Veiculo;
import Persistencia.BancoDeDados;

public class Janela extends JFrame {

    private JPanel mainPanel;
    private CardLayout cardLayout;
    private BancoDeDados bancoDeDados;

    public Janela(BancoDeDados bancoDeDados) {

        this.bancoDeDados = bancoDeDados;
        setTitle("Uma Locadora Chamada Torres");
        setSize(600, 400); //tamanho
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // SE FECHA JANELA ENTÃO PROGRAMA ENCERRA
        setLocationRelativeTo(null);

        // INICIALIZAÇÃO PRINCIPAL
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // PÁGINA PRNICIPAL HOME
        JPanel homePanel = criarHomePanel();
        mainPanel.add(homePanel, "home");

        // PÁGINA PRINCIPAL CLIENTE
        JPanel clientePanel = criarClientePanel();
        mainPanel.add(clientePanel, "cliente");

        // ABAS DA PÁGINA CLIENTE
        JPanel adicionarClientePanel = criarAdicionarClientePanel();
        mainPanel.add(adicionarClientePanel, "adicionarCliente");

        JPanel alterarClientePanel = criarAlterarClientePanel();
        mainPanel.add(alterarClientePanel, "alterarCliente");

        JPanel apagarClientePanel = criarApagarClientePanel();
        mainPanel.add(apagarClientePanel, "apagarCliente");

        JPanel buscarClientePanel = criarBuscarClientePanel();
        mainPanel.add(buscarClientePanel, "buscarCliente");

        JPanel visualizarTodosClientesPanel = criarVisualizarTodosClientesPanel();
        mainPanel.add(visualizarTodosClientesPanel, "visualizarTodosClientes");

        // PÁGINA PRINCIPAL VEÍCULO
        JPanel veiculoPanel = criarVeiculoPanel();
        mainPanel.add(veiculoPanel, "veiculo");

        // ABAS DA PÁGINA VEÍCULO
        JPanel adicionarVeiculoPanel = criarAdicionarVeiculoPanel();
        mainPanel.add(adicionarVeiculoPanel, "adicionarVeiculo");

        JPanel alterarVeiculoPanel = criarAlterarVeiculoPanel();
        mainPanel.add(alterarVeiculoPanel, "alterarVeiculo");

        JPanel apagarVeiculoPanel = criarApagarVeiculoPanel();
        mainPanel.add(apagarVeiculoPanel, "apagarVeiculo");

        JPanel buscarVeiculoPanel = criarBuscarVeiculoPanel();
        mainPanel.add(buscarVeiculoPanel, "buscarVeiculo");

        JPanel visualizarTodosVeiculosPanel = criarVisualizarTodosVeiculosPanel();
        mainPanel.add(visualizarTodosVeiculosPanel, "visualizarTodosVeiculos");

        // PÁGINA PRINCIPAL FUNCIONÁRIO
        JPanel funcionarioPanel = criarFuncionarioPanel();
        mainPanel.add(funcionarioPanel, "funcionario");

        // ABAS DA PÁGINA FUNCIONÁRIO
        JPanel adicionarFuncionarioPanel = criarAdicionarFuncionarioPanel();
        mainPanel.add(adicionarFuncionarioPanel, "adicionarFuncionario");

        JPanel alterarFuncionarioPanel = criarAlterarFuncionarioPanel();
        mainPanel.add(alterarFuncionarioPanel, "alterarFuncionario");

        JPanel apagarFuncionarioPanel = criarApagarFuncionarioPanel();
        mainPanel.add(apagarFuncionarioPanel, "apagarFuncionario");

        JPanel buscarFuncionarioPanel = criarBuscarFuncionarioPanel();
        mainPanel.add(buscarFuncionarioPanel, "buscarFuncionario");

        JPanel visualizarTodosFuncionariosPanel = criarVisualizarTodosFuncionariosPanel();
        mainPanel.add(visualizarTodosFuncionariosPanel, "visualizarTodosFuncionarios");


        // PÁGINA PRINCIPAL LOCAÇÃO
        JPanel locacaoPanel = criarLocacaoPanel();
        mainPanel.add(locacaoPanel, "locacao");

        add(mainPanel);
        setVisible(true);
    }

    private JPanel criarHomePanel() {

        // INICIALIZAÇÃO PRINCIPAL
        JPanel homePanel = new JPanel(new BorderLayout());
        homePanel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

        JLabel titleLabel = new JLabel(getTitle(), SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        homePanel.add(titleLabel, BorderLayout.NORTH);

        JPanel homeButtonPanel = new JPanel(new GridLayout(2, 2, 10, 10));

        // IDENTIFICAÇÃO BOTÕES
        JButton btnCliente = new JButton("Cliente");
        JButton btnVeiculo = new JButton("Veiculo");
        JButton btnFuncionario = new JButton("Funcionario");
        JButton btnLocacao = new JButton("Locacao");

        btnCliente.setPreferredSize(new Dimension(50, 25));
        btnVeiculo.setPreferredSize(new Dimension(50, 25));
        btnFuncionario.setPreferredSize(new Dimension(50, 25));
        btnLocacao.setPreferredSize(new Dimension(50, 25));

        homeButtonPanel.add(btnCliente);
        homeButtonPanel.add(btnVeiculo);
        homeButtonPanel.add(btnFuncionario);
        homeButtonPanel.add(btnLocacao);

        homePanel.add(homeButtonPanel, BorderLayout.CENTER);

        // EVENTO EM BOTÃO CLIENTE ---> IR PARA PAINEL CLIENTE
        btnCliente.addActionListener(e -> cardLayout.show(mainPanel, "cliente"));

        // EVENTO EM BOTÃO VEÍCULO ---> IR PARA PAINEL VEÍCULO
        btnVeiculo.addActionListener(e -> cardLayout.show(mainPanel, "veiculo"));

        // EVENTO EM BOTÃO FUNCIONÁRIO ---> IR PARA PAINEL FUNCIONÁRIO
        btnFuncionario.addActionListener(e -> cardLayout.show(mainPanel, "funcionario"));

        // EVENTO EM BOTÃO LOCAÇÃO ---> IR PARA PAINEL LOCAÇÃO
        btnLocacao.addActionListener(e -> cardLayout.show(mainPanel, "locacao"));

        return homePanel;
    }

    private JPanel criarClientePanel() {

        // INICIALIZAÇÃO PRINCIPAL
        JPanel clientePanel = new JPanel(new BorderLayout());
        clientePanel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

        JLabel clienteLabel = new JLabel("Cliente", SwingConstants.CENTER);
        clienteLabel.setFont(new Font("Arial", Font.BOLD, 24));
        clientePanel.add(clienteLabel, BorderLayout.NORTH);

        JPanel clienteButtonPanel = new JPanel(new GridLayout(3, 2, 10, 10));

        // IDENTIFICAÇÃO BOTÕES
        JButton btnInserir = new JButton("Inserir");
        JButton btnAlterar = new JButton("Alterar");
        JButton btnApagar = new JButton("Apagar");
        JButton btnBuscarId = new JButton("Buscar ID");
        JButton btnVisualizarTodos = new JButton("Visualizar Todos");
        JButton btnVoltar = new JButton("Voltar ao Menu Principal");

        clienteButtonPanel.add(btnInserir);
        clienteButtonPanel.add(btnAlterar);
        clienteButtonPanel.add(btnApagar);
        clienteButtonPanel.add(btnBuscarId);
        clienteButtonPanel.add(btnVisualizarTodos);
        clienteButtonPanel.add(btnVoltar);

        clientePanel.add(clienteButtonPanel, BorderLayout.CENTER);

        // EVENTO EM BOTÃO ADICIONAR ---> IR PARA PAINEL ADICIONAR CLIENTE
        btnInserir.addActionListener(e -> cardLayout.show(mainPanel, "adicionarCliente"));
        
        // EVENTO EM BOTÃO ALTERAR ---> IR PARA PAINEL ALTERAR CLIENTE
        btnAlterar.addActionListener(e-> cardLayout.show(mainPanel, "alterarCliente"));
        
        // EVENTO EM BOTÃO APAGAR ---> IR PARA PAINEL APAGAR CLIENTE
        btnApagar.addActionListener(e -> cardLayout.show(mainPanel, "apagarCliente"));
        
        // EVENTO EM BOTÃO BUSCAR ---> IR PARA PAINEL BUSCAR CLIENTE
        btnBuscarId.addActionListener(e -> cardLayout.show(mainPanel, "buscarCliente"));
        
        // EVENTO EM BOTÃO VISUALIZAR TODOS OS CLIENTES ---> IR PARA PAINEL VISUALIZAR TODOS OS CLIENTES
        btnVisualizarTodos.addActionListener(e -> cardLayout.show(mainPanel, "visualizarTodosClientes"));
        
        // EVENTO EM BOTÃO VOLTAR ---> IR PARA PAINEL HOME
        btnVoltar.addActionListener(e -> cardLayout.show(mainPanel, "home"));

        return clientePanel;
    }

    private JPanel criarAdicionarClientePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(60, 100, 60, 100));

        JLabel title = new JLabel("Adicionar Cliente", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        panel.add(title, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        JLabel lblNome = new JLabel("Nome do cliente:");
        JTextField txtNome = new JTextField();
        JLabel lblId = new JLabel("ID do cliente:");
        JTextField txtId = new JTextField();

        formPanel.add(lblNome);
        formPanel.add(txtNome);
        formPanel.add(lblId);
        formPanel.add(txtId);

        JButton btnConfirmar = new JButton("Confirmar");
        JButton btnVoltar = new JButton("Voltar");

        formPanel.add(btnConfirmar);
        formPanel.add(btnVoltar);

        panel.add(formPanel, BorderLayout.CENTER);

        // EVENTO EM BOTÃO VOLTAR ---> IR PARA PAINEL CLIENTE
        btnVoltar.addActionListener(e -> cardLayout.show(mainPanel, "cliente"));

        // EVENTO EM BOTÃO CONFIRMAR ---> FINALIZAR A AÇÃO
        btnConfirmar.addActionListener(e -> {
            System.out.println("Cliquei em Confirmar (adicionar)");
            String nome = txtNome.getText().trim();
            String idStr = txtId.getText().trim();
            if (nome.isEmpty() || idStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int id;
            try {
                id = Integer.parseInt(idStr);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ID inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (bancoDeDados.getClientes().procuraId(id) != null) {
                JOptionPane.showMessageDialog(this, "ID já existe.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Cliente cliente = new Cliente(id, nome);
            bancoDeDados.getClientes().insercao(cliente);
            JOptionPane.showMessageDialog(this, "Cliente adicionado com sucesso!");
            txtNome.setText("");
            txtId.setText("");
        });
        return panel;
    }

    private JPanel criarAlterarClientePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(60, 100, 60, 100));

        JLabel title = new JLabel("Alterar Cliente", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        panel.add(title, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        JLabel lblNome = new JLabel("Nome do cliente:");
        JTextField txtNome = new JTextField();
        JLabel lblId = new JLabel("ID do cliente:");
        JTextField txtId = new JTextField();

        formPanel.add(lblNome);
        formPanel.add(txtNome);
        formPanel.add(lblId);
        formPanel.add(txtId);

        JButton btnConfirmar = new JButton("Confirmar");
        JButton btnVoltar = new JButton("Voltar");

        formPanel.add(btnConfirmar);
        formPanel.add(btnVoltar);

        panel.add(formPanel, BorderLayout.CENTER);

        // EVENTO EM BOTÃO VOLTAR ---> IR PARA PAINEL CLIENTE
        btnVoltar.addActionListener(e -> cardLayout.show(mainPanel, "cliente"));

        btnConfirmar.addActionListener(e -> {
            System.out.println("Cliquei em Confirmar (alterar)");
            String nome = txtNome.getText().trim();
            String idStr = txtId.getText().trim();
            if (nome.isEmpty() || idStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int id;
            try {
                id = Integer.parseInt(idStr);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ID inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // Supondo que bancoDeDados e Cliente estejam acessíveis aqui
            if (bancoDeDados.getClientes().procuraId(id) == null) {
                JOptionPane.showMessageDialog(this, "ID não existe.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                Cliente cliente = new Cliente(id, nome);
                bancoDeDados.getClientes().alteracao(cliente, id);
                JOptionPane.showMessageDialog(this, "Cliente alterado com sucesso!");
                txtNome.setText("");
                txtId.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao alterar cliente: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
        return panel;
    }

    private JPanel criarApagarClientePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(60, 100, 60, 100));

        JLabel title = new JLabel("Apagar Cliente", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        panel.add(title, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        JLabel lblId = new JLabel("ID do cliente:");
        JTextField txtId = new JTextField();

        formPanel.add(lblId);
        formPanel.add(txtId);

        JButton btnConfirmar = new JButton("Confirmar");
        JButton btnVoltar = new JButton("Voltar");

        formPanel.add(btnConfirmar);
        formPanel.add(btnVoltar);

        panel.add(formPanel, BorderLayout.CENTER);

        // EVENTO EM BOTÃO VOLTAR ---> IR PARA PAINEL CLIENTE
        btnVoltar.addActionListener(e -> cardLayout.show(mainPanel, "cliente"));

        btnConfirmar.addActionListener(e -> {
            System.out.println("Cliquei em Confirmar (apagar)");
            String idStr = txtId.getText().trim();
            if (idStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha o campo de Id.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int id;
            try {
                id = Integer.parseInt(idStr);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Id inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (bancoDeDados.getClientes().procuraId(id) == null) {
                JOptionPane.showMessageDialog(this, "Id não existe.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                bancoDeDados.getClientes().remover(id);
                JOptionPane.showMessageDialog(this, "Cliente apagado com sucesso!");
                txtId.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao apagar cliente: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
        return panel;
    }

    private JPanel criarBuscarClientePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(60, 100, 60, 100));

        JLabel title = new JLabel("Buscar Cliente por ID", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        panel.add(title, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        JLabel lblId = new JLabel("ID do cliente:");
        JTextField txtId = new JTextField();

        formPanel.add(lblId);
        formPanel.add(txtId);

        JButton btnBuscar = new JButton("Buscar");
        JButton btnVoltar = new JButton("Voltar");

        formPanel.add(btnBuscar);
        formPanel.add(btnVoltar);

        panel.add(formPanel, BorderLayout.CENTER);

        // CAMPO PARA MOSTRAR RESULTADO DA BUSCA
        JTextArea resultado = new JTextArea(5,30);
        resultado.setEditable(false);
        resultado.setLineWrap(true);
        resultado.setWrapStyleWord(true);
        panel.add(new JScrollPane(resultado), BorderLayout.SOUTH);

        // EVENTO EM BOTÃO VOLTAR ---> IR PARA PAINEL CLIENTE
        btnVoltar.addActionListener(e -> cardLayout.show(mainPanel, "cliente"));

        btnBuscar.addActionListener(e -> {
            String idStr = txtId.getText().trim();
            if (idStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha o campo ID.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int id;
            try {
                id = Integer.parseInt(idStr);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ID inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Cliente cliente = bancoDeDados.getClientes().procuraId(id);
            if (cliente == null) {
                resultado.setText("Cliente não encontrado.");
            } else {
                resultado.setText(cliente.toString());
            }
        });

        return panel;
    }

    private JPanel criarVisualizarTodosClientesPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60));

        JLabel title = new JLabel("Todos os Clientes", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        panel.add(title, BorderLayout.NORTH);

        JTextArea areaClientes = new JTextArea();
        areaClientes.setEditable(false);
        areaClientes.setLineWrap(true);
        areaClientes.setWrapStyleWord(true);

        JScrollPane scroll = new JScrollPane(areaClientes);
        panel.add(scroll, BorderLayout.CENTER);

        JButton btnVoltar = new JButton("Voltar");
        JPanel btnPanel = new JPanel();
        btnPanel.add(btnVoltar);
        panel.add(btnPanel, BorderLayout.SOUTH);

        panel.addHierarchyListener(e -> {
            if ((e.getChangeFlags() & java.awt.event.HierarchyEvent.SHOWING_CHANGED) != 0 && panel.isShowing()) {
                areaClientes.setText(bancoDeDados.getClientes().toString());
            }
        });

        // EVENTO EM BOTÃO VOLTAR ---> IR PARA PAINEL CLIENTE
        btnVoltar.addActionListener(e -> cardLayout.show(mainPanel, "cliente"));

        return panel;
    }

    private JPanel criarVeiculoPanel() {

        // INICIALIZAÇÃO PRINCIPAL
        JPanel veiculoPanel = new JPanel(new BorderLayout());
        veiculoPanel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

        JLabel veiculoLabel = new JLabel("Veículo", SwingConstants.CENTER);
        veiculoLabel.setFont(new Font("Arial", Font.BOLD, 24));
        veiculoPanel.add(veiculoLabel, BorderLayout.NORTH);

        JPanel veiculoButtonPanel = new JPanel(new GridLayout(3, 2, 10, 10));

        // IDENTIFICAÇÃO BOTÕES
        JButton btnInserir = new JButton("Inserir");
        JButton btnAlterar = new JButton("Alterar");
        JButton btnApagar = new JButton("Apagar");
        JButton btnBuscarId = new JButton("Buscar por ID");
        JButton btnVisualizarTodos = new JButton("Visualizar Todos");
        JButton btnVoltar = new JButton("Voltar ao Menu Principal");

        veiculoButtonPanel.add(btnInserir);
        veiculoButtonPanel.add(btnAlterar);
        veiculoButtonPanel.add(btnApagar);
        veiculoButtonPanel.add(btnBuscarId);
        veiculoButtonPanel.add(btnVisualizarTodos);
        veiculoButtonPanel.add(btnVoltar);

        veiculoPanel.add(veiculoButtonPanel, BorderLayout.CENTER);
        
        // EVENTO EM BOTÃO ADICIONAR ---> IR PARA PAINEL ADICIONAR VEÍCULO
        btnInserir.addActionListener(e -> cardLayout.show(mainPanel, "adicionarVeiculo"));
        
        // EVENTO EM BOTÃO ALTERAR ---> IR PARA PAINEL ALTERAR VEÍCULO
        btnAlterar.addActionListener(e-> cardLayout.show(mainPanel, "alterarVeiculo"));
        
        // EVENTO EM BOTÃO APAGAR ---> IR PARA PAINEL APAGAR VEÍCULO
        btnApagar.addActionListener(e -> cardLayout.show(mainPanel, "apagarVeiculo"));
        
        // EVENTO EM BOTÃO BUSCAR ---> IR PARA PAINEL BUSCAR VEÍCULO
        btnBuscarId.addActionListener(e -> cardLayout.show(mainPanel, "buscarVeiculo"));
        
        // EVENTO EM BOTÃO VISUALIZAR TODOS OS FUNCIONÁRIOS ---> IR PARA PAINEL VISUALIZAR TODOS OS VEÍCULOS
        btnVisualizarTodos.addActionListener(e -> cardLayout.show(mainPanel, "visualizarTodosVeiculos"));
        
        // EVENTO EM BOTÃO VOLTAR ---> IR PARA PAINEL HOME
        btnVoltar.addActionListener(e -> cardLayout.show(mainPanel, "home"));

        return veiculoPanel;
    }

    private JPanel criarAdicionarVeiculoPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(60, 100, 60, 100));

        JLabel title = new JLabel("Adicionar Veículo", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        panel.add(title, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        JLabel lblMarca = new JLabel("Marca do veículo:");
        JTextField txtMarca = new JTextField();
        JLabel lblModelo = new JLabel("Modelo do veículo:");
        JTextField txtModelo = new JTextField();
        JLabel lblCor = new JLabel("Cor do veículo:");
        JTextField txtCor = new JTextField();
        JLabel lblAno = new JLabel("Ano do veículo:");
        JTextField txtAno = new JTextField();
        JLabel lblValorDiario = new JLabel("Valor da diária:");
        JTextField txtValorDiario = new JTextField();
        JLabel lblId = new JLabel("ID do veículo:");
        JTextField txtId = new JTextField();

        formPanel.add(lblMarca);
        formPanel.add(txtMarca);
        formPanel.add(lblModelo);
        formPanel.add(txtModelo);
        formPanel.add(lblCor);
        formPanel.add(txtCor);
        formPanel.add(lblAno);
        formPanel.add(txtAno);
        formPanel.add(lblValorDiario);
        formPanel.add(txtValorDiario);
        formPanel.add(lblId);
        formPanel.add(txtId);

        JButton btnConfirmar = new JButton("Confirmar");
        JButton btnVoltar = new JButton("Voltar");

        formPanel.add(btnConfirmar);
        formPanel.add(btnVoltar);

        panel.add(formPanel, BorderLayout.CENTER);

        // EVENTO EM BOTÃO VOLTAR ---> IR PARA PAINEL VEÍCULO
        btnVoltar.addActionListener(e -> cardLayout.show(mainPanel, "veiculo"));

        btnConfirmar.addActionListener(e -> {
            String marca = txtMarca.getText().trim();
            String modelo = txtModelo.getText().trim();
            String cor = txtCor.getText().trim();
            String anoStr = txtAno.getText().trim();
            String valorDiarioStr = txtValorDiario.getText().trim();
            String idStr = txtId.getText().trim();

            if (marca.isEmpty() || modelo.isEmpty() || cor.isEmpty() ||
                anoStr.isEmpty() || valorDiarioStr.isEmpty() || idStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int ano, id;
            double valorDiario;
            try {
                ano = Integer.parseInt(anoStr);
                valorDiario = Double.parseDouble(valorDiarioStr);
                id = Integer.parseInt(idStr);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ano, valor da diária ou ID inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (bancoDeDados.getVeiculos().procuraId(id) != null) {
                JOptionPane.showMessageDialog(this, "ID já existe.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Veiculo veiculo = new Veiculo(marca, modelo, ano, cor, valorDiario, id);
            bancoDeDados.getVeiculos().insercao(veiculo);
            JOptionPane.showMessageDialog(this, "Veículo adicionado com sucesso!");
            txtMarca.setText("");
            txtModelo.setText("");
            txtCor.setText("");
            txtAno.setText("");
            txtValorDiario.setText("");
            txtId.setText("");
        });
        return panel;
    }

    private JPanel criarFuncionarioPanel() {

        // INICIALIZAÇÃO PRINCIPAL
        JPanel funcionarioPanel = new JPanel(new BorderLayout());
        funcionarioPanel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

        JLabel funcionarioLabel = new JLabel("Funcionário", SwingConstants.CENTER);
        funcionarioLabel.setFont(new Font("Arial", Font.BOLD, 24));
        funcionarioPanel.add(funcionarioLabel, BorderLayout.NORTH);

        JPanel funcionarioButtonPanel = new JPanel(new GridLayout(3, 2, 10, 10));

        // IDENTIFICAÇÃO BOTÕES
        JButton btnInserir = new JButton("Inserir");
        JButton btnAlterar = new JButton("Alterar");
        JButton btnApagar = new JButton("Apagar");
        JButton btnBuscarId = new JButton("Buscar por ID");
        JButton btnVisualizarTodos = new JButton("Visualizar Todos");
        JButton btnVoltar = new JButton("Voltar ao Menu Principal");

        funcionarioButtonPanel.add(btnInserir);
        funcionarioButtonPanel.add(btnAlterar);
        funcionarioButtonPanel.add(btnApagar);
        funcionarioButtonPanel.add(btnBuscarId);
        funcionarioButtonPanel.add(btnVisualizarTodos);
        funcionarioButtonPanel.add(btnVoltar);

        funcionarioPanel.add(funcionarioButtonPanel, BorderLayout.CENTER);

        // EVENTO EM BOTÃO ADICIONAR ---> IR PARA PAINEL ADICIONAR FUNCIONARIO
        btnInserir.addActionListener(e -> cardLayout.show(mainPanel, "adicionarFuncionario"));
        
        // EVENTO EM BOTÃO ALTERAR ---> IR PARA PAINEL ALTERAR FUNCIONARIO
        btnAlterar.addActionListener(e-> cardLayout.show(mainPanel, "alterarFuncionario"));
        
        // EVENTO EM BOTÃO APAGAR ---> IR PARA PAINEL APAGAR FUNCIONARIO
        btnApagar.addActionListener(e -> cardLayout.show(mainPanel, "apagarFuncionario"));
        
        // EVENTO EM BOTÃO BUSCAR ---> IR PARA PAINEL BUSCAR FUNCIONARIO
        btnBuscarId.addActionListener(e -> cardLayout.show(mainPanel, "buscarFuncionario"));
        
        // EVENTO EM BOTÃO VISUALIZAR TODOS OS FUNCIONÁRIOS ---> IR PARA PAINEL VISUALIZAR TODOS OS FUNCIONARIOS
        btnVisualizarTodos.addActionListener(e -> cardLayout.show(mainPanel, "visualizarTodosFuncionarios"));
        
        // EVENTO EM BOTÃO VOLTAR ---> IR PARA PAINEL HOME
        btnVoltar.addActionListener(e -> cardLayout.show(mainPanel, "home"));

        return funcionarioPanel;
    }

    private JPanel criarAdicionarFuncionarioPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(60, 100, 60, 100));

        JLabel title = new JLabel("Adicionar Funcionário", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        panel.add(title, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        JLabel lblNome = new JLabel("Nome do funcionário:");
        JTextField txtNome = new JTextField();
        JLabel lblId = new JLabel("ID do funcionário:");
        JTextField txtId = new JTextField();

        formPanel.add(lblNome);
        formPanel.add(txtNome);
        formPanel.add(lblId);
        formPanel.add(txtId);

        JButton btnConfirmar = new JButton("Confirmar");
        JButton btnVoltar = new JButton("Voltar");

        formPanel.add(btnConfirmar);
        formPanel.add(btnVoltar);

        panel.add(formPanel, BorderLayout.CENTER);

        // EVENTO EM BOTÃO VOLTAR ---> IR PARA PAINEL FUNCIONÁRIO
        btnVoltar.addActionListener(e -> cardLayout.show(mainPanel, "funcionario"));

        // EVENTO EM BOTÃO CONFIRMAR ---> FINALIZAR A AÇÃO
        btnConfirmar.addActionListener(e -> {
            System.out.println("Cliquei em Confirmar (adicionar)");
            String nome = txtNome.getText().trim();
            String idStr = txtId.getText().trim();
            if (nome.isEmpty() || idStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int id;
            try {
                id = Integer.parseInt(idStr);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ID inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (bancoDeDados.getClientes().procuraId(id) != null) {
                JOptionPane.showMessageDialog(this, "ID já existe.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Cliente cliente = new Cliente(id, nome);
            bancoDeDados.getClientes().insercao(cliente);
            JOptionPane.showMessageDialog(this, "Funcionário adicionado com sucesso!");
            txtNome.setText("");
            txtId.setText("");
        });
        return panel;
    }

    private JPanel criarAlterarFuncionarioPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(60, 100, 60, 100));

        JLabel title = new JLabel("Alterar Funcionário", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        panel.add(title, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        JLabel lblNome = new JLabel("Nome do funcionário:");
        JTextField txtNome = new JTextField();
        JLabel lblId = new JLabel("ID do funcionário:");
        JTextField txtId = new JTextField();

        formPanel.add(lblNome);
        formPanel.add(txtNome);
        formPanel.add(lblId);
        formPanel.add(txtId);

        JButton btnConfirmar = new JButton("Confirmar");
        JButton btnVoltar = new JButton("Voltar");

        formPanel.add(btnConfirmar);
        formPanel.add(btnVoltar);

        panel.add(formPanel, BorderLayout.CENTER);

        // EVENTO EM BOTÃO VOLTAR ---> IR PARA PAINEL FUNCIONÁRIO
        btnVoltar.addActionListener(e -> cardLayout.show(mainPanel, "funcionario"));

        btnConfirmar.addActionListener(e -> {
            System.out.println("Cliquei em Confirmar (alterar)");
            String nome = txtNome.getText().trim();
            String idStr = txtId.getText().trim();
            if (nome.isEmpty() || idStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int id;
            try {
                id = Integer.parseInt(idStr);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ID inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            // Supondo que bancoDeDados e Cliente estejam acessíveis aqui
            if (bancoDeDados.getClientes().procuraId(id) == null) {
                JOptionPane.showMessageDialog(this, "ID não existe.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                Cliente cliente = new Cliente(id, nome);
                bancoDeDados.getClientes().alteracao(cliente, id);
                JOptionPane.showMessageDialog(this, "Funcionário alterado com sucesso!");
                txtNome.setText("");
                txtId.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao alterar funcionário: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
        return panel;
    }

    private JPanel criarApagarFuncionarioPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(60, 100, 60, 100));

        JLabel title = new JLabel("Apagar Funcionário", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        panel.add(title, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        JLabel lblId = new JLabel("ID do funcionário:");
        JTextField txtId = new JTextField();

        formPanel.add(lblId);
        formPanel.add(txtId);

        JButton btnConfirmar = new JButton("Confirmar");
        JButton btnVoltar = new JButton("Voltar");

        formPanel.add(btnConfirmar);
        formPanel.add(btnVoltar);

        panel.add(formPanel, BorderLayout.CENTER);

        // EVENTO EM BOTÃO VOLTAR ---> IR PARA PAINEL FUNCIONÁRIO
        btnVoltar.addActionListener(e -> cardLayout.show(mainPanel, "funcionario"));

        btnConfirmar.addActionListener(e -> {
            System.out.println("Cliquei em Confirmar (apagar)");
            String idStr = txtId.getText().trim();
            if (idStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha o campo de Id.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int id;
            try {
                id = Integer.parseInt(idStr);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Id inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (bancoDeDados.getClientes().procuraId(id) == null) {
                JOptionPane.showMessageDialog(this, "Id não existe.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                bancoDeDados.getClientes().remover(id);
                JOptionPane.showMessageDialog(this, "Funcionário apagado com sucesso!");
                txtId.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao apagar funcionário: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
        return panel;
    }

    private JPanel criarBuscarFuncionarioPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(60, 100, 60, 100));

        JLabel title = new JLabel("Buscar Funcionário por ID", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        panel.add(title, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        JLabel lblId = new JLabel("ID do funcionário:");
        JTextField txtId = new JTextField();

        formPanel.add(lblId);
        formPanel.add(txtId);

        JButton btnBuscar = new JButton("Buscar");
        JButton btnVoltar = new JButton("Voltar");

        formPanel.add(btnBuscar);
        formPanel.add(btnVoltar);

        panel.add(formPanel, BorderLayout.CENTER);

        // CAMPO PARA MOSTRAR RESULTADO DA BUSCA
        JTextArea resultado = new JTextArea(5,30);
        resultado.setEditable(false);
        resultado.setLineWrap(true);
        resultado.setWrapStyleWord(true);
        panel.add(new JScrollPane(resultado), BorderLayout.SOUTH);

        // EVENTO EM BOTÃO VOLTAR ---> IR PARA PAINEL CLIENTE
        btnVoltar.addActionListener(e -> cardLayout.show(mainPanel, "funcionario"));

        btnBuscar.addActionListener(e -> {
            String idStr = txtId.getText().trim();
            if (idStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha o campo ID.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int id;
            try {
                id = Integer.parseInt(idStr);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "ID inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Cliente cliente = bancoDeDados.getClientes().procuraId(id);
            if (cliente == null) {
                resultado.setText("Funcionário não encontrado.");
            } else {
                resultado.setText(cliente.toString());
            }
        });

        return panel;
    }

    private JPanel criarVisualizarTodosFuncionariosPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(40, 60, 40, 60));

        JLabel title = new JLabel("Todos os Funcionarios", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        panel.add(title, BorderLayout.NORTH);

        JTextArea areaClientes = new JTextArea();
        areaClientes.setEditable(false);
        areaClientes.setLineWrap(true);
        areaClientes.setWrapStyleWord(true);

        JScrollPane scroll = new JScrollPane(areaClientes);
        panel.add(scroll, BorderLayout.CENTER);

        JButton btnVoltar = new JButton("Voltar");
        JPanel btnPanel = new JPanel();
        btnPanel.add(btnVoltar);
        panel.add(btnPanel, BorderLayout.SOUTH);

        panel.addHierarchyListener(e -> {
            if ((e.getChangeFlags() & java.awt.event.HierarchyEvent.SHOWING_CHANGED) != 0 && panel.isShowing()) {
                areaClientes.setText(bancoDeDados.getClientes().toString());
            }
        });

        // EVENTO EM BOTÃO VOLTAR ---> IR PARA PAINEL CLIENTE
        btnVoltar.addActionListener(e -> cardLayout.show(mainPanel, "funcionario"));

        return panel;
    }

    private JPanel criarLocacaoPanel() {

        // INICIALIZAÇÃO PRINCIPAL
        JPanel locacaoPanel = new JPanel(new BorderLayout());
        locacaoPanel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

        JLabel locacaoLabel = new JLabel("Locação", SwingConstants.CENTER);
        locacaoLabel.setFont(new Font("Arial", Font.BOLD, 24));
        locacaoPanel.add(locacaoLabel, BorderLayout.NORTH);

        JPanel locacaoButtonPanel = new JPanel(new GridLayout(3, 2, 10, 10));

        // IDENTIFICAÇÃO BOTÕES
        JButton btnInserir = new JButton("Inserir");
        JButton btnAlterar = new JButton("Alterar");
        JButton btnApagar = new JButton("Apagar");
        JButton btnBuscarId = new JButton("Buscar por ID");
        JButton btnVisualizarTodos = new JButton("Visualizar Todos");
        JButton btnVoltar = new JButton("Voltar ao Menu Principal");

        locacaoButtonPanel.add(btnInserir);
        locacaoButtonPanel.add(btnAlterar);
        locacaoButtonPanel.add(btnApagar);
        locacaoButtonPanel.add(btnBuscarId);
        locacaoButtonPanel.add(btnVisualizarTodos);
        locacaoButtonPanel.add(btnVoltar);

        locacaoPanel.add(locacaoButtonPanel, BorderLayout.CENTER);

        // EVENTO EM BOTÃO VOLTAR ---> IR PARA PAINEL HOME
        btnVoltar.addActionListener(e -> cardLayout.show(mainPanel, "home"));

        return locacaoPanel;
    }

    public static void main(String[] args) {
        BancoDeDados banco = new BancoDeDados();
        new Janela(banco);
    }
}