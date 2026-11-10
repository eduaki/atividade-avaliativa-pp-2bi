package questao3;

public abstract class Complemento {

    private final String nome;
    private final double preco;

    protected Complemento(String nome, double preco) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do complemento é obrigatório.");
        }
        if (preco < 0) {
            throw new IllegalArgumentException("O preço do complemento não pode ser negativo.");
        }
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public Bebida aplicarEm(Bebida bebida) {
        return new BebidaComComplemento(bebida, this);
    }
}
