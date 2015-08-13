package com.montadora;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.utilitarios.Excecoes;
import com.utilitarios.Impressora;
import com.utilitarios.MetodosAuxiliares;

public class Motocicleta extends Veiculo {
	
	private int cilindrada;
	private int capacidadeDoTanque;

	public enum Tipos{//enum de tipos de motos
		SCOOTER(1, "Scooter"), CUSTOM(2, "Custom"), CHOPPER(3, "Chopper"), STREET(4, "Street"), ESPORTIVA(5, "Esportiva");
		
		private int opcaoTipo;
		private String nomeTipo;
		
		private Tipos(int opcaoTipo, String nomeTipo){
			this.opcaoTipo = opcaoTipo;
			this.nomeTipo = nomeTipo;
		}
		
		public int getOpcaoTipo(){
			return opcaoTipo;
		}
		
		public String getNomeTipo(){
			return nomeTipo;
		}
	};
	
	public void setTipo(int opcaoTipo){
		switch(opcaoTipo){
			case 1:
				this.tipo = Tipos.SCOOTER.getNomeTipo();
				break;
			case 2:
				this.tipo = Tipos.CUSTOM.getNomeTipo();
				break;
			case 3:
				this.tipo = Tipos.CHOPPER.getNomeTipo();
				break;
			case 4:
				this.tipo = Tipos.STREET.getNomeTipo();
				break;
			case 5:
				this.tipo = Tipos.ESPORTIVA.getNomeTipo();
				break;
		}
	}
	
	public void setTipo(String tipo){
		this.tipo = tipo;
	}
	
	public enum Montadoras{//enum das montadoras de moto
		HARLEY(1,"HARLEY-DAVIDSON"), HONDA(2, "HONDA"), SUZUKI(3, "SUZUKI"), KAWASAKI(4, "KAWASAKI"), SHINERAY(5, "SHINERAY");
		
		private int opcaoMontadoras;
		private String nomeMontadoras;
		
		private Montadoras(int opcaoMontadoras, String nomeMontadoras){
			this.opcaoMontadoras = opcaoMontadoras;
			this.nomeMontadoras = nomeMontadoras;
		}
		
		public int getOpcaoMontadoras(){
			return opcaoMontadoras;
		}
		
		public String getNomeMontadoras(){
			return nomeMontadoras;
		}
		
	};	
	
	public void setMontadora(int opcaoMontadora){
		switch(opcaoMontadora){
			case 1:
				this.montadora = Montadoras.HARLEY.getNomeMontadoras();
				break;
			case 2:
				this.montadora = Montadoras.HONDA.getNomeMontadoras();
				break;
			case 3:
				this.montadora = Montadoras.SUZUKI.getNomeMontadoras();
				break;
			case 4:
				this.montadora = Montadoras.KAWASAKI.getNomeMontadoras();
				break;
			case 5:
				this.montadora = Montadoras.SHINERAY.getNomeMontadoras();
				break;
		}
	}
	
	public void setMontadora(String montadora) {
		this.montadora = montadora;		
	}
	
	public String getMontadora(){
		return montadora;
	}	
	
	public int getCilindrada() {
		return cilindrada;
	}
	
	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}
	
	public int getCapacidadeDoTanque() {
		return capacidadeDoTanque;
	}
	
	public void setCapacidadeDoTanque(int capacidadeDoTanque) {
		this.capacidadeDoTanque = capacidadeDoTanque;
	}
	
	@Override
	public Motocicleta criarVeiculo(Scanner input, ArrayList<Veiculo> estoqueDeVeiculo) {// método que cria moto a partir do que foi informado pelo usuário
		
		Motocicleta moto = new Motocicleta();
		boolean temExcecao = false;
		int opcaoMontadora;
		int opcaoTipo;
		int opcaoCor;
		int opcaoCilindrada;
		int opcaoCapacidadeDoTanque;
		boolean temVeiculo;
		String chassi;
		
		do{
			System.out.println("Entre com o chassi do veículo:");
			chassi = input.next();
			temVeiculo = MetodosAuxiliares.checarChassi(chassi, estoqueDeVeiculo);
			if(!temVeiculo){
				moto.setChassi(chassi);
			}
			else{
				System.out.println("Chassi já existe no estoque, favor entrar com outro chassi.");
			}
		}while(temVeiculo);
		
		String texto = "Escolha uma montadora: ";
		String opcoes = "1 - HARLEY-DAVIDSON   \t 2 - HONDA \t 3 - SUZUKI \t 4 - KAWASAKI \t 5 - SHINERAY";
		
		do{
			System.out.println(texto);
			System.out.println(opcoes);
			opcaoMontadora = Excecoes.lancaExcecaoOpcoesVeiculo(input, texto, opcoes);
			if((opcaoMontadora < 1) || (opcaoMontadora > 5)){
				Impressora.imprimeOpcaoInvalida();
				MetodosAuxiliares.pressionarEnterErro();
			}else{
				moto.setMontadora(opcaoMontadora);
			}
			
		}while((opcaoMontadora < 1) || (opcaoMontadora > 5));
		
		texto = "Entre com o tipo do veículo: ";
		opcoes = "1 - Scooter   \t 2 - Custom \t 3 - Roadster \t 4 - Street \t 5 - Esportiva";
		do{
			System.out.println(texto);
			System.out.println(opcoes);
			opcaoTipo = Excecoes.lancaExcecaoOpcoesVeiculo(input, texto, opcoes);
			if((opcaoTipo < 1) || (opcaoTipo > 5)){
				Impressora.imprimeOpcaoInvalida();
				MetodosAuxiliares.pressionarEnterErro();					
			}else{
				moto.setTipo(opcaoTipo);	
			}			
			
		}while((opcaoTipo < 1) || (opcaoTipo > 5));
		
		input.nextLine();
		
		System.out.println("Entre com o modelo do veículo:");
		moto.setModelo(input.nextLine());
		
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
				moto.setCor(opcaoCor);	
			}				
			
		}while((opcaoCor < 1) || (opcaoCor > 5));
		
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

		System.out.println("Entre com a capacidade do taque de combustível: ");
		moto.setCapacidadeDoTanque(input.nextInt());
		
		do{
			temExcecao = false;
			System.out.println("Entre com o preço do veículo: ");
			try{
				moto.setPreco(input.nextFloat());	
			}catch(InputMismatchException e){
				System.out.println("O preço deve ser um número.");
				MetodosAuxiliares.pressionarEnterErro();
				temExcecao = true;
				input.nextLine();
			}catch(Exception e){
				Impressora.imprimeErroInesperado();
				MetodosAuxiliares.pressionarEnterErro();
				temExcecao = true;
				input.nextLine();
			}
					
		}while(temExcecao);
		
		return moto;
	}

}
