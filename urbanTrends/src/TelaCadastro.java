import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.text.MaskFormatter;

import model.Carrinho;
import model.Cliente;
import model.Estoque;

public class TelaCadastro extends JFrame {
    private JTextField campoNome;
    private JFormattedTextField campoCpf;
    private JTextField campoEndereco;
    private JTextField campoEmail;
    private JTextField campoSenha;

    public TelaCadastro() {
        setTitle("Cadastro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);
        setResizable(false);

        // Painel principal
        JPanel painel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Adicionar logomarca
        ImageIcon logoIcon = new ImageIcon("urbanTrends/imagens/logo_ut.png");
        JLabel labelLogo = new JLabel(logoIcon);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        painel.add(labelLogo, gbc);

        // Campos de cadastro
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 1;
        painel.add(new JLabel("Nome:"), gbc);

        campoNome = new JTextField(20); // Ajuste o tamanho conforme necessário
        gbc.gridx = 1;
        painel.add(campoNome, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        painel.add(new JLabel("CPF:"), gbc);

        try {
            MaskFormatter mascaraCpf = new MaskFormatter("###.###.###-##");
            campoCpf = new JFormattedTextField(mascaraCpf);
        } catch (Exception e) {
            campoCpf = new JFormattedTextField();
        }
        campoCpf.setColumns(20); // Define o tamanho do campo
        gbc.gridx = 1;
        painel.add(campoCpf, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        painel.add(new JLabel("Endereço:"), gbc);

        campoEndereco = new JTextField(20); // Ajuste o tamanho conforme necessário
        gbc.gridx = 1;
        painel.add(campoEndereco, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        painel.add(new JLabel("Email:"), gbc);

        campoEmail = new JTextField(20); // Ajuste o tamanho conforme necessário
        gbc.gridx = 1;
        painel.add(campoEmail, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        painel.add(new JLabel("Senha:"), gbc);

        campoSenha = new JPasswordField(20); // Ajuste o tamanho conforme necessário
        gbc.gridx = 1;
        painel.add(campoSenha, gbc);

        // Botões
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Cliente novoCliente = new Cliente(campoNome.getText(), campoCpf.getText(), campoEndereco.getText(), campoEmail.getText());
                salvarCliente(novoCliente, "urbanTrends/data/usuarios.txt");
                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso.");
                new TelaLogin(new Carrinho(), new Estoque());
                dispose();
            }
        });
        painelBotoes.add(botaoCadastrar);

        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TelaLogin(new Carrinho(), new Estoque());
                dispose();
            }
        });
        painelBotoes.add(botaoVoltar);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        painel.add(painelBotoes, gbc);

        add(painel);
        setVisible(true);
    }

    private void salvarCliente(Cliente cliente, String caminhoArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo, true))) {
            writer.write(cliente.getNome() + "," + cliente.getCpf() + "," + cliente.getEndereco() + "," + cliente.getEmail() + "," + campoSenha.getText() + "\n");
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Iniciar a tela de cadastro
        new TelaCadastro();
    }
}



