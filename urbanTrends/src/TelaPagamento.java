import javax.swing.*;
import javax.swing.text.MaskFormatter;
import model.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class TelaPagamento extends JFrame {
    private Carrinho carrinho;

    public TelaPagamento(Carrinho carrinho) {
        this.carrinho = carrinho;

        setTitle("Pagamento");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);
        setResizable(false);

        // Painel principal
        JPanel painel = new JPanel(new GridBagLayout());
        painel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Adicionar logomarca
        ImageIcon logoIcon = new ImageIcon("Trabalho-final-de-LP-POO/imagens/logo_ut.png");
        JLabel labelLogo = new JLabel(logoIcon);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        painel.add(labelLogo, gbc);

        // Título
        JLabel labelTitulo = new JLabel("Informações de Pagamento", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridy = 1;
        painel.add(labelTitulo, gbc);

        // Número do cartão
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        painel.add(new JLabel("Número do Cartão:"), gbc);

        JFormattedTextField campoNumeroCartao = null;
        try {
            MaskFormatter mascaraCartao = new MaskFormatter("#### #### #### ####");
            mascaraCartao.setPlaceholderCharacter(' ');
            campoNumeroCartao = new JFormattedTextField(mascaraCartao);
            campoNumeroCartao.setColumns(16); // Define o tamanho do campo
        } catch (ParseException e) {
            e.printStackTrace();
        }
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painel.add(campoNumeroCartao, gbc);

        // Validade
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE;
        painel.add(new JLabel("Validade (MM/AA):"), gbc);

        JFormattedTextField campoValidade = null;
        try {
            MaskFormatter mascaraValidade = new MaskFormatter("##/##");
            mascaraValidade.setPlaceholderCharacter(' ');
            campoValidade = new JFormattedTextField(mascaraValidade);
            campoValidade.setColumns(5); // Define o tamanho do campo
        } catch (ParseException e) {
            e.printStackTrace();
        }
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painel.add(campoValidade, gbc);

        // CVV
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.NONE;
        painel.add(new JLabel("CVV:"), gbc);

        JFormattedTextField campoCVV = null;
        try {
            MaskFormatter mascaraCVV = new MaskFormatter("###");
            mascaraCVV.setPlaceholderCharacter(' ');
            campoCVV = new JFormattedTextField(mascaraCVV);
            campoCVV.setColumns(3); // Define o tamanho do campo
        } catch (ParseException e) {
            e.printStackTrace();
        }
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        painel.add(campoCVV, gbc);

        // Opções de pagamento: Crédito ou Débito
        JPanel painelOpcoesPagamento = new JPanel(new GridLayout(1, 0));
        painelOpcoesPagamento.setBorder(BorderFactory.createTitledBorder("Opções de Pagamento"));

        JRadioButton radioCredito = new JRadioButton("Crédito");
        JRadioButton radioDebito = new JRadioButton("Débito");

        ButtonGroup grupoPagamento = new ButtonGroup();
        grupoPagamento.add(radioCredito);
        grupoPagamento.add(radioDebito);

        painelOpcoesPagamento.add(radioCredito);
        painelOpcoesPagamento.add(radioDebito);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        painel.add(painelOpcoesPagamento, gbc);

        // Botão de pagar
        JButton botaoPagar = new JButton("Pagar");
        botaoPagar.setPreferredSize(new Dimension(100, 30));
        JFormattedTextField finalCampoNumeroCartao = campoNumeroCartao;
        botaoPagar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (radioCredito.isSelected()) {
                    // Lógica para pagamento com cartão de crédito
                    Pagamento pagamento = new Pagamento(finalCampoNumeroCartao.getText().replace(" ", ""), "", "");
                    JOptionPane.showMessageDialog(null, "Pagamento com cartão de crédito realizado.");
                } else if (radioDebito.isSelected()) {
                    // Lógica para pagamento com cartão de débito
                    JOptionPane.showMessageDialog(null, "Pagamento com cartão de débito realizado.");
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione uma forma de pagamento.");
                }
                carrinho.esvaziarCarrinho();
                new TelaPrincipal(carrinho, new Estoque());
                dispose();
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        painel.add(botaoPagar, gbc);

        add(painel);
        setVisible(true);
    }

    public static void main(String[] args) {
        // Inicializar carrinho
        Carrinho carrinho = new Carrinho();
        // Iniciar a tela de pagamento
        new TelaPagamento(carrinho);
    }
}




