package questao1;

public class Main {

    public static void main(String[] args) {
        Produto notebook = new Produto("Notebook Gamer", 10);

        ObserverCompras compras = new ObserverCompras();
        ObserverVendas vendas = new ObserverVendas();
        ObserverAuditoria auditoria = new ObserverAuditoria();

        notebook.adicionarObserver(compras);
        notebook.adicionarObserver(vendas);
        notebook.adicionarObserver(auditoria);

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
        notebook.removerObserver(compras);
        System.out.println();

        System.out.println("=== 7) Nova queda para 2 unidades (Compras não é mais notificada) ===");
        notebook.alterarQuantidade(2);
        System.out.println();

        System.out.println("=== Registros da Auditoria ===");
        auditoria.getRegistros().forEach(registro -> System.out.println("- " + registro));
    }
}
