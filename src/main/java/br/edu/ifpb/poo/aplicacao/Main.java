package br.edu.ifpb.poo.aplicacao;

import java.util.Locale;

import br.edu.ifpb.poo.servico.BibliotecaServico;

public class Main {

    public static void main(String[] args) {

        Locale.setDefault(Locale.of("pt", "BR"));

        MenuPrincipal menu = new MenuPrincipal();

        menu.exibirMenuPrincipal();
    }
}