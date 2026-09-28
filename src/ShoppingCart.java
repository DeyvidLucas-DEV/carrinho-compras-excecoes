import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> produtos = new ArrayList<>();
    private double total;

    public void addItem(Product p) throws ProdutoIndisponivelException {
        if (p.getEstoque() == 0) {
            throw new ProdutoIndisponivelException(p.getNome());
        }
        produtos.add(p);
        total += p.getPreco();
        System.out.println(p.getNome() + " adicionado ao carrinho.");
    }

    public void checkout(double saldoDisponivel) throws SaldoInsuficienteException {
        if (total > saldoDisponivel) {
            throw new SaldoInsuficienteException(total - saldoDisponivel);
        }
        System.out.println("Compra finalizada! Total: R$" + total);
    }

    public List<Product> getProdutos() {
        return produtos;
    }

    public double getTotal() {
        return total;
    }
}
