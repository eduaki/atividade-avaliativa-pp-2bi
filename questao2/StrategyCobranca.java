package questao2;

import java.math.BigDecimal;

public interface StrategyCobranca {

    String getNome();

    BigDecimal calcularValor(Ticket ticket);
}
