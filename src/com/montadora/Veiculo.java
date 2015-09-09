package com.montadora;

import java.util.ArrayList;
import java.util.Scanner;

public class Veiculo {

	public static final float PRECO_MINIMO = 1;
	private String chassi;
	private String montadora;
	private String modelo;
	private String tipo;
	private String cor;
	private float preco;
	private Especificacao especificacaoVeiculo;

	public enum tipoVeiculo {
		CARRO("Carro", 1), MOTO("Moto", 2);

		private String nome;
		private int opcao;

		private tipoVeiculo(String nome, int opcao) {
			this.nome = nome;
			this.opcao = opcao;
		}

		public String getNome() {
			return nome;
		}

		public int getOpcao() {
			return opcao;
		}
	};

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	/*public Veiculo criarVeiculo(Scanner input,
			ArrayList<Veiculo> estoqueDeVeiculo) {
		
		
		return especificacaoVeiculo;
	}*/
}
