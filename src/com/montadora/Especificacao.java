package com.montadora;

import java.util.HashMap;

public class Especificacao {

	HashMap<String, Float> especificacaoVeiculo;

	public Especificacao(HashMap<String, Float> veiculo) {
		especificacaoVeiculo = veiculo;
	}

	public void setMontadora(int opcaoMontadora) {
		float montadora = opcaoMontadora;
		especificacaoVeiculo.put("montadora", montadora);
	}

	public void setTipo(int opcaoTipo) {
		float tipo = opcaoTipo;
		especificacaoVeiculo.put("tipo", tipo);
	}

	public void setCor(int opcaoCor) {
		float cor = opcaoCor;
		especificacaoVeiculo.put("cor", cor);
	}

	public void setModelo(int opcaoModelo) {
		float modelo = opcaoModelo;
		especificacaoVeiculo.put("modelo", modelo);
	}

	public float getOpcaoMontadora() {
		return especificacaoVeiculo.get("montadora").floatValue();
	}

	public float getOpcaoTipo() {
		return especificacaoVeiculo.get("tipo").floatValue();
	}

	public float getOpcaoCor() {
		return especificacaoVeiculo.get("cor").floatValue();
	}

	public float getOpcaoModelo() {
		return especificacaoVeiculo.get("modelo").floatValue();
	}

	public enum Cores {// enum das cores
		AZUL(1, "azul"), VERMELHO(2, "vermelho"), BRANCO(3, "branco"), PRETO(4,
				"preto"), VERDE(5, "verde");

		private int opcaoCores;
		private String nomeCores;

		private Cores(int opcaoCores, String nomeCores) {// construtor do enum
			this.opcaoCores = opcaoCores;
			this.nomeCores = nomeCores;
		}

		public int getOpcaoCores() {
			return opcaoCores;
		}

		public String getNomeCores() {
			return nomeCores;
		}
	};

	// eu sei que tem um problema
	/*
	 * public void setCor(int opcaoCor) {// seleciona uma cor a partir do que
	 * foi digitado no teclado switch (opcaoCor) { case 1: this.cor =
	 * Cores.AZUL.getNomeCores(); break; case 2: this.cor =
	 * Cores.VERMELHO.getNomeCores(); break; case 3: this.cor =
	 * Cores.BRANCO.getNomeCores(); break; case 4: this.cor =
	 * Cores.PRETO.getNomeCores(); break; case 5: this.especificacaoVeiculo =
	 * Cores.VERDE.getNomeCores(); break; } }
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((especificacaoVeiculo == null) ? 0 : especificacaoVeiculo
						.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Especificacao other = (Especificacao) obj;
		if (especificacaoVeiculo == null) {
			if (other.especificacaoVeiculo != null)
				return false;
		} else if (!especificacaoVeiculo.equals(other.especificacaoVeiculo))
			return false;
		return true;
	}

	public boolean comparaVeiculo(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Especificacao other = (Especificacao) obj;
		if (especificacaoVeiculo == null) {
			if (other.especificacaoVeiculo != null)
				return false;
		} else {
			if (other.especificacaoVeiculo.get("cambio") != null) {
				if (other.especificacaoVeiculo.get("cambio").floatValue() != especificacaoVeiculo
						.get("cambio").floatValue()) {
					return false;
				}
			}
			if (other.especificacaoVeiculo.get("montadora") != null) {
				if (other.especificacaoVeiculo.get("montadora").floatValue() != especificacaoVeiculo
						.get("montadora").floatValue()) {
					return false;
				}
			}
			if (other.especificacaoVeiculo.get("tipo") != null) {
				if (other.especificacaoVeiculo.get("tipo").floatValue() != especificacaoVeiculo
						.get("tipo").floatValue()) {
					return false;
				}
			}
			if (other.especificacaoVeiculo.get("motorizacao") != null) {
				if (other.especificacaoVeiculo.get("motorizacao").floatValue() != especificacaoVeiculo
						.get("motorizacao").floatValue()) {
					return false;
				}
			}
			if (other.especificacaoVeiculo.get("cilindrada") != null) {
				if (other.especificacaoVeiculo.get("cilindrada").floatValue() != especificacaoVeiculo
						.get("cilindrada").floatValue()) {
					return false;
				}
			}
			if (other.especificacaoVeiculo.get("capacidadeDoTanque") != null) {
				if (other.especificacaoVeiculo.get("capacidadeDoTanque")
						.floatValue() != especificacaoVeiculo.get(
						"capacidadeDoTanque").floatValue()) {
					return false;
				}
			}
			if (other.especificacaoVeiculo.get("cor") != null) {
				if (other.especificacaoVeiculo.get("cor").floatValue() != especificacaoVeiculo
						.get("cor").floatValue()) {
					return false;
				}
			}
		}
		return true;
	}

}
