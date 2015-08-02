package com.operacional;

import java.util.Scanner;

import com.utilitarios.teste.MetodosAuxiliares;

public class Main {
	
	private static int sair = 0;

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		Loja loja = new Loja();
		int opcaoMenu;
		
		System.out.println("********MENU********\n");
		System.out.println("Entre com 1 para para adicionar veículo.");
		System.out.println("Entre com 2 para excluir veículo.");
		System.out.println("Entre com 3 para listar todos os veículos.");
		System.out.println("Entre com 4 para buscar veículo pelo número de chassi.");
		System.out.println("Entre com 5 para listar estoque de carros.");
		System.out.println("Entre com 6 para listar estoque das motos.");	
		System.out.println("Entre com a opcao desejada ou 0 para sair: ");
		opcaoMenu = input.nextInt();
		
		while(opcaoMenu != sair){			
			if(opcaoMenu != sair){
				switch(opcaoMenu){
					case 1:
						loja.adicionarVeiculo(input);
						System.out.println("Veículo adicionado ao estoque com sucesso.");
						MetodosAuxiliares.pressionarEnter();
						break;
					/*case 2:
						loja.excluirVeiculo();
						break;*/
					case 3:
						loja.listarVeiculos();
						MetodosAuxiliares.pressionarEnter();
						break;
					/*case 4:
						loja.buscarVeiculo(input.nextLine());
						break;*/
					case 5:
						loja.listarCarros();
						MetodosAuxiliares.pressionarEnter();
						break;
					case 6:
						loja.listarMotos();
						MetodosAuxiliares.pressionarEnter();
						break;
					default:
						System.out.println("Opção inválida.");
						MetodosAuxiliares.pressionarEnter();
				}
				
				System.out.println("********MENU********\n");
				System.out.println("Entre com 1 para para adicionar veículo.");
				System.out.println("Entre com 2 para excluir veículo.");
				System.out.println("Entre com 3 para listar todos os veículos.");
				System.out.println("Entre com 4 para buscar veículo pelo número de chassi.");
				System.out.println("Entre com 5 para listar estoque de carros.");
				System.out.println("Entre com 6 para listar estoque das motos.");	
				System.out.println("Entre com a opcao desejada ou 0 para sair: ");
				opcaoMenu = input.nextInt();
			}
		}
	}
}
