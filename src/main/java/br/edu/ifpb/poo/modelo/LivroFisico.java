package br.edu.ifpb.poo.modelo;

public class LivroFisico extends Livro {
    private int numeroPaginas;

    public LivroFisico(int id, String autor, String titulo, int anoPublicacao, String isbn, Editora editora, int numeroPaginas) {
        super(id, autor, titulo, anoPublicacao, isbn, editora);
        this.numeroPaginas = numeroPaginas;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }
}