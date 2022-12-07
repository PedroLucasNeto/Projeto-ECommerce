package br.edu.unifacisa.entities;

import java.util.ArrayList;
import java.util.List;

public class ECommerce {

	private List<Usuario> usuarios;

	private List<Categoria> categorias;

	private List<Produto> produtos;

	private List<NotaFiscal> notas;

	public ECommerce() {

		this.usuarios = new ArrayList<>();
		this.categorias = new ArrayList<>();
		this.produtos = new ArrayList<>();
		this.notas = new ArrayList<>();
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

	public List<NotaFiscal> getNotas() {
		return notas;
	}

	public void setNotas(NotaFiscal nota) {
		this.notas.add(nota);
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
				this.excluiProdutoGeral(codigo);
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
	
	public void excluiProdutoGeral(int codigo) {
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
}
