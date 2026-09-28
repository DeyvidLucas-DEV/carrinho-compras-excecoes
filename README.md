# Carrinho de Compras com Tratamento de Exceções

Aluno: Deyvid Lucas da Cunha Amorim
RGM: 34040722

Disciplina: Paradigmas de Linguagens de Programação
Tema: Herança e Exceções

## Classes

- `EcommerceException`
- `ProdutoIndisponivelException`
- `SaldoInsuficienteException`
- `Product`
- `ShoppingCart`
- `Main`

## O que foi usado

- Exceções checadas: as três exceções herdam de `Exception`, então precisam ser declaradas com `throws`.
- `addItem()` e `checkout()` declaram no cabeçalho a exceção que podem lançar e usam `throw` quando detectam o erro.
- `finalizarPedido()` na `Main` chama `checkout()` e por isso também declara `throws SaldoInsuficienteException`, mesmo sem ter `throw` no corpo. A exceção é propagada até o `main`, onde é tratada.
- Blocos `try`, `catch` e `finally` no `main`.

## Como executar

```
cd src
javac *.java
java Main
```

## Resposta do Desafio Extra

A ordem importa porque o Java verifica os catches de cima para baixo e usa o primeiro que for compatível. Como `ProdutoIndisponivelException` e `SaldoInsuficienteException` são filhas de `EcommerceException`, se o catch da classe base viesse primeiro ele pegaria tudo e os catches específicos nunca seriam alcançados, e o compilador acusa erro. Por isso o mais genérico tem que ficar por último.
