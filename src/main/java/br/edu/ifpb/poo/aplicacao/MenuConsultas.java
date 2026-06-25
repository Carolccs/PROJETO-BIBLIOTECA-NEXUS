package br.edu.ifpb.poo.aplicacao;

import br.edu.ifpb.poo.modelo.*;
import br.edu.ifpb.poo.servico.BibliotecaServico;
import java.util.List;

public class MenuConsultas {

    private InterfaceUsuario ui;
    private BibliotecaServico servico;

    public MenuConsultas(InterfaceUsuario ui, BibliotecaServico servico) {
        this.ui = ui;
        this.servico = servico;
    }

    public void exibir() {
        int opcao = -1;

        while (opcao != 4) {
            System.out.println("\n--- CONSULTAS E RELATÓRIOS ---");
            System.out.println(" [1] Listar Itens do Acervo e Jogos (UC09)");
            System.out.println(" [2] Histórico de Empréstimos (UC10)");
            System.out.println(" [3] Relatório de Vendas de Jogos (UC11)");
            System.out.println(" [4] Voltar");

            opcao = ui.lerInteiro("Escolha: ");

            switch (opcao) {
                case 1: listarItens(); break;
                case 2: consultarHistoricoEmprestimos(); break;
                case 3: consultarVendasJogos(); break;
                case 4: break;
                default: System.out.println("Opção inválida.");
            }
        }
    }

    private void listarItens() {
        System.out.println("\n--- LISTAGEM GERAL DE ITENS ---");

        List<ItemAcervo> acervo = servico.getAcervo();
        if (acervo.isEmpty()) {
            System.out.println("Nenhum item cadastrado no acervo.");
        } else {
            System.out.println(">> Acervo da Biblioteca:");
            for (ItemAcervo item : acervo) {
                String extra = "";
                if (item instanceof Livro) {
                    extra = " | Editora: " + ((Livro) item).getEditora();
                }
                System.out.println("ID: " + item.getId() + " | Título: " + item.getTitulo() + 
                                   " | Autor: " + item.getAutor() + extra + " [" + item.getStatus() + "]");
            }
        }

        List<JogoTabuleiro> jogos = servico.getJogos();
        if (!jogos.isEmpty()) {
            System.out.println("\n>> Jogos de Tabuleiro e Cartas:");
            for (JogoTabuleiro jogo : jogos) {
                System.out.println("ID: " + jogo.getId() + " | Nome: " + jogo.getNome() + 
                                   " | Preço: R$ " + jogo.getPreco() + " [" + jogo.getStatus() + "]");
            }
        }
    }

    private void consultarHistoricoEmprestimos() {
        System.out.println("\n--- HISTÓRICO DE EMPRÉSTIMOS ---");
        
        List<Emprestimo> historico = servico.getHistoricoEmprestimos();

        if (historico.isEmpty()) {
            System.out.println("Não há registros de empréstimos.");
        } else {
            for (Emprestimo e : historico) {
                String multaStr = e.getValorMulta() > 0 ? String.format("R$ %.2f", e.getValorMulta()) : "zero reais";
                String dataDev = (e.getDataDevolucaoReal() != null) ? e.getDataDevolucaoReal().toString() : "EM ABERTO";
                
                System.out.println("Empréstimo ID: " + e.getId() + 
                                " | Usuário: " + e.getUsuario().getNome() + 
                                " | Devolução: " + dataDev + 
                                " | Multa: " + multaStr);
            }
        }
    }

    private void consultarVendasJogos() {
        System.out.println("\n--- VENDAS DE JOGOS REALIZADAS ---");
        List<Venda> vendas = servico.listarVendas();

        if (vendas.isEmpty()) {
            System.out.println("Nenhuma venda de jogo registrada até o momento.");
        } else {
            for (Venda v : vendas) {
                System.out.println("ID Jogo: " + v.getJogo().getId() + 
                                   " | Título: " + v.getJogo().getNome() + 
                                   " | Valor da Venda: R$ " + v.getValorVenda());
            }
        }
    }
}