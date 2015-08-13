package com.utilitarios;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Excecoes {
	public static int lancaExcecaoOpcoesVeiculo(Scanner input, String texto, String opcoes){
		int opcaoVeiculo = 0;
		boolean temExcecao = false;
		
		do{
			temExcecao = false;
			try{
				opcaoVeiculo = input.nextInt();
				
			}catch(InputMismatchException e){
				Impressora.imprimeOpcaoInvalida();
				MetodosAuxiliares.pressionarEnterErro();
				input.nextLine();
				temExcecao = true;
			}catch(Exception e){
				Impressora.imprimeErroInesperado();
				MetodosAuxiliares.pressionarEnterErro();
				input.nextLine();
				temExcecao = true;
			}
			if(temExcecao){
				System.out.println(texto);
				System.out.println(opcoes);
			}
		}while(temExcecao);
		
		return opcaoVeiculo;
	}

	public static int lancaExcecaoOpcoesVeiculo(Scanner input, String texto){
		int opcaoVeiculo = 0;
		boolean temExcecao = false;
		
		do{
			temExcecao = false;
			try{
				opcaoVeiculo = input.nextInt();
				
			}catch(InputMismatchException e){
				Impressora.imprimeOpcaoInvalida();
				MetodosAuxiliares.pressionarEnterErro();
				input.nextLine();
				temExcecao = true;
			}catch(Exception e){
				Impressora.imprimeErroInesperado();
				MetodosAuxiliares.pressionarEnterErro();
				input.nextLine();
				temExcecao = true;
			}
			if(temExcecao){
				System.out.println(texto);
			}
		}while(temExcecao);
		
		return opcaoVeiculo;
	}
	
	public static boolean lancaExcecaoLeituraVeiculo(String dadoDoVeiculo, String chassi){
		String eFloat = ".";
		
		if(dadoDoVeiculo.contains(eFloat)){
			try{
				float dadoDoVeiculoFormatado = Float.parseFloat(dadoDoVeiculo);
			}catch(NumberFormatException e){
				System.out.println("O veiculo com o chassi:'"+chassi+"', está com dados corrompidos e não será adicionado no estoque");
				return true;
			}			
		}else{
			try{
				int dadoDoVeiculoFormatado = Integer.parseInt(dadoDoVeiculo);
			}catch(NumberFormatException e){
				System.out.println("O veiculo com o chassi:'"+chassi+"', está com dados corrompidos e não será adicionado no estoque");
				return true;
			}
		}
		return false;
	}	
}
