package questao1;

public class StrategyCompras implements StrategyNotificacaoEstoque {

    private static final int ESTOQUE_MINIMO = 5;

    @Override
    public void notificar(Produto produto, int quantidadeAnterior, int quantidadeAtual) {
        if (quantidadeAtual < ESTOQUE_MINIMO) {
            System.out.printf(
                    "[Compras]   ALERTA: '%s' com estoque baixo (%d unidades, mínimo %d). Providenciar reposição.%n",
                    produto.getNome(), quantidadeAtual, ESTOQUE_MINIMO);
        }
    }
}
