package com.utilitarios;

import java.util.Scanner;

import com.loja.Loja;

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
					MetodosAuxiliares.pressionarEnterErro();
					break;
				case 2:
					loja.excluirVeiculo(input);
					MetodosAuxiliares.pressionarEnterErro();
					break;
				case 3:
					loja.listarVeiculos();
					MetodosAuxiliares.pressionarEnterErro();
					break;
				case 4:
					loja.buscarVeiculo(input);
					MetodosAuxiliares.pressionarEnterErro();
					break;
				case 5:
					loja.listarCarros();
					MetodosAuxiliares.pressionarEnterErro();
					break;
				case 6:
					loja.listarMotos();
					MetodosAuxiliares.pressionarEnterErro();
					break;
				case 7:
					CreateFile file = new CreateFile();
					file.openFile();
					file.gravarEstoque(loja);
					file.closedFile();
					break;
				default:
					System.out.println("Opção inválida.");
					MetodosAuxiliares.pressionarEnterErro();
			}				
			opcaoMenu = Impressora.imprimeMenu(input);
			System.out.println("");
		}
	}
}