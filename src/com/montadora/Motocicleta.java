package com.montadora;

import java.util.Scanner;

public class Motocicleta extends Veiculo {
	
	private int cilindrada;
	private int capacidadeDoTanque;
	private String tipo;
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getMontadora() {
		return montadora;
	}
	public void setMontadora(String montadora) {
		this.montadora = montadora;
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
	public void setMontadora(int opcaoMontadora) {
		// TODO Auto-generated method stub
		
	}
	
	public Motocicleta criarVeiculo(Scanner input) {
		Motocicleta moto = new Motocicleta();
		
		return moto;
	}

}
