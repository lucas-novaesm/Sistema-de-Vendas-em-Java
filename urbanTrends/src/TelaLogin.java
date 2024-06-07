import model.Carrinho;
import model.Estoque;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TelaLogin extends JFrame {
    private JTextField campoEmail;
    private JPasswordField campoSenha;
    private Carrinho carrinho;
    private Estoque estoque;

    public TelaLogin(Carrinho carrinho, Estoque estoque) {
        this.carrinho = carrinho;
        this.estoque = estoque;

        setTitle("Urban Trends");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);

        // Painel principal com GridBagLayout
        JPanel painel = new JPanel(new GridBagLayout());
        painel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Adicionar a imagem da logo da loja
        ImageIcon logoIcon = new ImageIcon("urbanTrends/imagens/logo_ut.png");
        Image logoImage = logoIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        JLabel labelLogo = new JLabel(new ImageIcon(logoImage));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        painel.add(labelLogo, gbc);

        // Campos de entrada para e-mail
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        painel.add(new JLabel("E-mail:"), gbc);

        campoEmail = new JTextField(20);  // Aumenta o tamanho do campo de digitação
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painel.add(campoEmail, gbc);

        // Campo de entrada para senha
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        painel.add(new JLabel("Senha:"), gbc);

        campoSenha = new JPasswordField(20);  // Aumenta o tamanho do campo de digitação
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painel.add(campoSenha, gbc);

        // Botão de login
        JButton botaoLogin = new JButton("Entrar");
        botaoLogin.setPreferredSize(new Dimension(100, 25));
        botaoLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usuario = campoEmail.getText().trim();
                String senha = new String(campoSenha.getPassword()).trim();
                if (!usuario.isEmpty() && !senha.isEmpty()) {
                    if (validarLogin(usuario, senha)) {
                        new TelaPrincipal(carrinho, estoque);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "E-mail ou senha inválidos.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
                }
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        painel.add(botaoLogin, gbc);

        // Botão de cadastro
        JButton botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.setPreferredSize(new Dimension(100, 25));
        botaoCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TelaCadastro();
                dispose();
            }
        });
        gbc.gridy = 4;
        painel.add(botaoCadastrar, gbc);

        add(painel, BorderLayout.CENTER);
        setVisible(true);
    }

    private boolean validarLogin(String usuario, String senha) {
        try (BufferedReader br = new BufferedReader(new FileReader("urbanTrends/data/usuarios.txt"))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length >= 5 && dados[3].equals(usuario) && dados[4].equals(senha)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        // Inicializar carrinho e estoque
        Carrinho carrinho = new Carrinho();
        Estoque estoque = new Estoque();

        // Iniciar a tela de login
        new TelaLogin(carrinho, estoque);
    }
}



