package com.montadora;

public class Carro extends Veiculo {
	
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

	private String cambio;
	private float motorizacao;
	private float preco;	
	
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
	public String getChassi() {
		return chassi;
	}
	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getCambio() {
		return cambio;
	}
	public void setCambio(String cambio) {
		this.cambio = cambio;
	}
	public float getMotorizacao() {
		return motorizacao;
	}
	public void setMotorizacao(float motorizacao) {
		this.motorizacao = motorizacao;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}	
	
}
