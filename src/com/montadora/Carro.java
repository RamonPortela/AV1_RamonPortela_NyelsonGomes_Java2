package com.montadora;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.utilitarios.teste.Excecoes;
import com.utilitarios.teste.Impressora;
import com.utilitarios.teste.MetodosAuxiliares;

public class Carro extends Veiculo {
	
	private String tipo;
	private String cambio;
	private float motorizacao;
	
	public enum Cambios{//enum de cambios
		MANUAL(1, "Manual"), AUTOMATICO(2, "Automático"), AUTOMATIZADO(3, "Automatizado"), CVT(4, "CVT");
		
		private int opcaoCambio;
		private String nomeCambio;
		
		private Cambios(int opcaoCambio, String nomeCambio){
			this.opcaoCambio = opcaoCambio;
			this.nomeCambio = nomeCambio;
		}
		
		public int getOpcaoCambio(){
			return opcaoCambio;
		}
		
		public String getNomeCambio(){
			return nomeCambio;
		}
	};
	
	public void setCambio(int opcaoCambio){
		switch(opcaoCambio){
			case 1:
				this.cambio = Cambios.MANUAL.getNomeCambio();
				break;
			case 2:
				this.cambio = Cambios.AUTOMATICO.getNomeCambio();
				break;
			case 3:
				this.cambio = Cambios.AUTOMATIZADO.getNomeCambio();
				break;
			case 4:
				this.cambio = Cambios.CVT.getNomeCambio();
				break;
		}
	}
	
	public String getCambio(){
		return cambio;
	}
	
