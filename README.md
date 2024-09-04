Cálculo de Descontos
1. Qual padrão de projeto pode ser utilizado no desenvolvimento de uma solução?
O padrão de projeto que pode ser utilizado é o Strategy Pattern. Esse padrão permite definir uma família de algoritmos, encapsulá-los e torná-los intercambiáveis. No contexto do sistema de cálculo de descontos, cada tipo de desconto é uma estratégia diferente que pode ser aplicada a uma venda. O Strategy Pattern facilita a adição de novas estratégias de desconto sem modificar o código existente, promovendo a extensibilidade e a manutenção do código.
2. Como poderíamos implementar estes tipos de desconto sem utilizar Padrões de Projetos?
Sem utilizar padrões de projeto, poderíamos implementar os tipos de desconto utilizando uma série de condicionais (if-else ou switch) diretamente na classe Venda.
Por exemplo:
public class Venda {
    private long id;
    private Cliente cliente;
    private LocalDate data;
    private double valorTotal;
    private String tipoDesconto;

    public Venda() {/**/}

    public Venda(Cliente cliente, LocalDate data, double valorTotal) {
        this.cliente = cliente;
        this.data = data;
        this.valorTotal = valorTotal;
    }

    // getters e setters

    public double aplicarDesconto() {
        double desconto = 0;
        if ("percentualDefinido".equals(tipoDesconto)) {
            desconto = valorTotal * 0.10; // Exemplo: 10% de desconto
        } else if ("progressivo".equals(tipoDesconto)) {
            desconto = valorTotal / 25;
            if (desconto > valorTotal * 0.20) {
                desconto = valorTotal * 0.20;
            }
        } else if ("aniversario".equals(tipoDesconto)) {
            if (data.equals(cliente.getDataNascimento())) {
                desconto = valorTotal * 0.15;
            }
        }
        return desconto;
    }
}
3. Quais os problemas que tal implementação traria?
Implementar os tipos de desconto sem utilizar padrões de projeto como o Strategy Pattern pode trazer vários problemas:
Código Complexo e Difícil de Manter:
Com o crescimento do número de tipos de desconto, o método aplicarDesconto ficaria cada vez mais complexo e difícil de manter. Adicionar um novo tipo de desconto exigiria a modificação do método, aumentando o risco de introduzir bugs.
Violação do Princípio de Responsabilidade Única (SRP):
A classe Venda assumiria responsabilidades extras além de suas responsabilidades primárias, violando o Princípio de Responsabilidade Única (SRP) do SOLID. A classe deveria se concentrar em representar uma venda e não em calcular descontos.
Dificuldade de Testes Unitários:
O código se tornaria mais difícil de testar isoladamente. Cada vez que um novo tipo de desconto fosse adicionado ou modificado, os testes para Venda precisariam ser atualizados para cobrir todas as ramificações do código.
Baixa Extensibilidade:
Adicionar novos tipos de desconto exigiria mudanças na classe Venda, tornando o código menos extensível. O Strategy Pattern permite adicionar novos algoritmos de desconto sem modificar o código existente.
Repetição de Código:
Se o cálculo de desconto fosse necessário em vários lugares, o código de cálculo do desconto teria que ser duplicado ou os métodos teriam que ser refatorados repetidamente.
Usar o Strategy Pattern resolve esses problemas encapsulando cada algoritmo de desconto em sua própria classe, promovendo a modularidade, a reutilização de código, e facilitando a adição de novos algoritmos de desconto sem modificar o código existente.
