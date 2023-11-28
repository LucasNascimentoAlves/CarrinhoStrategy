package br.ucsal.edu;

import java.util.Scanner;

public class CartaoDebitoStrategy implements PagamentoStrategy {
    @Override
    public void pagar(double total) {
        System.out.println("Pagando R$" + total + " com cartão de débito.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor, insira o número do seu cartão de débito:");
        String numeroCartao = scanner.nextLine();
        System.out.println("Por favor, insira o nome do titular do cartão:");
        String nomeTitular = scanner.nextLine();
        System.out.println("Por favor, insira a data de validade do cartão (MM/AA):");
        String dataValidade = scanner.nextLine();
        System.out.println("Por favor, insira o CVV do cartão:");
        String cvv = scanner.nextLine();
        System.out.println("Pagamento com cartão de débito processado.");
    }
}
