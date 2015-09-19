package com.utilitarios;

import java.util.ArrayList;
import java.util.Scanner;

import com.montadora.Veiculo;

public class LeVeiculos {

	private static final int VALOR_MINIMO = 1;
	private static final int VALOR_MAXIMO = 5;
	private static final int VALOR_MAXIMO_MOTORIZACAO = 7;
	private static final int VALOR_MAXIMO_CAMBIO = 4;
	private static final int VALOR_MAXIMO_CILINDRADAS = 999;
	private static final int VALOR_MAXIMO_CAPACIDADE_DO_TANQUE = 99;

	public static String leChassi(Scanner input, ArrayList<Veiculo> estoqueDeVeiculo) {
		boolean temVeiculo;
		boolean chassiInvalido = false;
		String chassi;

		do {
			chassiInvalido = false;

			System.out.println("Entre com o chassi do veículo:");
			chassi = input.next();

			temVeiculo = MetodosAuxiliares.checarChassi(chassi, estoqueDeVeiculo);
			if (!temVeiculo) {
				if (MetodosAuxiliares.tamanhoAdequado(chassi)) {
					return chassi;
				} else {
					System.out.println("Chassi inválido, entre com um novo número de chassi.");
					MetodosAuxiliares.pressionarEnterErro();
					chassiInvalido = true;
				}
			} else {
				System.out.println("Chassi já existe no estoque, favor entrar com outro chassi.");
				MetodosAuxiliares.pressionarEnterErro();
			}

		} while (temVeiculo || chassiInvalido);

		return null;

	}

	public static int leMontadora(Scanner input, String texto, String opcoes) {
		int opcaoMontadora;

		do {
			opcaoMontadora = Excecoes.lancaExcecaoOpcoesVeiculo(input, texto, opcoes);
			if ((opcaoMontadora < VALOR_MINIMO) || (opcaoMontadora > VALOR_MAXIMO)) {
				Impressora.imprimeOpcaoInvalida();
				MetodosAuxiliares.pressionarEnterErro();
			} else {
				return opcaoMontadora;
			}

		} while ((opcaoMontadora < VALOR_MINIMO) || (opcaoMontadora > VALOR_MAXIMO));
		return opcaoMontadora;

	}

	public static int leTipo(Scanner input, String texto, String opcoes) {
		int opcaoTipo;

		do {
			opcaoTipo = Excecoes.lancaExcecaoOpcoesVeiculo(input, texto, opcoes);
			if ((opcaoTipo < VALOR_MINIMO) || (opcaoTipo > VALOR_MAXIMO)) {
				Impressora.imprimeOpcaoInvalida();
				MetodosAuxiliares.pressionarEnterErro();
			} else {
				return opcaoTipo;
			}

		} while ((opcaoTipo < VALOR_MINIMO) || (opcaoTipo > VALOR_MAXIMO));
		return opcaoTipo;

	}

	public static String leModelo(Scanner input) {

		String modelo;

		System.out.println("Entre com o modelo do veículo:");
		modelo = input.nextLine();

		return modelo;
	}

	public static String leCor(Scanner input) {
		int opcaoCor;
		String texto;
		String opcoes;
		texto = "Selecione a cor do veículo: ";
		opcoes = "1 - azul   \t 2 - vermelho \t 3 - branco \t 4 - preto \t 5 - verde";

		do {
			opcaoCor = Excecoes.lancaExcecaoOpcoesVeiculo(input, texto, opcoes);
			if ((opcaoCor < VALOR_MINIMO) || (opcaoCor > VALOR_MAXIMO)) {
				Impressora.imprimeOpcaoInvalida();
				MetodosAuxiliares.pressionarEnterErro();
			} else {
				switch (opcaoCor) {
					case 1:
						return "azul";

					case 2:
						return "vermelho";

					case 3:
						return "branco";

					case 4:
						return "preto";

					case 5:
						return "verde";
				}
			}

		} while ((opcaoCor < VALOR_MINIMO) || (opcaoCor > VALOR_MAXIMO));
		return null;

	}

