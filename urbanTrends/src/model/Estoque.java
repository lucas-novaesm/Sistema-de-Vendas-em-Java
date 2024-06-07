package model;

import java.util.HashMap;
import java.util.Map;

public class Estoque {
    private Map<Produto, Integer> produtos;

    public Estoque() {
        this.produtos = new HashMap<>();
    }

    public void adicionarProduto(Produto produto, int quantidade) {
        if (produtos.containsKey(produto)) {
            produtos.put(produto, produtos.get(produto) + quantidade);
        } else {
            produtos.put(produto, quantidade);
        }
    }

    public void removerProduto(Produto produto, int quantidade) {
        if (produtos.containsKey(produto)) {
            int quantidadeAtual = produtos.get(produto);
            if (quantidadeAtual <= quantidade) {
                produtos.remove(produto);
            } else {
                produtos.put(produto, quantidadeAtual - quantidade);
            }
        }
    }

    public int consultarEstoque(Produto produto) {
        return produtos.getOrDefault(produto, 0);
    }

    public Map<Produto, Integer> getProdutos() {
        return produtos;
    }
}

