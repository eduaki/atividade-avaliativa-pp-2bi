package questao3;

public class Main {

    public static void main(String[] args) {
        Pedido pedido1 = new Pedido(new Espresso());
        pedido1.adicionarComplemento(new Leite());
        pedido1.adicionarComplemento(new Chantilly());

        Pedido pedido2 = new Pedido(new Cha());
        pedido2.adicionarComplemento(new Calda());
        pedido2.adicionarComplemento(new Calda());

        Pedido pedido3 = new Pedido(new Espresso());
        pedido3.adicionarComplemento(new Leite());
        pedido3.adicionarComplemento(new Leite());
        pedido3.adicionarComplemento(new Calda());
        pedido3.adicionarComplemento(new Chantilly());

        exibir("Pedido 1", pedido1);
        exibir("Pedido 2", pedido2);
        exibir("Pedido 3", pedido3);
    }

    private static void exibir(String rotulo, Pedido pedido) {
        System.out.printf("%s: %s | Total: %s%n", rotulo, pedido.getDescricao(), formatar(pedido.getPreco()));
    }

    private static String formatar(double valor) {
        long centavos = Math.round(valor * 100);
        return "R$ " + (centavos / 100) + "," + String.format("%02d", centavos % 100);
    }
}
