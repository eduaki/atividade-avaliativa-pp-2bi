package questao1;

public class Main {

    public static void main(String[] args) {
        Produto notebook = new Produto("Notebook Gamer", 10);

        StrategyCompras compras = new StrategyCompras();
        StrategyVendas vendas = new StrategyVendas();
        StrategyAuditoria auditoria = new StrategyAuditoria();

        notebook.adicionarStrategy(compras);
        notebook.adicionarStrategy(vendas);
        notebook.adicionarStrategy(auditoria);

        System.out.println("=== 1) Estoque inicial: " + notebook.getQuantidade() + " unidades ===");
        System.out.println();

        System.out.println("=== 2) Venda de 7 unidades (abaixo do mínimo) ===");
        notebook.alterarQuantidade(3);
        System.out.println();

        System.out.println("=== 3) Tentativa de alterar para 3 (mesma quantidade, sem comunicação) ===");
        notebook.alterarQuantidade(3);
        System.out.println();

        System.out.println("=== 4) Venda de todo o estoque ===");
        notebook.alterarQuantidade(0);
        System.out.println();

        System.out.println("=== 5) Reposição de 8 unidades (volta ao estoque) ===");
        notebook.alterarQuantidade(8);
        System.out.println();

        System.out.println("=== 6) Removendo a área de Compras ===");
        notebook.removerStrategy(compras);
        System.out.println();

        System.out.println("=== 7) Nova queda para 2 unidades (Compras não é mais notificada) ===");
        notebook.alterarQuantidade(2);
        System.out.println();

        System.out.println("=== Registros da Auditoria ===");
        auditoria.getRegistros().forEach(registro -> System.out.println("- " + registro));
    }
}
