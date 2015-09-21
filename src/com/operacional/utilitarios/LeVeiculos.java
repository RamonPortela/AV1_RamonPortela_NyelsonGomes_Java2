package com.operacional.utilitarios;

import java.util.ArrayList;
import java.util.Scanner;

import com.auxiliar.MetodosAuxiliares;
import com.operacional.montadora.Veiculo;

public class LeVeiculos {

	private static final int VALOR_MINIMO = 1;
	private static final int VALOR_MAXIMO = 5;
	private static final int VALOR_MAXIMO_MOTORIZACAO = 7;
	private static final int VALOR_MAXIMO_CAMBIO = 4;
	private static final int VALOR_MAXIMO_CILINDRADAS = 999;
	private static final int VALOR_MAXIMO_CAPACIDADE_DO_TANQUE = 99;

	/**
	 * @param input - Para evitar instanciar um novo Scanner
	 * @param estoqueDeVeiculo - Recebe um estoque de veículos do estoque.
	 * O metodo recebe um chassi inserido pelo usuário.
	 */
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

	/**
	 * @param input - Para evitar instanciar um novo Scanner
	 * @param texto - Responsável por exibir o menu no console
	 * @param opcoes - Responsável por exibir as opções no console
	 * @param pesquisa - Caso a ação seja de pesquisa retorna verdadeiro, caso seja adicionar retorna falso.
	 * @return Uma montadora solicitada pelo usuário.
	 */
	public static int leMontadora(Scanner input, String texto, String opcoes, boolean pesquisa) {
		int opcaoMontadora;
		int valorMinimo;
		
		if(pesquisa){
			valorMinimo = 0;
		}
		else{
			valorMinimo = VALOR_MINIMO;
		}

		do {
			opcaoMontadora = Excecoes.lancaExcecaoOpcoesVeiculo(input, texto, opcoes);
			if ((opcaoMontadora < valorMinimo) || (opcaoMontadora > VALOR_MAXIMO)) {
				Impressora.imprimeOpcaoInvalida();
				MetodosAuxiliares.pressionarEnterErro();
			} else {
				return opcaoMontadora;
			}

		} while ((opcaoMontadora < valorMinimo) || (opcaoMontadora > VALOR_MAXIMO));
		return opcaoMontadora;

	}

	/**
	 * @param input - Para evitar instanciar um novo Scanner
	 * @param texto - Responsável por exibir o menu no console
	 * @param opcoes - Responsável por exibir as opções no console
	 * @param pesquisa - Caso a ação seja de pesquisa retorna verdadeiro, caso seja adicionar retorna falso.
	 * @return Um tipo solicitado pelo usuário.
	 */
	public static int leTipo(Scanner input, String texto, String opcoes, boolean pesquisa) {
		int opcaoTipo;
		int valorMinimo;
		
		if(pesquisa){
			valorMinimo = 0;
		}
		else{
			valorMinimo = VALOR_MINIMO;
		}

		do {
			opcaoTipo = Excecoes.lancaExcecaoOpcoesVeiculo(input, texto, opcoes);
			if ((opcaoTipo < valorMinimo) || (opcaoTipo > VALOR_MAXIMO)) {
				Impressora.imprimeOpcaoInvalida();
				MetodosAuxiliares.pressionarEnterErro();
			} else {
				return opcaoTipo;
			}

		} while ((opcaoTipo < valorMinimo) || (opcaoTipo > VALOR_MAXIMO));
		return opcaoTipo;

	}

	/**
	 * @param input - Para evitar instanciar um novo Scanner
	 * @param pesquisa - Caso a ação seja de pesquisa retorna verdadeiro, caso seja adicionar retorna falso.
	 * @return Um modelo solicitado pelo usuário.
	 */
	public static String leModelo(Scanner input, boolean pesquisa) {

		String modelo;

		if(pesquisa){
			System.out.println("Entre com o modelo do veículo ou 0 para qualquer modelo:");
			modelo = input.nextLine();
			
			if(modelo.equals("0")){
				modelo = null;
			}
		}
		else{
			System.out.println("Entre com o modelo do veículo:");
			modelo = input.nextLine();	
		}
		return modelo;
	}

