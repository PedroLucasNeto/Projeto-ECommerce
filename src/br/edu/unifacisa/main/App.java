package br.edu.unifacisa.main;

import java.util.Locale;
import java.util.Scanner;

import br.edu.unifacisa.entities.Administrador;
import br.edu.unifacisa.entities.Categoria;
import br.edu.unifacisa.entities.Cliente;
import br.edu.unifacisa.entities.ECommerce;
import br.edu.unifacisa.entities.Endereco;
import br.edu.unifacisa.entities.Produto;
import br.edu.unifacisa.entities.Usuario;
import br.edu.unifacisa.entities.Vendedor;
import br.edu.unifacisa.enums.TipoUsuario;

public class App {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		Endereco endereco = new Endereco();
		ECommerce ecommerce = new ECommerce();
		Usuario administrador = new Administrador("Joao", "ppneto", "1234", TipoUsuario.ADMINISTRADOR);
		ecommerce.adicionaUsuario(administrador);
		Usuario cliente = new Cliente("Joao", "ppneto1", "1234", TipoUsuario.CLIENTE);
		ecommerce.adicionaUsuario(cliente);
		Usuario vendedor = new Vendedor("Lucas", "ppneto2", "1234", TipoUsuario.VENDEDOR);
		ecommerce.adicionaUsuario(vendedor);
		Categoria categoria1 = new Categoria("Carros");
		ecommerce.adicionaCategoria(categoria1);
		Categoria categoria2 = new Categoria("Motos");
		ecommerce.adicionaCategoria(categoria2);
		Categoria categoria = new Categoria();
		Produto produto;

		Usuario temp = new Usuario();

		System.out.println("Olá, Bem vindo(a) ao ECommerce\n1-Login\n2-Cadastro\n3-Sair.");
		int entrada1 = Integer.parseInt(scanner.nextLine());
		boolean continua = true;

