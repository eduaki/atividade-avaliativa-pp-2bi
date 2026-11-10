package questao1;

import java.util.ArrayList;
import java.util.List;

public class Produto {

    private final String nome;
    private int quantidade;
    private final List<ObserverEstoque> observadores = new ArrayList<>();

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

    public void adicionarObserver(ObserverEstoque observador) {
        if (observador == null) {
            throw new IllegalArgumentException("O observador é obrigatório.");
        }
        observadores.add(observador);
    }

    public boolean removerObserver(ObserverEstoque observador) {
        return observadores.remove(observador);
    }

    public List<ObserverEstoque> getObserveres() {
        return List.copyOf(observadores);
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
        notificarObserveres(quantidadeAnterior, novaQuantidade);
    }

    private void notificarObserveres(int quantidadeAnterior, int quantidadeAtual) {
        for (ObserverEstoque observador : List.copyOf(observadores)) {
            observador.atualizar(this, quantidadeAnterior, quantidadeAtual);
        }
    }

    private static void validarQuantidade(int quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("A quantidade em estoque não pode ser negativa.");
        }
    }
}
