package br.edu.ifpb.poo.modelo;

public class Revista extends ItemAcervo {
    private String issn;
    private int volume;
    private int numero;
    private int numeroPaginas;
    private Editora editora; 
    private String dataPublicacao;

    public Revista(int id, String autor, String titulo, int anoPublicacao, String issn, 
                   int volume, int numero, int numeroPaginas, Editora editora, String dataPublicacao) {
        super(id, autor, titulo, anoPublicacao);
        this.issn = issn;
        this.volume = volume;
        this.numero = numero;
        this.numeroPaginas = numeroPaginas;
        this.editora = editora;
        this.dataPublicacao = dataPublicacao;
    }

    public String getIssn() { return issn; }
    public void setIssn(String issn) { this.issn = issn; }

    public int getVolume() { return volume; }
    public void setVolume(int volume) { this.volume = volume; }

    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

    public int getNumeroPaginas() { return numeroPaginas; }
    public void setNumeroPaginas(int numeroPaginas) { this.numeroPaginas = numeroPaginas; }

    public Editora getEditora() { return editora; }
    public void setEditora(Editora editora) { this.editora = editora; }

    public String getDataPublicacao() { return dataPublicacao; }
    public void setDataPublicacao(String dataPublicacao) { this.dataPublicacao = dataPublicacao; }
}