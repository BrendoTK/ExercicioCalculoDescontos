import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente(1, "Brendo Braz", LocalDate.of(2000, 9, 4));

        Venda venda = new Venda(cliente, LocalDate.now(), 1000);

        DescontoStrategy descontoStrategy;

        // Exemplo de uso com desconto percentual definido
        descontoStrategy = new DescontoPercentualDefinido(10); // 10% de desconto
        venda.setDescontoStrategy(descontoStrategy);
        System.out.println("Desconto percentual definido: " + venda.aplicarDesconto());

        // Exemplo de uso com desconto progressivo
        descontoStrategy = new DescontoProgressivo();
        venda.setDescontoStrategy(descontoStrategy);
        System.out.println("Desconto progressivo: " + venda.aplicarDesconto());

        // Exemplo de uso com desconto de aniversário
        descontoStrategy = new DescontoAniversario();
        venda.setDescontoStrategy(descontoStrategy);
        System.out.println("Desconto de aniversário: " + venda.aplicarDesconto());
    }
}