package com.operacional.loja;

import java.util.ArrayList;
import java.util.Scanner;

import com.auxiliar.MetodosAuxiliares;
import com.operacional.montadora.Especificacao;
import com.operacional.montadora.Veiculo;
import com.operacional.utilitarios.Excecoes;
import com.operacional.utilitarios.Impressora;
import com.operacional.utilitarios.LeVeiculos;

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

	/**
	 * @param input - Para evitar instanciar um novo Scanner
	 * O metodo é responsavel por adicionar um veículo no estoque
	 */
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
				veiculo.setEspecificacaoVeiculo(veiculo.criarEspecificacao(input, this.getEstoqueDeVeiculos(), informacoes));// chama método de criar especificações
				this.estoqueDeVeiculos.add(veiculo);// adiciona carro na lista
			break;

			case 2: //moto
				informacoes.add(String.valueOf(opcaoDeVeiculo));
				veiculo.setTipoVeiculo(opcaoDeVeiculo);
				veiculo.setEspecificacaoVeiculo(veiculo.criarEspecificacao(input, this.getEstoqueDeVeiculos(), informacoes));// chama método  de criar especificações
				this.estoqueDeVeiculos.add(veiculo);// adiciona carro na moto
			break;

		}
		System.out.println("Veículo adicionado ao estoque com sucesso.");
	}

	/**
	 * @param input - Para evitar instanciar um novo Scanner
	 * O metodo é responsável por excluir um determinado veículo do estoque
	 */
	public void excluirVeiculo(Scanner input) {

		int posicaoLista = procurarVeiculo(input);//chama o método procuraVeiculo(ele retorna a posição do veiculo na lista)

		if (posicaoLista != VEICULO_NAO_ENCONTRADO) {
			this.estoqueDeVeiculos.remove(posicaoLista);// remove o veiculo que está na posição retornada pelo método
			System.out.println("Veiculo removido do estoque com sucesso.");
		} else {
			System.out.println("Veiculo não encontrado no estoque");
		}
	}


	public void listarVeiculos() { // Lista todos os veiculos encontrados no estoque
		if (this.estoqueDeVeiculos.isEmpty()) { // Verifica se o estoque está vazio
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

	/**
	 * @param input  - Para evitar instanciar um novo Scanner
	 * O metodo faz uma busca por uma especificação passado pelo usuário
	 */
	public void buscarEspecificacao(Scanner input){

		ArrayList<String> informacoes = new ArrayList<String>();
		int opcaoDeVeiculo;
		String texto1 = "Digite 1 para pesquisar um carro.";
		String texto2 = "Digite 2 para pesquisar uma motocicleta.";
		String texto3 = "Entre com a opção desejada: ";

		do {// do while pra ficar pedindo pro usuario digitar novamente caso ele não entre com 1 ou 2

			opcaoDeVeiculo = Excecoes.lancaExcecaoOpcoesVeiculo(input, texto1, texto2, texto3);
			System.out.println("");

			if ((opcaoDeVeiculo < OPCAO_MINIMA) || (opcaoDeVeiculo > OPCAO_MAXIMA)) {
				System.out.println("Opção inválida. Entre com a opção novamente.");
				MetodosAuxiliares.pressionarEnterErro();
			}

		} while ((opcaoDeVeiculo < OPCAO_MINIMA) || (opcaoDeVeiculo > OPCAO_MAXIMA));

		informacoes.add(String.valueOf(opcaoDeVeiculo));

		String texto;
		String opcoes;
		switch(opcaoDeVeiculo){

		case 1: //carro
			informacoes.add(null);

			texto = "Escolha uma montadora: ";
			opcoes = "0 - Qualquer \t 1 - GM   \t 2 - VOLKSWAGEN \t 3 - BMW \t 4 - FIAT \t 5 - FORD";
			switch(LeVeiculos.leMontadora(input, texto, opcoes, true)){

				case 0:
				informacoes.add(null);
				break;

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

			texto = "Entre com o tipo do veículo: ";
			opcoes = "0 - Qualquer \t 1 - Hatch   \t 2 - Sedan \t 3 - Minivan \t 4 - Picape \t 5 - Esportivo";
			switch(LeVeiculos.leTipo(input, texto, opcoes, true)){

				case 0:
				informacoes.add(null);
				break;

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

			informacoes.add(LeVeiculos.leModelo(input, true));
			informacoes.add(LeVeiculos.leCor(input, true));
			informacoes.add(LeVeiculos.leMotorizacao(input, true));
			informacoes.add(LeVeiculos.leCambio(input, true));
			informacoes.add(null);

		break;

		case 2:
			informacoes.add(null);

			texto = "Escolha uma montadora: ";
			opcoes = "0 - Qualquer \t 1 - HARLEY-DAVIDSON   \t 2 - HONDA \t 3 - SUZUKI \t 4 - KAWASAKI \t 5 - SHINERAY";
			switch(LeVeiculos.leMontadora(input, texto, opcoes, true)){

				case 0:
				informacoes.add(null);
				break;

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

			texto = "Entre com o tipo do veículo: ";
			opcoes = "0 - Qualquer \t 1 - Scooter   \t 2 - Custom \t 3 - Roadster \t 4 - Street \t 5 - Esportiva";
			switch(LeVeiculos.leTipo(input, texto, opcoes, true)){

				case 0:
				informacoes.add(null);
				break;

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

			informacoes.add(LeVeiculos.leModelo(input, true));
			informacoes.add(LeVeiculos.leCor(input, true));
			informacoes.add(LeVeiculos.leCilindradas(input, true));
			informacoes.add(LeVeiculos.leCapacidadeDoTanque(input, true));
			informacoes.add(null);
		break;

		}
		ArrayList<Veiculo> veiculosEncontrados = new ArrayList<Veiculo>();
		Especificacao especificacaoVeiculo = new Especificacao(informacoes);

		for(Veiculo veiculo : this.estoqueDeVeiculos){
			if(veiculo.getEspecificacaoVeiculo().comparaVeiculo(especificacaoVeiculo)){
				if(opcaoDeVeiculo == veiculo.getTipoVeiculo()){
					veiculosEncontrados.add(veiculo);
				}
			}
		}

		if(veiculosEncontrados.isEmpty()){
			System.out.println("\nNão foram encontrados veiculos com especificações solicitadas.\n");
		}
		else{
			for(Veiculo veiculo : veiculosEncontrados){

				switch(veiculo.getTipoVeiculo()){
				case 1:
					Impressora.imprimeCarro(veiculo);
					break;
				case 2:
					Impressora.imprimeMoto(veiculo);
					break;
				}
			}
		}

	}

	/**
	 * @param input - Para evitar instanciar um novo Scanner
	 * O metodo faz uma busca no estoque retornando todos os veiculos encontrados
	 */
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

	/**
	 * @param input - Para evitar instanciar um novo Scanner
	 * @return retorna um numero positivo quando um veículo é encontrado e um numero negativo quando não é encontrado no estoque
	 * O metodo faz uma busca no estoque pelo chassi e retorna todos os veiculos encontrados
	 */
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
