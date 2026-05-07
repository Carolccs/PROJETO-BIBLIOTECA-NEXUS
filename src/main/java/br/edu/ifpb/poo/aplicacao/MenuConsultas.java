package br.edu.ifpb.poo.aplicacao;

import java.util.List;

import br.edu.ifpb.poo.modelo.Emprestimo;
import br.edu.ifpb.poo.modelo.ItemAcervo;
import br.edu.ifpb.poo.modelo.Usuario;
import br.edu.ifpb.poo.servico.BibliotecaServico;

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

            ui.mostrarMensagem("\n--- MENU CONSULTAS ---");
            ui.mostrarMensagem("[1] Consultar Itens");
            ui.mostrarMensagem("[2] Consultar Usuários");
            ui.mostrarMensagem("[3] Consultar Empréstimos");
            ui.mostrarMensagem("[4] Voltar");

            opcao = ui.lerInteiro("Escolha: ");

            switch (opcao) {

                case 1:
                    consultarItens();
                    break;

                case 2:
                    consultarUsuarios();
                    break;

                case 3:
                    consultarEmprestimos();
                    break;

                case 4:
                    ui.mostrarMensagem("Voltando...");
                    break;

                default:
                    ui.mostrarMensagem("Opção inválida.");
            }
        }
    }

    private void consultarItens() {

        String termo = ui.lerTexto("Digite o termo da busca: ");

        List<ItemAcervo> resultados = servico.buscarItens(termo);

        if (resultados.isEmpty()) {
            ui.mostrarMensagem("Nenhum item encontrado.");
            return;
        }

        for (ItemAcervo item : resultados) {

            ui.mostrarMensagem(
                "ID: " + item.getId()
                + " | Título: " + item.getTitulo()
                + " | Status: " + item.getStatus()
            );
        }
    }

    private void consultarUsuarios() {

        String termo = ui.lerTexto("Digite nome ou ID: ");

        List<Usuario> resultados = servico.buscarUsuarios(termo);

        if (resultados.isEmpty()) {
            ui.mostrarMensagem("Nenhum usuário encontrado.");
            return;
        }

        for (Usuario usuario : resultados) {

            ui.mostrarMensagem(
                "ID: " + usuario.getId()
                + " | Nome: " + usuario.getNome()
            );
        }
    }

    private void consultarEmprestimos() {

        List<Emprestimo> lista = servico.filtrarEmprestimos("TODOS", "");

        if (lista.isEmpty()) {
            ui.mostrarMensagem("Nenhum empréstimo encontrado.");
            return;
        }

        for (Emprestimo e : lista) {
            ui.mostrarMensagem(e.toString());
        }
    }
}