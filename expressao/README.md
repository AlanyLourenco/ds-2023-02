Princípio da Abertura/Fechamento (Open/Closed Principle): Ao separar as operações matemáticas em classes diferentes, você torna o código mais aberto para extensões, mas fechado para modificações. Isso adere ao princípio de que o código deve ser aberto para estender (você pode adicionar novas operações facilmente) e fechado para modificações (não é necessário alterar as classes existentes para adicionar novas operações).

Princípio da Responsabilidade Única (Single Responsibility Principle): Cada classe tem uma única responsabilidade, que é a de realizar uma operação matemática específica. Isso mantém as classes focadas e coesas.

Princípio da Interface Segregada (Interface Segregation Principle): A interface Expressao possui uma única operação valor(), que é apropriada para as classes que a implementam. Isso evita a necessidade de classes implementarem métodos que não são relevantes para elas.

Padrão Decorator: O uso do padrão Decorator é uma lição valiosa. Ele permite que você adicione funcionalidades a objetos em tempo de execução, sem modificar suas estruturas de classes. Isso promove a flexibilidade e a extensibilidade do código.

Complexidade Ciclomática: A preocupação com a complexidade ciclomática é uma lição de design de software importante. Manter a complexidade sob controle ajuda a tornar o código mais legível e mantível.

Modularidade e Reutilização: A divisão das operações em classes separadas promove a reutilização de código. Você pode reutilizar as classes Soma, Subtrai, Multiplica e Divide em diferentes partes do sistema, se necessário.

