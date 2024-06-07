# Sistema de Vendas em Java 🛒

Este é um projeto de implementação de um sistema de vendas em Java, com interface gráfica usando Swing. O sistema permite que os usuários visualizem uma vitrine de produtos, adicionem itens ao carrinho, visualizem o carrinho, realizem o pagamento e efetuem o logout.

[![Logomarca da Loja](urbanTrends/imagens/logo_ut.png)](https://raw.githubusercontent.com/lucas-novaesm/Trabalho-final-de-LP-POO/main/urbanTrends/imagens/logo_ut.png)

## Funcionalidades:

### Tela de Vitrine de Produtos 🛍️:

- Exibe uma grade de produtos disponíveis para venda.
- Cada produto é representado por uma imagem, nome, preço e opção para adicionar ao carrinho.
- Os produtos são carregados a partir de um estoque pré-definido.

### Adição de Produtos ao Carrinho ➕:

- Os usuários podem selecionar produtos na vitrine e adicionar ao carrinho.
- Eles podem escolher o tamanho do produto, se aplicável.

### Tela do Carrinho 🛒:

- Exibe todos os itens atualmente no carrinho, incluindo a imagem, nome, preço, quantidade e subtotal de cada item.
- Permite que os usuários visualizem o total do carrinho.
- Oferece opções para esvaziar o carrinho ou prosseguir para o pagamento.

### Pagamento 💳:

- Ao prosseguir para o pagamento, os usuários são redirecionados para uma tela de pagamento onde podem inserir suas informações de pagamento.
- Após o pagamento ser concluído com sucesso, o carrinho é esvaziado e uma mensagem de confirmação é exibida.

### Logout 🔐:

- Os usuários têm a opção de fazer logout do sistema a qualquer momento.
- Ao fazer logout, eles são redirecionados para a tela de login.

## Funcionamento do Código 💻:

- O sistema é composto por várias classes Java que se comunicam para fornecer funcionalidades específicas.
- As classes principais incluem `TelaPrincipal`, `TelaCarrinho`, `TelaPagamento`, `TelaLogin`, `Carrinho`, `Estoque`, `Produto` e `ItemVenda`.
- O código faz uso extensivo do pacote `javax.swing` para criar a interface gráfica do usuário.
- O estoque de produtos é carregado a partir de um arquivo de dados.
- As interações do usuário são tratadas por meio de `ActionListeners` associados a botões e outros componentes de interface.

## Vídeo de Demonstração 🎥

https://github.com/lucas-novaesm/Trabalho-final-de-LP-POO/assets/122632100/bbad5825-63b1-4501-8b3c-fdfe238505e2


## Como Rodar o Projeto ▶️:

1. Certifique-se de ter o JDK (Java Development Kit) instalado em sua máquina.
2. Clone este repositório.
3. Importe o projeto em sua IDE Java favorita.
4. Compile o código-fonte.
5. Execute a classe `TelaLogin` para iniciar o sistema.
6. Faça login com as credenciais apropriadas ou crie uma nova conta.
7. Explore a vitrine de produtos, adicione itens ao carrinho, realize o pagamento e divirta-se fazendo compras!

Este projeto demonstra a implementação de um sistema de vendas simples em Java, com uma interface gráfica intuitiva e funcionalidades essenciais para uma experiência de compra agradável.
