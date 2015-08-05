package com.utilitarios.teste;

import java.io.FileNotFoundException;
import java.util.Formatter;

import com.montadora.Carro;
import com.montadora.Motocicleta;
import com.montadora.Veiculo;
import com.operacional.Loja;

public class CreateFile {
	
	private static int contador;
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
		
		Carro carro = new Carro();
		Motocicleta estoqueDeMoto = new Motocicleta();
		loja.estoqueDeVeiculos.get(contador);
		
		if(loja.getEstoqueDeVeiculos().get(contador) instanceof Carro){
			for(contador = 0; contador < loja.getEstoqueDeVeiculos().size(); contador++){
				output.format("+=====================================================================+%n"
						+ "| Chassi:%-10s \t   |"
						+ "%n| Montadora:%-10s \t   |"
						+ "%n| Modelo:%-10s \t |"
						+ "%n| Cor:%-10s\t          |"
						+ "%n+=====================================================================+", loja.getEstoqueDeVeiculos().get(contador).getChassi() ,loja.getEstoqueDeVeiculos().get(contador).getMontadora(), loja.getEstoqueDeVeiculos().get(contador).getModelo(), loja.getEstoqueDeVeiculos().get(contador).getCor(), loja.getEstoqueDeVeiculos().get(contador).getPreco());
			}
		}
		
		else if(loja.getEstoqueDeVeiculos().get(contador) instanceof Motocicleta){
			for(contador = 0; contador < loja.getEstoqueDeVeiculos().size(); contador++){
				output.format("+=====================================================================+%n"
						+ "| Chassi:%-10s \t   |"
						+ "%n| Montadora:%-10s \t   |"
						+ "%n| Modelo:%-10s \t |"
						+ "%n| Cor:%-10s\t          |"
						+ "%n+=====================================================================+", loja.getEstoqueDeVeiculos().get(contador).getChassi() ,loja.getEstoqueDeVeiculos().get(contador).getMontadora(), loja.getEstoqueDeVeiculos().get(contador).getModelo(), loja.getEstoqueDeVeiculos().get(contador).getCor(), loja.getEstoqueDeVeiculos().get(contador).getPreco());
			}
		}
		else {
			System.err.println("Nenhum veículo encontrado.");
			System.exit(1);
		}
		
		for(contador = 0; contador < loja.getEstoqueDeVeiculos().size(); contador++){
			output.format("+=====================================================================+%n"
					+ "| Chassi:%-10s \t   |"
					+ "%n| Montadora:%-10s \t   |"
					+ "%n| Modelo:%-10s \t |"
					+ "%n| Cor:%-10s\t          |"
					+ "%n+=====================================================================+", loja.getEstoqueDeVeiculos().get(contador).getChassi() ,loja.getEstoqueDeVeiculos().get(contador).getMontadora(), loja.getEstoqueDeVeiculos().get(contador).getModelo(), loja.getEstoqueDeVeiculos().get(contador).getCor(), loja.getEstoqueDeVeiculos().get(contador).getPreco());
		}
		
		for(Veiculo veiculo : loja.estoqueDeVeiculos){
			output.format("+=====================================================================+%n"
				+ "| Chassi:%-10s \t   |"
				+ "%n| Montadora:%-10s \t   |"
				+ "%n| Modelo:%-10s \t |"
				+ "%n| Cor:%-10s\t          |"
				+ "%n+=====================================================================+", loja.getEstoqueDeVeiculos().get(contador).getChassi() ,loja.getEstoqueDeVeiculos().get(contador).getMontadora(), loja.getEstoqueDeVeiculos().get(contador).getModelo(), loja.getEstoqueDeVeiculos().get(contador).getCor(), loja.getEstoqueDeVeiculos().get(contador).getPreco());
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
	
	public void closedFile(){		
		if(output != null){
			output.close();
		}
	}	
}
