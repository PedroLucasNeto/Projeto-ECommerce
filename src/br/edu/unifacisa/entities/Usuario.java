package br.edu.unifacisa.entities;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	public static int geradorId = 0;
	public int quantidadeClientes;

	private int id;
	private String nome;
	private List<Endereco> enderecos = new ArrayList<>();
	private String login;
	private String senha;
	private double saldo;
	TipoUsuario tipoUsuario;

	public Usuario() {
		this.saldo = 0;
	}
	
	public Usuario(String nome, String login, String senha, TipoUsuario tipoUsuario) {
		this.id = 0;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.tipoUsuario = tipoUsuario;
		this.saldo = 0;
	}

	public Usuario(String nome, String login, String senha, TipoUsuario tipoUsuario, Endereco endereco) {
		this.id = 0;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.tipoUsuario = tipoUsuario;
		this.enderecos.add(endereco);
		this.saldo = 0;
	}

	public void geraId() {
		this.id = geradorId + 1;
		geradorId++;
	}

	public int getId() {
		return this.id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return this.nome;
	}

	public void adicionaEndereco(Endereco endereco) {
		this.enderecos.add(endereco);
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getLogin() {
		return this.login;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}


	@Override
	public String toString() {
		return "ID do Cliente: " + id + "\nNome: " + nome + "\nLogin: " + login + "\nSenha: " + senha
				+ "\nTipo de usuario:" + tipoUsuario + "\nEndereços: " + enderecos;
	}

	public double getSaldo() {
		return saldo;
	}
}
