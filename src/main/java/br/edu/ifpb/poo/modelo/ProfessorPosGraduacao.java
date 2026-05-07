package br.edu.ifpb.poo.modelo;

public class ProfessorPosGraduacao extends Usuario {
    public static final int LIMITE_EMPRESTIMOS = 5;
    public static final int PRAZO_LIVROS = 14;
    public static final int PRAZO_OUTRAS_MIDIAS = 7;
    public static final double VALOR_MULTA_DIARIA = 1.00;

    public ProfessorPosGraduacao(int id, String nome, String email) {
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
        if (item instanceof Livro) {
            return PRAZO_LIVROS;
        }
        return PRAZO_OUTRAS_MIDIAS;
    }

}
