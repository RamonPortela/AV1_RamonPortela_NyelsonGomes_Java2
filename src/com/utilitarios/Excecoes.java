package com.utilitarios;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Excecoes {
	public static int lancaExcecaoOpcoesVeiculo(Scanner input, String texto, String opcoes) {
		int opcaoVeiculo = 0;
		boolean temExcecao = false;

		do {
			temExcecao = false;
			
			System.out.println(texto);
			System.out.println(opcoes);
			
			try {
				opcaoVeiculo = input.nextInt();

			} catch (InputMismatchException e) {
				Impressora.imprimeOpcaoInvalida();
				MetodosAuxiliares.pressionarEnterErro();
				input.nextLine();
				temExcecao = true;
			} catch (Exception e) {
				Impressora.imprimeErroInesperado();
				MetodosAuxiliares.pressionarEnterErro();
				input.nextLine();
				temExcecao = true;
			}
			
		} while (temExcecao);

		return opcaoVeiculo;
	}

	public static int lancaExcecaoOpcoesVeiculo(Scanner input, String texto) {
		int opcaoVeiculo = 0;
		boolean temExcecao = false;

		do {
			temExcecao = false;
			
			System.out.println(texto);
			
			try {
				opcaoVeiculo = input.nextInt();

			} catch (InputMismatchException e) {
				Impressora.imprimeOpcaoInvalida();
				MetodosAuxiliares.pressionarEnterErro();
				input.nextLine();
				temExcecao = true;
			} catch (Exception e) {
				Impressora.imprimeErroInesperado();
				MetodosAuxiliares.pressionarEnterErro();
				input.nextLine();
				temExcecao = true;
			}

		} while (temExcecao);

		return opcaoVeiculo;
	}

	public static int lancaExcecaoOpcoesVeiculo(Scanner input, String texto1, String texto2, String texto3) {
		int opcaoVeiculo = 0;
		boolean temExcecao = false;

		do {
			System.out.println(texto1);
			System.out.println(texto2);
			System.out.print(texto3);
			temExcecao = false;
			try {
				opcaoVeiculo = input.nextInt();

			} catch (InputMismatchException e) {
				Impressora.imprimeOpcaoInvalida();
				MetodosAuxiliares.pressionarEnterErro();
				input.nextLine();
				temExcecao = true;
			} catch (Exception e) {
				Impressora.imprimeErroInesperado();
				MetodosAuxiliares.pressionarEnterErro();
				input.nextLine();
				temExcecao = true;
			}
			
		} while (temExcecao);

		return opcaoVeiculo;
	}

	public static float lancaExcecaoPreco(Scanner input, String texto) {
		float preco = 0;
		boolean temExcecao = false;
		do {
			temExcecao = false;

			try {
				preco = input.nextFloat();
			} catch (InputMismatchException e) {
				System.out.println("O preço deve ser um número.");
				MetodosAuxiliares.pressionarEnterErro();
				input.nextLine();
				temExcecao = true;
			} catch (Exception e) {
				Impressora.imprimeErroInesperado();
				MetodosAuxiliares.pressionarEnterErro();
				input.nextLine();
				temExcecao = true;
			}

			if (temExcecao) {
				System.out.println(texto);
			}
			
		} while (temExcecao);

		return preco;
	}

	public static boolean lancaExcecaoLeituraVeiculo(String dadoDoVeiculo, String chassi) {
		String eFloat = ".";

		if (dadoDoVeiculo.contains(eFloat)) {
			try {
				float dadoDoVeiculoFormatado = Float.parseFloat(dadoDoVeiculo);
			} catch (NumberFormatException e) {
				System.out.println("O veiculo com o chassi:'"+ chassi+ "', está com dados corrompidos e não será adicionado no estoque");
				return true;
			}
		} else {
			try {
				int dadoDoVeiculoFormatado = Integer.parseInt(dadoDoVeiculo);
			} catch (NumberFormatException e) {
				System.out.println("O veiculo com o chassi:'"+ chassi + "', está com dados corrompidos e não será adicionado no estoque");
				return true;
			}
		}
		
		return false;
	}
}
