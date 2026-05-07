package br.edu.ifpb.poo.aplicacao;

import java.util.Scanner;

public class InterfaceUsuario {

    private Scanner leitor = new Scanner(System.in);

    public void mostrarMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public void titulo(String texto) {

        System.out.println("\n================================");
        System.out.println(texto.toUpperCase());
        System.out.println("================================");
    }

    public String lerTexto(String mensagem) {
        System.out.print(mensagem);
        return leitor.nextLine();
    }

    public void mensagem(String texto) {

        System.out.println(texto);
    }

    public int lerInteiro(String mensagem) {
        System.out.print(mensagem);

        try {
            return Integer.parseInt(leitor.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Erro: Digite apenas números.");
            return -1;
        }
    }
}