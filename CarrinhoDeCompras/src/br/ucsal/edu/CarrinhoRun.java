package br.ucsal.edu;

import java.util.Scanner;

public class CarrinhoRun {

	public static void main(String[] args) {
		
	    // Criando alguns produtos
		Produto produto1 = new Produto(1, "Livro 'Clean Code'", 40.0, 10);
		Produto produto2 = new Produto(2, "Teclado Mecânico", 150.0, 20);
		Produto produto3 = new Produto(3, "Mouse", 30.0, 15);

	    // Criando um carrinho
	    Carrinho carrinho = new Carrinho();

	    // Criando um Scanner para ler a entrada do usuário
	    Scanner scanner = new Scanner(System.in);

	    // Rodando o programa em um loop até que o usuário decida sair
	    while (true) {
	        System.out.println("Por favor, escolha uma opção:");
	        System.out.println("1. Adicionar produto ao carrinho");
	        System.out.println("2. Realizar o checkout");
	        System.out.println("3. Sair");
	        int opcao = scanner.nextInt();

	        switch (opcao) {
	        case 1:
	            System.out.println("Por favor, escolha um produto para adicionar ao carrinho:");
	            System.out.println("1. " + produto1.getNome());
	            System.out.println("2. " + produto2.getNome());
	            System.out.println("3. " + produto3.getNome());
	            int produtoEscolhido = scanner.nextInt();
	            int quantidade = 0;
	            switch (produtoEscolhido) {
                case 1:
                	System.out.println("Quantos você gostaria de adicionar ao carrinho?");
                    quantidade = scanner.nextInt();
                    carrinho.adicionarProduto(produto1, quantidade);
                    break;
                case 2:
                	System.out.println("Quantos você gostaria de adicionar ao carrinho?");
                    quantidade = scanner.nextInt();
                    carrinho.adicionarProduto(produto2, quantidade);
                    break;
                case 3:
                	System.out.println("Quantos você gostaria de adicionar ao carrinho?");
                    quantidade = scanner.nextInt();
                    carrinho.adicionarProduto(produto3, quantidade);
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
                    break;
            }
            break;
	            
	            
	        case 2: 
	        carrinho.checkout();
	        break;
	        case 3:
	            System.out.println("Obrigado por usar nosso sistema de carrinho de compras!");
	            return;
	        default:
	            System.out.println("Opção inválida. Por favor, tente novamente.");
	            break;
	        }
	    }
	}


}
