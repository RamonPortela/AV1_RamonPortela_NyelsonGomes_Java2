package com.utilitarios;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.montadora.Especificacao;
import com.montadora.Veiculo;

public class CarregarEstoque {

	private static final int QUANTIDADE_DE_LINHAS_REGISTRO = 10;
	private static final int TEM_EXCECAO = 0;
	private static final int CARRO = 1;
	private static final int MOTO = 2;
	private static final int CHASSI = 1;

	private Scanner input;

	/**
	 * @return Verdadeiro caso tenha criado ou aberto o arquivo e Falso caso tenha ocorrido uma falha
	 * @exception Caso ocorra uma falha na abertura do arquivo, uma exceção é lançada
	 * O metodo é responsável por criar um arquivo.
	 */
	public boolean abrirArquivo() { 
		try {
			input = new Scanner(new File("Estoque.txt"));
		} catch (FileNotFoundException falhaAbertura) {
			System.err.println("Erro na criação ou Abertura do Arquivo");
			return false;
		}
		return true;
	}

	/**
	 * @param estoqueDeVeiculos - Recebe um estoque de veiculos
	 * @return Verdadeiro caso tenha o arquivo seja aberto com sucesso, e Falso caso não seja aberto.
	 * O metodo é responsável por ler o estoque de veículos salvos em um arquivo.
	 */
	public boolean lerEstoqueSalvo(ArrayList<Veiculo> estoqueDeVeiculos) {
		int contadorDeLinhas;
		boolean temExcecao;
		boolean temVeiculo = false;

		while (input.hasNext()) {
			temVeiculo = true;
			contadorDeLinhas = 0;

			if (input.nextLine().indexOf("CARRO") > 0) {
				ArrayList<String> informacoes = new ArrayList<String>();
				Veiculo veiculo = new Veiculo();

				veiculo.setTipoVeiculo(CARRO);
				informacoes.add(String.valueOf(CARRO));

				contadorDeLinhas++;

				contadorDeLinhas = leDadosVeiculoInicio(veiculo, contadorDeLinhas, informacoes);

				String[] quintaLinha = input.nextLine().split(":");
				String[] motorizacao = quintaLinha[1].split(" ");
				String motorizacaoString = motorizacao[0].trim();
				motorizacaoString = motorizacaoString.replace(",", ".");
				temExcecao = Excecoes.lancaExcecaoLeituraVeiculo(motorizacaoString, informacoes.get(CHASSI));
				if (temExcecao) {
					contadorDeLinhas = pulaLinhasParaProximoRegistro(contadorDeLinhas);
					continue;
				} else {
					informacoes.add(motorizacaoString);
				}
				contadorDeLinhas++;

				String[] sextaLinha = input.nextLine().split(":");
				String[] cambio = sextaLinha[1].split(" ");
				String cambioFormatado = cambio[0].trim();
				informacoes.add(cambioFormatado);
				contadorDeLinhas++;

				contadorDeLinhas = leDadosVeiculoFim(veiculo, contadorDeLinhas, informacoes);

				if (contadorDeLinhas == TEM_EXCECAO) {
					continue;
				}

				Especificacao especificacao = new Especificacao(informacoes);
				veiculo.setEspecificacaoVeiculo(especificacao);

				estoqueDeVeiculos.add(veiculo);

			} else {
				ArrayList<String> informacoes = new ArrayList<String>();
				Veiculo veiculo = new Veiculo();

				veiculo.setTipoVeiculo(MOTO);
				informacoes.add(String.valueOf(MOTO));
				contadorDeLinhas++;

				contadorDeLinhas = leDadosVeiculoInicio(veiculo, contadorDeLinhas, informacoes);

				String[] quintaLinha = input.nextLine().split(":");
				String[] cilindrada = quintaLinha[1].split(" ");
				String cilindradaString = cilindrada[0].trim();
				temExcecao = Excecoes.lancaExcecaoLeituraVeiculo(cilindradaString, informacoes.get(CHASSI));
				if (temExcecao) {
					contadorDeLinhas = pulaLinhasParaProximoRegistro(contadorDeLinhas);
					continue;
				} else {
					informacoes.add(cilindradaString);
				}
				contadorDeLinhas++;

				String[] sextaLinha = input.nextLine().split(":");
				String[] capacidadeDoTanque = sextaLinha[1].split(" ");
				String capacidadeDoTanqueString = capacidadeDoTanque[0].trim();
				temExcecao = Excecoes.lancaExcecaoLeituraVeiculo(capacidadeDoTanqueString, informacoes.get(CHASSI));
				if (temExcecao) {
					contadorDeLinhas = pulaLinhasParaProximoRegistro(contadorDeLinhas);
					continue;
				} else {
					informacoes.add(capacidadeDoTanqueString);
				}

				contadorDeLinhas++;

				contadorDeLinhas = leDadosVeiculoFim(veiculo, contadorDeLinhas, informacoes);

				if (contadorDeLinhas == TEM_EXCECAO) {
					continue;
				}

				Especificacao especificacao = new Especificacao(informacoes);
				veiculo.setEspecificacaoVeiculo(especificacao);

				estoqueDeVeiculos.add(veiculo);
			}

			input.nextLine();
		}

		if (!temVeiculo)
			return false;

		return true;
	}

