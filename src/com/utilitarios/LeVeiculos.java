package com.utilitarios;

import java.util.ArrayList;
import java.util.Scanner;

import com.montadora.Carro;
import com.montadora.Motocicleta;
import com.montadora.Veiculo;

public class LeVeiculos {

	public static void leChassi(Scanner input, ArrayList<Veiculo> estoqueDeVeiculo, Veiculo veiculo) {
		boolean temVeiculo;
		String chassi;
		do{
			System.out.println("Entre com o chassi do veículo:");
			chassi = input.next();
			temVeiculo = MetodosAuxiliares.checarChassi(chassi, estoqueDeVeiculo);
			if(!temVeiculo){
				veiculo.setChassi(chassi);
			}
			else{
				System.out.println("Chassi já existe no estoque, favor entrar com outro chassi.");
			}
		}while(temVeiculo);
	}

	public static void leMontadora(Scanner input, Veiculo veiculo, String texto, String opcoes) {
		int opcaoMontadora;

		do{
			System.out.println(texto);
			System.out.println(opcoes);
			opcaoMontadora = Excecoes.lancaExcecaoOpcoesVeiculo(input, texto, opcoes);
			if((opcaoMontadora < 1) || (opcaoMontadora > 5)){
				Impressora.imprimeOpcaoInvalida();
				MetodosAuxiliares.pressionarEnterErro();
			}else{
				veiculo.setMontadora(opcaoMontadora);
			}
			
		}while((opcaoMontadora < 1) || (opcaoMontadora > 5));
	}

	public static void leTipo(Scanner input, Veiculo veiculo, String texto, String opcoes) {
		int opcaoTipo;

		do{
			System.out.println(texto);
			System.out.println(opcoes);
			opcaoTipo = Excecoes.lancaExcecaoOpcoesVeiculo(input, texto, opcoes);
			if((opcaoTipo < 1) || (opcaoTipo > 5)){
				Impressora.imprimeOpcaoInvalida();
				MetodosAuxiliares.pressionarEnterErro();					
			}else{
				veiculo.setTipo(opcaoTipo);	
			}			
			
		}while((opcaoTipo < 1) || (opcaoTipo > 5));
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
		do{
			System.out.println(texto);
			System.out.println(opcoes);
			opcaoCor = Excecoes.lancaExcecaoOpcoesVeiculo(input, texto, opcoes);
			if((opcaoCor < 1) || (opcaoCor > 5)){
				Impressora.imprimeOpcaoInvalida();
				MetodosAuxiliares.pressionarEnterErro();
			}else{
				veiculo.setCor(opcaoCor);	
			}				
			
		}while((opcaoCor < 1) || (opcaoCor > 5));
	}

	public static void lePreco(Scanner input, Veiculo veiculo) {
		float preco;
		String texto;
		texto = "Entre com o preço do veículo: ";
		do{

			System.out.println(texto);
			preco = Excecoes.lancaExcecaoPreco(input, texto);
			if(preco < Veiculo.PRECO_MINIMO){
				System.out.println("Preço deve ser um valor positivo");
				MetodosAuxiliares.pressionarEnterErro();
			}else{
				veiculo.setPreco(preco);
			}
			
		}while(preco < Veiculo.PRECO_MINIMO);
	}

	public static void leMotorizacao(Scanner input, Carro carro) {
		int opcaoMotorizacao;
		String texto;
		String opcoes;
		texto = "Selecione a motorização do carro: ";
		opcoes = "1 - 1.0   \t 2 - 1.3 \t 3 - 1.4 \t 4 - 1.5 \t 5 - 1.6 \t 6 - 1.8 \t 7 - 2.0";		
		do{
			System.out.println(texto);
			System.out.println(opcoes);
			
			opcaoMotorizacao = Excecoes.lancaExcecaoOpcoesVeiculo(input, texto, opcoes);
			
			if((opcaoMotorizacao < 1) || (opcaoMotorizacao > 7)){
				Impressora.imprimeOpcaoInvalida();
				MetodosAuxiliares.pressionarEnterErro();
			}else{
				carro.setMotorizacao(opcaoMotorizacao);
			}
			
		}while((opcaoMotorizacao < 1) || (opcaoMotorizacao > 7));
	}

	public static void leCambio(Scanner input, Carro carro) {
		int opcaoCambio;
		String texto;
		String opcoes;
		texto = "Selecione o tipo de câmbio do carro: ";
		opcoes = "1 - Manual   \t 2 - Automático \t 3 - Automatizado \t 4 - CVT";			
		do{
			System.out.println(texto);
			System.out.println(opcoes);
			opcaoCambio = Excecoes.lancaExcecaoOpcoesVeiculo(input, texto, opcoes);
			if((opcaoCambio < 1) || (opcaoCambio > 4)){
				Impressora.imprimeOpcaoInvalida();
				MetodosAuxiliares.pressionarEnterErro();
			}else{
				carro.setCambio(opcaoCambio);
			}				
				
		}while((opcaoCambio < 1) || (opcaoCambio > 4));
	}
	
	public static void leCilindradas(Scanner input, Motocicleta moto) {
		int opcaoCilindrada;
		String texto;
		texto = "Entre com as cilindradas da moto: ";		
		do{
			System.out.println(texto);
			
			opcaoCilindrada = Excecoes.lancaExcecaoOpcoesVeiculo(input, texto);
			if((opcaoCilindrada < 1) || (opcaoCilindrada > 999)){
				System.out.println("Cilindrada inválida.");
			}
			else{
				moto.setCilindrada(opcaoCilindrada);
			}
		}
		while((opcaoCilindrada < 1) || (opcaoCilindrada > 999));
	}
	
	public static void leCapacidadeDoTanque(Scanner input, Motocicleta moto) {
		int opcaoCapacidadeDoTanque;
		String texto;
		texto = "Entre com a capacidade do tanque em Litros: ";
		do{
			System.out.println(texto);
			opcaoCapacidadeDoTanque = Excecoes.lancaExcecaoOpcoesVeiculo(input, texto);
			if((opcaoCapacidadeDoTanque < 1) || (opcaoCapacidadeDoTanque > 99)){
				System.out.println("Capacidade do tanque acima do limite.");
			}
			else{
				moto.setCapacidadeDoTanque(opcaoCapacidadeDoTanque);
			}
		}while((opcaoCapacidadeDoTanque < 1) || (opcaoCapacidadeDoTanque > 99));
	}
	
}
