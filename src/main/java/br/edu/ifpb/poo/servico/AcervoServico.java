package br.edu.ifpb.poo.servico;

import br.edu.ifpb.poo.modelo.*;
import java.util.ArrayList;
import java.util.List;

public class AcervoServico {
    
    private List<ItemAcervo> itens = new ArrayList<>();
    private List<Editora> editoras = new ArrayList<>();

    public void cadastrarEditora(int id, String nome, String cnpj) {
        editoras.add(new Editora(id, nome, cnpj));
    }

    public void cadastrarLivroFisico(int id, String autor, String titulo, int ano, String isbn, int idEditora, int paginas) {
        Editora ed = buscarEditoraPorId(idEditora);
        if (ed != null) {
            itens.add(new LivroFisico(id, autor, titulo, ano, isbn, ed, paginas));
        }
    }

    public void cadastrarAudioLivro(int id, String autor, String titulo, int ano, String isbn, int idEditora, int duracao) {
        Editora ed = buscarEditoraPorId(idEditora);
        if (ed != null) {
            itens.add(new AudioLivro(id, autor, titulo, ano, isbn, ed, duracao));
        }
    }

    public void cadastrarRevista(int id, String autor, String titulo, int ano, String issn, int vol, int num, int paginas, int idEditora, String data) {
        Editora ed = buscarEditoraPorId(idEditora);
        if (ed != null) {
            itens.add(new Revista(id, autor, titulo, ano, issn, vol, num, paginas, ed, data));
        } else {
            System.out.println("Erro: Editora não encontrada!");
        }
    }

    public void cadastrarCd(int id, String artista, String titulo, int ano, List<String> faixas) {
        itens.add(new Cd(id, artista, titulo, ano, faixas));
    }

    public boolean removerItem(int id) {
        ItemAcervo item = buscarItemPorId(id);
        if (item != null && item.getStatus().equals("DISPONÍVEL")) {
            return itens.remove(item);
        }
        return false;
    }

    public List<Editora> getEditoras() { return editoras;}


    public Editora buscarEditoraPorId(int id) {
        for (Editora e : editoras) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    public ItemAcervo buscarItemPorId(int id) {
        return itens.stream()
                .filter(i -> i.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<ItemAcervo> getItens() {
        return new ArrayList<>(itens);
    }
}