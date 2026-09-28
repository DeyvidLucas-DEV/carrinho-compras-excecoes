# Carrinho de Compras com Tratamento de Exceções

Aluno: Deyvid Lucas da Cunha Amorim
RGM: 34040722

Disciplina: Programação Orientada a Objetos (Herança e Exceções)

## Classes

- `EcommerceException`
- `ProdutoIndisponivelException`
- `SaldoInsuficienteException`
- `Product`
- `ShoppingCart`
- `Main`

## Como executar

```
cd src
javac *.java
java Main
```

## Resposta do Desafio Extra

A ordem importa porque o Java verifica os catches de cima para baixo e usa o primeiro que for compatível. Como `ProdutoIndisponivelException` e `SaldoInsuficienteException` são filhas de `EcommerceException`, se o catch da classe base viesse primeiro ele pegaria tudo e os catches específicos nunca seriam alcançados, e o compilador acusa erro. Por isso o mais genérico tem que ficar por último.
