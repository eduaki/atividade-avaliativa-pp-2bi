package questao2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class StrategyMensalista implements StrategyCobranca {

    public static final BigDecimal VALOR_FIXO = new BigDecimal("250.00");

    @Override
    public String getNome() {
        return "Mensalista";
    }

    @Override
    public BigDecimal calcularValor(Ticket ticket) {
        return VALOR_FIXO.setScale(2, RoundingMode.HALF_UP);
    }
}
