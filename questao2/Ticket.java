package questao2;

import java.math.BigDecimal;

public class Ticket {

    private final String placa;
    private final int minutosPermanencia;
    private StrategyCobranca estrategia;

    public Ticket(String placa, int minutosPermanencia, StrategyCobranca estrategia) {
        if (placa == null || placa.isBlank()) {
            throw new IllegalArgumentException("A placa do veículo é obrigatória.");
        }
        if (minutosPermanencia < 0) {
            throw new IllegalArgumentException("O tempo de permanência não pode ser negativo.");
        }
        this.placa = placa;
        this.minutosPermanencia = minutosPermanencia;
        this.estrategia = validarStrategy(estrategia);
    }

    public String getPlaca() {
        return placa;
    }

    public int getMinutosPermanencia() {
        return minutosPermanencia;
    }

    public StrategyCobranca getStrategy() {
        return estrategia;
    }

    public void alterarStrategy(StrategyCobranca estrategia) {
        this.estrategia = validarStrategy(estrategia);
    }

    public BigDecimal calcularValor() {
        return estrategia.calcularValor(this);
    }

    private static StrategyCobranca validarStrategy(StrategyCobranca estrategia) {
        if (estrategia == null) {
            throw new IllegalArgumentException("A estratégia de cobrança é obrigatória.");
        }
        return estrategia;
    }
}
