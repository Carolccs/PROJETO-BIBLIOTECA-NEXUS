package br.edu.ifpb.poo.aplicacao;

import br.edu.ifpb.poo.modelo.AlunoGraduacao;
import br.edu.ifpb.poo.modelo.FuncionarioAdministrativo;
import br.edu.ifpb.poo.modelo.ProfessorPosGraduacao;
import br.edu.ifpb.poo.servico.BibliotecaServico;

public class MenuUsuarios {

    private InterfaceUsuario ui;
    private BibliotecaServico servico;

    public MenuUsuarios(
            InterfaceUsuario ui,
            BibliotecaServico servico) {

        this.ui = ui;
        this.servico = servico;
    }

    public void exibir() {

        int opcao = -1;

        while (opcao != 4) {

            ui.titulo("USUÁRIOS");

            System.out.println("[1] Cadastrar Aluno");
            System.out.println("[2] Cadastrar Professor");
            System.out.println("[3] Cadastrar Funcionário");
            System.out.println("[4] Voltar");

            opcao = ui.lerInteiro("Escolha: ");

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
            }
        }
    }

    private void cadastrarAluno() {

        int id = ui.lerInteiro("ID: ");
        String nome = ui.lerTexto("Nome: ");
        String email = ui.lerTexto("Email: ");

        AlunoGraduacao aluno =
                new AlunoGraduacao(id, nome, email);

        servico.cadastrarUsuario(aluno);

        ui.mensagem("Aluno cadastrado.");
    }

    private void cadastrarProfessor() {

        int id = ui.lerInteiro("ID: ");
        String nome = ui.lerTexto("Nome: ");
        String email = ui.lerTexto("Email: ");

        ProfessorPosGraduacao professor =
                new ProfessorPosGraduacao(id, nome, email);

        servico.cadastrarUsuario(professor);

        ui.mensagem("Professor cadastrado.");
    }

    private void cadastrarFuncionario() {

        int id = ui.lerInteiro("ID: ");
        String nome = ui.lerTexto("Nome: ");
        String email = ui.lerTexto("Email: ");

        FuncionarioAdministrativo funcionario =
                new FuncionarioAdministrativo(id, nome, email);

        servico.cadastrarUsuario(funcionario);

        ui.mensagem("Funcionário cadastrado.");
    }
}
