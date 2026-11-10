package questao2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class StrategyConveniado implements StrategyCobranca {

    public static final int MINUTOS_GRATUITOS = 30;

    public static final BigDecimal VALOR_POR_HORA_INICIADA = new BigDecimal("6.00");

    public static final BigDecimal PERCENTUAL_DESCONTO = new BigDecimal("0.20");

    @Override
    public String getNome() {
        return "Conveniado";
    }

    @Override
    public BigDecimal calcularValor(Ticket ticket) {
        int minutosExcedentes = ticket.getMinutosPermanencia() - MINUTOS_GRATUITOS;
        int horasIniciadas = TempoCobranca.horasIniciadas(minutosExcedentes);

        BigDecimal valorBase = VALOR_POR_HORA_INICIADA.multiply(BigDecimal.valueOf(horasIniciadas));
        BigDecimal desconto = valorBase.multiply(PERCENTUAL_DESCONTO);

        return valorBase.subtract(desconto).setScale(2, RoundingMode.HALF_UP);
    }
}
