package br.edu.unifacisa.entities;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
	
	private List<Produto> produtos = new ArrayList<>();
	
	
	public 	Carrinho() {
		
	}
	
	public Carrinho(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	
	public void adicionaProdutoNoCarrinho(Produto produto) {
		produtos.add(produto);
	}

}
