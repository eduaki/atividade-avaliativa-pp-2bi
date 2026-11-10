package questao2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class StrategyRotativo implements StrategyCobranca {

    public static final BigDecimal VALOR_POR_HORA_INICIADA = new BigDecimal("8.00");

    @Override
    public String getNome() {
        return "Rotativo";
    }

    @Override
    public BigDecimal calcularValor(Ticket ticket) {
        int horasIniciadas = TempoCobranca.horasIniciadas(ticket.getMinutosPermanencia());
        return VALOR_POR_HORA_INICIADA
                .multiply(BigDecimal.valueOf(horasIniciadas))
                .setScale(2, RoundingMode.HALF_UP);
    }
}
