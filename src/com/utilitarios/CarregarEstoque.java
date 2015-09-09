package com.utilitarios;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.montadora.Carro;
import com.montadora.Motocicleta;
import com.montadora.Veiculo;

public class CarregarEstoque {

	private static final int QUANTIDADE_DE_LINHAS_REGISTRO = 10;
	private static final int TEM_EXCECAO = 0;

	private Scanner input;

	public boolean abrirArquivo() {
		try {
			input = new Scanner(new File("Estoque.txt"));
		} catch (FileNotFoundException falhaAbertura) {
			System.err.println("Erro na criação ou Abertura do Arquivo");
			return false;
		}
		return true;
	}

	public boolean lerEstoqueSalvo(ArrayList<Veiculo> estoqueDeVeiculos) {
		int contadorDeLinhas;
		boolean temExcecao;
		boolean temVeiculo = false;

		while (input.hasNext()) {
			temVeiculo = true;
			contadorDeLinhas = 0;

			if (input.nextLine().indexOf("CARRO") > 0) {
				Carro carro = new Carro();
				contadorDeLinhas++;

				contadorDeLinhas = leDadosVeiculoInicio(carro, contadorDeLinhas);

				String[] quintaLinha = input.nextLine().split(":");
				String[] motorizacao = quintaLinha[1].split(" ");
				String motorizacaoString = motorizacao[0].trim();
				motorizacaoString = motorizacaoString.replace(",", ".");
				temExcecao = Excecoes.lancaExcecaoLeituraVeiculo(motorizacaoString, carro.getChassi());
				if (temExcecao) {
					contadorDeLinhas = pulaLinhasParaProximoRegistro(contadorDeLinhas);
					continue;
				} else {
					float motorizacaoFormatado = Float.parseFloat(motorizacaoString);
					carro.setMotorizacao(motorizacaoFormatado);
				}
				contadorDeLinhas++;

				String[] sextaLinha = input.nextLine().split(":");
				String[] cambio = sextaLinha[1].split(" ");
				String cambioFormatado = cambio[0].trim();
				carro.setCambio(cambioFormatado);
				contadorDeLinhas++;

				contadorDeLinhas = leDadosVeiculoFim(carro, contadorDeLinhas);

				if (contadorDeLinhas == TEM_EXCECAO) {
					continue;
				}

				estoqueDeVeiculos.add(carro);
			} else {
				Motocicleta moto = new Motocicleta();
				contadorDeLinhas++;

				contadorDeLinhas = leDadosVeiculoInicio(moto, contadorDeLinhas);

				String[] quintaLinha = input.nextLine().split(":");
				String[] cilindrada = quintaLinha[1].split(" ");
				String cilindradaString = cilindrada[0].trim();
				temExcecao = Excecoes.lancaExcecaoLeituraVeiculo(cilindradaString, moto.getChassi());
				if (temExcecao) {
					contadorDeLinhas = pulaLinhasParaProximoRegistro(contadorDeLinhas);
					continue;
				} else {
					int cilindradaFormatada = Integer.parseInt(cilindradaString);
					moto.setCilindrada(cilindradaFormatada);
				}
				contadorDeLinhas++;

				String[] sextaLinha = input.nextLine().split(":");
				String[] capacidadeDoTanque = sextaLinha[1].split(" ");
				String capacidadeDoTanqueString = capacidadeDoTanque[0].trim();
				temExcecao = Excecoes.lancaExcecaoLeituraVeiculo(capacidadeDoTanqueString, moto.getChassi());
				if (temExcecao) {
					contadorDeLinhas = pulaLinhasParaProximoRegistro(contadorDeLinhas);
					continue;
				} else {
					int capacidadeDoTanqueFormatada = Integer.parseInt(capacidadeDoTanqueString);
					moto.setCapacidadeDoTanque(capacidadeDoTanqueFormatada);
				}

				contadorDeLinhas++;

				contadorDeLinhas = leDadosVeiculoFim(moto, contadorDeLinhas);

				if (contadorDeLinhas == TEM_EXCECAO) {
					continue;
				}

				estoqueDeVeiculos.add(moto);
			}

			input.nextLine();
		}
		
		if (!temVeiculo)
			return false;

		return true;
	}

	private int leDadosVeiculoInicio(Veiculo veiculo, int contadorDeLinhas) {
		String[] primeiraLinha = input.nextLine().split(":");
		String[] chassi = primeiraLinha[1].split(" ");
		String chassiFormatado = chassi[0].trim();
		veiculo.setChassi(chassiFormatado);
		contadorDeLinhas++;

		String[] segundaLinha = input.nextLine().split(":");
		String[] montadora = segundaLinha[1].split(" ");
		String montadoraFormatada = montadora[0].trim();
		//veiculo.setMontadora(montadoraFormatada);
		contadorDeLinhas++;

		String[] terceiraLinha = input.nextLine().split(":");
		String[] tipo = terceiraLinha[1].split(" ");
		String tipoFormatado = tipo[0].trim();
		//veiculo.setTipo(tipoFormatado);
		contadorDeLinhas++;

		String[] quartaLinha = input.nextLine().split(":");
		String[] modelo = quartaLinha[1].split(" ");

		String modeloFormatado = "";

		for (int contadorLetrasModelo = 0; contadorLetrasModelo < (modelo.length - 1); contadorLetrasModelo++) {
			modeloFormatado = modeloFormatado.concat(modelo[contadorLetrasModelo]);
			modeloFormatado += " ";
		}
		modeloFormatado = modeloFormatado.trim();
		//veiculo.setModelo(modeloFormatado);
		contadorDeLinhas++;

		return contadorDeLinhas;
	}

	private int leDadosVeiculoFim(Veiculo veiculo, int contadorDeLinhas) {
		boolean temExcecao;

		String[] setimaLinha = input.nextLine().split(":");
		String[] cor = setimaLinha[1].split(" ");
		String corFormatada = cor[0].trim();
		//veiculo.setCor(corFormatada);
		contadorDeLinhas++;

		String[] oitavaLinha = input.nextLine().split(":");
		String[] preco = oitavaLinha[1].split(" ");
		String precoString = preco[0].trim();
		precoString = precoString.replace(",", ".");
		temExcecao = Excecoes.lancaExcecaoLeituraVeiculo(precoString, veiculo.getChassi());
		if (temExcecao) {
			contadorDeLinhas = pulaLinhasParaProximoRegistro(contadorDeLinhas);
			return TEM_EXCECAO;
		} else {
			float precoFormatado = Float.parseFloat(precoString);
			veiculo.setPreco(precoFormatado);
		}
		contadorDeLinhas++;

		return contadorDeLinhas;
	}

	private int pulaLinhasParaProximoRegistro(int contadorDeLinhas) {
		for (int contador = ++contadorDeLinhas; contador < QUANTIDADE_DE_LINHAS_REGISTRO; contador++) {
			input.nextLine();
		}
		return contadorDeLinhas;
	}

	public void fecharArquivo() {
		if (input != null) {
			input.close();
		} else if (input == null) {
			System.out.println("Erro na Leitura do Arquivo.");
		}
	}
}
