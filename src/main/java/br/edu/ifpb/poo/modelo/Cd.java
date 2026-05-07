package br.edu.ifpb.poo.modelo;

import java.util.List;

public class Cd extends ItemAcervo {
    private String artista;
    private List<String> listaFaixas;

    public Cd(int id, String titulo, int anoPublicacao, String artista, List<String> faixas) {
        super(id, titulo, anoPublicacao);
        this.artista = artista;
        this.listaFaixas = faixas;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public List<String> getListaFaixas() {
        return listaFaixas;
    }

    public void setListaFaixas(List<String> listaFaixas) {
        this.listaFaixas = listaFaixas;
    }
}