		do {
			switch (entrada1) {
			case 1:
				System.out.println("Digite seu login:");
				String login = scanner.nextLine();
				System.out.println("Digite sua senha:");
				String senha = scanner.nextLine();
				temp = ecommerce.autenticaUsuario(login, senha);

				if (temp != null) {
					entrada1 = 4;
				} else {
					System.out.println("Os dados não conferem!");
				}

				break;

			case 2:
				System.out.println("Para cadastrar preencha o formulário com o que se pede:\n");
				System.out.println("1-Cliente: \n2-Vendedor: ");
				int vendedorOuCliente = Integer.parseInt(scanner.nextLine());

				if (vendedorOuCliente == 1) {

					Usuario usuario = new Cliente();
					
					System.out.println("Nome:");
					String nome = scanner.nextLine();
					usuario.setNome(nome);
					System.out.println("Login:");
					usuario.setLogin(scanner.nextLine());
					System.out.println("Senha:");
					usuario.setSenha(scanner.nextLine());
					System.out.println("--------Endereco--------\nRua:");
					endereco.setRua(scanner.nextLine());
					System.out.println("Numero:");
					endereco.setNumero(Integer.parseInt(scanner.nextLine()));
					System.out.println("Complemento:");
					endereco.setComplemento(scanner.nextLine());

					usuario.geraId();
					usuario.setTipoUsuario(TipoUsuario.CLIENTE);
					ecommerce.adicionaUsuario(usuario);

					System.out.println("Seu perfil foi criado, confira seus dados:\n" + usuario);
					temp = usuario;

					entrada1 = 4;

				} else if (vendedorOuCliente == 2) {
					Usuario usuario = new Vendedor();
					System.out.println("Nome:");

					usuario.setNome(scanner.nextLine());
					System.out.println("Login:");
					usuario.setLogin(scanner.nextLine());
					System.out.println("Senha:");
					usuario.setSenha(scanner.nextLine());
					System.out.println("--------Endereco--------\nRua:");
					endereco.setRua(scanner.nextLine());
					System.out.println("Numero:");
					endereco.setNumero(Integer.parseInt(scanner.nextLine()));
					System.out.println("Complemento:");
					endereco.setComplemento(scanner.nextLine());

					usuario.geraId();
					usuario.setTipoUsuario(TipoUsuario.VENDEDOR);
					ecommerce.adicionaUsuario(usuario);

					System.out.println("Seu perfil foi criado, confira seus dados:\n" + usuario);
					temp = usuario;

					entrada1 = 4;

				} else {
					System.out.println("Opção Inválida!");
				}
				break;
			case 3:
				System.out.println("Aplicação encerrada...\nObrigado por interagir!");
				continua = false;
				break;
			case 4:
				if (temp.getTipoUsuario().equals(TipoUsuario.ADMINISTRADOR)) {
					System.out.println("Você está logado como administrador.");
					System.out.println(
							"1-Listar Categorias:\n2-Listar Usuarios:\n3-Listar Todos os Produtos:\n4-Listar Produtos por Categoria\n5-Criar Categoria:\n6-Criar Produto:\n7-Excluir Produto"
									+ "\n8-Sair.");
					int menuAdm = Integer.parseInt(scanner.nextLine());
					switch (menuAdm) {
					case 1:
						ecommerce.listaCategorias();
						break;
					case 2:
						ecommerce.listaUsuarios();
						break;
					case 3:
						ecommerce.listaProdutos();
						break;

					case 4:
						ecommerce.listaCategoriasEProdutos();
						break;
					case 5:
						System.out.println("Qual o nome da categoria que deseja criar?");
						categoria.setNome(scanner.nextLine());
						ecommerce.adicionaCategoria(categoria);
						System.out.println("Deseja adicionar algum produto a esta categoria?(1-Sim/2-Não)");
						int adiciona = Integer.parseInt(scanner.nextLine());
						if (adiciona == 1) {
							produto = new Produto();
							System.out.println("Digite o nome do produto:");
							produto.setDescricao(scanner.nextLine());
							System.out.println("Digite a marca do produto:");
							produto.setMarca(scanner.nextLine());
							System.out.println("Digite o preço do produto:");
							produto.setPreco(Double.parseDouble(scanner.nextLine()));
							produto.geraId();
							categoria.adicionaProdutoNaCategoria(produto);

							System.out.println("Produto adicionado com sucesso!");

						} else if (adiciona == 2) {
							System.out.println("Ok!");
						} else {
							System.out.println("Opção inválida!");
						}
						break;
					case 6:
						produto = new Produto();
						System.out.println("Digite o nome do produto:");
						produto.setDescricao(scanner.nextLine());
						System.out.println("Digite a marca do produto:");
						produto.setMarca(scanner.nextLine());
						System.out.println("Digite o preço do produto:");
						produto.setPreco(Double.parseDouble(scanner.nextLine()));
						produto.geraId();
						boolean tentaAdicionar = true;
						while (tentaAdicionar) {
							System.out.println("A que categoria pertence o produto:");
							ecommerce.listaCategorias();
							String nomeCategoria = scanner.nextLine();
							boolean produtoAdicionado = ecommerce.encontraCategoria(nomeCategoria, produto);
							if (produtoAdicionado != true) {
								System.out.println();
								System.out.println("Tente novamente. Categoria não existente ou não encontrada.");
							} else {
								System.out.println("Produto adicionado com sucesso!");
								tentaAdicionar = false;
							}
						}
						break;
					case 7:
						System.out.println("\n");
						System.out.println("Em qual categoria está o produto que deseja remover?");
						ecommerce.listaCategorias();
						String nomeCategoria = scanner.nextLine();
						System.out.println("Digite o ID do produto que deseja remover?");
						int idProduto = Integer.parseInt(scanner.nextLine());
						boolean removido = ecommerce.excluiProduto(nomeCategoria, idProduto);

						if (removido) {
							System.out.println("Produto removido com sucesso!");
						} else {
							System.out.println("Não foi possível remover produto, tente novamente!");
						}

						break;
					case 8:
						System.out.println("Ok!");
						continua = false;
						break;
					}

				} else if (temp.getTipoUsuario().equals(TipoUsuario.VENDEDOR)) {
					// TODO Criar menu de vendedor

				} else if (temp.getTipoUsuario().equals(TipoUsuario.CLIENTE)) {
					System.out.println("Você está logado com cliente;");
					System.out.println(
							"1-Ver Categorias:\n2-Ver Todos os produtos:\n3-Adicionar produto ao carrinho:\n4-Ver carrinho:\n5-Sair.");
					int menuCliente = Integer.parseInt(scanner.nextLine());
					if (menuCliente == 1) {
						ecommerce.listaCategorias();
					} else if (menuCliente == 2) {
						ecommerce.listaCategoriasEProdutos();
					} else if (menuCliente == 3) {
						System.out.println("Qual é o ID do produto que você deseja adicionar ao carrinho?");
						int id = Integer.parseInt(scanner.nextLine());
						categoria.encontraProduto(id);

					} else if (menuCliente == 4) {

					} else if (menuCliente == 5) {

					} else {
						System.out.println("Opção inválida!");
					}

				} else {
					System.out.println("Não foi possível identificar seu cadastro!");
				}
				break;

			}
		} while (continua);

		scanner.close();
	}
}
