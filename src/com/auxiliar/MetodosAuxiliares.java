package com.auxiliar;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.operacional.montadora.Veiculo;
import com.operacional.utilitarios.Impressora;

public class MetodosAuxiliares {

	private static final int LINHAS_PARA_PULAR = 25;
	private static final int TAMANHO_MAXIMO_CHASSI = 17;

	public static void pressionarEnter() {
		System.out.println("Pressione enter para voltar ao menu.");
		Scanner input = new Scanner(System.in);
		input.nextLine();//s� continua pro proximo passo se o usuario apertar a tecla enter
		limparTela();// chama metodo de limpar tela
	}

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

	/**
	 * @param checaChassi - Recebe um numero de chassi solicitado pelo usu�rio
	 * @param comparaVeiculo - Array List com os ve�culos em estoque.
	 * @return Verdadeiro caso encontre um chassi de um ve�culo procurado pelo usu�rio, e false caso n�o o encontre.
	 */
	public static boolean checarChassi(String checaChassi, ArrayList<Veiculo> comparaVeiculo) {

		for (Veiculo checaVeiculo : comparaVeiculo) {
			if (checaVeiculo.getEspecificacaoVeiculo().getChassi().equals(checaChassi)) {

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

	// Checa se o tamanho do chassi ultrapassa os limites
	public static boolean tamanhoAdequado(String chassi) {
		if (chassi.length() > TAMANHO_MAXIMO_CHASSI) {
			return false;
		}
		return true;
	}
}
