package com.montadora;

import java.util.Scanner;

public abstract class Veiculo {
	
	protected String chassi;
	protected String montadora;
	protected String modelo;
	protected String cor;
	protected float preco;
	
	public String getChassi() {
		return chassi;
	}
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	
	public abstract String getMontadora();
	
	public abstract void setMontadora(int opcaoMontadora);
	
	public enum Cores{
		AZUL(1,"azul"), VERMELHO(2, "vermelho"), BRANCO(3, "branco"), PRETO(4, "preto"), VERDE(5, "verde");
		
		private int opcaoCores;
		private String nomeCores;
		
		private Cores(int opcaoCores, String nomeCores){
			this.opcaoCores = opcaoCores;
			this.nomeCores = nomeCores;
		}		
		public int getOpcaoCores(){
			return opcaoCores;
		}
		public String getNomeCores(){
			return nomeCores;
		}
	};

	public void setCor(int opcaoCor){
		switch(opcaoCor){
			case 1:
				this.cor = Cores.AZUL.getNomeCores();
				break;
			case 2:
				this.cor = Cores.VERMELHO.getNomeCores();
				break;
			case 3:
				this.cor = Cores.BRANCO.getNomeCores();
				break;
			case 4:
				this.cor = Cores.PRETO.getNomeCores();
				break;
			case 5:
				this.cor = Cores.VERDE.getNomeCores();
				break;
		}
	}
	
	public String getCor() {
		return cor;
	}
	
	public float getPreco() {
		return preco;
	}
	
	public void setPreco(float preco) {
		this.preco = preco;
	}

	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	protected abstract Veiculo criarVeiculo(Scanner input);
}
