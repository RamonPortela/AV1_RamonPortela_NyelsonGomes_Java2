package com.operacional.utilitarios;

import java.util.Scanner;

import com.auxiliar.MetodosAuxiliares;
import com.operacional.montadora.Veiculo;

public class Impressora {

	public static void imprimeCarro(Veiculo veiculo) {
		System.out.println("-------CARRO-------");
		System.out.println("chassi: " + veiculo.getEspecificacaoVeiculo().getChassi());
		System.out.println("Montadora: " + veiculo.getEspecificacaoVeiculo().getMontadora());
		System.out.println("Tipo: " + veiculo.getEspecificacaoVeiculo().getTipo());
		System.out.println("Modelo: " + veiculo.getEspecificacaoVeiculo().getModelo());
		System.out.println("Cor: " + veiculo.getEspecificacaoVeiculo().getCor());
		System.out.println("motorizacao: " + veiculo.getEspecificacaoVeiculo().getMotorizacao());
		System.out.println("Cambio: " + veiculo.getEspecificacaoVeiculo().getCambio());
		System.out.println("Pre�o: " + veiculo.getEspecificacaoVeiculo().getPreco());
	}

	public static void imprimeMoto(Veiculo veiculo) {
		System.out.println("-------MOTO-------");
		System.out.println("chassi: " + veiculo.getEspecificacaoVeiculo().getChassi());
		System.out.println("Montadora: " + veiculo.getEspecificacaoVeiculo().getMontadora());
		System.out.println("Tipo: " + veiculo.getEspecificacaoVeiculo().getTipo());
		System.out.println("Modelo: " + veiculo.getEspecificacaoVeiculo().getModelo());
		System.out.println("Cor: " + veiculo.getEspecificacaoVeiculo().getCor());
		System.out.println("Cilindradas: " + veiculo.getEspecificacaoVeiculo().getCilindrada());
		System.out.println("Capacidade do tanque: "+ veiculo.getEspecificacaoVeiculo().getCapacidadeDoTanque() + " Litros");
		System.out.println("Pre�o: " + veiculo.getEspecificacaoVeiculo().getPreco());
	}

	public static int imprimeMenu(Scanner input) {
		int opcaoMenu = -1;

		System.out.println("********MENU********\n");
		System.out.println("Entre com 1 para para adicionar ve�culo.");
		System.out.println("Entre com 2 para excluir ve�culo.");
		System.out.println("Entre com 3 para listar todos os ve�culos.");
		System.out.println("Entre com 4 para buscar ve�culo pelo n�mero de chassi.");
		System.out.println("Entre com 5 para pesquisar veiculo por especifica��o.");
		System.out.println("Entre com 6 para listar estoque de carros.");
		System.out.println("Entre com 7 para listar estoque das motos.");
		System.out.println("Entre com 8 para salvar o estoque em um arquivo.");
		System.out.println("Entre com 9 para recuperar um estoque salvo.");
		System.out.print("Entre com a opcao desejada ou 0 para sair: ");
		opcaoMenu = MetodosAuxiliares.leOpcaoMenu(input, opcaoMenu);

		return opcaoMenu;
	}

	public static void imprimeOpcaoInvalida() {
		System.err.println("Op��o digitada inv�lida, entre com uma opcao v�lida.");
	}

	public static void imprimeErroInesperado() {
		System.err.println("Um erro inesperado ocorreu, por favor entre com a op��o novamente.");
	}

}
