package com.loja;

import java.util.ArrayList;
import java.util.Scanner;

import com.montadora.Veiculo;
import com.utilitarios.Excecoes;
import com.utilitarios.Impressora;
import com.utilitarios.MetodosAuxiliares;

public class Loja {

	private static final int VEICULO_NAO_ENCONTRADO = -1;
	private static final int OPCAO_MINIMA = 1;
	private static final int OPCAO_MAXIMA = 2;
	private static final int POSICAO_INICIAL = 0;

	private String endereco;
	private String nome;
	private ArrayList<Veiculo> estoqueDeVeiculos = new ArrayList<Veiculo>();

	public ArrayList<Veiculo> getEstoqueDeVeiculos() {
		return estoqueDeVeiculos;
	}

	public void setEstoqueDeVeiculos(ArrayList<Veiculo> estoqueDeVeiculos) {
		this.estoqueDeVeiculos = estoqueDeVeiculos;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void adicionarVeiculo(Scanner input) {
		int opcaoDeVeiculo;
		String texto1 = "Digite 1 para adicionar um carro.";
		String texto2 = "Digite 2 para adicionar uma motocicleta.";
		String texto3 = "Entre com a opção desejada: ";

		do {// do while pra ficar pedindo pro usuario digitar novamente caso ele não entre com 1 ou 2

			opcaoDeVeiculo = Excecoes.lancaExcecaoOpcoesVeiculo(input, texto1, texto2, texto3);
			System.out.println("");

			if ((opcaoDeVeiculo < OPCAO_MINIMA) || (opcaoDeVeiculo > OPCAO_MAXIMA)) {
				System.out.println("Opção inválida. Entre com a opção novamente.");
				MetodosAuxiliares.pressionarEnterErro();
			}

		} while ((opcaoDeVeiculo < OPCAO_MINIMA) || (opcaoDeVeiculo > OPCAO_MAXIMA));

		ArrayList<String> informacoes = new ArrayList<String>();
		Veiculo veiculo = new Veiculo();

		switch (opcaoDeVeiculo) {
			case 1: //carro
				informacoes.add(String.valueOf(opcaoDeVeiculo));
				veiculo.setTipoVeiculo(opcaoDeVeiculo);
				veiculo.setEspecificacaoVeiculo(veiculo.criarVeiculo(input, this.getEstoqueDeVeiculos(), informacoes));// chama método de criar especificações
				this.estoqueDeVeiculos.add(veiculo);// adiciona carro na lista
			break;

			case 2: //moto
				informacoes.add(String.valueOf(opcaoDeVeiculo));
				veiculo.setTipoVeiculo(opcaoDeVeiculo);
				veiculo.setEspecificacaoVeiculo(veiculo.criarVeiculo(input, this.getEstoqueDeVeiculos(), informacoes));// chama método  de criar especificações
				this.estoqueDeVeiculos.add(veiculo);// adiciona carro na moto
			break;

		}
		System.out.println("Veículo adicionado ao estoque com sucesso.");
	}

	public void excluirVeiculo(Scanner input) {

		int posicaoLista = procurarVeiculo(input);//chama o método procuraVeiculo(ele retorna a posição do veiculo na lista)

		if (posicaoLista != VEICULO_NAO_ENCONTRADO) {
			this.estoqueDeVeiculos.remove(posicaoLista);// remove o veiculo que está na posição retornada pelo método
			System.out.println("Veiculo removido do estoque com sucesso.");
		} else {
			System.out.println("Veiculo não encontrado no estoque");
		}
	}

	public void listarVeiculos() {
		if (this.estoqueDeVeiculos.isEmpty()) {
			System.out.println("Estoque está vazio.");
		} else {
			for (Veiculo veiculo : this.estoqueDeVeiculos) {// for-each que percorre a lista de veiculos
				switch (veiculo.getTipoVeiculo()) {
					case 1:
						Impressora.imprimeCarro(veiculo);
					break;

					case 2:
						Impressora.imprimeMoto(veiculo);
					break;
				}
				System.out.println("");
			}
		}
	}

	public void listarCarros() {// imprime somente o estoque de carros

		for (Veiculo veiculo : this.estoqueDeVeiculos) {// percorre arraylist
			if (veiculo.getTipoVeiculo() == 1) {// checa se o veiculo é um carro, se for imprime os dados do carro na tela
				Impressora.imprimeCarro(veiculo);
				System.out.println("");
			}
		}
	}

	public void buscarVeiculo(Scanner input) {

		int posicaoLista = procurarVeiculo(input);// chama o método procuraVeiculo(ele retorna a posição do veiculo na lista)

		if (posicaoLista != VEICULO_NAO_ENCONTRADO) {
			Veiculo veiculo = this.estoqueDeVeiculos.get(posicaoLista);// recupera o veiculo que está na posição retornada pelo método

			switch (veiculo.getTipoVeiculo()) {
				case 1:
					Impressora.imprimeCarro(veiculo);
				break;

				case 2:
					Impressora.imprimeMoto(veiculo);
				break;
			}

		} else {
			System.out.println("Veiculo não encontrado no estoque");
		}
	}

	public void listarMotos() {// imprime somente estoque de motos

		for (Veiculo veiculo : this.estoqueDeVeiculos) {// percorre arraylist
			if (veiculo.getTipoVeiculo() == 2) {// checa se o veiculo é um carro, se for imprime os dados do carro na tela
				Impressora.imprimeMoto(veiculo);
				System.out.println("");
			}
		}
	}

	private int procurarVeiculo(Scanner input) {
		int posicaoLista = POSICAO_INICIAL;
		String chassi;
		Veiculo veiculo;

		input.nextLine();
		System.out.println("Entre com o chassi do veiculo: ");
		chassi = input.nextLine();

		while (posicaoLista < this.estoqueDeVeiculos.size()) {// while que percorre toda a lista e se tem o controle de que posição da lista em que ele está
			veiculo = this.estoqueDeVeiculos.get(posicaoLista);// recupera o veiculo da lista
			if (veiculo.getEspecificacaoVeiculo().getChassi().equals(chassi)) {// checa se o chassi é igual ao indicado pelo usuário
				return posicaoLista;// se for igual retorna qual posição da lista aquele veiculo está
			}
			posicaoLista++;
		}
		return VEICULO_NAO_ENCONTRADO;
	}
}
