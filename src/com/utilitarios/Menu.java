package com.utilitarios;

import java.util.ArrayList;
import java.util.Scanner;

import com.loja.Loja;
import com.montadora.Veiculo;

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
					SalvaEstoque file = new SalvaEstoque();
					if(file.abrirArquivo()){
						file.gravarEstoque(loja);
						file.fecharArquivo();						
					}else{
						MetodosAuxiliares.pressionarEnter();
					}

					break;
				case 8:
					CarregarEstoque arquivo = new CarregarEstoque();
					
					ArrayList<Veiculo> estoqueDeVeiculos = loja.getEstoqueDeVeiculos();
					estoqueDeVeiculos.clear();
					
					if(arquivo.abrirArquivo()){
						arquivo.lerEstoqueSalvo(estoqueDeVeiculos);
						arquivo.fecharArquivo();
						loja.setEstoqueDeVeiculos(estoqueDeVeiculos);
					}else{
						MetodosAuxiliares.pressionarEnter();
					}

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