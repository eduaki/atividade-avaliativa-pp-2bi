package questao2;

public class Main {

    public static void main(String[] args) {
        StrategyCobranca rotativo = new StrategyRotativo();
        StrategyCobranca mensalista = new StrategyMensalista();
        StrategyCobranca conveniado = new StrategyConveniado();

        int permanencia = 135;

        System.out.println("=== 1) Mesmo tempo de permanência (" + permanencia + " min) nos três perfis ===");
        exibir(new Ticket("ABC-1234", permanencia, rotativo));
        exibir(new Ticket("ABC-1234", permanencia, mensalista));
        exibir(new Ticket("ABC-1234", permanencia, conveniado));
        System.out.println();

        System.out.println("=== 2) Troca de perfil no mesmo tíquete (placa ABC-1234, " + permanencia + " min) ===");
        Ticket ticket = new Ticket("ABC-1234", permanencia, rotativo);
        exibir(ticket);
        ticket.alterarStrategy(mensalista);
        exibir(ticket);
        ticket.alterarStrategy(conveniado);
        exibir(ticket);
        System.out.println();

        int permanenciaCurta = 25;
        System.out.println("=== 3) Permanência curta (" + permanenciaCurta + " min) nos três perfis ===");
        exibir(new Ticket("ABC-1234", permanenciaCurta, rotativo));
        exibir(new Ticket("ABC-1234", permanenciaCurta, mensalista));
        exibir(new Ticket("ABC-1234", permanenciaCurta, conveniado));
        System.out.println();

        int permanenciaExata = 180;
        System.out.println("=== 4) Permanência exata de " + permanenciaExata + " min nos três perfis ===");
        exibir(new Ticket("ABC-1234", permanenciaExata, rotativo));
        exibir(new Ticket("ABC-1234", permanenciaExata, mensalista));
        exibir(new Ticket("ABC-1234", permanenciaExata, conveniado));
    }

    private static void exibir(Ticket ticket) {
        System.out.printf("Placa %s | Perfil %-11s | %3d min | %s%n",
                ticket.getPlaca(),
                ticket.getStrategy().getNome(),
                ticket.getMinutosPermanencia(),
                Moeda.formatar(ticket.calcularValor()));
    }
}
