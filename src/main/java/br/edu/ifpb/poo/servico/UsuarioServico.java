package br.edu.ifpb.poo.servico;

import br.edu.ifpb.poo.modelo.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UsuarioServico {

    private List<Usuario> usuarios;

    public UsuarioServico() {
        this.usuarios = new ArrayList<>();
    }

    public void cadastrarUsuario(Usuario usuario) {
        if (usuario != null) {
            this.usuarios.add(usuario);
        }
    }

    public Usuario buscarUsuarioPorId(int id) {
        return usuarios.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Usuario> buscarPorNome(String nome) {
        return usuarios.stream()
                .filter(u -> u.getNome().toLowerCase().contains(nome.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Usuario> getUsuarios() {
        return new ArrayList<>(this.usuarios);
    }

    public boolean removerUsuario(int id) {
        Usuario u = buscarUsuarioPorId(id);
        
        if (u != null && !u.isMultaPendente()) {
            return usuarios.remove(u);
        }
        return false;
    }
}