	/**
	 * @param veiculo - Recebe um veículo criado, para guardar os dados do arquivo.
	 * @param contadorDeLinhas - Linha atual que está no arquivo.
	 * @param informacoes - Recebe as informações do veículo criado.
	 * @return Quando o arquivo for lido em outra função, ele não começar a ser lido do início.
	 */
	private int leDadosVeiculoInicio(Veiculo veiculo, int contadorDeLinhas, ArrayList<String> informacoes) {
		String[] primeiraLinha = input.nextLine().split(":");
		String[] chassi = primeiraLinha[1].split(" ");
		String chassiFormatado = chassi[0].trim();
		informacoes.add(chassiFormatado);
		contadorDeLinhas++;

		String[] segundaLinha = input.nextLine().split(":");
		String[] montadora = segundaLinha[1].split(" ");
		String montadoraFormatada = montadora[0].trim();
		informacoes.add(montadoraFormatada);
		contadorDeLinhas++;

		String[] terceiraLinha = input.nextLine().split(":");
		String[] tipo = terceiraLinha[1].split(" ");
		String tipoFormatado = tipo[0].trim();
		informacoes.add(tipoFormatado);
		contadorDeLinhas++;

		String[] quartaLinha = input.nextLine().split(":");
		String[] modelo = quartaLinha[1].split(" ");

		String modeloFormatado = "";

		for (int contadorLetrasModelo = 0; contadorLetrasModelo < (modelo.length - 1); contadorLetrasModelo++) {
			modeloFormatado = modeloFormatado.concat(modelo[contadorLetrasModelo]);
			modeloFormatado += " ";
		}
		modeloFormatado = modeloFormatado.trim();
		informacoes.add(modeloFormatado);
		contadorDeLinhas++;

		return contadorDeLinhas;
	}

	/**
	 * @param veiculo - Recebe um veículo criado, para guardar os dados do arquivo.
	 * @param contadorDeLinhas - Linha atual que está no arquivo.
	 * @param informacoes - Recebe as informações do veículo criado.
	 * @return Quando o arquivo for lido em outra função, ele não começar a ser lido do fim.
	 */
	private int leDadosVeiculoFim(Veiculo veiculo, int contadorDeLinhas, ArrayList<String> informacoes) {
		boolean temExcecao;

		String[] setimaLinha = input.nextLine().split(":");
		String[] cor = setimaLinha[1].split(" ");
		String corFormatada = cor[0].trim();
		informacoes.add(5, corFormatada);
		contadorDeLinhas++;

		String[] oitavaLinha = input.nextLine().split(":");
		String[] preco = oitavaLinha[1].split(" ");
		String precoString = preco[0].trim();
		precoString = precoString.replace(",", ".");
		temExcecao = Excecoes.lancaExcecaoLeituraVeiculo(precoString, informacoes.get(CHASSI));
		if (temExcecao) {
			contadorDeLinhas = pulaLinhasParaProximoRegistro(contadorDeLinhas);
			return TEM_EXCECAO;
		} else {
			informacoes.add(precoString);
		}
		contadorDeLinhas++;

		return contadorDeLinhas;
	}
	
	/**
	 * @param contadorDeLinhas - Recebe a linha atual.
	 * @return Retorna a linha no início do próximo registro.
	 */
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
