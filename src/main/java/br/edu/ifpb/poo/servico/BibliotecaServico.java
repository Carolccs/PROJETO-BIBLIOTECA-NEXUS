package br.edu.ifpb.poo.servico;

import br.edu.ifpb.poo.modelo.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BibliotecaServico {
    private List<ItemAcervo> acervo = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();
    private int proximoIdEmprestimo = 1;
    public List<ItemAcervo> getAcervo() {
        return new ArrayList<>(this.acervo); }

    public void cadastrarItem(ItemAcervo item) { acervo.add(item); }
    public void cadastrarUsuario(Usuario usuario) { usuarios.add(usuario); }

    public String realizarEmprestimo(Usuario usuario, ItemAcervo item) {
        if (temAtraso(usuario)) return "Erro: Usuário possui empréstimos em atraso.";
        if (usuario.isMultaPendente()) return "Erro: Usuário possui multa pendente.";
        if (!item.getStatus().equals("DISPONÍVEL")) return "Erro: Item não está disponível.";
        if (contarAtivos(usuario) >= usuario.getLimiteEmprestimos()) return "Erro: Limite de itens excedido.";

        LocalDate hoje = LocalDate.now();
        LocalDate prevista = hoje.plusDays(usuario.getPrazoEmprestimo(item));
        
        Emprestimo e = new Emprestimo(proximoIdEmprestimo++, usuario, item, hoje, prevista);
        emprestimos.add(e);
        
        item.setStatus("EMPRESTADO");

        return "Empréstimo realizado com sucesso para " + usuario.getNome() + 
               ". Devolução prevista: " + prevista;
    }

    public String registrarDevolucao(Emprestimo e) {
        LocalDate hoje = LocalDate.now();
        e.setDataDevolucaoReal(hoje);
        e.getItem().setStatus("DISPONÍVEL");

        if (hoje.isAfter(e.getDataDevolucaoPrevista())) {
            long dias = ChronoUnit.DAYS.between(e.getDataDevolucaoPrevista(), hoje);
            double valorMulta = dias * e.getUsuario().getValorMultaDiaria();
            
            e.setValorMulta(valorMulta);
            e.getUsuario().setMultaPendente(true);
            
            return "Devolução com ATRASO de " + dias + " dias. Multa: R$ " + valorMulta;
        }
        return "Devolução realizada com sucesso.";
    }

    public List<ItemAcervo> buscarItens(String termo) {
        String busca = termo.toLowerCase();
        return acervo.stream()
            .filter(i -> i.getTitulo().toLowerCase().contains(busca) || 
                        String.valueOf(i.getId()).equals(busca) ||
                        (i instanceof Livro && (((Livro) i).getAutores().toLowerCase().contains(busca) || 
                                               ((Livro) i).getIsbn().contains(busca))) ||
                        (i instanceof Revista && ((Revista) i).getIssn().contains(busca)))
            .collect(Collectors.toList());
    }

    public List<Usuario> buscarUsuarios(String termo) {
        String busca = termo.toLowerCase();
        return usuarios.stream()
            .filter(u -> u.getNome().toLowerCase().contains(busca) || String.valueOf(u.getId()).equals(busca))
            .collect(Collectors.toList());
    }

    public Usuario buscarUsuarioPorId(int id) {
        return usuarios.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
    }

    public List<Emprestimo> filtrarEmprestimos(String filtro, String parametro) {
        LocalDate hoje = LocalDate.now();
        switch (filtro) {
            case "EM_ABERTO": 
                return emprestimos.stream().filter(e -> e.getDataDevolucaoReal() == null).collect(Collectors.toList());
            case "EM_ATRASO": 
                return emprestimos.stream().filter(e -> e.getDataDevolucaoReal() == null && hoje.isAfter(e.getDataDevolucaoPrevista())).collect(Collectors.toList());
            case "HISTORICO_USUARIO": 
                return emprestimos.stream().filter(e -> String.valueOf(e.getUsuario().getId()).equals(parametro)).collect(Collectors.toList());
            default:
                return new ArrayList<>(emprestimos);
        }
    }

    public String removerItem(int id) { 
        ItemAcervo itemEncontrado = acervo.stream()
                .filter(i -> i.getId() == id)
                .findFirst()
                .orElse(null);

        if (itemEncontrado == null) return "Erro: Item com ID " + id + " não encontrado.";

        if (!itemEncontrado.getStatus().equals("DISPONÍVEL")) {
            return "Erro: O item não pode ser excluído pois seu status é " + itemEncontrado.getStatus() + ".";
        }

        acervo.remove(itemEncontrado);
        return "Sucesso: Item removido com sucesso.";
    }

    private boolean temAtraso(Usuario u) {
        LocalDate hoje = LocalDate.now();
        return emprestimos.stream().anyMatch(e -> e.getUsuario().equals(u) && 
               e.getDataDevolucaoReal() == null && hoje.isAfter(e.getDataDevolucaoPrevista()));
    }

    private long contarAtivos(Usuario u) {
        return emprestimos.stream().filter(e -> e.getUsuario().equals(u) && e.getDataDevolucaoReal() == null).count();
    }

    public ItemAcervo buscarItemPorId(int id) {
        return acervo.stream()
                .filter(i -> i.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Emprestimo buscarEmprestimoAbertoPorItem(int idItem) {
        return emprestimos.stream()

                .filter(e ->
                        e.getItem().getId() == idItem &&
                        e.getDataDevolucaoReal() == null)

                .findFirst()
                .orElse(null);
    }

    public void popularDados() {
        cadastrarUsuario(new AlunoGraduacao(10, "João Silva", "joao.silva@email.com"));
        cadastrarUsuario(new AlunoGraduacao(11, "Mariana Oliveira", "mariana@email.com"));

        cadastrarUsuario(new ProfessorPosGraduacao(20, "Prof. Ricardo Santos", "ricardo@ifpb.edu.br"));
        cadastrarUsuario(new ProfessorPosGraduacao(21, "Prof. Carlos Guedes", "carlos@ifpb.edu.br"));

        cadastrarUsuario(new FuncionarioAdministrativo(30, "Ana Paula", "ana@ifpb.edu.br"));
        cadastrarUsuario(new FuncionarioAdministrativo(31, "Diana Lima", "diana@ifpb.edu.br"));

        Livro livro1 = new Livro(
                101,
                "Java: Como Programar",
                2021,
                "978-85",
                "Deitel",
                "Pearson",
                10,
                "Tecnologia",
                900,
                "Guia Completo"
        );

        Livro livro2 = new Livro(
                102,
                "Código Limpo",
                2008,
                "978-01",
                "Robert Martin",
                "Prentice Hall",
                1,
                "Tecnologia",
                464,
                "Boas práticas de programação"
        );

        Livro livro3 = new Livro(
                103,
                "O Senhor dos Anéis",
                1954,
                "978-99",
                "J.R.R. Tolkien",
                "HarperCollins",
                1,
                "Fantasia",
                1200,
                "A jornada do Um Anel"
        );

        cadastrarItem(livro1);
        cadastrarItem(livro2);
        cadastrarItem(livro3);

        Revista revista1 = new Revista(
                201,
                "National Geographic",
                2024,
                "0027-9358",
                145,
                4,
                "Abril",
                "15/04/2024"
        );

        Revista revista2 = new Revista(
                202,
                "Mundo Estranho",
                2023,
                "ISSN-123",
                150,
                5,
                "Editora Abril",
                "01/05/2023"
        );

        cadastrarItem(revista1);
        cadastrarItem(revista2);

        List<String> faixasPinkFloyd = List.of(
                "Time",
                "Money",
                "Us and Them"
        );

        Cd cd1 = new Cd(
                301,
                "Dark Side of the Moon",
                1973,
                "Pink Floyd",
                faixasPinkFloyd
        );

        cadastrarItem(cd1);

        Dvd dvd1 = new Dvd(
                401,
                "Interstellar",
                2014,
                "Christopher Nolan",
                169,
                "12 anos"
        );

        Dvd dvd2 = new Dvd(
                402,
                "Inception",
                2010,
                "Christopher Nolan",
                148,
                "14 anos"
        );

        cadastrarItem(dvd1);
        cadastrarItem(dvd2);

        realizarEmprestimo(buscarUsuarioPorId(10), livro1);
        realizarEmprestimo(buscarUsuarioPorId(20), livro2);
        realizarEmprestimo(buscarUsuarioPorId(20), dvd1);
        realizarEmprestimo(buscarUsuarioPorId(11), revista1);
        realizarEmprestimo(buscarUsuarioPorId(30), cd1);

        System.out.println(">>> Sistema povoado com sucesso!");
    }
}