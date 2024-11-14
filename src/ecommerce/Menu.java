package ecommerce;

import java.util.Scanner;
import product.model.InfosDoProduto;



public class Menu {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

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

			if (opcao == 0) {
				System.out.println("\nGenShop - Tudo em um só clique!");
				sobre();
				scanner.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println("Cadastrar Produto\n\n");

				break;
			case 2:
				System.out.println("Listar todos os produtos\n\n");

				break;
			case 3:
				System.out.println("Excluir Produto\n\n");

				break;

			default:
				System.out.println("\nOpção Inválida!\n");
				break;
			}

		}
	}

	public static void sobre() {

	}

}
