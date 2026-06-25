package br.edu.ifpb.poo.aplicacao;

import br.edu.ifpb.poo.servico.BibliotecaServico;
import java.util.ArrayList;
import java.util.List;


public class MenuItens {

    private InterfaceUsuario ui;
    private BibliotecaServico servico;

    public MenuItens(InterfaceUsuario ui, BibliotecaServico servico) {
        this.ui = ui;
        this.servico = servico;
    }

    public void exibir() {
        int opcao = -1;

        while (opcao != 8) { 
            System.out.println("\n--- GERENCIAR ITENS ---");
            System.out.println("[1] Cadastrar Livro (Físico ou Áudio)");
            System.out.println("[2] Cadastrar Revista");
            System.out.println("[3] Cadastrar CD");
            System.out.println("[4] Cadastrar DVD");
            System.out.println("[5] Cadastrar Jogo de Tabuleiro");
            System.out.println("[6] Cadastrar Editora");
            System.out.println("[7] Excluir Item");
            System.out.println("[8] Voltar");

            opcao = ui.lerInteiro("Escolha: ");

            switch (opcao) {
                case 1: cadastrarLivro(); break;
                case 2: cadastrarRevista(); break;
                case 3: cadastrarCd(); break;
                case 4: cadastrarDvd(); break;
                case 5: cadastrarJogo(); break;
                case 6: cadastrarEditora(); break;
                case 7: excluirItem(); break;
                case 8: break; // Apenas volta ao menu principal
                default: System.out.println("Opção inválida.");
            }
        }
    }

    private void cadastrarEditora() {
        System.out.println("\n-- Cadastro de Editora --");
        int id = ui.lerInteiro("ID da Editora: ");
        String nome = ui.lerTexto("Nome: ");
        String cnpj = ui.lerTexto("CNPJ: ");
        servico.cadastrarEditora(id, nome, cnpj);
    }

    private void cadastrarLivro() {
        System.out.println("\n-- Cadastro de Livro --");
        System.out.println("[3] Livro Físico | [4] Áudio-Livro");
        int subtipo = ui.lerInteiro("Escolha o tipo: ");

        int id = ui.lerInteiro("ID do Item: ");
        String titulo = ui.lerTexto("Título: ");
        String autor = ui.lerTexto("Autor: ");
        int ano = ui.lerInteiro("Ano de Publicação: ");
        String isbn = ui.lerTexto("ISBN: ");
        int idEditora = ui.lerInteiro("ID da Editora para vincular: ");

        if (subtipo == 1) {
            int paginas = ui.lerInteiro("Quantidade de páginas: ");
            servico.cadastrarLivroFisico(id, autor, titulo, ano, isbn, idEditora, paginas);
        } else {
            int duracao = ui.lerInteiro("Duração em minutos: ");
            servico.cadastrarAudioLivro(id, autor, titulo, ano, isbn, idEditora, duracao);
        }
    }

    private void cadastrarJogo() {
        System.out.println("\n-- Cadastro de Jogo de Tabuleiro --");
        int id = ui.lerInteiro("ID do Jogo: ");
        String nome = ui.lerTexto("Nome do Jogo: ");
        String tipo = ui.lerTexto("Tipo (Carta ou Tabuleiro): ");
        int pecas = ui.lerInteiro("Quantidade de peças: ");
        
        // Uso de Double para o preço (necessário para UC11)
        System.out.print("Preço de venda: ");
        double preco = Double.parseDouble(ui.lerTexto("")); 
        
        servico.cadastrarJogo(id, nome, tipo, pecas, preco);
    }

    private void excluirItem() {
        int id = ui.lerInteiro("Digite o ID do item para remover: ");
        boolean sucesso = servico.removerItem(id);
        
        if (sucesso) {
            System.out.println("Item removido com sucesso do sistema.");
        } else {
            System.out.println("Erro: ID não encontrado ou item possui pendências.");
        }
    }

    private void cadastrarRevista() {
        System.out.println("\n-- Cadastro de Revista --");
        int id = ui.lerInteiro("ID: ");
        String titulo = ui.lerTexto("Título: ");
        String autor = ui.lerTexto("Autor/Editor: ");
        int ano = ui.lerInteiro("Ano: ");
        String issn = ui.lerTexto("ISSN: ");
        int volume = ui.lerInteiro("Volume: ");
        int numero = ui.lerInteiro("Número: ");
        int paginas = ui.lerInteiro("Páginas: "); 
        int idEditora = ui.lerInteiro("ID da Editora: ");
        String data = ui.lerTexto("Data de Publicação: ");

        servico.cadastrarRevista(id, autor, titulo, ano, issn, volume, numero, paginas, idEditora, data);
    }

    private void cadastrarCd() {
        System.out.println("\n-- Cadastro de CD --");
        int id = ui.lerInteiro("ID: ");
        String titulo = ui.lerTexto("Título: ");
        String artista = ui.lerTexto("Artista: ");
        int ano = ui.lerInteiro("Ano: ");
        int numFaixas = ui.lerInteiro("Número de faixas: ");
        List<String> faixas = new ArrayList<String>();
        for (int i = 0; i < numFaixas; i++) {
            faixas.add(ui.lerTexto("Faixa " + (i + 1) + ": "));
        }
        servico.cadastrarCd(id, artista, titulo, ano, faixas);
    }

    private void cadastrarDvd() {
        System.out.println("Funcionalidade opcional em implementação.");
    }
}
