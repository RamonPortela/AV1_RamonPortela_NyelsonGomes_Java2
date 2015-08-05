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
	
	public void gravarEstoque(Loja loja){
		

		for(Veiculo veiculo : loja.estoqueDeVeiculos){
			if(veiculo instanceof Carro){
				Carro carro = (Carro) veiculo;
				output.format("Chassi: ");
				/*output.format("+=====================================================================+%n"
						+ "| Chassi:%-10s \t   |"
						+ "%n| Montadora:%-10s \t   |"
						+ "%n| Tipo:%-10s \t |"
						+ "%n| Modelo:%-10s \t |"
						+ "%n| Motorização:%-10f \t |"
						+ "%n| Câmbio:%-10s \t |"
						+ "%n| Cor:%-10s\t          |"
						+ "%n| Preço:%-10f \t |"
						+ "%n+=====================================================================+", carro.getChassi() 
						, carro.getMontadora(), carro.getTipo(), carro.getModelo()
						, carro.getMotorizacao(), carro.getCambio(), carro.getCor(), carro.getPreco());
			*/}else{
				Motocicleta moto = (Motocicleta) veiculo;
				output.format("+=====================================================================+%n"
						+ "| Chassi:%-10s \t   |"
						+ "%n| Montadora:%-10s \t   |"
						+ "%n| Tipo:%-10s \t |"
						+ "%n| Modelo:%-10s \t |"
						+ "%n| Cilindrada:%-10d \t |"
						+ "%n| Capacidade do Tanque:%-10d litros \t |"
						+ "%n| Cor:%-10s\t          |"
						+ "%n| Preço:%-10f \t |"
						+ "%n+=====================================================================+", moto.getChassi()
						, moto.getMontadora(), moto.getTipo(), moto.getModelo()
						, moto.getCilindrada(), moto.getCapacidadeDoTanque(), moto.getCor(), moto.getPreco());
				}
			}
		}

	
	public void closedFile(){		
		if(output != null){
			output.close();
		}
	}	
}
