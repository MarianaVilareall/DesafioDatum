# language: pt

Funcionalidade: Teste da Compra de produtos
  Como usuário
  Eu quero fazer a compra de ao menos três produto
  Para que eu possa estar bem vestida

  Cenario: Realizando compra dos produtos
    Dado que estou no site e-commerce
    Quando informo o usuário "mariana.vilareal@hotmail.com"
    E a senha "Devo31VM@"
    E seleciono entrar
    Quando eu seleciono o primeiro item
    E seleciono o segundo item
    E seleciono o terceiro item
    Entao vejo que os itens foram adicionados com sucesso ao carrinho
