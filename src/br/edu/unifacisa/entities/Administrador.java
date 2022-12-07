package br.edu.unifacisa.entities;

import br.edu.unifacisa.enums.TipoUsuario;

public class Administrador extends Usuario{

	public Administrador(String nome, String login, String senha, TipoUsuario tipoUsuario) {
		super(nome, login, senha, tipoUsuario);
	}

}
