package com.montadora;

import java.util.Scanner;

public class Carro extends Veiculo {
	
	private String cambio;
	private float motorizacao;
	
	public enum Cambios{
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
	
	public enum Montadoras{
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
	
	public enum Motorizacoes{
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
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public Carro criarVeiculo(Scanner input){
		
		Carro carro = new Carro();
		
		System.out.println("Entre com o chassi do veículo:");
		carro.setChassi(input.next());
		System.out.println("Escolha uma montadora: ");
		System.out.println("1 - GM   \t 2 - VOLKSWAGEN \t 3 - BMW \t 4 - FIAT \t 5 - FORD");
		carro.setMontadora(input.nextInt());
		System.out.println("Selecione a cor do veículo: ");
		System.out.println("1 - azul   \t 2 - vermelho \t 3 - branco \t 4 - preto \t 5 - verde");
		carro.setCor(input.nextInt());
		System.out.println("Entre com o modelo do veículo:");
		carro.setModelo(input.next());
		
		
		carro.setMotorizacao(50);
		return carro;
	}
	
}
