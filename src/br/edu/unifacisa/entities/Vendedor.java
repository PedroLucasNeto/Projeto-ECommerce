package br.edu.unifacisa.entities;

import java.util.ArrayList;
import java.util.List;

import br.edu.unifacisa.enums.TipoUsuario;

public class Vendedor extends Usuario{
	
	private List<Endereco> enderecos;
	
	private List<Produto> estoque;

	private double saldo;

	public Vendedor(double saldo) {
		super();
		this.saldo = saldo;
		this.enderecos = new ArrayList<>();
		this.estoque = new ArrayList<>();
	}

	public Vendedor() {
		this.enderecos = new ArrayList<>();
		this.estoque = new ArrayList<>();
	}

	public Vendedor(String nome, String login, String senha, TipoUsuario tipoUsuario) {
		super(nome, login, senha, tipoUsuario);
		this.enderecos = new ArrayList<>();
		this.estoque = new ArrayList<>();
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Endereco endereco) {
		this.enderecos.add(endereco);
	}

	public double getSaldo() {
		return saldo;
	}
	
	public List<Produto> getEstoque() {
		return estoque;
	}

	public void setEstoque(Produto produto) {
		this.estoque.add(produto);
	}
	
	
}
