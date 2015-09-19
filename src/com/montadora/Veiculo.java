package com.montadora;

import java.util.ArrayList;
import java.util.Scanner;

import com.utilitarios.LeVeiculos;

public class Veiculo {

	public static final float PRECO_MINIMO = 1;
	private Especificacao especificacaoVeiculo;
	private int tipoVeiculo;

	public int getTipoVeiculo() {
		return tipoVeiculo;
	}

	public void setTipoVeiculo(int tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}

	public Especificacao getEspecificacaoVeiculo() {
		return especificacaoVeiculo;
	}

	public void setEspecificacaoVeiculo(Especificacao especificacaoVeiculo) {
		this.especificacaoVeiculo = especificacaoVeiculo;
	}

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

	public Especificacao criarVeiculo(Scanner input, ArrayList<Veiculo> estoqueDeVeiculo, ArrayList<String> informacoes) {
		String texto;
		String opcoes;
		int tipoDeVeiculo = Integer.parseInt(informacoes.get(0));

		switch(tipoDeVeiculo){

			case 1: //carro
				informacoes.add(LeVeiculos.leChassi(input, estoqueDeVeiculo));

				texto = "Escolha uma montadora: ";
				opcoes = "1 - GM   \t 2 - VOLKSWAGEN \t 3 - BMW \t 4 - FIAT \t 5 - FORD";
				switch(LeVeiculos.leMontadora(input, texto, opcoes)){
					case 1:
						informacoes.add("GM");
					break;

					case 2:
						informacoes.add("VOLKSWAGEN");
					break;

					case 3:
						informacoes.add("BMW");
					break;

					case 4:
						informacoes.add("FIAT");
					break;

					case 5:
						informacoes.add("FORD");
					break;
				}

				texto = "Entre com o tipo do ve�culo: ";
				opcoes = "1 - Hatch   \t 2 - Sedan \t 3 - Minivan \t 4 - Picape \t 5 - Esportivo";
				switch(LeVeiculos.leTipo(input, texto, opcoes)){
					case 1:
						informacoes.add("Hatch");
					break;

					case 2:
						informacoes.add("Sedan");
					break;

					case 3:
						informacoes.add("Minivan");
					break;

					case 4:
						informacoes.add("Picape");
					break;

					case 5:
						informacoes.add("Esportivo");
					break;
				}

				input.nextLine();

				informacoes.add(LeVeiculos.leModelo(input));
				informacoes.add(LeVeiculos.leCor(input));
				informacoes.add(LeVeiculos.leMotorizacao(input));
				informacoes.add(LeVeiculos.leCambio(input));
				informacoes.add(LeVeiculos.lePreco(input));

			break;

			case 2:
				informacoes.add(LeVeiculos.leChassi(input, estoqueDeVeiculo));

				texto = "Escolha uma montadora: ";
				opcoes = "1 - HARLEY-DAVIDSON   \t 2 - HONDA \t 3 - SUZUKI \t 4 - KAWASAKI \t 5 - SHINERAY";
				switch(LeVeiculos.leMontadora(input, texto, opcoes)){
					case 1:
						informacoes.add("HARLEY-DAVIDSON");
					break;

					case 2:
						informacoes.add("HONDA");
					break;

					case 3:
						informacoes.add("SUZUKI");
					break;

					case 4:
						informacoes.add("KAWASAKI");
					break;

					case 5:
						informacoes.add("SHINERAY");
					break;
				}

				texto = "Entre com o tipo do ve�culo: ";
				opcoes = "1 - Scooter   \t 2 - Custom \t 3 - Roadster \t 4 - Street \t 5 - Esportiva";
				switch(LeVeiculos.leTipo(input, texto, opcoes)){
					case 1:
						informacoes.add("Scooter");
					break;

					case 2:
						informacoes.add("Custom");
					break;

					case 3:
						informacoes.add("Roadster");
					break;

					case 4:
						informacoes.add("Street");
					break;

					case 5:
						informacoes.add("Esportiva");
					break;
				}

				input.nextLine();

				informacoes.add(LeVeiculos.leModelo(input));
				informacoes.add(LeVeiculos.leCor(input));
				informacoes.add(LeVeiculos.leCilindradas(input));
				informacoes.add(LeVeiculos.leCapacidadeDoTanque(input));
				informacoes.add(LeVeiculos.lePreco(input));
			break;

	}

		Especificacao especificacao = new Especificacao(informacoes);

		return especificacao;
	}
}
