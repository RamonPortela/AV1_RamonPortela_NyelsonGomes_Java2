package com.operacional;

import com.montadora.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Loja {
	
	private String endereco;
	private String nome;
	ArrayList<Veiculo> estoqueDeVeiculos = new ArrayList<Veiculo>();
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void adicionarVeiculo(Scanner input) {
		
		int opcaoDeVeiculo;
		
		do{
			
			System.out.println("Entre com 1 para adicionar um carro.");
			System.out.println("Entre com 2 para adicionar uma motocicleta.");
			
			opcaoDeVeiculo = input.nextInt();
			if((opcaoDeVeiculo < 1) || (opcaoDeVeiculo > 2)){
				System.out.println("Opção inválida. Entre com a opção novamente.");
			}
			
		}while((opcaoDeVeiculo < 1) || (opcaoDeVeiculo > 2));
		
		switch(opcaoDeVeiculo){
			case 1:
					Carro carro = new Carro();
					carro = carro.criarVeiculo(input);
					this.estoqueDeVeiculos.add(carro);
				break;
			case 2:
				break;
		}
		
		
	}
	
	public void listarVeiculos(){
		for(Veiculo veiculo : this.estoqueDeVeiculos){
			if(veiculo instanceof Carro){
				Carro carro = (Carro) veiculo;
				System.out.println("-------CARRO-------");
				System.out.println("chassi: "+carro.getChassi());
				System.out.println("Montadora: "+carro.getMontadora());
				System.out.println("Tipo: "+carro.getTipo());
				System.out.println("Modelo: "+carro.getModelo());
				System.out.println("Cor: "+carro.getCor());
				System.out.println("motorizacao: "+carro.getMotorizacao());
				System.out.println("Cambio: "+carro.getCambio());
				System.out.println("Preço: "+carro.getPreco());
			}else{
				Motocicleta moto = (Motocicleta) veiculo;
				Carro carro = (Carro) veiculo;
				System.out.println("-------MOTO-------");
				System.out.println("chassi: "+moto.getChassi());
				System.out.println("Montadora: "+moto.getMontadora());
				System.out.println("Tipo: "+moto.getTipo());
				System.out.println("Modelo: "+moto.getModelo());
				System.out.println("Cor: "+moto.getCor());
				System.out.println("motorizacao: "+moto.getCilindrada());
				System.out.println("Cambio: "+moto.getCapacidadeDoTanque());
				System.out.println("Preço: "+moto.getPreco());
			}
			System.out.println("");
		}
	}
	
/*	public void adicionarMotocicleta(Motocicleta motocicleta) {
		this.estoqueDeMotocicletas.add(motocicleta);
	}
	
	public void excluirCarro(int posicaoLista){
		this.estoqueDeCarros.remove(posicaoLista);
	}
	
	public void excluirMotocicleta(int posicaoLista) {
		this.estoqueDeMotocicletas.remove(posicaoLista);
	}
	
	public void listarEstoquedeCarros(){
		int posicaoLista = 0;
		Carro carro = new Carro();
		
		while(posicaoLista < this.estoqueDeCarros.size()){
			carro = this.estoqueDeCarros.get(posicaoLista);
			System.out.println("Chassi: "+carro.getChassi());
			System.out.println("Montadora: "+carro.getMontadora());
			System.out.println("Tipo: "+carro.getTipo());
			System.out.println("Modelo: "+carro.getModelo());
			System.out.println("Cor: "+carro.getCor());
			System.out.println("Motorizacao: "+carro.getMotorizacao());
			System.out.println("Cambio: "+carro.getCambio());
			System.out.println("Preço: "+carro.getPreco());
			posicaoLista++;
		}		
	}
	public void pesquisarCarro(){
		int posicaoLista = 0;
		Carro carro = new Carro();
		
		while(posicaoLista < this.estoqueDeCarros.size()){
			carro = this.estoqueDeCarros.get(posicaoLista);			
			System.out.println("Chassi: "+carro.getChassi());
			System.out.println("Montadora: "+carro.getMontadora());
			System.out.println("Tipo: "+carro.getTipo());
			System.out.println("Modelo: "+carro.getModelo());
			System.out.println("Cor: "+carro.getCor());
			System.out.println("Motorizacao: "+carro.getMotorizacao());
			System.out.println("Cambio: "+carro.getCambio());
			System.out.println("Preço: "+carro.getPreco());
			posicaoLista++;
		}		
	}
	public void buscarCarro(String chassi){
		boolean achouCarro = false;
		int posicaoLista = 0;
		Carro carro = new Carro();
		
		while(posicaoLista < this.estoqueDeCarros.size()){
			carro = this.estoqueDeCarros.get(posicaoLista);
			if(carro.getChassi() == chassi){
				System.out.println("Chassi: "+carro.getChassi());
				//System.out.println("Montadora: "+carro.getMontadora());
				System.out.println("Tipo: "+carro.getTipo());
				System.out.println("Modelo: "+carro.getModelo());
				System.out.println("Cor: "+carro.getCor());
				System.out.println("Motorizacao: "+carro.getMotorizacao());
				System.out.println("Cambio: "+carro.getCambio());
				System.out.println("Preço: "+carro.getPreco());
				achouCarro = true;
				break;
			}
			posicaoLista++;
		}
		if(!achouCarro){
			System.out.println("Carro não encontrado.");
		}
	}
	
	public void listarMotocicleta(){
		int posicaoLista = 0;
		Motocicleta motocicleta = new Motocicleta();
		
		while(posicaoLista < this.estoqueDeCarros.size()){
			motocicleta = this.estoqueDeMotocicletas.get(posicaoLista);
			System.out.println("Chassi: " + motocicleta.getChassi());
			System.out.println("Modelo: " + motocicleta.getModelo());
			System.out.println("Tipo: " + motocicleta.getTipo());
			System.out.println("Cor: " + motocicleta.getCor());
			System.out.println("Cilindrada: " + motocicleta.getCilindrada());
			System.out.println("Capacidade do Tanque: " + motocicleta.getCapacidade_do_tanque());
			System.out.println("Preço: " + motocicleta.getPreco());
			posicaoLista++;
		}
	}
	
	public void buscarMotocicleta(String chassi){
		boolean achouMoto = false;
		int posicaoLista = 0;
		Motocicleta motocicleta = new Motocicleta();
		
		while(posicaoLista < this.estoqueDeMotocicletas.size()){
			motocicleta = this.estoqueDeMotocicletas.get(posicaoLista);
			if(motocicleta.getChassi() == chassi){
				System.out.println("Chassi: " + motocicleta.getChassi());
				System.out.println("Modelo: " + motocicleta.getModelo());
				System.out.println("Tipo: " + motocicleta.getTipo());
				System.out.println("Cor: " + motocicleta.getCor());
				System.out.println("Cilindrada: " + motocicleta.getCilindrada());
				System.out.println("Capacidade do Tanque: " + motocicleta.getCapacidade_do_tanque());
				System.out.println("Preço: " + motocicleta.getPreco());
				achouMoto = true;
				break;
			}
			posicaoLista++;
		}
		if(!achouMoto){
			System.out.println("Moto não encontrada.");
		}
	}*/
}
