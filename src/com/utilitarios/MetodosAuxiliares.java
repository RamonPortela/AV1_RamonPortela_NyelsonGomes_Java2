package com.utilitarios;

import java.util.Scanner;

public class MetodosAuxiliares {
	
	public static void pressionarEnter(){
		System.out.println("Pressione enter para voltar ao menu.");
		Scanner input = new Scanner(System.in);
		input.nextLine();//só continua pro proximo passo se o usuario apertar a tecla enter
		limparTela();//chama metodo de limpar tela
	}
	
	public static void pressionarEnterErro(){
		System.out.println("Pressione enter para continuar.");
		Scanner input = new Scanner(System.in);
		input.nextLine();
		System.out.print("");
	}
	public static void limparTela(){//varias quebras de linha "limpar" o console
		for(int i = 0; i < 25; i++){
			System.out.println("\n");
		}
	}
	
}
