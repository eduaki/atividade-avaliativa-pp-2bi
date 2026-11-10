package questao3;

public class BebidaComComplemento implements Bebida {

    private static final String SEPARADOR = " + ";

    private final Bebida bebida;
    private final Complemento complemento;

    public BebidaComComplemento(Bebida bebida, Complemento complemento) {
        if (bebida == null) {
            throw new IllegalArgumentException("A bebida é obrigatória.");
        }
        if (complemento == null) {
            throw new IllegalArgumentException("O complemento é obrigatório.");
        }
        this.bebida = bebida;
        this.complemento = complemento;
    }

    @Override
    public String getDescricao() {
        return bebida.getDescricao() + SEPARADOR + complemento.getNome();
    }

    @Override
    public double getPreco() {
        return bebida.getPreco() + complemento.getPreco();
    }

    public Bebida getBebida() {
        return bebida;
    }

    public Complemento getComplemento() {
        return complemento;
    }
}
