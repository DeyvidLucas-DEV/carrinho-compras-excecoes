public class Main {

    public static void finalizarPedido(ShoppingCart cart, double saldo) throws SaldoInsuficienteException {
        System.out.println("Itens no carrinho: " + cart.getProdutos().size());
        cart.checkout(saldo);
    }

    public static void main(String[] args) {
        Product notebook = new Product("Notebook", 3500.0, 5);
        Product mouse = new Product("Mouse", 150.0, 10);
        Product teclado = new Product("Teclado", 250.0, 0);

        ShoppingCart cart = new ShoppingCart();

        System.out.println("--- Adicionando produtos ---");
        try {
            cart.addItem(notebook);
            cart.addItem(mouse);
            cart.addItem(teclado);
        } catch (ProdutoIndisponivelException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            System.out.println("Total atual do carrinho: R$" + cart.getTotal());
        }

        System.out.println("\n--- Finalizando a compra ---");
        try {
            finalizarPedido(cart, 2000.0);
        } catch (SaldoInsuficienteException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            System.out.println("Passei pelo try ou pelo catch");
        }

        System.out.println("\n--- Pegadinha: catch só com o tipo base ---");
        try {
            cart.addItem(teclado);
        } catch (EcommerceException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n--- Desafio extra: dois catches no mesmo bloco ---");
        try {
            cart.addItem(mouse);
            cart.checkout(1000.0);
        } catch (ProdutoIndisponivelException e) {
            System.out.println("Produto: " + e.getMessage());
        } catch (SaldoInsuficienteException e) {
            System.out.println("Saldo: " + e.getMessage());
        } finally {
            System.out.println("Fim do atendimento");
        }
    }
}
