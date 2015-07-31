package com.montadora;

public abstract class Veiculo {

	public void setCor(String cor) {
		this.cor = cor;
	}

	protected String chassi;
	protected String montadora;
	protected String modelo;
	protected String tipo;
	protected String cor;	
	
	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getMontadora() {
		return montadora;
	}

	public void setMontadora(String montadora) {
		this.montadora = montadora;
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

	protected abstract void criarVeiculo();
}
