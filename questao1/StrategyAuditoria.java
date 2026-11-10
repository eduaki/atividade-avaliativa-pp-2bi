package questao1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StrategyAuditoria implements StrategyNotificacaoEstoque {

    private final List<String> registros = new ArrayList<>();

    @Override
    public void notificar(Produto produto, int quantidadeAnterior, int quantidadeAtual) {
        String registro = String.format(
                "Produto '%s': estoque alterado de %d para %d unidade(s).",
                produto.getNome(), quantidadeAnterior, quantidadeAtual);
        registros.add(registro);
        System.out.println("[Auditoria] " + registro);
    }

    public List<String> getRegistros() {
        return Collections.unmodifiableList(registros);
    }
}
