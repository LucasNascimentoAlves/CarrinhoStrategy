package br.ucsal.edu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Carrinho {
	
	// Criando um objeto Scanner para ler a entrada do usuário
	Scanner sc = new Scanner(System.in);

	// Inicializando um Map para armazenar os produtos no carrinho
	private Map<Produto, Integer> produtos = new HashMap<>();

	// Estratégia de pagamento
	private PagamentoStrategy pagamentoStrategy;

	// Método para adicionar um produto ao carrinho
	public void adicionarProduto(Produto produto, int quantidade) {
	    // Verificando se o produto não é nulo e se há estoque disponível
	    if (produto != null && produto.getEstoque() >= quantidade) {
	        // Adicionando o produto ao carrinho ou incrementando a quantidade se já estiver no carrinho
	        produtos.put(produto, produtos.getOrDefault(produto, 0) + quantidade);
	        // Reduzindo o estoque do produto
	        produto.removerEstoque(quantidade);
	        System.out.println("Adicionado " + quantidade + " do produto " + produto.getNome() + " ao carrinho.");
	    } else {
	        System.out.println("Produto indisponível ou inválido para adição ao carrinho.");
	    }
	}

	// Método para remover um produto do carrinho
	public void removerProduto(Produto produto) {
		// Verificando se o produto está no carrinho e se a quantidade é maior que zero
		if (produtos.containsKey(produto) && produtos.get(produto) > 0) {
			// Reduzindo a quantidade do produto no carrinho ou removendo completamente se a quantidade for 1
			produtos.put(produto, produtos.get(produto) - 1);
			// Aumentando o estoque do produto
			produto.adicionarEstoque(1);
			System.out.println("Produto removido do carrinho: " + produto.getNome());
		} else {
			System.out.println("O produto não está no carrinho.");
		}
	}

	// Método para calcular o total do carrinho
	public double calcularTotal() {
		double total = 0.0;
		// Iterando sobre cada produto no carrinho
		for (Map.Entry<Produto, Integer> entry : produtos.entrySet()) {
			// Adicionando o preço do produto multiplicado pela quantidade ao total
			total += entry.getKey().getPreco() * entry.getValue();
		}
		return total;
	}

	// Método para realizar o checkout
	public void checkout() {
	    System.out.println("O total do seu carrinho é: R$" + calcularTotal());
	    System.out.println("Por favor, escolha seu método de pagamento:");
	    System.out.println("1. Cartão de crédito");
	    System.out.println("2. Cartão de débito");
	    System.out.println("3. Pix");

	    // Lendo a escolha do usuário
	    int escolha = sc.nextInt();

	    // Definindo a estratégia de pagamento de acordo com a escolha do usuário
	    switch (escolha) {
	        case 1:
	            setPagamentoStrategy(new CartaoCreditoStrategy());
	            break;
	        case 2:
	            setPagamentoStrategy(new CartaoDebitoStrategy());
	            break;
	        case 3:
	            setPagamentoStrategy(new PixStrategy());
	            break;
	        default:
	            System.out.println("Escolha inválida. Por favor, tente novamente.");
	            checkout();
	            return;
	    }

	    // Realizando o pagamento e limpando o carrinho após o checkout
	    if (pagamentoStrategy != null) {
	        pagamentoStrategy.pagar(calcularTotal());
	        produtos.clear();
	    } else {
	        System.out.println("Por favor, escolha um método de pagamento.");
	    }
	}

	// Método para definir a estratégia de pagamento
	public void setPagamentoStrategy(PagamentoStrategy pagamentoStrategy) {
	    this.pagamentoStrategy = pagamentoStrategy;
	}

	// Sobrescrevendo o método toString para retornar uma representação em string do carrinho
	@Override
	public String toString() {
		return "Carrinho [produtos=" + produtos + "]";
	}
}
