package br.edu.ifpb.poo.aplicacao;

import br.edu.ifpb.poo.modelo.Emprestimo;
import br.edu.ifpb.poo.modelo.ItemAcervo;
import br.edu.ifpb.poo.modelo.Usuario;
import br.edu.ifpb.poo.servico.BibliotecaServico;

public class MenuOperacoes {

    private InterfaceUsuario ui;
    private BibliotecaServico servico;

    public MenuOperacoes(
            InterfaceUsuario ui,
            BibliotecaServico servico) {

        this.ui = ui;
        this.servico = servico;
    }

    public void exibir() {

        int opcao = -1;

        while (opcao != 3) {

            ui.titulo("Operações");

            System.out.println("[1] Empréstimo");
            System.out.println("[2] Devolução");
            System.out.println("[3] Voltar");

            opcao = ui.lerInteiro("Escolha: ");

            switch (opcao) {

                case 1:
                    realizarEmprestimo();
                    break;

                case 2:
                    registrarDevolucao();
                    break;
            }
        }
    }

    private void realizarEmprestimo() {

        int idUsuario =
                ui.lerInteiro("ID usuário: ");

        Usuario usuario =
                servico.buscarUsuarioPorId(idUsuario);

        if (usuario == null) {

            System.out.println("Usuário não encontrado.");
            return;
        }

        int idItem =
                ui.lerInteiro("ID item: ");

        ItemAcervo item =
                servico.buscarItemPorId(idItem);

        if (item == null) {

            System.out.println("Item não encontrado.");
            return;
        }

        String resultado =
                servico.realizarEmprestimo(usuario, item);

        System.out.println(resultado);
    }

    private void registrarDevolucao() {

        int idItem =
                ui.lerInteiro("ID item devolvido: ");

        Emprestimo emprestimo =
                servico.buscarEmprestimoAbertoPorItem(idItem);

        if (emprestimo == null) {

            System.out.println(
                    "Nenhum empréstimo ativo encontrado."
            );

            return;
        }

        String resultado =
                servico.registrarDevolucao(emprestimo);

        System.out.println(resultado);
    }
}
