package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {
    private String email;

    public Cliente(String nome, String cpf, String endereco, String email) {
        super(nome, cpf, endereco);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getTipo() {
        return "Cliente";
    }

    public static void salvarClientes(List<Cliente> clientes, String caminhoArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            for (Cliente cliente : clientes) {
                writer.write(cliente.getNome() + "," + cliente.getCpf() + "," + cliente.getEndereco() + "," + cliente.getEmail());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Cliente> carregarClientes(String caminhoArquivo) {
        List<Cliente> clientes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length == 4) {
                    clientes.add(new Cliente(dados[0], dados[1], dados[2], dados[3]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return clientes;
    }
}


