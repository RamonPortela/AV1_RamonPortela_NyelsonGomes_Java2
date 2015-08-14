package com.utilitarios;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

import com.loja.Loja;
import com.montadora.Veiculo;

public class Menu {

	public static void menu() {

		final int sair = 0;

		Scanner input = new Scanner(System.in);
		Loja loja = new Loja();
		int opcaoMenu;

		opcaoMenu = Impressora.imprimeMenu(input);
		System.out.println("");

		while (opcaoMenu != sair) {
			switch (opcaoMenu) {
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
				if (file.abrirArquivo()) {
					file.gravarEstoque(loja);
					file.fecharArquivo();
					System.out.println("Estoque salvo com sucesso.");
					MetodosAuxiliares.pressionarEnter();
				} else {
					System.out.println("Um erro ocorreu durante o processo de salvar o arquivo.");
					MetodosAuxiliares.pressionarEnter();
				}
				break;
				
			case 8:
				CarregarEstoque arquivo = new CarregarEstoque();
				boolean temVeiculo;
				
				ArrayList<Veiculo> estoqueDeVeiculos = loja.getEstoqueDeVeiculos();
				estoqueDeVeiculos.clear();
				
				if(arquivo.abrirArquivo()){
					temVeiculo = arquivo.lerEstoqueSalvo(estoqueDeVeiculos);
					if(temVeiculo){
						loja.setEstoqueDeVeiculos(estoqueDeVeiculos);
						System.out.println("Estoque carregado com sucesso.");
					}else{
						System.out.println("Não há veiculos para serem carrados.");
					}
					arquivo.fecharArquivo();
					MetodosAuxiliares.pressionarEnter();
				}else{
					System.out.println("Um erro ocrreu durante o processo de carregar o arquivo.");
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