package com.utilitarios;

import java.util.Scanner;

import com.montadora.Carro;
import com.montadora.Motocicleta;

public class Impressora {
	
	public static void imprimeCarro(Carro carro){
		System.out.println("-------CARRO-------");
		System.out.println("chassi: "+carro.getChassi());
		System.out.println("Montadora: "+carro.getMontadora());
		System.out.println("Tipo: "+carro.getTipo());
		System.out.println("Modelo: "+carro.getModelo());
		System.out.println("Cor: "+carro.getCor());
		System.out.println("motorizacao: "+carro.getMotorizacao());
		System.out.println("Cambio: "+carro.getCambio());
		System.out.println("Preço: "+carro.getPreco());
	}
	
	public static void imprimeMoto(Motocicleta moto){
		System.out.println("-------MOTO-------");
		System.out.println("chassi: "+moto.getChassi());
		System.out.println("Montadora: "+moto.getMontadora());
		System.out.println("Tipo: "+moto.getTipo());
		System.out.println("Modelo: "+moto.getModelo());
		System.out.println("Cor: "+moto.getCor());
		System.out.println("Cilindradas: "+moto.getCilindrada());
		System.out.println("Capacidade do tanque: "+moto.getCapacidadeDoTanque()+" Litros");
		System.out.println("Preço: "+moto.getPreco());		
	}
	
	public static int imprimeMenu(Scanner input){
		int opcaoMenu = -1;
		
		System.out.println("********MENU********\n");
		System.out.println("Entre com 1 para para adicionar veículo.");
		System.out.println("Entre com 2 para excluir veículo.");
		System.out.println("Entre com 3 para listar todos os veículos.");
		System.out.println("Entre com 4 para buscar veículo pelo número de chassi.");
		System.out.println("Entre com 5 para listar estoque de carros.");
		System.out.println("Entre com 6 para listar estoque das motos.");
		System.out.println("Entre com 7 para salvar o estoque em um arquivo.");
		System.out.println("Entre com 8 para recuperar um estoque salvo.");
		System.out.print("Entre com a opcao desejada ou 0 para sair: ");
		opcaoMenu = MetodosAuxiliares.leOpcaoMenu(input, opcaoMenu);
		
		
		return opcaoMenu;
	}


	
	public static void imprimeOpcaoInvalida(){
		System.err.println("Opção digitada inválida, entre com uma opcao válida.");
	}
	
	public static void imprimeErroInesperado(){
		System.err.println("Um erro inesperado ocorreu, por favor entre com a opção novamente.");
	}
}
