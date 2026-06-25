package br.edu.ifpb.poo.servico;

import br.edu.ifpb.poo.modelo.*;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaServico {

    

    public BibliotecaServico() {
        this.acervoServico = new AcervoServico();
    }
    
    private AcervoServico acervoServico = new AcervoServico();
    private UsuarioServico usuarioServico = new UsuarioServico();
    private EmprestimoServico emprestimoServico = new EmprestimoServico();
    private VendaServico vendaServico = new VendaServico();

    public void cadastrarEditora(int id, String nome, String cnpj) {
        acervoServico.cadastrarEditora(id, nome, cnpj);
    }

    public void cadastrarLivroFisico(int id, String autor, String titulo, int ano, String isbn, int idEditora, int paginas) {
        acervoServico.cadastrarLivroFisico(id, autor, titulo, ano, isbn, idEditora, paginas);
    }

    public void cadastrarAudioLivro(int id, String autor, String titulo, int ano, String isbn, int idEditora, int duracao) {
        acervoServico.cadastrarAudioLivro(id, autor, titulo, ano, isbn, idEditora, duracao);
    }

    public List<Editora> getEditoras() {
        return acervoServico.getEditoras();
    }
    public void cadastrarRevista(int id, String autor, String titulo, int ano, String issn, int vol, int num, int paginas, int idEditora, String data) {
        acervoServico.cadastrarRevista(id, autor, titulo, ano, issn, vol, num, paginas, idEditora, data);
    }

    public void cadastrarCd(int id, String artista, String titulo, int ano, List<String> faixas) {
        acervoServico.cadastrarCd(id, artista, titulo, ano, faixas);
    }

    public boolean removerItem(int id) {
        return acervoServico.removerItem(id);
    }
    public void cadastrarUsuario(Usuario u) {
        usuarioServico.cadastrarUsuario(u);
    }

    public Usuario buscarUsuarioPorId(int id) {
        return usuarioServico.buscarUsuarioPorId(id);
    }

    public boolean realizarEmprestimo(int idUsuario, int idItem) {
        Usuario u = usuarioServico.buscarUsuarioPorId(idUsuario);
        
        Object item = acervoServico.buscarItemPorId(idItem);
        if (item == null) {
            item = vendaServico.buscarJogoPorId(idItem);
        }

        return emprestimoServico.realizarEmprestimo(u, item);
    }

    public double registrarDevolucao(int idItem) {
        Object item = acervoServico.buscarItemPorId(idItem);
        if (item == null) {
            item = vendaServico.buscarJogoPorId(idItem);
        }
        return emprestimoServico.registrarDevolucao(item);
    }

    public List<Emprestimo> getHistoricoEmprestimos() {
        return emprestimoServico.getHistoricoCompleto();
    }

    public void cadastrarJogo(int id, String nome, String tipo, int pecas, double preco) {
        vendaServico.cadastrarJogo(id, nome, tipo, pecas, preco);
    }

    public boolean venderJogo(int idJogo) {
        return vendaServico.realizarVenda(idJogo);
    }

    public List<Venda> listarVendas() {
        return vendaServico.listarVendas();
    }

    public List<ItemAcervo> getAcervo() {
        return acervoServico.getItens();
    }

    public List<JogoTabuleiro> getJogos() {
        return vendaServico.getJogos();
    }
    
    public Editora buscarEditoraPorId(int id) {
        return acervoServico.buscarEditoraPorId(id);
    }


    public void popularDadosSistema() {

        cadastrarEditora(1, "Novatec", "11111111111111");
        cadastrarEditora(2, "Alta Books", "22222222222222");

        cadastrarLivroFisico(
                101,
                "Deitel",
                "Java Como Programar",
                2023,
                "9788576052450",
                1,
                1200
        );

        cadastrarAudioLivro(
                102,
                "Sommerville",
                "Engenharia de Software",
                2022,
                "9788543024978",
                2,
                720
        );

        cadastrarRevista(
                201,
                "Equipe Tech",
                "Mundo Java",
                2025,
                "1234-5678",
                10,
                5,
                80,
                1,
                "01/06/2025"
        );

        List<String> faixas = new ArrayList<>();
        faixas.add("Faixa 1");
        faixas.add("Faixa 2");
        faixas.add("Faixa 3");

        cadastrarCd(
                301,
                "Queen",
                "Greatest Hits",
                1981,
                faixas
        );

        
        cadastrarJogo(
                401,
                "Banco Imobiliário",
                "Tabuleiro",
                150,
                129.90
        );
    }
}