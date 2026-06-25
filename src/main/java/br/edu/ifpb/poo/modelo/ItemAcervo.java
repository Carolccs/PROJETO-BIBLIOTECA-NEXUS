package br.edu.ifpb.poo.modelo;

public abstract class ItemAcervo {
    private int id;
    private String autor;
    private String titulo;
    private String status;
    private int anoPublicacao;

    public ItemAcervo(int id, String autor, String titulo, int anoPublicacao) {
        this.id = id;
        this.autor = autor;
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
        this.status = "DISPONÍVEL";
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public int getAnoPublicacao() { return anoPublicacao; }
    public void setAnoPublicacao(int anoPublicacao) { this.anoPublicacao = anoPublicacao; }
}
