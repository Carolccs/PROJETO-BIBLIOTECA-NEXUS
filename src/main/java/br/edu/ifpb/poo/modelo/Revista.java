package br.edu.ifpb.poo.modelo;

public class Revista extends ItemAcervo {
    private String issn;
    private int volume;
    private int numero;
    private String editora;
    private String dataPublicacao;

    public Revista(int id, String titulo, int anoPublicacao, String issn, int volume, int numero, String editora,
            String dataPublicacao) {
        super(id, titulo, anoPublicacao);
        this.issn = issn;
        this.volume = volume;
        this.numero = numero;
        this.editora = editora;
        this.dataPublicacao = dataPublicacao;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public void setDataPublicacao(String dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public String getIssn() {
        return issn;
    }

    public int getVolume() {
        return volume;
    }

    public int getNumero() {
        return numero;
    }

    public String getEditora() {
        return editora;
    }

    public String getDataPublicacao() {
        return dataPublicacao;
    }

   
}