	/**
	 * @param input - Para evitar instanciar um novo Scanner
	 * @param pesquisa - Caso a ação seja de pesquisa retorna verdadeiro, caso seja adicionar retorna falso.
	 * @return Uma cor solicitada pelo usuário.
	 */
	public static String leCor(Scanner input, boolean pesquisa) {
		int opcaoCor;
		String texto;
		String opcoes;
		int valorMinimo;
		
		if(pesquisa){
			opcoes = "0 - Qualquer \t 1 - azul   \t 2 - vermelho \t 3 - branco \t 4 - preto \t 5 - verde";
			valorMinimo = 0;
		}
		else{
			opcoes = "1 - azul   \t 2 - vermelho \t 3 - branco \t 4 - preto \t 5 - verde";
			valorMinimo = VALOR_MINIMO;
		}
		texto = "Selecione a cor do veículo: ";

		do {
			opcaoCor = Excecoes.lancaExcecaoOpcoesVeiculo(input, texto, opcoes);
			if ((opcaoCor < valorMinimo) || (opcaoCor > VALOR_MAXIMO)) {
				Impressora.imprimeOpcaoInvalida();
				MetodosAuxiliares.pressionarEnterErro();
			} else {
				switch (opcaoCor) {
					
					case 0:
						return null;
					
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

		} while ((opcaoCor < valorMinimo) || (opcaoCor > VALOR_MAXIMO));
		return null;

	}

	/**
	 * @param input - Para evitar instanciar um novo Scanner
	 * @return Um preço solicitado pelo usuário.
	 */
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

	/**
	 * @param input - Para evitar instanciar um novo Scanner
	 * @param pesquisa - Caso a ação seja de pesquisa retorna verdadeiro, caso seja adicionar retorna falso.
	 * @return Uma motorização solicitada pelo usuário.
	 */
	public static String leMotorizacao(Scanner input, boolean pesquisa) {
		int opcaoMotorizacao;
		String texto;
		String opcoes;
		int valorMinimo;
		
		if(pesquisa){
			opcoes = "0 - Qualquer \t 1 - 1.0   \t 2 - 1.3 \t 3 - 1.4 \t 4 - 1.5 \t 5 - 1.6 \t 6 - 1.8 \t 7 - 2.0";
			valorMinimo = 0;
		}
		else{
			opcoes = "1 - 1.0   \t 2 - 1.3 \t 3 - 1.4 \t 4 - 1.5 \t 5 - 1.6 \t 6 - 1.8 \t 7 - 2.0";
			valorMinimo = VALOR_MINIMO;
		}
		texto = "Selecione a motorização do carro: ";		

		do {
			opcaoMotorizacao = Excecoes.lancaExcecaoOpcoesVeiculo(input, texto, opcoes);

			if ((opcaoMotorizacao < valorMinimo) || (opcaoMotorizacao > VALOR_MAXIMO_MOTORIZACAO)) {
				Impressora.imprimeOpcaoInvalida();
				MetodosAuxiliares.pressionarEnterErro();
			} else {
				switch (opcaoMotorizacao) {
				
				case 0:
					return null;
					
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

		} while ((opcaoMotorizacao < valorMinimo) || (opcaoMotorizacao > VALOR_MAXIMO_MOTORIZACAO));
		return null;

	}

	/**
	 * @param input - Para evitar instanciar um novo Scanner
	 * @param pesquisa - Caso a ação seja de pesquisa retorna verdadeiro, caso seja adicionar retorna falso.
	 * @return Um cambio solicitado pelo usuário.
	 */
	public static String leCambio(Scanner input, boolean pesquisa) {
		int opcaoCambio;
		String texto;
		String opcoes;
		int valorMinimo;
		
		if(pesquisa){
			opcoes = "0 - Qualquer \t 1 - Manual   \t 2 - Automático \t 3 - Automatizado \t 4 - CVT";
			valorMinimo = 0;
		}
		else{
			opcoes = "1 - Manual   \t 2 - Automático \t 3 - Automatizado \t 4 - CVT";
			valorMinimo = VALOR_MINIMO;
		}
		
		texto = "Selecione o tipo de câmbio do carro: ";

		do {
			opcaoCambio = Excecoes.lancaExcecaoOpcoesVeiculo(input, texto, opcoes);

			if ((opcaoCambio < valorMinimo) || (opcaoCambio > VALOR_MAXIMO_CAMBIO)) {
				Impressora.imprimeOpcaoInvalida();
				MetodosAuxiliares.pressionarEnterErro();
			} else {
				switch (opcaoCambio) {
				
				case 0:
					return null;
					
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

		} while ((opcaoCambio < valorMinimo) || (opcaoCambio > VALOR_MAXIMO_CAMBIO));
		return null;

	}

	/**
	 * @param input - Para evitar instanciar um novo Scanner
	 * @param pesquisa - Caso a ação seja de pesquisa retorna verdadeiro, caso seja adicionar retorna falso.
	 * @return Uma cilindrada solicitada pelo usuário.
	 */
	public static String leCilindradas(Scanner input, boolean pesquisa) {
		int opcaoCilindrada;
		String texto;
		int valorMinimo;

		if(pesquisa){
			texto = "Entre com as cilindradas da moto ou 0 para qualquer cilindrada: ";
			valorMinimo = 0;
		}
		else{
			texto = "Entre com as cilindradas da moto: ";
			valorMinimo = VALOR_MINIMO;
		}
		
		do {
			opcaoCilindrada = Excecoes.lancaExcecaoOpcoesVeiculo(input, texto);

			if ((opcaoCilindrada < valorMinimo) || (opcaoCilindrada > VALOR_MAXIMO_CILINDRADAS)) {
				System.out.println("Cilindrada inválida.");
			} else {
				if(pesquisa && opcaoCilindrada == valorMinimo){
					return null;
				}
				else{
				return String.valueOf(opcaoCilindrada);
				}
			}

		} while ((opcaoCilindrada < valorMinimo) || (opcaoCilindrada > VALOR_MAXIMO_CILINDRADAS));

		return String.valueOf(opcaoCilindrada);
	}

	/**
	 * @param input - Para evitar instanciar um novo Scanner
	 * @param pesquisa - Caso a ação seja de pesquisa retorna verdadeiro, caso seja adicionar retorna falso.
	 * @return Uma Capacidade do Tanque solicitada pelo usuário.
	 */
	public static String leCapacidadeDoTanque(Scanner input, boolean pesquisa) {
		int opcaoCapacidadeDoTanque;
		String texto;
		int valorMinimo;
		
		if(pesquisa){
			texto = "Entre com a capacidade do tanque ou 0 para qualquer capacidade do tanque: ";
			valorMinimo = 0;
		}
		else{
			texto = "Entre com a capacidade do tanque: ";
			valorMinimo = VALOR_MINIMO;
		}

		do {
			opcaoCapacidadeDoTanque = Excecoes.lancaExcecaoOpcoesVeiculo(input, texto);

			if ((opcaoCapacidadeDoTanque < valorMinimo) || (opcaoCapacidadeDoTanque > VALOR_MAXIMO_CAPACIDADE_DO_TANQUE)) {
				System.out.println("Capacidade do tanque acima do limite.");
			} else {
				if(pesquisa && opcaoCapacidadeDoTanque == valorMinimo){
					return null;
				}
				else{					
					return String.valueOf(opcaoCapacidadeDoTanque);
				}
			}

		} while ((opcaoCapacidadeDoTanque < valorMinimo) || (opcaoCapacidadeDoTanque > VALOR_MAXIMO_CAPACIDADE_DO_TANQUE));

		return String.valueOf(opcaoCapacidadeDoTanque);
	}

}