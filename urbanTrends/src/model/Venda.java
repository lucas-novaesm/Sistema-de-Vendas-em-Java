package model;

import java.util.List;

public class Venda {
    private Cliente cliente;
    private List<ItemVenda> itens;
    private double total;

    public Venda(Cliente cliente, List<ItemVenda> itens) {
        this.cliente = cliente;
        this.itens = itens;
        this.total = calcularTotal();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }

    public double getTotal() {
        return total;
    }

    private double calcularTotal() {
        double total = 0;
        for (ItemVenda item : itens) {
            total += item.getSubtotal();
        }
        return total;
    }
}

