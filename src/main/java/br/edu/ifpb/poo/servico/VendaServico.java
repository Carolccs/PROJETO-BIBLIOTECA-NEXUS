package br.edu.ifpb.poo.servico;

import br.edu.ifpb.poo.modelo.JogoTabuleiro;
import br.edu.ifpb.poo.modelo.Venda;
import java.util.ArrayList;
import java.util.List;

/**
 * Serviço responsável pela gestão de jogos de tabuleiro e registro de vendas.
 * Implementa UC05 e UC11 conforme os requisitos da Parte 2.
 */
public class VendaServico {
    private List<JogoTabuleiro> jogos = new ArrayList<>();
    private List<Venda> vendasRealizadas = new ArrayList<>();

    /**
     * UC05 - Cadastrar novo jogo de tabuleiro.
     * @param id Identificador único.
     * @param nome Nome do jogo.
     * @param tipo "CARTA" ou "TABULEIRO".
     * @param pecas Quantidade de peças.
     * @param preco Preço de venda/avaliação.
     */
    public void cadastrarJogo(int id, String nome, String tipo, int pecas, double preco) {
        JogoTabuleiro novoJogo = new JogoTabuleiro(id, nome, tipo, pecas, preco);
        // Por padrão, o status inicial é DISPONÍVEL conforme regras de negócio [4]
        novoJogo.setStatus("DISPONÍVEL");
        jogos.add(novoJogo);
    }

    /**
     * Realiza a venda de um jogo de tabuleiro.
     * Altera o status do jogo para garantir a integridade da operação [5].
     * 
     * @param idJogo ID do jogo a ser vendido.
     * @return boolean true se a venda foi realizada com sucesso.
     */
    public boolean realizarVenda(int idJogo) {
        JogoTabuleiro jogo = buscarJogoPorId(idJogo);
        
        // Regra de Negócio: O item deve estar DISPONÍVEL para ser vendido [6]
        if (jogo != null && jogo.getStatus().equals("DISPONÍVEL")) {
            Venda novaVenda = new Venda(jogo, jogo.getPreco());
            vendasRealizadas.add(novaVenda);
            
            // Atualiza status para impedir que o jogo seja emprestado ou vendido novamente
            jogo.setStatus("VENDIDO");
            return true;
        }
        return false;
    }

    /**
     * UC11 - Retorna a lista de todas as vendas realizadas.
     * @return Lista de objetos Venda contendo ID, título e valor [3].
     */
    public List<Venda> listarVendas() {
        return new ArrayList<>(this.vendasRealizadas);
    }

    /**
     * Busca um jogo específico pelo ID.
     * @param id ID do jogo.
     * @return JogoTabuleiro ou null se não encontrado.
     */
    public JogoTabuleiro buscarJogoPorId(int id) {
        return jogos.stream()
                .filter(j -> j.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<JogoTabuleiro> getJogos() {
        return new ArrayList<>(this.jogos);
    }
}
