package questao1;

public interface StrategyNotificacaoEstoque {

    void notificar(Produto produto, int quantidadeAnterior, int quantidadeAtual);
}
