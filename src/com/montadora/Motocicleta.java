package com.montadora;

import java.util.Scanner;

public class Motocicleta extends Veiculo {
	
	private int cilindrada;
	private int capacidadeDoTanque;
	private String tipo;

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
	
	public String getTipo(){
		return tipo;
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
	
	public Motocicleta criarVeiculo(Scanner input) {// método que cria moto a partir do que foi informado pelo usuário
		Motocicleta moto = new Motocicleta();
		
		System.out.println("Entre com o chassi do veículo:");
		moto.setChassi(input.next());
		System.out.println("Escolha uma montadora: ");
		System.out.println("1 - HARLEY-DAVIDSON   \t 2 - HONDA \t 3 - SUZUKI \t 4 - KAWASAKI \t 5 - SHINERAY");
		moto.setMontadora(input.nextInt());
		System.out.println("Entre com o tipo do veículo: ");
		System.out.println("1 - Scooter   \t 2 - Custom \t 3 - Roadster \t 4 - Street \t 5 - Esportiva");
		moto.setTipo(input.nextInt());
		input.nextLine();
		System.out.println("Entre com o modelo do veículo:");
		moto.setModelo(input.nextLine());
		System.out.println("Selecione a cor do veículo: ");
		System.out.println("1 - azul   \t 2 - vermelho \t 3 - branco \t 4 - preto \t 5 - verde");
		moto.setCor(input.nextInt());
		System.out.println("Entre com as cilindradas da moto: ");
		moto.setCilindrada(input.nextInt());
		System.out.println("Entre com a capacidade do taque de combustível: ");
		moto.setCapacidadeDoTanque(input.nextInt());
		System.out.println("Entre com o preço do veículo: ");
		moto.setPreco(input.nextFloat());
		
		return moto;
	}
}
