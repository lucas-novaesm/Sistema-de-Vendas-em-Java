import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.List;
import model.Carrinho;
import model.Estoque;
import model.ItemVenda;
import model.Produto;

public class TelaCarrinho extends JFrame {
    private Carrinho carrinho;

    public TelaCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;

        setTitle("Carrinho de Compras");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel painelPrincipal = new JPanel(new BorderLayout());

        JPanel painelItens = new JPanel(new GridLayout(0, 1));

        List<ItemVenda> itens = carrinho.getItens();

        if (itens.isEmpty()) {
            JLabel labelVazio = new JLabel("O carrinho está vazio.");
            labelVazio.setHorizontalAlignment(SwingConstants.CENTER);
            painelItens.add(labelVazio);
        } else {
            for (ItemVenda item : itens) {
                JPanel painelItem = new JPanel(new FlowLayout(FlowLayout.LEFT));

                Produto produto = item.getProduto();

                // Adicionando imagem do produto
                ImageIcon icon = new ImageIcon(produto.getCaminhoImagem());
                Image image = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                JLabel labelImagem = new JLabel(new ImageIcon(image));
                painelItem.add(labelImagem);

                // Adicionando informações do produto
                JLabel labelNome = new JLabel(produto.getNome());
                JLabel labelPreco = new JLabel("R$" + produto.getPreco());
                JLabel labelQuantidade = new JLabel("Quantidade: " + item.getQuantidade());
                JLabel labelSubtotal = new JLabel("Subtotal: R$" + item.getSubtotal());

                painelItem.add(labelNome);
                painelItem.add(labelPreco);
                painelItem.add(labelQuantidade);
                painelItem.add(labelSubtotal);

                painelItens.add(painelItem);
            }
        }

        JPanel painelTotal = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        DecimalFormat df = new DecimalFormat("#.00");
        JLabel labelTotal = new JLabel("Total: R$" + df.format(carrinho.calcularTotal()));

        JButton botaoEsvaziar = new JButton("Esvaziar Carrinho");
        botaoEsvaziar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                carrinho.esvaziarCarrinho();
                dispose();
                JOptionPane.showMessageDialog(null, "Carrinho esvaziado.");
            }
        });

        JButton botaoPagamento = new JButton("Ir para Pagamento");
        botaoPagamento.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TelaPagamento(carrinho);
                dispose();
            }
        });

        JButton botaoVoltar = new JButton("Voltar para Vitrine");
        botaoVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TelaPrincipal(carrinho, new Estoque());
                dispose();
            }
        });

        painelTotal.add(labelTotal);
        painelTotal.add(botaoEsvaziar);
        painelTotal.add(botaoPagamento);
        painelTotal.add(botaoVoltar);

        painelPrincipal.add(new JScrollPane(painelItens), BorderLayout.CENTER); // Adicionando JScrollPane
        painelPrincipal.add(painelTotal, BorderLayout.SOUTH);

        add(painelPrincipal);
        setVisible(true);
    }
}

