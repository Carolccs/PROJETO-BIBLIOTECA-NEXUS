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
    
    public abstract int getLimiteEmprestimos(); 
    public abstract double getValorMultaDiaria(); 
    public abstract int getPrazoEmprestimo(ItemAcervo item); 
}