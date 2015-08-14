package com.utilitarios;

import java.util.ArrayList;
import java.util.Scanner;

import com.montadora.Carro;
import com.montadora.Motocicleta;
import com.montadora.Veiculo;

public class LeVeiculos {

	private static final int VALOR_MINIMO = 1;
	private static final int VALOR_MAXIMO = 5;
	private static final int VALOR_MAXIMO_MOTORIZACAO = 7;
	private static final int VALOR_MAXIMO_CAMBIO = 4;
	private static final int VALOR_MAXIMO_CILINDRADAS = 999;
	private static final int VALOR_MAXIMO_CAPACIDADE_DO_TANQUE = 99;

	public static void leChassi(Scanner input, ArrayList<Veiculo> estoqueDeVeiculo, Veiculo veiculo) {
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
					veiculo.setChassi(chassi);
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
		
	}

	public static void leMontadora(Scanner input, Veiculo veiculo, String texto, String opcoes) {
		int opcaoMontadora;

		do {
			opcaoMontadora = Excecoes.lancaExcecaoOpcoesVeiculo(input, texto, opcoes);
			if ((opcaoMontadora < VALOR_MINIMO) || (opcaoMontadora > VALOR_MAXIMO)) {
				Impressora.imprimeOpcaoInvalida();
				MetodosAuxiliares.pressionarEnterErro();
			} else {
				veiculo.setMontadora(opcaoMontadora);
			}

		} while ((opcaoMontadora < VALOR_MINIMO) || (opcaoMontadora > VALOR_MAXIMO));
		
	}

	public static void leTipo(Scanner input, Veiculo veiculo, String texto,
			String opcoes) {
		int opcaoTipo;

		do {
			opcaoTipo = Excecoes.lancaExcecaoOpcoesVeiculo(input, texto, opcoes);
			if ((opcaoTipo < VALOR_MINIMO) || (opcaoTipo > VALOR_MAXIMO)) {
				Impressora.imprimeOpcaoInvalida();
				MetodosAuxiliares.pressionarEnterErro();
			} else {
				veiculo.setTipo(opcaoTipo);
			}

		} while ((opcaoTipo < VALOR_MINIMO) || (opcaoTipo > VALOR_MAXIMO));
		
	}

	public static void leModelo(Scanner input, Veiculo veiculo) {
		System.out.println("Entre com o modelo do veículo:");
		veiculo.setModelo(input.nextLine());
	}

	public static void leCor(Scanner input, Veiculo veiculo) {
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
				veiculo.setCor(opcaoCor);
			}

		} while ((opcaoCor < VALOR_MINIMO) || (opcaoCor > VALOR_MAXIMO));
		
	}

	public static void lePreco(Scanner input, Veiculo veiculo) {
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
				veiculo.setPreco(preco);
			}

		} while (preco < Veiculo.PRECO_MINIMO);
		
	}

	public static void leMotorizacao(Scanner input, Carro carro) {
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
				carro.setMotorizacao(opcaoMotorizacao);
			}

		} while ((opcaoMotorizacao < VALOR_MINIMO) || (opcaoMotorizacao > VALOR_MAXIMO_MOTORIZACAO));
		
	}

	public static void leCambio(Scanner input, Carro carro) {
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
				carro.setCambio(opcaoCambio);
			}

		} while ((opcaoCambio < VALOR_MINIMO) || (opcaoCambio > VALOR_MAXIMO_CAMBIO));
		
	}

	public static void leCilindradas(Scanner input, Motocicleta moto) {
		int opcaoCilindrada;
		String texto;
		texto = "Entre com as cilindradas da moto: ";
		
		do {
			opcaoCilindrada = Excecoes.lancaExcecaoOpcoesVeiculo(input, texto);
			
			if ((opcaoCilindrada < VALOR_MINIMO) || (opcaoCilindrada > VALOR_MAXIMO_CILINDRADAS)) {
				System.out.println("Cilindrada inválida.");
			} else {
				moto.setCilindrada(opcaoCilindrada);
			}
			
		} while ((opcaoCilindrada < VALOR_MINIMO) || (opcaoCilindrada > VALOR_MAXIMO_CILINDRADAS));
		
	}

	public static void leCapacidadeDoTanque(Scanner input, Motocicleta moto) {
		int opcaoCapacidadeDoTanque;
		String texto;
		texto = "Entre com a capacidade do tanque em Litros: ";
		
		do {			
			opcaoCapacidadeDoTanque = Excecoes.lancaExcecaoOpcoesVeiculo(input, texto);
			
			if ((opcaoCapacidadeDoTanque < VALOR_MINIMO) || (opcaoCapacidadeDoTanque > VALOR_MAXIMO_CAPACIDADE_DO_TANQUE)) {
				System.out.println("Capacidade do tanque acima do limite.");
			} else {
				moto.setCapacidadeDoTanque(opcaoCapacidadeDoTanque);
			}
			
		} while ((opcaoCapacidadeDoTanque < VALOR_MINIMO) || (opcaoCapacidadeDoTanque > VALOR_MAXIMO_CAPACIDADE_DO_TANQUE));
		
	}
	
}