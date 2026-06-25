package br.edu.ifpb.poo.modelo;

public abstract class Livro extends ItemAcervo {
    private String isbn;
    private Editora editora;

    public Livro(int id, String autor, String titulo, int anoPublicacao, String isbn, Editora editora) {
        super(id, autor, titulo, anoPublicacao);
        this.isbn = isbn;
        this.editora = editora;
    }
    
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

}