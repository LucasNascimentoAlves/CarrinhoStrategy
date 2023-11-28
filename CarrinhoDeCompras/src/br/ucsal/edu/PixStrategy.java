package br.ucsal.edu;

import java.util.UUID;

public class PixStrategy implements PagamentoStrategy {
	@Override
	public void pagar(double total) {
	    System.out.println("Pagando R$" + total + " com Pix.");
	    String chavePix = gerarChavePix();
	    System.out.println("Use a seguinte chave Pix para realizar o pagamento: " + chavePix);
	    try {
	        // Fazendo a thread atual dormir por 10 segundos
	        Thread.sleep(10000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
	    System.out.println("Pagamento com Pix processado.");
	}

    private String gerarChavePix() {
        return UUID.randomUUID().toString();
    }
}
