package ecommerce;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import product.model.InfosDoProduto;
import conta.controller.ProdutoController;

public class Menu {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		ProdutoController produtoController = new ProdutoController();

		int opcao;

		while (true) {

			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                    GenShop                          ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Cadastrar                            ");
			System.out.println("            2 - Buscar                               ");
			System.out.println("            3 - Atualizar                            ");
			System.out.println("            4 - Excluir                              ");
			System.out.println("            0 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Digite a opção desejada:                             ");

			opcao = scanner.nextInt();
			scanner.nextLine();

			if (opcao == 0) {
				System.out.println("\nGenShop - Tudo em um só clique!");
				sobre();
				scanner.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println("Cadastrar Produto\n");

				System.out.print("Digite o nome do produto: ");
				String nome = scanner.nextLine();

				System.out.print("Digite o preço do produto: ");
				double preco = scanner.nextDouble();
				scanner.nextLine();

				System.out.print("Digite a categoria do produto: ");
				String categoria = scanner.nextLine();

				System.out.print("Digite a marca do produto: ");
				String marca = scanner.nextLine();

				System.out.print("Digite a quantidade em estoque: ");
				int estoque = scanner.nextInt();

				int idProduto = produtoController.gerarNumero();

				InfosDoProduto novoProduto = new InfosDoProduto(idProduto, nome, preco, categoria, marca, estoque);

				produtoController.cadastrar(novoProduto);

				break;

			case 2:
				System.out.println("Listar todos os produtos\n");

				produtoController.listarTodas();

				break;

			case 3:
				System.out.println("Atualizar Produto\n");

				System.out.print("Digite o ID do produto que deseja atualizar: ");
				int idParaAtualizar = scanner.nextInt();
				scanner.nextLine();

				InfosDoProduto produtoExistente = (InfosDoProduto) produtoController.procurarPorId(idParaAtualizar);

				if (produtoExistente != null) {

					System.out
							.print("Digite o novo nome do produto (atualmente: " + produtoExistente.getNome() + "): ");
					String novoNome = scanner.nextLine();

					System.out.print(
							"Digite o novo preço do produto (atualmente: " + produtoExistente.getPreco() + "): ");
					double novoPreco = scanner.nextDouble();
					scanner.nextLine();

					System.out.print("Digite a nova categoria do produto (atualmente: "
							+ produtoExistente.getCategoria() + "): ");
					String novaCategoria = scanner.nextLine();

					System.out.print(
							"Digite a nova marca do produto (atualmente: " + produtoExistente.getMarca() + "): ");
					String novaMarca = scanner.nextLine();

					System.out.print("Digite a nova quantidade em estoque (atualmente: " + produtoExistente.getEstoque()
							+ "): ");
					int novoEstoque = scanner.nextInt();

					InfosDoProduto produtoAtualizado = new InfosDoProduto(idParaAtualizar, novoNome, novoPreco,
							novaCategoria, novaMarca, novoEstoque);
					produtoController.atualizar(produtoAtualizado);
				} else {
					System.out.println("\nProduto não encontrado!");
				}

				break;

			case 4:
				System.out.println("Excluir Produto\n");

				System.out.print("Digite o ID do produto que deseja excluir: ");
				int idParaExcluir = scanner.nextInt();

				produtoController.deletar(idParaExcluir);

				break;

			default:
				System.out.println("\nOpção Inválida!\n");
				break;
			}
		}
	}

	public static void sobre() {
		System.out.println("GenShop - Plataforma de E-commerce");
	}
}
