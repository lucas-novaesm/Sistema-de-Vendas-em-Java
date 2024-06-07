package model;

public class Pagamento extends FormaPagamento {
    private String numeroCartao;
    private String validade;
    private String cvv;

    public Pagamento(String numeroCartao, String validade, String cvv) {
        this.numeroCartao = numeroCartao;
        this.validade = validade;
        this.cvv = cvv;
    }

    @Override
    public String realizarPagamento(double valor) {
        // Implementação fictícia do pagamento
        return "Pagamento de R$" + valor + " realizado com sucesso!";
    }
}

