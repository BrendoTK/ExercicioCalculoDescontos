public class DescontoPercentualDefinido implements DescontoStrategy {
    private final double percentual;

    public DescontoPercentualDefinido(double percentual) {
        this.percentual = percentual;
    }

    @Override
    public double calcularDesconto(Venda venda) {
        return venda.getValorTotal() * (percentual / 100);
    }
}