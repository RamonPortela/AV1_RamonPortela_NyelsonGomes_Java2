package com.utilitarios.teste;

import java.util.Scanner;

public class MetodosAuxiliares {
	public static void pressionarEnter(){
		System.out.println("Pressione enter para voltar ao menu");
		Scanner input = new Scanner(System.in);
		input.nextLine();
		limparTela();
	}
	public static void limparTela(){
		for(int i = 0; i < 50; i++){
			System.out.println("\n");
		}
	}
}
