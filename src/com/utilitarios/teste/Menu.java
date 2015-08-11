package com.utilitarios.teste;

import java.util.Scanner;

import com.operacional.Loja;

public class Menu {
	
	public static void menu(){
		
		final int sair = 0;
				
		Scanner input = new Scanner(System.in);
		Loja loja = new Loja();
		int opcaoMenu;
				
		opcaoMenu = Impressora.imprimeMenu(input);
		System.out.println("");
			
		while(opcaoMenu != sair){
			switch(opcaoMenu){
				case -1:
				break;
				case 1:
					loja.adicionarVeiculo(input);
					MetodosAuxiliares.pressionarEnter();
					break;
				case 2:
					loja.excluirVeiculo(input);
					MetodosAuxiliares.pressionarEnter();
					break;
				case 3:
					loja.listarVeiculos();
					MetodosAuxiliares.pressionarEnter();
					break;
				case 4:
					loja.buscarVeiculo(input);
					MetodosAuxiliares.pressionarEnter();
					break;
				case 5:
					loja.listarCarros();
					MetodosAuxiliares.pressionarEnter();
					break;
				case 6:
					loja.listarMotos();
					MetodosAuxiliares.pressionarEnter();
					break;
				case 7:
					CreateFile file = new CreateFile();
					file.openFile();
					file.gravarEstoque(loja);
					file.closedFile();
					break;
				default:
					System.out.println("Opção inválida.");
					MetodosAuxiliares.pressionarEnter();
			}				
			opcaoMenu = Impressora.imprimeMenu(input);
			System.out.println("");
		}
	}
}