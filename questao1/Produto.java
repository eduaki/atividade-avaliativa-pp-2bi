package questao1;

import java.util.ArrayList;
import java.util.List;

public class Produto {

    private final String nome;
    private int quantidade;
    private final List<StrategyNotificacaoEstoque> estrategias = new ArrayList<>();

    public Produto(String nome, int quantidadeInicial) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do produto é obrigatório.");
        }
        validarQuantidade(quantidadeInicial);
        this.nome = nome;
        this.quantidade = quantidadeInicial;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void adicionarStrategy(StrategyNotificacaoEstoque estrategia) {
        if (estrategia == null) {
            throw new IllegalArgumentException("A estratégia de notificação é obrigatória.");
        }
        estrategias.add(estrategia);
    }

    public boolean removerStrategy(StrategyNotificacaoEstoque estrategia) {
        return estrategias.remove(estrategia);
    }

    public List<StrategyNotificacaoEstoque> getStrategys() {
        return List.copyOf(estrategias);
    }

    public void alterarQuantidade(int novaQuantidade) {
        validarQuantidade(novaQuantidade);

        if (novaQuantidade == quantidade) {
            System.out.printf(
                    "[Sistema]   Nenhuma alteração em '%s': a quantidade continua %d.%n", nome, quantidade);
            return;
        }

        int quantidadeAnterior = quantidade;
        quantidade = novaQuantidade;

        System.out.printf("[Sistema]   '%s': %d -> %d unidade(s).%n", nome, quantidadeAnterior, novaQuantidade);
        for (StrategyNotificacaoEstoque estrategia : List.copyOf(estrategias)) {
            estrategia.notificar(this, quantidadeAnterior, novaQuantidade);
        }
    }

    private static void validarQuantidade(int quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("A quantidade em estoque não pode ser negativa.");
        }
    }
}
