package com.utilitarios;

import java.util.ArrayList;
import java.util.Scanner;

import com.loja.Loja;
import com.montadora.Veiculo;

public class Menu {
	
	private static final int SAIR = 0;
	private static final int PRIMEIRA_OPCAO = 1;
	private static final int SEGUNDA_OPCAO = 2;
	private static final int TERCEIRA_OPCAO = 3;
	private static final int QUARTA_OPCAO = 4;
	private static final int QUINTA_OPCAO = 5;
	private static final int SEXTA_OPCAO = 6;
	private static final int SETIMA_OPCAO = 7;
	private static final int OITAVA_OPCAO = 8;

	public static void menu() {

		

		Scanner input = new Scanner(System.in);
		Loja loja = new Loja();
		int opcaoMenu;

		opcaoMenu = Impressora.imprimeMenu(input);
		System.out.println("");

		while (opcaoMenu != SAIR) {
			switch (opcaoMenu) {
			case -1:
				break;

			case PRIMEIRA_OPCAO:
				loja.adicionarVeiculo(input);
				MetodosAuxiliares.pressionarEnter();
				break;
			case SEGUNDA_OPCAO:
				loja.excluirVeiculo(input);
				MetodosAuxiliares.pressionarEnter();
				break;

			case TERCEIRA_OPCAO:
				loja.listarVeiculos();
				MetodosAuxiliares.pressionarEnter();
				break;

			case QUARTA_OPCAO:
				loja.buscarVeiculo(input);
				MetodosAuxiliares.pressionarEnter();
				break;

			case QUINTA_OPCAO:
				loja.listarCarros();
				MetodosAuxiliares.pressionarEnter();
				break;

			case SEXTA_OPCAO:
				loja.listarMotos();
				MetodosAuxiliares.pressionarEnter();
				break;

			case SETIMA_OPCAO:
				SalvaEstoque file = new SalvaEstoque();
				if (file.abrirArquivo()) {
					file.gravarEstoque(loja);
					file.fecharArquivo();
					System.out.println("Estoque salvo com sucesso.");
					MetodosAuxiliares.pressionarEnter();
				} else {
					System.out.println("Um erro ocorreu durante o processo de salvar o arquivo.");
					MetodosAuxiliares.pressionarEnter();
				}
				break;

			case OITAVA_OPCAO:
				CarregarEstoque arquivo = new CarregarEstoque();
				boolean temVeiculo;

				ArrayList<Veiculo> estoqueDeVeiculos = loja.getEstoqueDeVeiculos();
				estoqueDeVeiculos.clear();

				if (arquivo.abrirArquivo()) {
					temVeiculo = arquivo.lerEstoqueSalvo(estoqueDeVeiculos);
					if (temVeiculo) {
						loja.setEstoqueDeVeiculos(estoqueDeVeiculos);
						System.out.println("Estoque carregado com sucesso.");
					} else {
						System.out.println("Não há veiculos para serem carrados.");
					}
					arquivo.fecharArquivo();
					MetodosAuxiliares.pressionarEnter();
				} else {
					System.out.println("Um erro ocrreu durante o processo de carregar o arquivo.");
					MetodosAuxiliares.pressionarEnter();
				}

				break;

			default:
				System.out.println("Opção inválida.");
				MetodosAuxiliares.pressionarEnterErro();
			}

			opcaoMenu = Impressora.imprimeMenu(input);
			System.out.println("");
		}

	}

}