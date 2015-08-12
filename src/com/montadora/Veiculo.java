package com.montadora;

import java.util.Scanner;

public abstract class Veiculo {
	
	protected String chassi;
	protected String montadora;
	protected String modelo;
	protected String tipo;
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
	public abstract void setMontadora(String montadora);
	
	public String getTipo(){
		return tipo;
	}
	
	public abstract void setTipo(int opcaoTipo);
	public abstract void setTipo(String tipo);
	
	public enum Cores{//enum das cores
		AZUL(1,"azul"), VERMELHO(2, "vermelho"), BRANCO(3, "branco"), PRETO(4, "preto"), VERDE(5, "verde");
		
		private int opcaoCores;
		private String nomeCores;
		
		private Cores(int opcaoCores, String nomeCores){//construtor do enum
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

	public void setCor(int opcaoCor){//seleciona uma cor a partir do que foi digitado no teclado
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
	
	public void setCor(String cor){
		this.cor = cor;
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
	
	public abstract Veiculo criarVeiculo(Scanner input);//força as subclasses a fazerem esse método obrigatóriamente
}
