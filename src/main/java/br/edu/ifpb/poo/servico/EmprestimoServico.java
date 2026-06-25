package br.edu.ifpb.poo.servico;

import br.edu.ifpb.poo.modelo.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmprestimoServico {
    private List<Emprestimo> emprestimos = new ArrayList<>();
    private int proximoId = 1;

    public boolean realizarEmprestimo(Usuario usuario, Object item) {
        if (usuario == null || usuario.isMultaPendente()) {
            return false;
        }

        if (contarEmprestimosAtivos(usuario) >= usuario.getLimiteEmprestimos()) {
            return false;
        }

        if (!isItemDisponivel(item)) {
            return false;
        }

        LocalDate hoje = LocalDate.now();
        int prazoDias = usuario.getPrazoEmprestimo((ItemAcervo) item);
        LocalDate dataPrevista = hoje.plusDays(prazoDias);

        Emprestimo novo = new Emprestimo(proximoId++, usuario, item, hoje, dataPrevista);
        emprestimos.add(novo);

        atualizarStatusItem(item, "EMPRESTADO");
        
        return true;
    }

    public double registrarDevolucao(Object item) {
        Emprestimo emp = buscarEmprestimoAtivoPorItem(item);
        if (emp == null) return -1; // Item não encontrado ou não emprestado

        LocalDate hoje = LocalDate.now();
        emp.setDataDevolucaoReal(hoje);
        
        long diasAtraso = ChronoUnit.DAYS.between(emp.getDataDevolucaoPrevista(), hoje);
        double multaTotal = 0.0;

        if (diasAtraso > 0) {
            multaTotal = diasAtraso * emp.getUsuario().getValorMultaDiaria();
            emp.setValorMulta(multaTotal);
            emp.getUsuario().setMultaPendente(true); // Bloqueia novos empréstimos [4]
        }

        atualizarStatusItem(item, "DISPONÍVEL");
        
        return multaTotal;
    }

    public List<Emprestimo> getHistoricoCompleto() {
        return new ArrayList<>(this.emprestimos);
    }

    public List<Emprestimo> getHistoricoPorUsuario(int idUsuario) {
        return emprestimos.stream()
                .filter(e -> e.getUsuario().getId() == idUsuario)
                .collect(Collectors.toList());
    }

    private int contarEmprestimosAtivos(Usuario u) {
        return (int) emprestimos.stream()
                .filter(e -> e.getUsuario().equals(u) && e.getDataDevolucaoReal() == null)
                .count();
    }

    private Emprestimo buscarEmprestimoAtivoPorItem(Object item) {
        return emprestimos.stream()
                .filter(e -> e.getItem().equals(item) && e.getDataDevolucaoReal() == null)
                .findFirst()
                .orElse(null);
    }

    private boolean isItemDisponivel(Object item) {
        if (item instanceof ItemAcervo) return ((ItemAcervo) item).getStatus().equals("DISPONÍVEL");
        if (item instanceof JogoTabuleiro) return ((JogoTabuleiro) item).getStatus().equals("DISPONÍVEL");
        return false;
    }

    private void atualizarStatusItem(Object item, String status) {
        if (item instanceof ItemAcervo) ((ItemAcervo) item).setStatus(status);
        if (item instanceof JogoTabuleiro) ((JogoTabuleiro) item).setStatus(status);
    }
}
