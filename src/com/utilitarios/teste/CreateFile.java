package com.utilitarios.teste;

import java.io.FileNotFoundException;
import java.util.Formatter;

import com.montadora.Carro;
import com.montadora.Motocicleta;
import com.montadora.Veiculo;
import com.operacional.Loja;

public class CreateFile {

	private Formatter output;
	
	public void openFile(){
		try{
			output = new Formatter("Estoque.txt");
		}
		catch(FileNotFoundException falhaAbertura){
			System.err.println("Erro na abertura do arquivo.");
			System.exit(1);
		}
	}	
	
	public void mostrarEstoque(){
		Loja loja = new Loja();
		int	contador = 0;
		
		Carro carro = new Carro();
		Motocicleta estoqueDeMoto = new Motocicleta();
		loja.estoqueDeVeiculos.get(contador);
		
		for(Veiculo veiculo : loja.estoqueDeVeiculos){
			output.format("+=====================================================================+%n"
				+ "| Nome:%-39s \t Cpf:%-14s   |"
				+ "%n| Classe:%-10s \t Numero do Assento:%-2d \t Numero do Vagão:%-2d   |"
				+ "%n| Data da Viagem:%-10s \tHora da Viagem:%-5s\tDuração:%-2s hr |"
				+ "%n| Origem:%-20s\tDestino:%-20s          |"
				+ "%n+=====================================================================+", args)
		}
		
		MetodosAuxiliares.imprimeCarro(carro);
		MetodosAuxiliares.imprimeMoto(estoqueDeMoto);
		
		output.format("+=====================================================================+%n"
				+ "| Nome:%-39s \t Cpf:%-14s   |"
				+ "%n| Classe:%-10s \t Numero do Assento:%-2d \t Numero do Vagão:%-2d   |"
				+ "%n| Data da Viagem:%-10s \tHora da Viagem:%-5s\tDuração:%-2s hr |"
				+ "%n| Origem:%-20s\tDestino:%-20s          |"
				+ "%n+=====================================================================+", carro.getChassi());
	}
}
