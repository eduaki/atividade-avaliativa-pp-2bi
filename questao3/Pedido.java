package questao3;

public class Pedido {

    private Bebida bebida;

    public Pedido(Bebida bebidaBase) {
        if (bebidaBase == null) {
            throw new IllegalArgumentException("A bebida base é obrigatória.");
        }
        this.bebida = bebidaBase;
    }

    public void adicionarComplemento(Complemento complemento) {
        if (complemento == null) {
            throw new IllegalArgumentException("O complemento é obrigatório.");
        }
        this.bebida = complemento.aplicarEm(bebida);
    }

    public String getDescricao() {
        return bebida.getDescricao();
    }

    public double getPreco() {
        return bebida.getPreco();
    }
}
