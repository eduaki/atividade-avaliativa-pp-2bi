package questao2;

public final class TempoCobranca {

    public static final int MINUTOS_POR_HORA = 60;

    private TempoCobranca() {
    }

    public static int horasIniciadas(int minutos) {
        if (minutos <= 0) {
            return 0;
        }
        return (minutos + MINUTOS_POR_HORA - 1) / MINUTOS_POR_HORA;
    }
}
