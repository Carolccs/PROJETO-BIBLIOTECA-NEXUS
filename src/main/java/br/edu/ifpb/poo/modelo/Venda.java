package br.edu.ifpb.poo.modelo;

public class Venda {
    private JogoTabuleiro jogo;
    private double valorVenda;

    public Venda(JogoTabuleiro jogo, double valorVenda) {
        this.jogo = jogo;
        this.valorVenda = valorVenda;
    }

    public JogoTabuleiro getJogo() {
        return jogo;
    }

    public void setJogo(JogoTabuleiro jogo) {
        this.jogo = jogo;
    }

    public double getValorVenda() { return valorVenda;}

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public int getIdJogo() { return jogo.getId();}

    public String getTituloJogo() { return jogo.getNome(); }
}