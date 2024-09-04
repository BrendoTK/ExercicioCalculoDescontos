import java.time.LocalDate;

public class DescontoAniversario implements DescontoStrategy {
    @Override
    public double calcularDesconto(Venda venda) {
        LocalDate hoje = LocalDate.now();
        LocalDate dataNascimento = venda.getCliente().getDataNascimento();

        if (hoje.getMonth() == dataNascimento.getMonth() && hoje.getDayOfMonth() == dataNascimento.getDayOfMonth()) {
            return venda.getValorTotal() * 0.15;
        }
        return 0;
    }
}