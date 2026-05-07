package br.edu.ifpb.poo.aplicacao;

import br.edu.ifpb.poo.servico.BibliotecaServico;

public class MenuPrincipal {

    private InterfaceUsuario ui;
    private BibliotecaServico servico;

    private MenuItens menuItens;
    private MenuUsuarios menuUsuarios;
    private MenuOperacoes menuOperacoes;
    private MenuConsultas menuConsultas;

    public MenuPrincipal() {

        ui = new InterfaceUsuario();
        servico = new BibliotecaServico();

        menuItens = new MenuItens(ui, servico);
        menuUsuarios = new MenuUsuarios(ui, servico);
        menuOperacoes = new MenuOperacoes(ui, servico);
        menuConsultas = new MenuConsultas(ui, servico);
    }

    public void exibirMenuPrincipal() {

        int opcao = -1;

        while (opcao != 5) {

            System.out.println("\n--- SISTEMA NEXUS ---");
            System.out.println("[1] Gerenciar Itens");
            System.out.println("[2] Gerenciar Usuários");
            System.out.println("[3] Operações");
            System.out.println("[4] Consultas");
            System.out.println("[5] Sair");

            opcao = ui.lerInteiro("Escolha: ");

            switch (opcao) {

                case 1:
                    menuItens.exibir();
                    break;

                case 2:
                    menuUsuarios.exibir();
                    break;

                case 3:
                    menuOperacoes.exibir();
                    break;

                case 4:
                    menuConsultas.exibir();
                    break;

                case 5:
                    System.out.println("Sistema encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}

/*package br.edu.ifpb.poo.aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.ifpb.poo.modelo.AlunoGraduacao;
import br.edu.ifpb.poo.modelo.Cd;
import br.edu.ifpb.poo.modelo.Dvd;
import br.edu.ifpb.poo.modelo.Emprestimo;
import br.edu.ifpb.poo.modelo.FuncionarioAdministrativo;
import br.edu.ifpb.poo.modelo.ItemAcervo;
import br.edu.ifpb.poo.modelo.Livro;
import br.edu.ifpb.poo.modelo.ProfessorPosGraduacao;
import br.edu.ifpb.poo.modelo.Revista;
import br.edu.ifpb.poo.modelo.Usuario;
import br.edu.ifpb.poo.servico.BibliotecaServico;


public class Menu {
    private Scanner leitor = new Scanner(System.in);
    private BibliotecaServico servico = new BibliotecaServico();

    public void exibirMenuPrincipal() {
        int opcao = -1;
        while (opcao != 5) {
            System.out.println("\n--- SISTEMA TEKO: MENU PRINCIPAL ---");
            System.out.println("[1] Gerenciar Itens");
            System.out.println("[2] Gerenciar Usuários");
            System.out.println("[3] Operações (Empréstimo/Devolução)");
            System.out.println("[4] Consultas");
            System.out.println("[5] Sair");
            System.out.print("Selecione uma opção: ");

           opcao = lerInteiro();

             switch (opcao) {
                case 1: menuItens(); break;
                case 2: menuUsuarios(); break;
                case 3: menuOperacoes(); break;
                case 4: menuConsultas(); break;
                case 5: System.out.println("Sistema encerrado com sucesso."); break;
                default: if (opcao != -1) System.out.println("Opção inexistente.");
            }
        }
    }

    private int lerInteiro() {
        try {
            return Integer.parseInt(leitor.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Erro: Entrada inválida! Por favor, digite apenas números.");
            return -1; 
        }
    }

    private void menuItens() {
        int opcao = -1;
        while (opcao != 6) {
            System.out.println("\n-- GERENCIAR ITENS --");
            System.out.println("[1] Cadastrar Livro");
            System.out.println("[2] Cadastrar Revista");
            System.out.println("[3] Cadastrar Cd");
            System.out.println("[4] Cadastrar Dvd");
            System.out.println("[5] Excluir Item");
            System.out.println("[6] Voltar");
            System.out.print("Escolha: ");
            opcao = lerInteiro();

            switch (opcao) {
                case 1: cadastrarLivro(); break;
                case 2: cadastrarRevista(); break;
                case 3: cadastrarCd(); break;
                case 4: cadastrarDvd(); break;
                case 5: excluirItem(); break;
            }
        }
    }

    private void menuUsuarios() {
        int opcao = -1;
        while (opcao != 4) {
            System.out.println("\n-- GERENCIAR USUÁRIOS --");
            System.out.println("[1] Cadastrar Aluno");
            System.out.println("[2] Cadastrar Professor / Pós-Graduação");
            System.out.println("[3] Cadastrar Funcionário");
            System.out.println("[4] Voltar");
            System.out.print("Escolha: ");
            opcao = lerInteiro();

            switch (opcao) {
                case 1:
                    cadastrarAluno();
                    break;
                case 2:
                    cadastrarProfessor();
                    break;
                case 3:
                    cadastrarFuncionario();
                    break;
                case 4:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void cadastrarAluno() {
        System.out.println("\n--- CADASTRO DE ALUNO DE GRADUAÇÃO ---");
        System.out.print("ID Único: ");
        int id = lerInteiro();
        System.out.print("Nome: ");
        String nome = leitor.nextLine();
        System.out.print("E-mail: ");
        String email = leitor.nextLine();

        AlunoGraduacao novoAluno = new AlunoGraduacao(id, nome, email);
        servico.cadastrarUsuario(novoAluno);

        System.out.println("Sucesso: Aluno " + nome + " cadastrado com sucesso!");
    }
    
    private void cadastrarProfessor() {
        System.out.println("\n--- CADASTRO DE PROFESSOR / PÓS-GRADUAÇÃO ---");
        System.out.print("ID Único: ");
        int id = lerInteiro();
        System.out.print("Nome: ");
        String nome = leitor.nextLine();
        System.out.print("E-mail: ");
        String email = leitor.nextLine();

        ProfessorPosGraduacao novoProf = new ProfessorPosGraduacao(id, nome, email);
        servico.cadastrarUsuario(novoProf);

        System.out.println("Sucesso: Professor " + nome + " cadastrado com sucesso!");
    }

    private void cadastrarFuncionario() {
        System.out.println("\n--- CADASTRO DE FUNCIONÁRIO ADMINISTRATIVO ---");
        System.out.print("ID Único: ");
        int id = lerInteiro();
        System.out.print("Nome: ");
        String nome = leitor.nextLine();
        System.out.print("E-mail: ");
        String email = leitor.nextLine();

        FuncionarioAdministrativo novoFunc = new FuncionarioAdministrativo(id, nome, email);
        servico.cadastrarUsuario(novoFunc);

        System.out.println("Sucesso: Funcionário " + nome + " cadastrado com sucesso!");
    }

    private void menuOperacoes() {
        int opcao = -1;

        while (opcao != 3) {

            System.out.println("\n-- OPERAÇÕES --");
            System.out.println("[1] Realizar Empréstimo");
            System.out.println("[2] Registrar Devolução");
            System.out.println("[3] Voltar");
            System.out.print("Escolha: ");
            opcao = lerInteiro();
            switch (opcao) {
                case 1:
                    realizarEmprestimo();
                    break;

                case 2:
                    registrarDevolucao();
                    break;

                case 3:
                    System.out.println("Voltando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void realizarEmprestimo() {
        System.out.println("\n--- REALIZAR EMPRÉSTIMO ---");
        System.out.print("ID do usuário: ");
        int idUsuario = lerInteiro();
        Usuario usuario = servico.buscarUsuarioPorId(idUsuario);

        if (usuario == null) {

            System.out.println("Erro: Usuário não encontrado.");
            return;
        }

        System.out.print("ID do item: ");
        int idItem = lerInteiro();

        ItemAcervo item = servico.buscarItemPorId(idItem);

        if (item == null) {

            System.out.println("Erro: Item não encontrado.");
            return;
        }

        String resultado =
                servico.realizarEmprestimo(usuario, item);

        System.out.println(resultado);
    }

    private void registrarDevolucao() {
        System.out.println("\n--- REGISTRAR DEVOLUÇÃO ---");

        System.out.print("ID do item devolvido: ");

        int idItem = lerInteiro();

        Emprestimo emprestimo =
                servico.buscarEmprestimoAbertoPorItem(idItem);

        if (emprestimo == null) {

            System.out.println(
                    "Erro: Não existe empréstimo ativo para este item."
            );

            return;
        }

        String resultado =
                servico.registrarDevolucao(emprestimo);

        System.out.println(resultado);

        if (emprestimo.getValorMulta() > 0) {

            System.out.printf(
                    "Valor da multa: R$ %.2f%n",
                    emprestimo.getValorMulta()
            );
        }
    }

     private void cadastrarLivro() {
        System.out.println("\n--- CADASTRO DE LIVRO ---");
        System.out.println("ID: ");
        int id = lerInteiro();
        System.out.println("Título: ");
        String titulo = leitor.nextLine();
        System.out.println("ISBN: ");
        String isbn = leitor.nextLine();
        System.out.println("Autor(es): ");
        String autores = leitor.nextLine();
        System.out.println("Editora: ");
        String editora = leitor.nextLine();
        System.out.println("Ano: ");
        int ano = lerInteiro();
        System.out.println("Edição: ");
        int edicao = lerInteiro();
        System.out.println("Gênero: ");
        String genero = leitor.nextLine();
        System.out.println("Páginas: ");
        int paginas = lerInteiro();
        System.out.println("Sinopse: ");
        String sinopse = leitor.nextLine();

        Livro novoLivro = new Livro(id, titulo, ano, isbn, autores, editora, edicao, genero, paginas, sinopse);

        servico.cadastrarItem(novoLivro);

        System.out.println("Sucesso: Livro '" + titulo + "' cadastrado!"); // Feedback claro [5]
    }

    private void cadastrarRevista() {
        System.out.println("\n---CADASTRO REVISTA ---");

        System.out.print("Digite o ID da revista: ");
        int id = lerInteiro();

        System.out.print("Título: ");
        String titulo = leitor.nextLine();

        System.out.print("ISSN: ");
        String issn = leitor.nextLine();

        System.out.print("Volume: ");
        int volume = lerInteiro();

        System.out.print("Número: ");
        int numero = lerInteiro();

        System.out.print("Editora: ");
        String editora = leitor.nextLine();

        System.out.print("Ano de Publicação: ");
        int anoPublicacao = lerInteiro();

        System.out.print("Data de Publicação (ex: 06/05/2026): ");
        String dataPublicacao = leitor.nextLine();

       Revista novaRevista = new Revista(id, titulo, anoPublicacao, issn, volume, numero, editora, dataPublicacao);

        servico.cadastrarItem(novaRevista);

        System.out.println("\nSucesso: A revista '" + titulo + "' foi cadastrada com sucesso!");
    }

    private void cadastrarCd() {
        System.out.println("\n--- CADASTRO CD ---");

        System.out.print("Digite o ID do CD: ");
        int id = lerInteiro();

        System.out.print("Título do Álbum: ");
        String titulo = leitor.nextLine();

        System.out.print("Artista/Banda: ");
        String artista = leitor.nextLine();

        System.out.print("Ano de Lançamento: ");
        int ano = lerInteiro();

        List<String> faixas = new ArrayList<>();
        System.out.print("Quantas faixas este CD possui? ");
        int quantidade = lerInteiro();

        for (int i = 1; i <= quantidade; i++) {
            System.out.print("Nome da faixa " + i + ": ");
            String nomeFaixa = leitor.nextLine();
            faixas.add(nomeFaixa);
        }

        Cd novoCd = new Cd(id, titulo, ano, artista, faixas);

        servico.cadastrarItem(novoCd);

        System.out.println("\nSucesso: O CD '" + titulo + "' de " + artista + " foi cadastrado!");
    }

    private void cadastrarDvd() {
        System.out.println("\n --- CADASTRO DVD ---");

        System.out.print("Digite o ID do DVD: ");
        int id = lerInteiro(); 

        System.out.print("Título do Filme: ");
        String titulo = leitor.nextLine();

        System.out.print("Diretor: ");
        String diretor = leitor.nextLine();

        System.out.print("Ano de Lançamento: ");
        int ano = lerInteiro();

        System.out.print("Duração (em minutos): ");
        int duracao = lerInteiro();

        System.out.print("Classificação Indicativa: ");
        String classificacao = leitor.nextLine();

        Dvd novoDvd = new Dvd(id, titulo, ano, diretor, duracao, classificacao);

        servico.cadastrarItem(novoDvd);

        System.out.println("\nSucesso: O DVD '" + titulo + "' foi cadastrado com sucesso!");
    }

    private void excluirItem() {
        System.out.println("\n--- GERENCIAR EXCLUSÃO DE ITENS ---");
       
        List<ItemAcervo> itens = servico.getAcervo();
        
        if (itens.isEmpty()) {
            System.out.println("O acervo está vazio. Não há itens para excluir.");
            return;
        }

        System.out.println("Itens Atuais no Acervo:");
        System.out.println("--------------------------------------------------");
        for (ItemAcervo item : itens) {
            System.out.printf("ID: %-4d | Título: %-20s | Status: %s%n", 
                    item.getId(), item.getTitulo(), item.getStatus());
        }
        System.out.println("--------------------------------------------------");

        System.out.print("Digite o ID do item que deseja EXCLUIR: ");
        int id = lerInteiro(); 
        String resultado = servico.removerItem(id);
        System.out.println("\n" + resultado);
    }

    private void menuConsultas() {
        int opcao = -1;
        while (opcao != 4) {
            System.out.println("\n-- MENU DE CONSULTAS --");
            System.out.println("1. Consultar Itens (Título/Autor/Editora/ISBN/ISSN)");
            System.out.println("2. Consultar Usuários (Nome/ID)");
            System.out.println("3. Consultar Empréstimos (Abertos/Atraso/Histórico)");
            System.out.println("4. Voltar");
            System.out.print("Escolha: ");
            opcao = lerInteiro();

            switch (opcao) {
                case 1 : consultarItensUI(); break;
                case 2 : consultarUsuariosUI(); break;
                case 3 : consultarEmprestimosUI(); break;
            }
        }
    }

    private void consultarItensUI() {
        System.out.print("Digite o termo de busca: ");
        String termo = leitor.nextLine();
        List<ItemAcervo> resultados = servico.buscarItens(termo);
        
        System.out.println("\n--- RESULTADO DA BUSCA DE ITENS ---");
        // A listagem deve mostrar a disponibilidade (Status) [2]
        System.out.printf("%-5s | %-20s | %-12s | %-10s%n", "ID", "TÍTULO", "STATUS", "TIPO");
        for (ItemAcervo i : resultados) {
            System.out.printf("%-5d | %-20s | %-12s | %-10s%n", 
                i.getId(), i.getTitulo(), i.getStatus(), i.getClass().getSimpleName());
        }
    }

    private void consultarEmprestimosUI() {
        System.out.println("\nFiltros:");
        System.out.println("[1] Em Aberto");
        System.out.println("[2] Em Atraso");
        System.out.println("[3] Histórico por Usuário");
        int filtro = lerInteiro();
        List<Emprestimo> lista = new ArrayList<>();

        if (filtro == 1) lista = servico.filtrarEmprestimos("EM_ABERTO", "");
        else if (filtro == 2) lista = servico.filtrarEmprestimos("EM_ATRASO", "");
        else if (filtro == 3) {
            System.out.print("ID do Usuário: ");
            lista = servico.filtrarEmprestimos("HISTORICO_USUARIO", leitor.nextLine());
        }

        System.out.println("\n--- RELATÓRIO DE EMPRÉSTIMOS ---");
        for (Emprestimo e : lista) {
            System.out.println("ID: " + e.getId() + " | Item: " + e.getItem().getTitulo() + 
                            " | Usuário: " + e.getUsuario().getNome() + 
                            " | Previsto: " + e.getDataDevolucaoPrevista());
        }
    }

    private void consultarUsuariosUI() {
        System.out.println("\n--- CONSULTA DE USUÁRIOS ---");
        System.out.print("Digite o Nome ou ID para busca: ");
        String termo = leitor.nextLine();
        List<Usuario> resultados = servico.buscarUsuarios(termo);
            for (Usuario u : resultados) {

            System.out.println(
                    "ID: " + u.getId() +
                    " | Nome: " + u.getNome() +
                    " | Email: " + u.getEmail()
            );
        }

        if (resultados.isEmpty()) {
            System.out.println("Nenhum usuário encontrado para o termo: " + termo);
            return; 
        }
    }
}*/