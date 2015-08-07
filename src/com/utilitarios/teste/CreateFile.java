package com.utilitarios.teste;

import java.io.FileNotFoundException;
import java.util.Formatter;

import com.montadora.Carro;
import com.montadora.Motocicleta;
import com.montadora.Veiculo;
import com.operacional.Loja;

public class CreateFile {	
		
	private Formatter output; // Objeto utilizado para gerar o arquivo de texto
	
	// Cria ou abre um arquivo
	public void openFile(){		
		try {
			output = new Formatter("Estoque.txt");
		} catch (FileNotFoundException falhaAbertura) {
			System.err.println("Erro na criação ou Abertura do Arquivo");
			System.exit(1);
		}
	}	
	
	public void gravarEstoque(Loja loja){		

		for(Veiculo veiculo : loja.estoqueDeVeiculos){			
			if(veiculo instanceof Carro){					
				Carro carro = (Carro) veiculo;
				
				output.format("+==================================+%n"
						+ "| Chassi:%-25s |"
						+ "%n| Montadora:%-22s |"
						+ "%n| Tipo:%-27s |"
						+ "%n| Modelo:%-25s |"
						+ "%n| Motorização:%-20.1f |"
						+ "%n| Câmbio:%-25s |"
						+ "%n| Cor:%-28s |"
						+ "%n| Preço:%-26.2f |"
						+ "%n+==================================+", carro.getChassi() 
						, carro.getMontadora(), carro.getTipo(), carro.getModelo()
						, carro.getMotorizacao(), carro.getCambio(), carro.getCor(), carro.getPreco());
			}else{				
				Motocicleta moto = (Motocicleta) veiculo;
				
				output.format("+==================================+%n"
						+ "| Chassi:%-25s |"
						+ "%n| Montadora:%-22s |"
						+ "%n| Tipo:%-27s |"
						+ "%n| Modelo:%-25s |"
						+ "%n| Cilindrada:%-21d |"
						+ "%n| Capacidade do Tanque:%-4d litros |"
						+ "%n| Cor:%-28s |"
						+ "%n| Preço:%-26.2f |"
						+ "%n+==================================+", moto.getChassi()
						, moto.getMontadora(), moto.getTipo(), moto.getModelo()
						, moto.getCilindrada(), moto.getCapacidadeDoTanque(), moto.getCor(), moto.getPreco());
				}
			output.format("%n");
			}
		}

	
	public void closedFile(){		
		if(output != null){
			output.close();
		}
	}	
}
