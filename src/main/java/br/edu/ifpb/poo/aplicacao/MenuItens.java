package br.edu.ifpb.poo.aplicacao;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.poo.modelo.Cd;
import br.edu.ifpb.poo.modelo.Dvd;
import br.edu.ifpb.poo.modelo.ItemAcervo;
import br.edu.ifpb.poo.modelo.Livro;
import br.edu.ifpb.poo.modelo.Revista;
import br.edu.ifpb.poo.servico.BibliotecaServico;

public class MenuItens {

    private InterfaceUsuario ui;
    private BibliotecaServico servico;

    public MenuItens(
            InterfaceUsuario ui,
            BibliotecaServico servico) {

        this.ui = ui;
        this.servico = servico;
    }

    public void exibir() {

        int opcao = -1;

        while (opcao != 6) {

            ui.titulo("ITENS");

            System.out.println("[1] Livro");
            System.out.println("[2] Revista");
            System.out.println("[3] CD");
            System.out.println("[4] DVD");
            System.out.println("[5] Excluir");
            System.out.println("[6] Voltar");

            opcao = ui.lerInteiro("Escolha: ");

            switch (opcao) {

                case 1:
                    cadastrarLivro();
                    break;

                case 2:
                    cadastrarRevista();
                    break;

                case 3:
                    cadastrarCd();
                    break;

                case 4:
                    cadastrarDvd();
                    break;

                case 5:
                    excluirItem();
                    break;
            }
        }
    }

    private void cadastrarLivro() {

        int id = ui.lerInteiro("ID: ");
        String titulo = ui.lerTexto("Título: ");
        String isbn = ui.lerTexto("ISBN: ");
        String autores = ui.lerTexto("Autores: ");
        String editora = ui.lerTexto("Editora: ");
        int ano = ui.lerInteiro("Ano: ");
        int edicao = ui.lerInteiro("Edição: ");
        String genero = ui.lerTexto("Gênero: ");
        int paginas = ui.lerInteiro("Páginas: ");
        String sinopse = ui.lerTexto("Sinopse: ");

        Livro livro = new Livro(
                id,
                titulo,
                ano,
                isbn,
                autores,
                editora,
                edicao,
                genero,
                paginas,
                sinopse
        );

        servico.cadastrarItem(livro);

        ui.mensagem("Livro cadastrado.");
    }

    private void cadastrarRevista() {

        int id = ui.lerInteiro("ID: ");
        String titulo = ui.lerTexto("Título: ");
        String issn = ui.lerTexto("ISSN: ");
        int volume = ui.lerInteiro("Volume: ");
        int numero = ui.lerInteiro("Número: ");
        String editora = ui.lerTexto("Editora: ");
        int ano = ui.lerInteiro("Ano: ");
        String data = ui.lerTexto("Data publicação: ");

        Revista revista = new Revista(
                id,
                titulo,
                ano,
                issn,
                volume,
                numero,
                editora,
                data
        );

        servico.cadastrarItem(revista);

        ui.mensagem("Revista cadastrada.");
    }

    private void cadastrarCd() {

        int id = ui.lerInteiro("ID: ");
        String titulo = ui.lerTexto("Título: ");
        String artista = ui.lerTexto("Artista: ");
        int ano = ui.lerInteiro("Ano: ");

        List<String> faixas = new ArrayList<>();

        int qtd = ui.lerInteiro("Quantidade faixas: ");

        for (int i = 1; i <= qtd; i++) {

            faixas.add(
                    ui.lerTexto("Faixa " + i + ": ")
            );
        }

        Cd cd = new Cd(
                id,
                titulo,
                ano,
                artista,
                faixas
        );

        servico.cadastrarItem(cd);

        ui.mensagem("CD cadastrado.");
    }

    private void cadastrarDvd() {

        int id = ui.lerInteiro("ID: ");
        String titulo = ui.lerTexto("Título: ");
        String diretor = ui.lerTexto("Diretor: ");
        int ano = ui.lerInteiro("Ano: ");
        int duracao = ui.lerInteiro("Duração: ");
        String classificacao =
                ui.lerTexto("Classificação: ");

        Dvd dvd = new Dvd(
                id,
                titulo,
                ano,
                diretor,
                duracao,
                classificacao
        );

        servico.cadastrarItem(dvd);

        ui.mensagem("DVD cadastrado.");
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
            int id = ui.lerInteiro("ID: ");
            String resultado = servico.removerItem(id);
            System.out.println("\n" + resultado);
    }
       
}
