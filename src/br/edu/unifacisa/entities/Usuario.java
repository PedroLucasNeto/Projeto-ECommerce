package br.edu.unifacisa.entities;

import br.edu.unifacisa.enums.TipoUsuario;

public class Usuario {
	public static int geradorId = 0;

	private int id;
	private String nome;
	private String login;
	private String senha;
	private TipoUsuario tipoUsuario;
	public Usuario() {
		
	}

	public Usuario(String nome, String login, String senha, TipoUsuario tipoUsuario) {
		this.id = 0;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.tipoUsuario = tipoUsuario;
	}

	public Usuario(String nome, String login, String senha, Endereco endereco) {
		this.id = 0;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
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
		return "ID do Cliente: " + id + "\nNome: " + nome + "\nLogin: " + login + "\nSenha: " + senha;
	}


	
	

}
