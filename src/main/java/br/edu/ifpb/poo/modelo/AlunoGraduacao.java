package br.edu.ifpb.poo.modelo;

public class AlunoGraduacao extends Usuario {
    public static final int LIMITE_EMPRESTIMOS = 3;
    public static final int PRAZO_DIAS = 7;
    public static final double VALOR_MULTA_DIARIA = 2.00;

    public AlunoGraduacao(int id, String nome, String email) {
        super(id, nome, email);
    }

    @Override
    public int getLimiteEmprestimos() {
        return LIMITE_EMPRESTIMOS;
    }

    @Override
    public double getValorMultaDiaria() {
        return VALOR_MULTA_DIARIA;
    }

    @Override
    public int getPrazoEmprestimo(ItemAcervo item) {
        return PRAZO_DIAS;
    }
}

