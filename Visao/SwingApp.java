package Visao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingApp extends JFrame {

    private JPanel mainPanel;
    private CardLayout cardLayout;

    public SwingApp() {
        setTitle("Uma Locadora Chamada Torres"); //titulo
        setSize(600, 400); //tamanho da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //fecha janela então fecha operação
        setLocationRelativeTo(null); // centraliza a janela na tela

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Painel Principal
        JPanel homePanel = createButtonPanel("Locadora Torres", new String[]{"Cliente", "Veículo", "Funcionário", "Locação"}); //criando botão com
        mainPanel.add(homePanel, "Home");

        // Submenus
        JPanel clientePanel = createButtonPanel("Cliente", new String[]{"Cadastrar Cliente", "Consultar Cliente", "Atualizar Cliente", "Excluir Cliente"});
        mainPanel.add(clientePanel, "Cliente");

        JPanel veiculoPanel = createButtonPanel("Veiculo", new String[]{"Cadastrar Veículo", "Consultar Veículo", "Atualizar Veículo", "Excluir Veículo"});
        mainPanel.add(veiculoPanel, "Veiculo");

        JPanel funcionarioPanel = createButtonPanel("Funcionario", new String[]{"Cadastrar Funcionário", "Consultar Funcionário", "Atualizar Funcionário", "Excluir Funcionário"});
        mainPanel.add(funcionarioPanel, "Funcionario");

        JPanel locacaoPanel = createButtonPanel("Locacao", new String[]{"Nova Locação", "Consultar Locação", "Finalizar Locação", "Relatórios"});
        mainPanel.add(locacaoPanel, "Locacao");

        add(mainPanel);

        // Adiciona um botão de "Voltar" para cada submenu
        addBackButton(clientePanel, "Home");
        addBackButton(veiculoPanel, "Home");
        addBackButton(funcionarioPanel, "Home");
        addBackButton(locacaoPanel, "Home");

        setVisible(true);
    }

    private JPanel createButtonPanel(String title, String[] buttonNames) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titleLabel = new JLabel(title, SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(titleLabel, BorderLayout.NORTH);

        JPanel buttonGridPanel = new JPanel(new GridLayout(2, 2, 10, 10)); // 2x2 grid for 4 buttons
        buttonGridPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

        for (String name : buttonNames) {
            JButton button = new JButton(name);
            button.setPreferredSize(new Dimension(150, 50));
            buttonGridPanel.add(button);
        }

        JPanel centerPanel = new JPanel(new GridBagLayout()); // Para centralizar o grid de botões
        centerPanel.add(buttonGridPanel);
        panel.add(centerPanel, BorderLayout.CENTER);

        return panel;
    }

    private void addBackButton(JPanel panel, String targetPanel) {
        JButton backButton = new JButton("Voltar");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, targetPanel);
            }
        });
        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        southPanel.add(backButton);
        panel.add(southPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SwingApp();
            }
        });
    }
}


