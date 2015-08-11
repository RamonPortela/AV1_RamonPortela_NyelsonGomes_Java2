package com.utilitarios.teste;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Excecoes {
	public static int lancaExcecaoOpcoesVeiculo(Scanner input){
		int opcaoVeiculo = 0;
		
		try{
			opcaoVeiculo = input.nextInt();
			
		}catch(InputMismatchException e){
			Impressora.imprimeOpcaoInvalida();
			MetodosAuxiliares.pressionarEnter();
			input.nextLine();
		}catch(Exception e){
			Impressora.imprimeErroInesperado();
			MetodosAuxiliares.pressionarEnter();
			input.nextLine();
		}
		return opcaoVeiculo;
	}
}
