package com.utilitarios;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.montadora.Carro;
import com.montadora.Motocicleta;
import com.montadora.Veiculo;

public class CarregarEstoque {
	
	private Scanner input;
	
	public boolean abrirArquivo(){		
		try{
			input = new Scanner(new File("Estoque.txt"));
		}catch (FileNotFoundException falhaAbertura) {
			System.err.println("Erro na criação ou Abertura do Arquivo");
			return false;
		}
		return true;
	}
	
	public void lerEstoqueSalvo(ArrayList<Veiculo> estoqueDeVeiculos){
		while(input.hasNext()){
			
			if(input.nextLine().indexOf("CARRO") > 0){
				Carro carro = new Carro();
				
				leDadosVeiculoInicio(carro);
				
				String[] quintaLinha = input.nextLine().split(":");
				String[] motorizacao = quintaLinha[1].split(" ");
				String motorizacaoString = motorizacao[0].trim();
				motorizacaoString = motorizacaoString.replace(",", ".");
				float motorizacaoFormatado = Float.parseFloat(motorizacaoString);
				carro.setMotorizacao(motorizacaoFormatado);
				
				String[] sextaLinha = input.nextLine().split(":");
				String[] cambio = sextaLinha[1].split(" ");
				String cambioFormatado = cambio[0].trim();
				carro.setCambio(cambioFormatado);
				
				leDadosVeiculoFim(carro);
				
				estoqueDeVeiculos.add(carro);
			}else{
				Motocicleta moto = new Motocicleta();
				
				leDadosVeiculoInicio(moto);
				
				String[] quintaLinha = input.nextLine().split(":");
				String[] cilindrada = quintaLinha[1].split(" ");
				String cilindradaString = cilindrada[0].trim();
				int cilindradaFormatada = Integer.parseInt(cilindradaString);
				moto.setCilindrada(cilindradaFormatada);
				
				String[] sextaLinha = input.nextLine().split(":");
				String[] capacidadeDoTanque = sextaLinha[1].split(" ");
				String capacidadeDoTanqueString = capacidadeDoTanque[0].trim();
				int capacidadeDoTanqueFormatada = Integer.parseInt(capacidadeDoTanqueString);
				moto.setCapacidadeDoTanque(capacidadeDoTanqueFormatada);
				
				leDadosVeiculoFim(moto);
				
				estoqueDeVeiculos.add(moto);
			}
			
			input.nextLine();
		}
	}
	
	private void leDadosVeiculoInicio(Veiculo veiculo){
		String[] primeiraLinha = input.nextLine().split(":");
		String[] chassi = primeiraLinha[1].split(" ");
		String chassiFormatado = chassi[0].trim();
		veiculo.setChassi(chassiFormatado);
		
		String[] segundaLinha = input.nextLine().split(":");
		String[] montadora = segundaLinha[1].split(" ");
		String montadoraFormatada = montadora[0].trim();
		veiculo.setMontadora(montadoraFormatada);
		
		String[] terceiraLinha = input.nextLine().split(":");
		String[] tipo = terceiraLinha[1].split(" ");
		String tipoFormatado = tipo[0].trim();
		veiculo.setTipo(tipoFormatado);
		
		String[] quartaLinha = input.nextLine().split(":");
		String[] modelo = quartaLinha[1].split(" ");
		
		String modeloFormatado = "";
		
		for(int contadorLetrasModelo = 0; contadorLetrasModelo < (modelo.length-1); contadorLetrasModelo++){
			modeloFormatado = modeloFormatado.concat(modelo[contadorLetrasModelo]);
			modeloFormatado += " ";				
		}
		modeloFormatado = modeloFormatado.trim();
		veiculo.setModelo(modeloFormatado);
	}
	
	private void leDadosVeiculoFim(Veiculo veiculo){
		String[] setimaLinha = input.nextLine().split(":");
		String[] cor = setimaLinha[1].split(" ");
		String corFormatada = cor[0].trim();
		veiculo.setCor(corFormatada);
		
		String[] oitavaLinha = input.nextLine().split(":");
		String[] preco = oitavaLinha[1].split(" ");
		String precoString = preco[0].trim();
		precoString = precoString.replace(",", ".");
		float precoFormatado = Float.parseFloat(precoString);
		veiculo.setPreco(precoFormatado);
	}
	
	public void fecharArquivo(){		
		if(input != null){
			input.close();
		}
		else if(input == null){
			System.out.println("Erro na Leitura do Arquivo.");
		}
	}
}
