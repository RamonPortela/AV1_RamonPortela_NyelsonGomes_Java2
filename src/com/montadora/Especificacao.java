package com.montadora;

import java.util.ArrayList;
import java.util.HashMap;

public class Especificacao {

	HashMap<String, String> especificacaoVeiculo; // Mapa para adicionar as especificacoes dos veiculos

	public Especificacao(HashMap<String, String> veiculo) {
		especificacaoVeiculo = veiculo;
	}

	/**
	 * @param informacoes - Array List com as especificações passadas pelo usuário
	 * O construtor pede todas as especificações do veículo 
	 */
	public Especificacao(ArrayList<String> informacoes) {
		int posicaoArray = 0;
		int tipoDeVeiculo = Integer.parseInt(informacoes.get(posicaoArray));

		especificacaoVeiculo = new HashMap<String, String>();

		switch(tipoDeVeiculo){

			case 1:
				posicaoArray++;
				especificacaoVeiculo.put("chassi", informacoes.get(posicaoArray));
				posicaoArray++;
				especificacaoVeiculo.put("montadora", informacoes.get(posicaoArray));
				posicaoArray++;
				especificacaoVeiculo.put("tipo", informacoes.get(posicaoArray));
				posicaoArray++;
				especificacaoVeiculo.put("modelo", informacoes.get(posicaoArray));
				posicaoArray++;
				especificacaoVeiculo.put("cor", informacoes.get(posicaoArray));
				posicaoArray++;
				especificacaoVeiculo.put("motorizacao", informacoes.get(posicaoArray));
				posicaoArray++;
				especificacaoVeiculo.put("cambio", informacoes.get(posicaoArray));
				posicaoArray++;
				especificacaoVeiculo.put("preco", informacoes.get(posicaoArray));
				break;

			case 2:
				posicaoArray++;
				especificacaoVeiculo.put("chassi", informacoes.get(posicaoArray));
				posicaoArray++;
				especificacaoVeiculo.put("montadora", informacoes.get(posicaoArray));
				posicaoArray++;
				especificacaoVeiculo.put("tipo", informacoes.get(posicaoArray));
				posicaoArray++;
				especificacaoVeiculo.put("modelo", informacoes.get(posicaoArray));
				posicaoArray++;
				especificacaoVeiculo.put("cor", informacoes.get(posicaoArray));
				posicaoArray++;
				especificacaoVeiculo.put("cilindradas", informacoes.get(posicaoArray));
				posicaoArray++;
				especificacaoVeiculo.put("capacidadeDoTanque", informacoes.get(posicaoArray));
				posicaoArray++;
				especificacaoVeiculo.put("preco", informacoes.get(posicaoArray));
				break;

		}
	}

	public String getChassi(){
		return especificacaoVeiculo.get("chassi");
	}

	public String getMontadora(){
		return especificacaoVeiculo.get("montadora");
	}

	public String getTipo(){
		return especificacaoVeiculo.get("tipo");
	}

	public String getModelo(){
		return especificacaoVeiculo.get("modelo");
	}

	public String getCor(){
		return especificacaoVeiculo.get("cor");
	}

	public String getPreco(){
		return especificacaoVeiculo.get("preco");
	}

	public String getMotorizacao(){
		return especificacaoVeiculo.get("motorizacao");
	}

	public String getCambio(){
		return especificacaoVeiculo.get("cambio");
	}

	public String getCilindrada(){
		return especificacaoVeiculo.get("cilindradas");
	}

	public String getCapacidadeDoTanque(){
		return especificacaoVeiculo.get("capacidadeDoTanque");
	}

	public HashMap<String, String> getEspecificacaoVeiculo() {
		return especificacaoVeiculo;
	}

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

	/**
	 * @param obj - Contém um objeto do tipo Veículo
	 * @return Caso a comparação da especificação do veículo seja a mesma que o usuário solicitou é retornado verdadeiro, caso não, falso.
	 * O método é responsável por retornar a comparação de uma especificação
	 */
	public boolean comparaVeiculo(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Especificacao outro = (Especificacao) obj;
		if (especificacaoVeiculo == null) {
			if (outro.especificacaoVeiculo != null)
				return false;
		} else {
			if (outro.especificacaoVeiculo.get("cambio") != null) {
				if (!outro.especificacaoVeiculo.get("cambio").equals(especificacaoVeiculo
						.get("cambio"))) {
					return false;
				}
			}
			if (outro.especificacaoVeiculo.get("montadora") != null) {
				if (!outro.especificacaoVeiculo.get("montadora").equals(especificacaoVeiculo
						.get("montadora"))) {
					return false;
				}
			}
			if (outro.especificacaoVeiculo.get("tipo") != null) {
				if (!outro.especificacaoVeiculo.get("tipo").equals(especificacaoVeiculo
						.get("tipo"))) {
					return false;
				}
			}
			if (outro.especificacaoVeiculo.get("motorizacao") != null) {
				if (!outro.especificacaoVeiculo.get("motorizacao").equals(especificacaoVeiculo
						.get("motorizacao"))) {
					return false;
				}
			}
			if (outro.especificacaoVeiculo.get("cilindrada") != null) {
				if (!outro.especificacaoVeiculo.get("cilindrada").equals(especificacaoVeiculo
						.get("cilindrada"))) {
					return false;
				}
			}
			if (outro.especificacaoVeiculo.get("capacidadeDoTanque") != null) {
				if (!outro.especificacaoVeiculo.get("capacidadeDoTanque").equals(especificacaoVeiculo.get(
						"capacidadeDoTanque"))) {
					return false;
				}
			}
			if (outro.especificacaoVeiculo.get("cor") != null) {
				if (!outro.especificacaoVeiculo.get("cor").equals(especificacaoVeiculo
						.get("cor"))) {
					return false;
				}
			}
		}
		return true;
	}

}
