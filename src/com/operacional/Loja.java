package com.operacional;

import com.montadora.*;

import java.util.ArrayList;

public class Loja {
	
	private String endereco;
	private String nome;
	private ArrayList<Carro> estoqueDeCarros;
	private ArrayList<Motocicleta> estoqueDeMotocicletas;
	
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
	public void adicionarCarro(Carro carro) {
		this.estoqueDeCarros.add(carro);
	}
	public void adicionarMotocicleta(Motocicleta motocicleta) {
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
/*	public void pesquisarCarro(){
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
	}*/
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
	}
}
