package br.edu.ifpb.poo.modelo;

public class JogoTabuleiro {
    private int id;
    private String nome;
    private String tipo; // "CARTA" ou "TABULEIRO"
    private int quantidadePecas;
    private double preco;
    private String status; // "DISPONÍVEL", "EMPRESTADO" ou "VENDIDO"

    public JogoTabuleiro(int id, String nome, String tipo, int quantidadePecas, double preco) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.quantidadePecas = quantidadePecas;
        this.preco = preco;
        this.status = "DISPONÍVEL";
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public int getQuantidadePecas() { return quantidadePecas;}
    public void setQuantidadePecas(int quantidadePecas) {this.quantidadePecas = quantidadePecas; }

}
