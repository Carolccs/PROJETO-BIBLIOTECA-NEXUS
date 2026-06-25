package br.edu.ifpb.poo.modelo;

public class AudioLivro extends Livro {
    private int duracaoMinutos;

    public AudioLivro(int id, String autor, String titulo, int anoPublicacao, String isbn, Editora editora, int duracaoMinutos) {
        super(id, autor, titulo, anoPublicacao, isbn, editora);
        this.duracaoMinutos = duracaoMinutos;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }
}