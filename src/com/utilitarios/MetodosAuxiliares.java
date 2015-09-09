package com.utilitarios;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.montadora.Veiculo;

public class MetodosAuxiliares {
	
	private static final int LINHAS_PARA_PULAR = 25;
	private static final int TAMANHO_MAXIMO_CHASSI = 17;

	public static void pressionarEnter() {
		System.out.println("Pressione enter para voltar ao menu.");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		input.nextLine();//só continua pro proximo passo se o usuario apertar a tecla enter
		limparTela();// chama metodo de limpar tela
	}

	@SuppressWarnings("resource")
	public static void pressionarEnterErro() {
		System.out.println("Pressione enter para continuar.");
		Scanner input = new Scanner(System.in);
		input.nextLine();
		System.out.print("");
	}

	public static void limparTela() {// varias quebras de linha "limpar" o console
		for (int numLinhas = 0; numLinhas < LINHAS_PARA_PULAR; numLinhas++) {
			System.out.println("\n");
		}

	}

	public static boolean checarChassi(String checaChassi, ArrayList<Veiculo> comparaVeiculo) {

		for (Veiculo checaVeiculo : comparaVeiculo) {
			if (checaVeiculo.getChassi().equals(checaChassi)) {

				return true;
			}

		}

		return false;
	}

	public static int leOpcaoMenu(Scanner input, int opcaoMenu) {

		try {
			opcaoMenu = input.nextInt();
		} catch (InputMismatchException e) {
			Impressora.imprimeOpcaoInvalida();
			MetodosAuxiliares.pressionarEnterErro();
			input.nextLine();
		} catch (Exception e) {
			Impressora.imprimeErroInesperado();
			MetodosAuxiliares.pressionarEnterErro();
			input.nextLine();
		}
		return opcaoMenu;
	}

	public static boolean tamanhoAdequado(String chassi) {
		if (chassi.length() > TAMANHO_MAXIMO_CHASSI) {
			return false;
		}
		return true;
	}
}
