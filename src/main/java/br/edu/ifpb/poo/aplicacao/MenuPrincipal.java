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

        servico.popularDados();

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
