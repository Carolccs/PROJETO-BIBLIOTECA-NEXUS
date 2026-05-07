package br.edu.ifpb.poo.modelo;

public class Livro extends ItemAcervo {
    private String isbn;
    private String autores;
    private String editora;
    private int edicao;
    private String genero;
    private int numPaginas;
    private String sinopse;
    
    public Livro(int id, String titulo, int anoPublicacao, String isbn, String autores, String editora, int edicao,
            String genero, int numPaginas, String sinopse) {
        super(id, titulo, anoPublicacao);
        this.isbn = isbn;
        this.autores = autores;
        this.editora = editora;
        this.edicao = edicao;
        this.genero = genero;
        this.numPaginas = numPaginas;
        this.sinopse = sinopse;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getIsbn() {
        return isbn;
    }
    public String getAutores() {
        return autores;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void setAutores(String autor) {
        this.autores = autor;
    }
    public String getEditora() {
        return editora;
    }
    public int getEdicao() {
        return edicao;
    }
    public String getGenero() {
        return genero;
    }
    public int getNumPaginas() {
        return numPaginas;
    }
    public String getSinopse() {
        return sinopse;
    }
    
}
