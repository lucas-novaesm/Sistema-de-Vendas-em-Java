package model;

public class Vendedor extends Pessoa {
    private double salario;

    public Vendedor(String nome, String cpf, String endereco, double salario) {
        super(nome, cpf, endereco);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String getTipo() {
        return "Vendedor";
    }
}

