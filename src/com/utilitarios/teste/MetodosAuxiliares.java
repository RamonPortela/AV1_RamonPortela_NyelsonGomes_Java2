package com.utilitarios.teste;

import java.util.Scanner;

import com.montadora.Carro;
import com.montadora.Motocicleta;

public class MetodosAuxiliares {
	public static void pressionarEnter(){
		System.out.println("Pressione enter para voltar ao menu");
		Scanner input = new Scanner(System.in);
		input.nextLine();//s� continua pro proximo passo se o usuario apertar a tecla enter
		limparTela();//chama metodo de limpar tela
	}
	public static void limparTela(){//varias quebras de linha "limpar" o console
		for(int i = 0; i < 50; i++){
			System.out.println("\n");
		}
	}
	
	public static void imprimeCarro(Carro carro){
		System.out.println("-------CARRO-------");
		System.out.println("chassi: "+carro.getChassi());
		System.out.println("Montadora: "+carro.getMontadora());
		System.out.println("Tipo: "+carro.getTipo());
		System.out.println("Modelo: "+carro.getModelo());
		System.out.println("Cor: "+carro.getCor());
		System.out.println("motorizacao: "+carro.getMotorizacao());
		System.out.println("Cambio: "+carro.getCambio());
		System.out.println("Pre�o: "+carro.getPreco());
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
		System.out.println("Pre�o: "+moto.getPreco());		
	}
	
	public static int imprimeMenu(Scanner input){
		int opcaoMenu;
		
		System.out.println("********MENU********\n");
		System.out.println("Entre com 1 para para adicionar ve�culo.");
		System.out.println("Entre com 2 para excluir ve�culo.");
		System.out.println("Entre com 3 para listar todos os ve�culos.");
		System.out.println("Entre com 4 para buscar ve�culo pelo n�mero de chassi.");
		System.out.println("Entre com 5 para listar estoque de carros.");
		System.out.println("Entre com 6 para listar estoque das motos.");	
		System.out.print("Entre com a opcao desejada ou 0 para sair: ");
		opcaoMenu = input.nextInt();
		
		return opcaoMenu;
	}
	
}
