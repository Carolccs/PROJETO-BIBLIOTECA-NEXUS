package br.edu.ifpb.poo.modelo;

public abstract class Usuario {
    private int id;
    private String nome;
    private String email;
    private boolean multaPendente;

    public Usuario(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.multaPendente = false;
    }

    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public boolean isMultaPendente() { return multaPendente; }
    public void setMultaPendente(boolean multaPendente) { this.multaPendente = multaPendente; }
    
    // Métodos Abstratos: Cada subclasse implementará seus valores específicos [1, 2]
    public abstract int getLimiteEmprestimos(); // 3 para Aluno, 5 para Professor, 2 para Funcionario
    public abstract double getValorMultaDiaria(); // R$ 2.00, R$ 1.00 ou R$ 1.50
    public abstract int getPrazoEmprestimo(ItemAcervo item); // Regra dinâmica para Professores [1]

    

}