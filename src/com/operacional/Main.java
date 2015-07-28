package com.operacional;

import java.util.Scanner;

import com.montadora.*;
import com.operacional.Loja;

public class Main {
	
	private static int sair = 0; 

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		Loja veiculo = new Loja();
		Carro carro = new Carro();
		Motocicleta motocicleta = new Motocicleta();
		int opcaoMenu;
		
		System.out.println("********MENU********\n");
		System.out.println("Entre com 1 para listar estoque dos Carros.");
		System.out.println("Entre com 2 para adicionar Carro.");
		System.out.println("Entre com 3 para excluir Carro.");
		System.out.println("Entre com 4 para buscar Carro.");
		System.out.println("Entre com 5 para listar estoque das Moto.");
		System.out.println("Entre com 6 para adicionar Moto.");	
		System.out.println("Entre com 7 para excluir Moto.");
		System.out.println("Entre com a opcao desejada ou 0 para sair: ");
		opcaoMenu = input.nextInt();
		
		if(opcaoMenu != sair){
			switch(opcaoMenu){
			case 1:
				veiculo.listarEstoquedeCarros();
				break;
			case 2:
				veiculo.adicionarCarro(carro);
				break;
			case 3:
				veiculo.excluirCarro(input.nextInt());
				break;
			case 4:
				veiculo.buscarCarro(input.nextLine());
				break;
			case 5:
				veiculo.listarMotocicleta();
				break;
			case 6:
				veiculo.buscarMotocicleta(input.nextLine());
				break;
			case 7:
				veiculo.excluirMotocicleta(input.nextInt());
			}
		}

	}

}