	public static String lePreco(Scanner input) {
		float preco;
		String texto;
		texto = "Entre com o preço do veículo: ";

		do {
			System.out.println(texto);

			preco = Excecoes.lancaExcecaoPreco(input, texto);
			if (preco < Veiculo.PRECO_MINIMO) {
				System.out.println("Preço deve ser um valor positivo");
				MetodosAuxiliares.pressionarEnterErro();
			} else {
				return String.valueOf(preco);
			}

		} while (preco < Veiculo.PRECO_MINIMO);

		return null;
	}

	public static String leMotorizacao(Scanner input) {
		int opcaoMotorizacao;
		String texto;
		String opcoes;
		texto = "Selecione a motorização do carro: ";
		opcoes = "1 - 1.0   \t 2 - 1.3 \t 3 - 1.4 \t 4 - 1.5 \t 5 - 1.6 \t 6 - 1.8 \t 7 - 2.0";

		do {
			opcaoMotorizacao = Excecoes.lancaExcecaoOpcoesVeiculo(input, texto, opcoes);

			if ((opcaoMotorizacao < VALOR_MINIMO) || (opcaoMotorizacao > VALOR_MAXIMO_MOTORIZACAO)) {
				Impressora.imprimeOpcaoInvalida();
				MetodosAuxiliares.pressionarEnterErro();
			} else {
				switch (opcaoMotorizacao) {
				case 1:
					return "1.0";

				case 2:
					return "1.3";

				case 3:
					return "1.4";

				case 4:
					return "1.5";

				case 5:
					return "1.6";

				case 6:
					return "1.8";

				case 7:
					return "2.0";
				}
			}

		} while ((opcaoMotorizacao < VALOR_MINIMO) || (opcaoMotorizacao > VALOR_MAXIMO_MOTORIZACAO));
		return null;

	}

	public static String leCambio(Scanner input) {
		int opcaoCambio;
		String texto;
		String opcoes;
		texto = "Selecione o tipo de câmbio do carro: ";
		opcoes = "1 - Manual   \t 2 - Automático \t 3 - Automatizado \t 4 - CVT";

		do {
			opcaoCambio = Excecoes.lancaExcecaoOpcoesVeiculo(input, texto, opcoes);

			if ((opcaoCambio < VALOR_MINIMO) || (opcaoCambio > VALOR_MAXIMO_CAMBIO)) {
				Impressora.imprimeOpcaoInvalida();
				MetodosAuxiliares.pressionarEnterErro();
			} else {
				switch (opcaoCambio) {
				case 1:
					return "Manual";

				case 2:
					return "Automático";

				case 3:
					return "Automatizado";

				case 4:
					return "CVT";

				case 5:
					return "verde";
			}
			}

		} while ((opcaoCambio < VALOR_MINIMO) || (opcaoCambio > VALOR_MAXIMO_CAMBIO));
		return null;

	}

	public static String leCilindradas(Scanner input) {
		int opcaoCilindrada;
		String texto;
		texto = "Entre com as cilindradas da moto: ";

		do {
			opcaoCilindrada = Excecoes.lancaExcecaoOpcoesVeiculo(input, texto);

			if ((opcaoCilindrada < VALOR_MINIMO) || (opcaoCilindrada > VALOR_MAXIMO_CILINDRADAS)) {
				System.out.println("Cilindrada inválida.");
			} else {
				return String.valueOf(opcaoCilindrada);
			}

		} while ((opcaoCilindrada < VALOR_MINIMO) || (opcaoCilindrada > VALOR_MAXIMO_CILINDRADAS));

		return String.valueOf(opcaoCilindrada);
	}

	public static String leCapacidadeDoTanque(Scanner input) {
		int opcaoCapacidadeDoTanque;
		String texto;
		texto = "Entre com a capacidade do tanque em Litros: ";

		do {
			opcaoCapacidadeDoTanque = Excecoes.lancaExcecaoOpcoesVeiculo(input, texto);

			if ((opcaoCapacidadeDoTanque < VALOR_MINIMO) || (opcaoCapacidadeDoTanque > VALOR_MAXIMO_CAPACIDADE_DO_TANQUE)) {
				System.out.println("Capacidade do tanque acima do limite.");
			} else {
				return String.valueOf(opcaoCapacidadeDoTanque);
			}

		} while ((opcaoCapacidadeDoTanque < VALOR_MINIMO) || (opcaoCapacidadeDoTanque > VALOR_MAXIMO_CAPACIDADE_DO_TANQUE));

		return String.valueOf(opcaoCapacidadeDoTanque);
	}

}