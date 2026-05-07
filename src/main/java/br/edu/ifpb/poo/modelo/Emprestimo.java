package br.edu.ifpb.poo.modelo;

import java.time.LocalDate;

public class Emprestimo {
    private int id;
    private Usuario usuario;
    private ItemAcervo item;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista;
    private LocalDate dataDevolucaoReal;
    private double valorMulta;

    public Emprestimo(int id, Usuario usuario, ItemAcervo item, LocalDate dataEmprestimo, LocalDate dataDevolucaoPrevista) {
        this.id = id;
        this.usuario = usuario;
        this.item = item;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
        this.valorMulta = 0.0;
    }

    public int getId() { return id; }
    public Usuario getUsuario() { return usuario; }
    public ItemAcervo getItem() { return item; }
    public LocalDate getDataEmprestimo() { return dataEmprestimo; }
    public LocalDate getDataDevolucaoPrevista() { return dataDevolucaoPrevista; }
    
    public LocalDate getDataDevolucaoReal() { return dataDevolucaoReal; }
    public void setDataDevolucaoReal(LocalDate dataDevolucaoReal) { this.dataDevolucaoReal = dataDevolucaoReal; }

    public double getValorMulta() { return valorMulta; }
    public void setValorMulta(double valorMulta) { this.valorMulta = valorMulta; }

    
    @Override
    public String toString() {
        return String.format("ID: %d | Item: %s | Usuário: %s | Devolução: %s | Multa: R$ %.2f", 
                id, item.getTitulo(), usuario.getNome(), 
                (dataDevolucaoReal != null ? dataDevolucaoReal : "Pendente"), valorMulta);
    }
}