	public enum Tipos{//enum de tipos de carro
		HATCH(1, "Hatch"), SEDAN(2, "Sedan"), MINIVAN(3, "Minivan"), PICAPE(4, "Picape"), ESPORTIVO(5, "Esportivo");
		
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
				this.tipo = Tipos.HATCH.getNomeTipo();
				break;
			case 2:
				this.tipo = Tipos.SEDAN.getNomeTipo();
				break;
			case 3:
				this.tipo = Tipos.MINIVAN.getNomeTipo();
				break;
			case 4:
				this.tipo = Tipos.PICAPE.getNomeTipo();
				break;
			case 5:
				this.tipo = Tipos.ESPORTIVO.getNomeTipo();
				break;
		}
	}
	
	public String getTipo(){
		return tipo;
	}
	
	public enum Montadoras{//enum das montadoras de carro
		GM(1,"GM"), VOLKSWAGEN(2, "VOLKSWAGEN"), BMW(3, "BMW"), FIAT(4, "FIAT"), FORD(5, "FORD");
		
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
				this.montadora = Montadoras.GM.getNomeMontadoras();
				break;
			case 2:
				this.montadora = Montadoras.VOLKSWAGEN.getNomeMontadoras();
				break;
			case 3:
				this.montadora = Montadoras.BMW.getNomeMontadoras();
				break;
			case 4:
				this.montadora = Montadoras.FIAT.getNomeMontadoras();
				break;
			case 5:
				this.montadora = Montadoras.FORD.getNomeMontadoras();
				break;
		}
	}
	
	public String getMontadora(){
		return montadora;
	}
	
	public enum Motorizacoes{//enum das enumerações
		MOTOR10(1, (float)1.0), MOTOR13(2, (float)1.3), MOTOR14(3, (float)1.4), MOTOR15(4,(float) 1.5), MOTOR16(5, (float)1.6), MOTOR18(6, (float)1.8), MOTOR20(7, (float)2.0);
		
		private int opcaoMotorizacao;
		private float valorMotorizacao;
		
		private Motorizacoes(int opcaoMotorizacao, float valorMotorizacao){
			this.opcaoMotorizacao = opcaoMotorizacao;
			this.valorMotorizacao = valorMotorizacao;
		}
		
		public int getOpcaoMotorizacao(){
			return opcaoMotorizacao;
		}
		
		public float getValorMotorizacao(){
			return valorMotorizacao;
		}
	};
	
	public void setMotorizacao(int opcaoMotorizacao){
		switch(opcaoMotorizacao){
			case 1:
				this.motorizacao = Motorizacoes.MOTOR10.getValorMotorizacao();
				break;
			case 2:
				this.motorizacao = Motorizacoes.MOTOR13.getValorMotorizacao();
				break;
			case 3:
				this.motorizacao = Motorizacoes.MOTOR14.getValorMotorizacao();
				break;
			case 4:
				this.motorizacao = Motorizacoes.MOTOR15.getValorMotorizacao();
				break;
			case 5:
				this.motorizacao = Motorizacoes.MOTOR16.getValorMotorizacao();
				break;
			case 6:
				this.motorizacao = Motorizacoes.MOTOR18.getValorMotorizacao();
				break;
			case 7:
				this.motorizacao = Motorizacoes.MOTOR20.getValorMotorizacao();
				break;
		}
	}
	
	public float getMotorizacao(){
		return motorizacao;
	}
	
	@Override
	public Carro criarVeiculo(Scanner input){//metodo que cria o veiculo a partir do que usuario informar do teclado
		boolean temExcecao = false;
		int opcaoMontadora = 0;
		int opcaoTipo = 0;
		int opcaoCor = 0;
		int opcaoMotorizacao = 0;
		int opcaoCambio = 0;
		Carro carro = new Carro();
		
		System.out.println("Entre com o chassi do veículo:");
		carro.setChassi(input.next());
		
		do{
			System.out.println("Escolha uma montadora: ");
			System.out.println("1 - GM   \t 2 - VOLKSWAGEN \t 3 - BMW \t 4 - FIAT \t 5 - FORD");
			opcaoMontadora = Excecoes.lancaExcecaoOpcoesVeiculo(input);
			if((opcaoMontadora < 1) || (opcaoMontadora > 5)){
				Impressora.imprimeOpcaoInvalida();
				MetodosAuxiliares.pressionarEnter();
			}else{
				carro.setMontadora(opcaoMontadora);
			}
			
		}while((opcaoMontadora < 1) || (opcaoMontadora > 5));
		
		do{
			System.out.println("Entre com o tipo do veículo: ");
			System.out.println("1 - Hatch   \t 2 - Sedan \t 3 - Minivan \t 4 - Picape \t 5 - Esportivo");
			opcaoTipo = Excecoes.lancaExcecaoOpcoesVeiculo(input);
			if((opcaoTipo < 1) || (opcaoTipo > 5)){
				Impressora.imprimeOpcaoInvalida();
				MetodosAuxiliares.pressionarEnter();					
			}else{
				carro.setTipo(opcaoTipo);	
			}			
			
		}while((opcaoTipo < 1) || (opcaoTipo > 5));

		input.nextLine();
		
		System.out.println("Entre com o modelo do veículo:");
		carro.setModelo(input.nextLine());
		
		do{
			System.out.println("Selecione a cor do veículo: ");
			System.out.println("1 - azul   \t 2 - vermelho \t 3 - branco \t 4 - preto \t 5 - verde");
			opcaoCor = Excecoes.lancaExcecaoOpcoesVeiculo(input);
			if((opcaoCor < 1) || (opcaoCor > 5)){
				Impressora.imprimeOpcaoInvalida();
				MetodosAuxiliares.pressionarEnter();
			}else{
				carro.setCor(opcaoCor);	
			}				
			
		}while((opcaoCor < 1) || (opcaoCor > 5));
		
		do{
			System.out.println("Selecione a motorização do carro: ");
			System.out.println("1 - 1.0   \t 2 - 1.3 \t 3 - 1.4 \t 4 - 1.5 \t 5 - 1.6 \t 6 - 1.8 \t 7 - 2.0");
			
			opcaoMotorizacao = Excecoes.lancaExcecaoOpcoesVeiculo(input);
			
			if((opcaoMotorizacao < 1) || (opcaoMotorizacao > 7)){
				Impressora.imprimeOpcaoInvalida();
				MetodosAuxiliares.pressionarEnter();
			}else{
				carro.setCambio(opcaoMotorizacao);
			}
			
		}while((opcaoMotorizacao < 1) || (opcaoMotorizacao > 7));
		
		do{
			System.out.println("Selecione o tipo de câmbio do carro: ");
			System.out.println("1 - Manual   \t 2 - Automático \t 3 - Automatizado \t 4 - CVT");
			opcaoCambio = Excecoes.lancaExcecaoOpcoesVeiculo(input);
			if((opcaoCambio < 1) || (opcaoCambio > 4)){
				Impressora.imprimeOpcaoInvalida();
				MetodosAuxiliares.pressionarEnter();
			}else{
				carro.setCambio(opcaoCambio);
			}				
				
		}while((opcaoCambio < 1) || (opcaoCambio > 4));
		
		do{
			temExcecao = false;
			System.out.println("Entre com o preço do veículo: ");
			try{
				carro.setPreco(input.nextFloat());	
			}catch(InputMismatchException e){
				System.out.println("O preço deve ser um número.");
				MetodosAuxiliares.pressionarEnter();
				temExcecao = true;
				input.nextLine();
			}catch(Exception e){
				Impressora.imprimeErroInesperado();
				MetodosAuxiliares.pressionarEnter();
				temExcecao = true;
				input.nextLine();
			}
					
		}while(temExcecao);
		
		return carro;
	}
	
}