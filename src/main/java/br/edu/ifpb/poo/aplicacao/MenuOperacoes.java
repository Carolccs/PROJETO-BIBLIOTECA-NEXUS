package br.edu.ifpb.poo.aplicacao;

import br.edu.ifpb.poo.servico.BibliotecaServico;

public class MenuOperacoes {

    private InterfaceUsuario ui;
    private BibliotecaServico servico;
    public MenuOperacoes(InterfaceUsuario ui, BibliotecaServico servico) {
        this.ui = ui;
        this.servico = servico;
    }

    public void exibir() {
        int opcao = -1;

        while (opcao != 4) {
            System.out.println("\n--- OPERAÇÕES (SISTEMA NEXUS) ---");
            System.out.println(" [1] Realizar Empréstimo (Livro, Revista ou Jogo)");
            System.out.println(" [2] Registrar Devolução (Com Cálculo de Multa)");
            System.out.println(" [3] Realizar Venda de Jogo");
            System.out.println(" [4] Voltar");

            opcao = ui.lerInteiro("Escolha: ");

            switch (opcao) {
                case 1: realizarEmprestimo(); break;
                case 2: registrarDevolucao(); break;
                case 3: realizarVenda(); break;
                case 4: break;
                default: System.out.println("Opção inválida.");
            }
        }
    }

    private void realizarEmprestimo() {
        System.out.println("\n-- Novo Empréstimo --");
        int idUsuario = ui.lerInteiro("ID do Usuário: ");
        int idItem = ui.lerInteiro("ID do Item (Livro, Revista ou Jogo): ");

        boolean sucesso = servico.realizarEmprestimo(idUsuario, idItem);

        if (sucesso) {
            System.out.println("Empréstimo registrado com sucesso!");
        } else {
            System.out.println("Erro: Verifique se o item está disponível ou se o usuário possui pendências.");
        }
    }

    private void registrarDevolucao() {
        System.out.println("\n-- Registrar Devolução --");
        int idItem = ui.lerInteiro("ID do Item devolvido: ");

        double multa = servico.registrarDevolucao(idItem);

        if (multa == -1) {
            System.out.println("Erro: Item não encontrado ou não está emprestado.");
        } else if (multa > 0) {
            System.out.printf("Devolução concluída com atraso. Multa aplicada: R$ %.2f\n", multa);
        } else {
            System.out.println("Devolução concluída com sucesso e no prazo.");
        }
    }

    private void realizarVenda() {
        System.out.println("\n-- Venda de Jogo de Tabuleiro --");
        int idJogo = ui.lerInteiro("ID do Jogo para venda: ");
        
        boolean sucesso = servico.venderJogo(idJogo);

        if (sucesso) {
            System.out.println("Venda realizada com sucesso! O status do jogo foi alterado para VENDIDO.");
        } else {
            System.out.println("Erro: Jogo não encontrado ou não está disponível para venda.");
        }
    }
}