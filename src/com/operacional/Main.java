package com.operacional;

import java.util.Scanner;

import com.utilitarios.teste.CreateFile;
import com.utilitarios.teste.MetodosAuxiliares;

public class Main {
	
	private static int sair = 0;

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		Loja loja = new Loja();
		int opcaoMenu;
		
		opcaoMenu = MetodosAuxiliares.imprimeMenu(input);
		System.out.println("");
		
		while(opcaoMenu != sair){			
			if(opcaoMenu != sair){
				switch(opcaoMenu){
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
				opcaoMenu = MetodosAuxiliares.imprimeMenu(input);
				System.out.println("");
			}
		}
	}
}
