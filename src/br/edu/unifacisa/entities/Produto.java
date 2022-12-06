package br.edu.unifacisa.entities;

public class Produto {

	private static int codigo;

	private int id;

	private double preco;

	private String descricao;

	private String marca;

	public Produto() {

	}

	public int getId() {
		return id;
	}

	public void geraId() {
		this.id = codigo + 1;
		codigo++;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public String toString() {
		return "ID do produto: " + id + "\nDescricao: " + descricao + "\nPreço: " + preco + "\nMarca: " + marca + "\n";
	}

}
