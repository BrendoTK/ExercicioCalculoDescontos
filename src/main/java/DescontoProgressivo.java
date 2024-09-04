public class DescontoProgressivo implements DescontoStrategy {
    @Override
    public double calcularDesconto(Venda venda) {
        double desconto = venda.getValorTotal() / 25;
        return Math.min(desconto, venda.getValorTotal() * 0.20);
    }
}