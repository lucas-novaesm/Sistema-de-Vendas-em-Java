package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Produto {
    private int id;
    private String nome;
    private double preco;
    private String caminhoImagem;  // Novo atributo

    public Produto(int id, String nome, double preco, String caminhoImagem) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.caminhoImagem = caminhoImagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }

    public static void salvarProdutos(List<Produto> produtos, String caminhoArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            for (Produto produto : produtos) {
                writer.write(produto.getId() + "," + produto.getNome() + "," + produto.getPreco() + "," + produto.getCaminhoImagem());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Produto> carregarProdutos(String caminhoArquivo) {
        List<Produto> produtos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length == 4) {
                    produtos.add(new Produto(Integer.parseInt(dados[0]), dados[1], Double.parseDouble(dados[2]), dados[3]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return produtos;
    }
}
