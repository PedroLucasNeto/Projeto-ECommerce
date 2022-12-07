package br.edu.unifacisa.entities;

import java.util.ArrayList;
import java.util.List;

import br.edu.unifacisa.enums.TipoUsuario;

public class Cliente extends Usuario {

	private List<Endereco> enderecos;

	private List<Produto> carrinho;

	private double saldo;

	public Cliente() {
		super();
		this.enderecos = new ArrayList<>();
		this.carrinho = new ArrayList<>();
	}

	public Cliente(String nome, String login, String senha, TipoUsuario tipoUsuario) {
		super(nome, login, senha, tipoUsuario);
		this.enderecos = new ArrayList<>();
		this.carrinho = new ArrayList<>();
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

	public List<Produto> getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(Produto produto) {
		this.carrinho.add(produto);
	}
}
