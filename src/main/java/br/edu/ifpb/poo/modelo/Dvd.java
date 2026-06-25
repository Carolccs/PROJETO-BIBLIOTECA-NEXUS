package br.edu.ifpb.poo.modelo;

public class Dvd extends ItemAcervo {
    private String diretor;
    private int duracao; // em minutos
    private String classificacaoIndicativa;

    public Dvd(int id, String diretor, String titulo, int anoPublicacao,  int duracao, String classificacao) {
        super(id, diretor, titulo, anoPublicacao);
        this.diretor = diretor;
        this.duracao = duracao;
        this.classificacaoIndicativa = classificacao;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getClassificacaoIndicativa() {
        return classificacaoIndicativa;
    }

    public void setClassificacaoIndicativa(String classificacaoIndicativa) {
        this.classificacaoIndicativa = classificacaoIndicativa;
    }

}
