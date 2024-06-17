import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TelaPrincipal extends JFrame {
    private JButton botaoVerCarrinho;
    private JButton botaoLogout;
    private Carrinho carrinho;
    private Estoque estoque;

    public TelaPrincipal(Carrinho carrinho, Estoque estoque) {
        this.carrinho = carrinho;
        this.estoque = estoque;

        setTitle("Vitrine de Produtos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 590);
        setLocationRelativeTo(null);

        JPanel painelPrincipal = new JPanel(new BorderLayout());

        // Adicionando produtos ao estoque
        estoque.adicionarProduto(new Produto(1, "CAMISA", 75.0, "Trabalho-final-de-LP-POO/urbanTrends/imagens/camisa.png"), 10);
        estoque.adicionarProduto(new Produto(2, "MOLETOM", 90.0, "Trabalho-final-de-LP-POO/urbanTrends/imagens/moletom.png"), 10);
        estoque.adicionarProduto(new Produto(3, "CAMISA POLO", 70.0, "Trabalho-final-de-LP-POO/urbanTrends/imagens/camisa_social.png"), 10);
        estoque.adicionarProduto(new Produto(4, "CALÇA MOLETOM", 95.0, "Trabalho-final-de-LP-POO/urbanTrends/imagens/calca_moletom.png"), 10);
        estoque.adicionarProduto(new Produto(5, "CALÇA JEANS", 110.0, "Trabalho-final-de-LP-POO/urbanTrends/imagens/calca_jeans.png"), 10);
        estoque.adicionarProduto(new Produto(6, "BERMUDA", 60.0, "Trabalho-final-de-LP-POO/urbanTrends/imagens/bermuda.png"), 10);

        JPanel painelProdutos = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Adicionando itens de produto do estoque
        for (Produto produto : estoque.getProdutos().keySet()) {
            JPanel painelProduto = new JPanel();
            painelProduto.setLayout(new BoxLayout(painelProduto, BoxLayout.Y_AXIS));

            // Adicionando imagem do produto
            ImageIcon icon = new ImageIcon(produto.getCaminhoImagem());
            Image image = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            JLabel labelImagem = new JLabel(new ImageIcon(image));
            labelImagem.setAlignmentX(Component.CENTER_ALIGNMENT);
            painelProduto.add(labelImagem);

            // Adicionando nome e preço do produto
            JLabel labelNomePreco = new JLabel(produto.getNome() + " - R$" + produto.getPreco());
            labelNomePreco.setAlignmentX(Component.CENTER_ALIGNMENT);
            painelProduto.add(labelNomePreco);

            // Adicionando JComboBox para selecionar o tamanho
            String[] tamanhos = {"PP", "P", "M", "G", "GG"};
            JComboBox<String> comboBoxTamanhos = new JComboBox<>(tamanhos);
            comboBoxTamanhos.setAlignmentX(Component.CENTER_ALIGNMENT);
            painelProduto.add(comboBoxTamanhos);

            // Botão de adicionar ao carrinho
            JButton botaoAdicionarCarrinho = new JButton("Adicionar ao carrinho");
            botaoAdicionarCarrinho.setAlignmentX(Component.CENTER_ALIGNMENT);
            botaoAdicionarCarrinho.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String tamanhoSelecionado = (String) comboBoxTamanhos.getSelectedItem();
                    carrinho.adicionarItem(produto, 1);
                    JOptionPane.showMessageDialog(null, produto.getNome() + " (Tamanho: " + tamanhoSelecionado + ") adicionado ao carrinho.");
                }
            });
            painelProduto.add(botaoAdicionarCarrinho);

            // Adicionando o painel do produto ao painel de produtos
            painelProdutos.add(painelProduto, gbc);
            gbc.gridx++;
            if (gbc.gridx > 2) {
                gbc.gridx = 0;
                gbc.gridy++;
            }
        }

        // Botões na parte inferior da janela
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER));
        botaoVerCarrinho = new JButton("Ver Carrinho");
        botaoVerCarrinho.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TelaCarrinho(carrinho);
                dispose();
            }
        });

        botaoLogout = new JButton("Logout");
        botaoLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Logout realizado com sucesso.");
                // new TelaLogin(carrinho, estoque); // Você precisará substituir pela tela de login adequada
                dispose();
            }
        });

        painelBotoes.add(botaoVerCarrinho);
        painelBotoes.add(botaoLogout);

        // Adicionando os componentes ao painel principal
        painelPrincipal.add(painelProdutos, BorderLayout.CENTER);
        painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);

        // Adicionando o painel principal à janela
        add(painelPrincipal);
        setVisible(true);
    }

    public static void main(String[] args) {
        Carrinho carrinho = new Carrinho();
        Estoque estoque = new Estoque();
        new TelaPrincipal(carrinho, estoque);
    }
}













