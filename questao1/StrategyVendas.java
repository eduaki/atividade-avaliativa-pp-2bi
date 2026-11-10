package questao1;

public class StrategyVendas implements StrategyNotificacaoEstoque {

    @Override
    public void notificar(Produto produto, int quantidadeAnterior, int quantidadeAtual) {
        if (quantidadeAnterior == 0 && quantidadeAtual > 0) {
            System.out.printf(
                    "[Vendas]    ALERTA: '%s' voltou ao estoque com %d unidades. Retomar as vendas.%n",
                    produto.getNome(), quantidadeAtual);
        }
    }
}
