package br.edu.unifacisa.entities;

import java.util.ArrayList;
import java.util.List;

public class ECommerce {

	private List<Usuario> usuarios = new ArrayList<>();

	private List<Categoria> categorias = new ArrayList<>();
	
	private List<Produto> produtos = new ArrayList<>();

	public ECommerce() {

	}

	public void listaCategoriasEProdutos() {
		for (Categoria categoria : categorias) {
			System.out.println(categoria);
		}
	}

	public void listaCategorias() {
		for (Categoria categoria : categorias) {
			System.out.println(categoria.getNome());
		}
	}

	public void adicionaCategoria(Categoria categoria) {
		this.categorias.add(categoria);
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void adicionaUsuario(Usuario usuario) {
		usuario.geraId();
		usuarios.add(usuario);
	}

//	public boolean autenticaUsuario(String login, String senha) {
//		boolean autenticado = false;
//		for (Usuario usuario : usuarios) {
//			if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
//				autenticado = true;
//			}
//		}
//		return autenticado;
//	}

	public boolean encontraCategoria(String nome, Produto produto) {

		boolean categoriaEncontrada = false;

		for (Categoria categoria : categorias) {
			if (categoria.getNome().equalsIgnoreCase(nome)) {
				categoria.adicionaProdutoNaCategoria(produto);
				categoriaEncontrada = true;
			}
		}
		return categoriaEncontrada;
	}

	public boolean excluiProduto(String nome, int codigo) {
		boolean produtoRemovido = false;
		for (Categoria categoria : categorias) {
			if (categoria.getNome().equalsIgnoreCase(nome)) {
				categoria.excluiProduto(codigo);
				produtoRemovido = true;
				return produtoRemovido;
			}
		}
		return produtoRemovido;
	}

	public Usuario autenticaUsuario(String login, String senha) {
		for (Usuario usuario : usuarios) {
			if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
				return usuario;
			}
		}
		return null;
	}

	public void listaUsuarios() {
		for (Usuario usuario : usuarios) {
			System.out.println(usuario.toString());
		}
	}

	public void listaProdutos() {
		for (Categoria categoria : categorias) {
			produtos.addAll(categoria.getProdutos());
		}
		System.out.println(produtos);
		
	}
}
