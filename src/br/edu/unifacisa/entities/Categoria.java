package br.edu.unifacisa.entities;

import java.util.ArrayList;
import java.util.List;

public class Categoria {

	private String nome;

	private List<Produto> produtos = new ArrayList<>();

	public Categoria() {
	}

	public Categoria(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void adicionaProdutoNaCategoria(Produto produto) {
		produtos.add(produto);
	}

	public void excluiProduto(int codigo) {
		int posicao = -1;

		for (int i = 0; i < produtos.size(); i++) {
			if (produtos.get(i).getId() == codigo) {
				posicao = i;
			}
		}
		if (posicao != -1) {
			produtos.remove(posicao);
		}
	}

	public Produto encontraProduto(int codigo) {
		Produto produto = new Produto();
		for (int i = 0; i < produtos.size(); i++) {
			if (produtos.get(i).getId() == codigo) {
				produto = produtos.get(i);
			}
		}
		return produto;
	}

//	@Override
//	public String toString() {
//		StringBuilder sb = new StringBuilder();
//		sb.append(nome.toUpperCase() + "\n");
//		for (int i = 0; i < produtos.size(); i++) {
//			sb.append(String.format("%d. %s - Preço: R$%.2f\n", i + 1, produtos.get(i).getDescricao(),
//					produtos.get(i).getPreco()));
//		}
//		return sb.toString();
//	}

//	@Override
//	public String toString() {
//		return "Categoria: " + nome + "\nProdutos: \n" + produtos + "\n";
//	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(nome.toUpperCase() + "\n");
		for (int i = 0; i < produtos.size(); i++) {
			sb.append(String.format("%d. %s - Preço: R$%.2f\n", produtos.get(i).getId(), produtos.get(i).getDescricao(),
					produtos.get(i).getPreco()));
		}
		return sb.toString();
	}

}
