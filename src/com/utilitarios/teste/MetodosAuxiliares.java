package com.utilitarios.teste;

import java.util.Scanner;

import com.montadora.Carro;
import com.montadora.Motocicleta;

public class MetodosAuxiliares {
	public static void pressionarEnter(){
		System.out.println("Pressione enter para voltar ao menu");
		Scanner input = new Scanner(System.in);
		input.nextLine();//só continua pro proximo passo se o usuario apertar a tecla enter
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
	
}
