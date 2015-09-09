package com.montadora;

import java.util.ArrayList;
import java.util.Scanner;

import com.utilitarios.LeVeiculos;

public class Carro extends Veiculo {
	
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
	
	public void setCambio(String cambio){
		this.cambio = cambio;
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
	
	/*public void setTipo(int opcaoTipo){
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
	
	public void setTipo(String tipo){
		this.tipo = tipo;
	}*/
	
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
	
	/*public void setMontadora(int opcaoMontadora){
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
	
	public void setMontadora(String montadora) {
		this.montadora = montadora;		
	}
	
	public String getMontadora(){
		return montadora;
	}*/
	
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
	
	public void setMotorizacao(float motorizacao){
		this.motorizacao = motorizacao;
	}
	
	public float getMotorizacao(){
		return motorizacao;
	}
	
	/*@Override
	public Carro criarVeiculo(Scanner input, ArrayList<Veiculo> estoqueDeVeiculo){//metodo que cria o veiculo a partir do que usuario informar do teclado
		Carro carro = new Carro();	
		String texto;
		String opcoes;
		
		LeVeiculos.leChassi(input, estoqueDeVeiculo, carro);
		
		texto = "Escolha uma montadora: ";
		opcoes = "1 - GM   \t 2 - VOLKSWAGEN \t 3 - BMW \t 4 - FIAT \t 5 - FORD";
		LeVeiculos.leMontadora(input, carro, texto, opcoes);
		
		texto = "Entre com o tipo do veículo: ";
		opcoes = "1 - Hatch   \t 2 - Sedan \t 3 - Minivan \t 4 - Picape \t 5 - Esportivo";
		LeVeiculos.leTipo(input, carro, texto, opcoes);
		
		input.nextLine();
		
		LeVeiculos.leModelo(input, carro);
		LeVeiculos.leCor(input, carro);		
		LeVeiculos.leMotorizacao(input, carro);
		LeVeiculos.leCambio(input, carro);		
		LeVeiculos.lePreco(input, carro);

		return carro;
	}*/

}